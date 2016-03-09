package com.rea.robot.pojo;

public enum Command {
	PLACE("PLACE"), MOVE("MOVE"), LEFT("LEFT"), RIGHT("RIGHT"), REPORT("REPORT");
	private String commandType;

	private Command(String cType) {
		commandType = cType;

	}

	public String getCommandType() {
		return commandType;
	}
}
