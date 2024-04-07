package com.travelers.post.bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.travelers.common.FileManagerService;
import com.travelers.post.comment.bo.CommentBO;
import com.travelers.post.comment.dto.CommentDTO;
import com.travelers.post.dao.PostDAO;
import com.travelers.post.dto.GeocoderResultDTO;
import com.travelers.post.dto.PostDTO;
import com.travelers.post.dto.PostDetailDTO;
import com.travelers.post.like.bo.LikeBO;
import com.travelers.post.like.dto.LikeDTO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	@Value("${google.maps.key}")
	private String googlemapskey;
	
	
	// google apis 에서 지역이름에 따른 위도, 경도 등 정보 가져오기
    public String getCoordinatesString(String locationName) {
    	
    	try {
			String encodedLocation = URLEncoder.encode(locationName, "UTF-8");
			String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="+encodedLocation+"&key="+googlemapskey;
			
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			
			BufferedReader br;
			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			String inputLine;
			StringBuilder response = new StringBuilder();
			while((inputLine = br.readLine()) != null){
				response.append(inputLine);
			}
			br.close();
			return response.toString();
			
	        
		} catch (IOException e) {
			return "failed to get response";
		}
       
    }
    

    
    private Map<String, Object> parseCoordinates(String jsonString){
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject;
    	
    	try {
			jsonObject = (JSONObject) jsonParser.parse(jsonString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
    	
    	Map<String, Object> resultMap = new HashMap<>();
    	
    	JSONArray results = (JSONArray) jsonObject.get("results");
        JSONObject result = (JSONObject) results.get(0);
        
        JSONObject geometry = (JSONObject) result.get("geometry");
        JSONObject location = (JSONObject) geometry.get("location");
        
    	resultMap.put("lat", location.get("lat"));
    	resultMap.put("lng", location.get("lng"));
    	
    	
    	return resultMap;
    	
    	
    }
    
    
    public GeocoderResultDTO getCoordinatesApi(String locationName) {
    	String coordinatesData = getCoordinatesString(locationName);
    	
    	Map<String, Object> parseCoordinates = parseCoordinates(coordinatesData);
    	
    	GeocoderResultDTO geocoderResultDTO = new GeocoderResultDTO();
    	geocoderResultDTO.setLocationName(locationName);
    	geocoderResultDTO.setLat(parseCoordinates.get("lat").toString());
    	geocoderResultDTO.setLng(parseCoordinates.get("lng").toString());
    	
    	return geocoderResultDTO;
    }
    
    
    public int addPost(int userCd, String userName, MultipartFile[] files, String content, 
				String locationName, String lat, String lng) {
    	
    	
    	String filePathList = "";
    	
    	for(int i=0; i<files.length; i++) {
    		filePathList += FileManagerService.saveFile(userCd, files[i]);
    		if(i != files.length-1) {
    			filePathList += ",";
    		}
    	}
    	
    	return postDAO.insertPost(userCd,userName,filePathList, content, locationName, lat, lng);
    	
    }
    
    
    public List<PostDetailDTO> locationPostDetailList(String locationName) {
    	GeocoderResultDTO result = this.getCoordinatesApi(locationName);
    	
    	String lat = result.getLat();
    	String lng = result.getLng();
    	
    	List<PostDetailDTO> postDetailList = new ArrayList<>();
    	
    	List<PostDTO> postDTOList = postDAO.selectLocationPostList(locationName, lat, lng);
    	
    	for(PostDTO i : postDTOList) {
    		// postDTO.getPostCd() 기반으로 comment, like 가져와서 PostDetailDTO에 set하기 *
    		List<CommentDTO> commentList = commentBO.selectCommentList(i.getPostCd());
    		List<LikeDTO> likeList = likeBO.selectLikeList(i.getPostCd());
    		
    		PostDetailDTO postDetailDTO = new PostDetailDTO();
    		postDetailDTO.setPostDTO(i);
    		//commentList, likeList 저장
    		
    		postDetailList.add(postDetailDTO);
    	}

    	return postDetailList;    	
    }
    
    public int deletePost(int postCd) {
    	
    	int count = postDAO.deletePost(postCd);
    	
    	if(count == 1) {
    		//comment 지우기 
    	}
    	
    	
    	return count;
    }
    
 
}
