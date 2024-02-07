package com.travelers.post.bo;

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
	
	 
    public String getCoordinates(String address) {
        String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json";
        String url = String.format("%s?address=%s&key=%s", apiUrl, address, googlemapskey);

        return restTemplate.getForObject(url, String.class);
    }

}
