package com.rea.robot.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.commands.ICommand;
import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.pojo.Direction;
import com.rea.robot.pojo.Position;
import com.rea.robot.robot.IRobo;

public class RightCommand implements ICommand {
	private static Logger log = Logger.getLogger(RightCommand.class.getName());

	@Override
	public void execute(IRobo robo) throws IllegalMoveException {
		log.log(Level.INFO, "Turning Robo to the Right.");
		Position roboPosition = robo.getPosition();
		if (roboPosition.getFacing().equals(Direction.EAST)) {
			roboPosition.setFacing(Direction.SOUTH);
		} else if (roboPosition.getFacing().equals(Direction.SOUTH)) {
			roboPosition.setFacing(Direction.WEST);
		} else if (roboPosition.getFacing().equals(Direction.WEST)) {
			roboPosition.setFacing(Direction.NORTH);
		} else if (roboPosition.getFacing().equals(Direction.NORTH)) {
			roboPosition.setFacing(Direction.EAST);
		}
	}

}
