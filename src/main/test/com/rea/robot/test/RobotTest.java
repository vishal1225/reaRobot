package com.rea.robot.test;

import com.rea.robot.pojo.Direction;
import com.rea.robot.pojo.Position;
import com.rea.robot.robot.IRobo;
import com.rea.robot.robot.Robot;

import junit.framework.TestCase;

public class RobotTest extends TestCase {

	IRobo robo;

	public void testCreateRobot() {
		robo = new Robot();
		assertNotNull(robo);
		// robo has a position
		// position has x, y coordnates and a facing Direction
		int roboXCoordinate = 0;
		int roboYCoordinate = 0;
		Direction facingDirection = Direction.NORTH;
		Position position = new Position(roboXCoordinate, roboYCoordinate, facingDirection);
		robo.setPosition(position);
		assertEquals(roboXCoordinate, robo.getPosition().getX());
		assertEquals(roboYCoordinate, robo.getPosition().getY());
		assertEquals(facingDirection, robo.getPosition().getFacing());
	}
}
