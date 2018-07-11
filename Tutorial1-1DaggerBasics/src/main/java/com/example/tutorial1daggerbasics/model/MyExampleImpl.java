package com.example.tutorial1daggerbasics.model;

import java.util.Date;

public class MyExampleImpl implements MyExample {

    private long mDate;

    public MyExampleImpl() {
        mDate = new Date().getTime();
    }

    public long getDate() {
        return mDate;
    }

}