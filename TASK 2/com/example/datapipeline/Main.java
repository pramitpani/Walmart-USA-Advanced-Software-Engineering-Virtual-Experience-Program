package com.example.datapipeline;

public class Main {
    public static void main(String[] args) {
        Processor processor = new PassthroughProcessor();
        processor.configure(ModeIdentifier.PASSTHROUGH, DatabaseIdentifier.POSTGRES);
        processor.process(new DataPoint("Sample Data"));

        processor.configure(ModeIdentifier.DUMP, DatabaseIdentifier.POSTGRES);
        processor.process(new DataPoint("Sample Data"));

        processor = new ValidateProcessor();
        processor.configure(ModeIdentifier.VALIDATE, DatabaseIdentifier.ELASTIC);
        processor.process(new DataPoint("Sample Data"));
    }
}

