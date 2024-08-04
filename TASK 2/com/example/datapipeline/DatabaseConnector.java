package com.example.datapipeline;

public interface DatabaseConnector {
    void connect();
    void insert(DataPoint data);
    boolean validate(DataPoint data);
}
