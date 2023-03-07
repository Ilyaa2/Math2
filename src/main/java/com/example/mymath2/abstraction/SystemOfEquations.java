package com.example.mymath2.abstraction;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public interface SystemOfEquations {
    public List<List<UnaryOperator<Double>>> getMatrix();

    public List<BinaryOperator<Double>> getArray();

    public double resultOfFirstFunc(double x);
    public double resultOfSecondFunc(double x);
}
