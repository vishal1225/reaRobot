package com.rea.robot.commands;

import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.pojo.Position;
import com.rea.robot.robot.IRobo;

public class PlaceCommand implements ICommand {

	private Position initPosition;

	public PlaceCommand(Position position) {
		this.initPosition = position;
	}

	@Override
	public void execute(IRobo robo) throws IllegalMoveException {
		if (initPosition.getX() <= MAX_X && initPosition.getX() >= MIN_X && initPosition.getY() >= MIN_Y
				&& initPosition.getY() <= MAX_Y) {
			robo.setPosition(initPosition);
		} else {
			throw new IllegalMoveException("Can not place Robo out of grid.");
		}

	}

}
