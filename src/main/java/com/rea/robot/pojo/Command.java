package com.rea.robot.pojo;

public enum Command {
	PLACE("PLACE"), MOVE("MOVE"), LEFT("LEFT"), RIGHT("RIGHT"), REPORT("REPORT");
	private String commandType;

	private Command(String commandType) {
		commandType = commandType;

	}

	public String getCommandType() {
		return commandType;
	}
}
