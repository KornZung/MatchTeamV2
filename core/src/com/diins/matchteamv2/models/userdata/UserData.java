package com.diins.matchteamv2.models.userdata;

/**
 * Created by Pakorn on 29/7/2558.
 */
public abstract  class UserData {
    protected UserDataType userDataType;
    private float width;
    private float height;

    public UserData() {

    }

    public UserData(float width, float height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
