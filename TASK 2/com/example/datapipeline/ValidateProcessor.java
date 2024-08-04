package com.example.datapipeline;

public class ValidateProcessor extends AbstractProcessor {
    @Override
    public void process(DataPoint data) {
        // In Validate mode, validate the data before inserting
        if (dbConnector.validate(data)) {
            dbConnector.insert(data);
        } else {
            System.out.println("Data validation failed: " + data);
        }
    }
}
