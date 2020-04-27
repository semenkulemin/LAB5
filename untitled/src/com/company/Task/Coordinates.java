package com.company.Task;

public class Coordinates {
    private long x;
    private float y; //Значение поля должно быть больше -425

    public Coordinates(long X, float Y){
        this.x=X;
        this.y=Y;
    }

    public long getCoordinatesOfX(){
        return x;
    }

    public float getCoordinatesOfY(){
        return y;
    }

    public String toString(){
        return "Coordinates: (" + x + "," + y + ")";
    }
}