package com.example.c0777180_w2020_mad3125_fp.Util;

public class DataRepo {
    private static DataRepo instance = new DataRepo();

    private DataRepo() {
    }
    public static DataRepo getInstance(){
        return instance;
    }

}
