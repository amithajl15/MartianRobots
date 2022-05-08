package com.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RobotDaoTest {


	RobotDao robo = new RobotDao(0,0,'W');

	@Test
	void moveHappy() {
		robo.move("FF");
		assertEquals("0 2 N", robo.position());
	}

	@Test
	void moveUnhappy() {
		robo.move("FFRRRFF");
		assertEquals("-2 2 W LOST", robo.position());
	}

}
