package com.example.datapipeline;

public interface Processor {
    void configure(ModeIdentifier mode, DatabaseIdentifier db);
    void process(DataPoint data);
}
