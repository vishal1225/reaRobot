package com.rea.robot.commands;

import com.rea.robot.exceptions.IllegalMoveException;
import com.rea.robot.pojo.Position;
import com.rea.robot.robot.IRobo;

public class ReportCommand implements ICommand {

	@Override
	public void execute(IRobo robo) throws IllegalMoveException {
		Position roboPosition = robo.getPosition();
		System.out.println(roboPosition.getX() + ", " + roboPosition.getY()
				+ ", " + roboPosition.getFacing());

	}

}
