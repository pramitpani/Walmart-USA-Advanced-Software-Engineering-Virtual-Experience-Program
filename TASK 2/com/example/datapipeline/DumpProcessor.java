package com.example.datapipeline;

public class DumpProcessor extends AbstractProcessor {
    @Override
    public void process(DataPoint data) {
        // In Dump mode, we simply discard the data
        System.out.println("Data discarded: " + data);
    }
}

