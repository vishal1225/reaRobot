package com.rea.robot.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.rea.robot.commands.ICommand;
import com.rea.robot.commands.LeftCommand;
import com.rea.robot.commands.MoveCommand;
import com.rea.robot.commands.PlaceCommand;
import com.rea.robot.commands.RightCommand;
import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.pojo.Direction;
import com.rea.robot.pojo.Position;
import com.rea.robot.robot.IRobo;
import com.rea.robot.robot.Robot;

public class RobotTest {
	private static Logger log = Logger.getLogger(RobotTest.class.getName());
	IRobo robo;

	@Before
	public void initRobo() {
		robo = new Robot();
	}

	@Test
	public void testCreateRobot() {
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

	@Test
	public void testRoboPlaceCommand() {
		// create a robo commands
		// command should have max and min range, lets make it configurable
		robo = new Robot();
		ICommand placeCommand = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		try {
			placeCommand.execute(robo);
		} catch (IllegalMoveException e) {
			log.log(Level.WARNING, e.getMessage());
		}
		assertTrue(robo.getPosition().getX() == 0);
		assertTrue(robo.getPosition().getY() == 0);
		assertTrue(robo.getPosition().getFacing() == Direction.NORTH);

	}

	@Test
	public void testPlaceOutOfGrid() {
		robo = new Robot();
		ICommand placeCommand = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		try {
			placeCommand.execute(robo);
		} catch (IllegalMoveException e) {
			assertTrue(e.getMessage().equals("Can not place Robo out of grid"));
		}
	}

	@Test
	public void testRoboLeftCommand() throws IllegalMoveException {
		robo = new Robot();
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		command = new LeftCommand();
		command.execute(robo);
		assertEquals(Direction.WEST, robo.getPosition().getFacing());
	}

	@Test
	public void testRoboRightCommand() throws IllegalMoveException {
		robo = new Robot();
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		command = new RightCommand();
		command.execute(robo);
		assertEquals(Direction.EAST, robo.getPosition().getFacing());
	}

	@Test
	public void testRoboMoveCommand() throws IllegalMoveException {
		robo = new Robot();
		ICommand command = new PlaceCommand(new Position(0, 0, Direction.NORTH));
		command.execute(robo);
		command = new MoveCommand();
		command.execute(robo);
		assertEquals(Direction.NORTH, robo.getPosition().getFacing());
		assertEquals(0, robo.getPosition().getX());
		assertEquals(1, robo.getPosition().getY());
	}

	@Test
	public void testRoboMoveOutofGrid() {
		robo = new Robot();
		ICommand command = new PlaceCommand(new Position(5, 0, Direction.NORTH));
		try {
			command.execute(robo);
			command = new MoveCommand();
			command.execute(robo);
		} catch (IllegalMoveException e) {
			assertTrue(e.getMessage().equals("Can not move Robo out of grid"));
		}
	}
}
