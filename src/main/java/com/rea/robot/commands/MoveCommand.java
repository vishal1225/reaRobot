package com.rea.robot.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.commands.ICommand;
import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.pojo.Direction;
import com.rea.robot.pojo.Position;
import com.rea.robot.robot.IRobo;

public class MoveCommand implements ICommand {
	private static Logger log = Logger.getLogger(MoveCommand.class.getName());

	@Override
	public void execute(IRobo robo) throws IllegalMoveException {
		log.log(Level.INFO, "Moving Robo on the grid.");
		Position roboPosition = robo.getPosition();
		if (roboPosition.getFacing().equals(Direction.EAST)) {
			if (roboPosition.getX() + 1 < MAX_Y) {
				roboPosition.setX(roboPosition.getX() + 1);
			} else {
				throw new IllegalMoveException("Can not move Robo out of grid.");
			}
		} else if (roboPosition.getFacing().equals(Direction.NORTH)) {
			if (roboPosition.getY() + 1 < MAX_X) {
				roboPosition.setY(roboPosition.getY() + 1);
			} else {
				throw new IllegalMoveException("Can not move Robo out of grid.");
			}
		} else if (roboPosition.getFacing().equals(Direction.WEST)) {
			if (roboPosition.getX() - 1 > MIN_Y) {
				roboPosition.setX(roboPosition.getX() - 1);
			} else {
				throw new IllegalMoveException("Can not move Robo out of grid.");
			}

		} else if (roboPosition.getFacing().equals(Direction.SOUTH)) {
			if (roboPosition.getY() - 1 > MIN_X) {
				roboPosition.setY(roboPosition.getY() - 1);
			} else {
				throw new IllegalMoveException("Can not move Robo out of grid.");
			}
		}

	}

}
