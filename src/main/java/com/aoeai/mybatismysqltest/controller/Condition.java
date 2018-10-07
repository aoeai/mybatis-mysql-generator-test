package com.aoeai.mybatismysqltest.controller;

public class Condition {

    private String column;

    private Object property;

    private String symbol;

    public String getColumn() {
        return column;
    }

    public Condition setColumn(String column) {
        this.column = column;
        return this;
    }

    public Object getProperty() {
        return property;
    }

    public Condition setProperty(Object property) {
        this.property = property;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public Condition setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }
}
