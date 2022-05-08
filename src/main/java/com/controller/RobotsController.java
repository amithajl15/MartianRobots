package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.RobotsService;

@RestController
public class RobotsController {
	@Autowired
	RobotsService robotsService;

	@RequestMapping(value = "/positions", method = RequestMethod.POST)
	public ResponseEntity<String> getPositions(@RequestBody String input) {
		String[] lines = input.split("\\R");
		return robotsService.identifyPosition(lines);
	}
}
