package com.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.RobotDao;

@Service
public class RobotsServiceImpl implements RobotsService {

	@Override
	public ResponseEntity<String> identifyPosition(String[] lines) {
		String[] initialPosition = lines[0].split(" ");
		char direction= initialPosition[2].charAt(0);
		int x = Integer.parseInt(initialPosition[0]);
		int y = Integer.parseInt(initialPosition[1]);
		RobotDao robot = new RobotDao(x, y, direction);
		robot.move(lines[1]);

		return  new ResponseEntity<String>(robot.position(), HttpStatus.CREATED);
	}


}
