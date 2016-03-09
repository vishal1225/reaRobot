package com.rea.robot.robot;

import com.rea.robot.IRobo;
import com.rea.robot.pojo.Position;

public class Robot implements IRobo {
	private Position position;

	@Override
	public void setPosition(Position position) {
		this.position = position;

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

}
