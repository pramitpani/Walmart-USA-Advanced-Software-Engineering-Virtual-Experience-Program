package com.example.datapipeline;

public class DataPoint {
    // Add fields and methods for DataPoint
    private String data;

    public DataPoint(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}

