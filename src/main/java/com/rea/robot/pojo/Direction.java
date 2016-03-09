package com.rea.robot.pojo;

public enum Direction {
	NORTH("NORTH"), EAST("EAST"), WEST("WEST"), SOUTH("SOUTH");
    private String value;
    private Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
