package com.example.user.myapplication;

/**
 * Created by user on 8/9/2018.
 */

public class Ring_Pic_Items  {
    int Image ;
    String Date;
    String Time;

    public Ring_Pic_Items(int image, String date, String time) {
        Image = image;
        Date = date;
        Time = time;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
