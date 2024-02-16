package com.travelers.post.bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public String getCoordinates(String locationName) {
    	try {
			String encodedLocation = URLEncoder.encode(locationName, "UTF-8");
			String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="+locationName+"&key="+googlemapskey;
	    
			
			//return restTemplate.getForObject(url, String.class);
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed to get response";
		}
       
    }
    
    private Map<String, Object> parseCoordinates(String jsonString){
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject;
    	
    	jsonObject = jsonParser.parse(jsonString);
    	
    	Map<String, Object> resultMap = new HashMap<>();
    	
    	JSONObject mainData = (JSONObject) jsonObject.get("main");
    	resultMap.put("temt", mainData.get("temp"));N
    	
    	
    	
    }

}
