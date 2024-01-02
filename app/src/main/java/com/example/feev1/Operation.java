package com.example.feev1;

import java.io.Serializable;

public class Operation implements Serializable {
    float a, b;
    String operation;
    public Operation() {
    }
    public Operation(float a, float b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }
    public float getA() {
        return a;
    }
    public void setA(float a) {
        this.a = a;
    }
    public float getB() {
        return b;
    }
    public void setB(float b) {
        this.b = b;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    @Override
    public String toString() {
        return "Operation{" +
                "a=" + a +
                ", b=" + b +
                ", operation=" + operation +
                '}';
    }
}
