package com.example.androidrecyclerview;

public class User
{
    public String name;
    public float score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public User(String name, float score)
    {
        this.name = name;
        this.score = score;
    }
}
