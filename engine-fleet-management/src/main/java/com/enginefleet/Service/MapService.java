package com.enginefleet.Service;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;

	@Service
	public class MapService {

	    @Autowired
	    private RestTemplate restTemplate;

	    public String getDistanceMatrix(String coordinates) {

	        String url = "http://router.project-osrm.org/table/v1/driving/"
	                + coordinates
	                + "?annotations=distance";

	        return restTemplate.getForObject(url, String.class);
	    }
	}


