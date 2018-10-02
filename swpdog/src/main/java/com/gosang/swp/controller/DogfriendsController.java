package com.gosang.swp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/appcontroller/*")
public class DogfriendsController {

	private static final Logger logger = LoggerFactory.getLogger(DogfriendsController.class);
	
	@RequestMapping(value = "/{temp}/{humi}", method = RequestMethod.GET)
	public ResponseEntity<String> checkTemp(@PathVariable("temp") Integer temp, 
											@PathVariable("humi") Integer humi) throws Exception {
		logger.debug("..... temp={}, humi={}", temp, humi);
		try {
			DogfriendsVO vo = service.readTemp(temp);
			return new ResponseEntity<Integer>(temp, HttpStatus.OK);
		}catch{
			
		}
		return null;
	}

}
