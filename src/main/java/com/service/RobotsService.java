package com.service;

import org.springframework.http.ResponseEntity;

public interface RobotsService {
	public ResponseEntity<String> identifyPosition(String[] lines) ;
}
