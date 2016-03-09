package com.rea.robot.pojo;

public class Position {

    private int x;
    private int y;
    private Direction f;


    public Position(int x, int y, Direction f) {
        this.x = x;
        this.y = y;
        this.f = f;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x=x;
    }
    public void setY(int y) {
        this.y=y;
    }
    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return f;
    }

    public void setFacing(Direction direction) {
        this.f=direction;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + f +
                '}';
    }

}
