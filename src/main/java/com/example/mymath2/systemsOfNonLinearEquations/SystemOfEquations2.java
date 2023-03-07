package com.example.mymath2.systemsOfNonLinearEquations;


import com.example.mymath2.abstraction.SystemOfEquations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class SystemOfEquations2 implements SystemOfEquations {
     /*
    y^2 + x - 8 =0
    x^2 + y + 5x =0
     */

    private static final List<List<UnaryOperator<Double>>> matrix_of_derivative = new ArrayList<>() {{
        add(new ArrayList<>() {{
            add((x) -> 1d);
            add((y) -> 2 * y);
        }});
        add(new ArrayList<>() {{
            add((x) -> 2 * x + 5);
            add((y) -> 1d);
        }});
    }};

    private static final List<BinaryOperator<Double>> array_of_functions = new ArrayList<>() {{
        add((x, y) -> ( -(y * y + x - 8) ));
        add((x, y) -> ( -(x * x + y + 5*x) ));
    }};

    @Override
    public List<List<UnaryOperator<Double>>> getMatrix() {
        return matrix_of_derivative;
    }

    @Override
    public List<BinaryOperator<Double>> getArray() {
        return array_of_functions;
    }

    @Override
    public double resultOfFirstFunc(double x) {
        return Math.sqrt(8-x);
    }

    @Override
    public double resultOfSecondFunc(double x) {
        return -5*x - x*x;
    }


}
