package com.example.datapipeline;

public class PostgresConnector implements DatabaseConnector {
    @Override
    public void connect() {
        // Connect to Postgres database
        System.out.println("Connected to Postgres database.");
    }

    @Override
    public void insert(DataPoint data) {
        // Insert data into Postgres database
        System.out.println("Data inserted into Postgres: " + data);
    }

    @Override
    public boolean validate(DataPoint data) {
        // Validate data for Postgres database
        // (Dummy implementation, assume all data is valid)
        return true;
    }
}

