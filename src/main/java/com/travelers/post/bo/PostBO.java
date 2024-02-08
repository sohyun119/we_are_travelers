package com.travelers.post.bo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostBO {
	
//	@Autowired
//	private PostDAO postDAO;
	
	@Value("${google.maps.key}")
	private String googlemapskey;
	
	private final RestTemplate restTemplate;

    @Autowired
    public PostBO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
	 
    public String getCoordinates(String locationName) {
    	try {
			String encodedLocation = URLEncoder.encode(locationName, "UTF-8");
			String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json";
	        String url = String.format("%s?address=%s&key=%s", apiUrl, encodedLocation, googlemapskey);
	        
			
			return restTemplate.getForObject(url, String.class);
	        
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
       
    }

}
