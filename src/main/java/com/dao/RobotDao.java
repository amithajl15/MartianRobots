package com.dao;

public class RobotDao {

	private int x;
	private int y;
	private char currentDirection;
	int min = 0;
	int max = 50;


	public RobotDao() {
		this(1, 1, 'N');
	}

	public RobotDao(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		currentDirection = direction;
	}

	public void move(String moves) {
		int direction= setDirection(this.currentDirection);
		for (char ch : moves.toCharArray()) { 
			if (ch == 'R')
				direction = (direction + 1)%4;
			else if (ch == 'L')
				direction = (4+ direction - 1) % 4;

			if (ch != 'F')
				continue;
			if (direction == 0) {
				y += 1;
			} if (direction == 1) {
				x += 1;
			} if (direction == 2) {
				y -= 1;
			} if (direction == 3) {
				x -= 1;
			}
		}
		this.currentDirection = setCurrentDirection(direction);
	}

	private int setDirection(char direction) {
		switch(direction) {
		case 'N' : return 0;
		case 'E' : return 1;
		case 'S' : return 2;
		case 'W' : return 3;
		default : throw new IllegalArgumentException("Invalid Direction");
		}

	}
	private char setCurrentDirection(int direction) {
		switch(direction) {
		case 0 : return 'N';
		case 1 : return 'E';
		case 2 : return 'S';
		case 3 : return 'W';
		default : return 'N';
		}

	}
	public void reset() {
		x = 0;
		y = 0;
		currentDirection = 0;
	}

	public String position() {

		boolean lost = isLost(x, y);
		if (lost)
			return x + " " + y +" " + this.currentDirection + " " +"LOST" ; 
		else
			return x + " " + y +" " + this.currentDirection; 
	}

	private boolean isLost(int x, int y) {
		if( x >= max || x < min || y >=50 || y< min) 
			return true;

		return false;
	}
}

