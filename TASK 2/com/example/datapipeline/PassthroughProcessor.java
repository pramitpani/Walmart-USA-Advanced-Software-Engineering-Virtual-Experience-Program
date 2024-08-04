package com.example.datapipeline;

public class PassthroughProcessor extends AbstractProcessor {
    @Override
    public void process(DataPoint data) {
        // In Passthrough mode, we insert data into the configured database
        dbConnector.insert(data);
    }
}
