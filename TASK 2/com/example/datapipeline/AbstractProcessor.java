package com.example.datapipeline;

public abstract class AbstractProcessor implements Processor {
    protected ModeIdentifier mode;
    protected DatabaseIdentifier database;
    protected DatabaseConnector dbConnector;

    @Override
    public void configure(ModeIdentifier mode, DatabaseIdentifier db) {
        this.mode = mode;
        this.database = db;
        switch (db) {
            case POSTGRES:
                this.dbConnector = new PostgresConnector();
                break;
            case REDIS:
                this.dbConnector = new RedisConnector();
                break;
            case ELASTIC:
                this.dbConnector = new ElasticConnector();
                break;
        }
        dbConnector.connect();
    }

    @Override
    public abstract void process(DataPoint data);
}

