package com.travelers.post.bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.travelers.post.dto.GeocoderResultDTO;

@Service
public class PostBO {
	
//	@Autowired
//	private PostDAO postDAO;
	
	@Value("${google.maps.key}")
	private String googlemapskey;
	
	//private final RestTemplate restTemplate;

//    @Autowired
//    public PostBO(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
	
	
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
    	
    	JSONObject result = (JSONObject) jsonObject.get("result");
    	JSONArray geometry = (JSONArray) result.get("geometry");
    	JSONObject location = (JSONObject) geometry.get(0);
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
    
    
    

}
