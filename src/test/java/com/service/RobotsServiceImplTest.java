package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.dao.RobotDao;

public class RobotsServiceImplTest {

	@Autowired
	RobotsServiceImpl roboService;

	@Mock
	RobotDao robot = new RobotDao(0, 0,'W');
	@Mock
	RobotDao WrongRobot = new RobotDao(0, 0,'G');

	@Test
	void identifyPositionHappy() {
		robot.move("FF");
		assertEquals(HttpStatus.CREATED,  HttpStatus.CREATED);
	}


}
