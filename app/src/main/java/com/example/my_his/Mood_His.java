package com.example.my_his;

public class Mood_His {
    private int UserID;
    private int MoodID;
    private String Mood;
    private String Mood2;
    private String Date;
    //getters
    public String getMood() {
        return Mood;
    }

    public String getMood2() {
        return Mood2;
    }

    public String getDate() {
        return Date;
    }

    public int getUserID() {
        return UserID;
    }

    public int getMoodID() {
        return MoodID;
    }
    //setters
    public void setMood(String mood) {
        Mood = mood;
    }

    public void setMood2(String mood2) {
        Mood2 = mood2;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setMoodID(int moodID) {
        MoodID = moodID;
    }
    //constructor
    public Mood_His(int UserID, int MoodID, String Mood, String Mood2, String Date){
        this.UserID = UserID;
        this.MoodID = MoodID;
        this.Mood = Mood;
        this.Mood2 = Mood2;
        this.Date = Date;
    }
}