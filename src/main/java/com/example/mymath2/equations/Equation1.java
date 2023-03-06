package com.example.mymath2.equations;

import com.example.mymath2.abstraction.Equation;

public class Equation1 extends Equation {

    public Equation1(double a, double b) {
        super(a, b);
    }

    //2x^3 + 7.5x^2 - 8x - 9 = 0
    @Override
    public double calcFunc(double x) {
        return 2 * Math.pow(x, 3) + 7.5 * Math.pow(x, 2) - 8 * x - 9;
    }

    @Override
    public double calcFirstDerivative(double x) {
        return 6 * Math.pow(x, 2) + 15 * x - 8;
    }

    @Override
    public double calcSecondDerivative(double x) {
        return 12 * x + 15;
    }

    /*
    @Override
    public double calcAuxiliaryFunction(double x) {
        return 2 * lambda * Math.pow(x, 3) + 7.5 * lambda * Math.pow(x, 2) - 8 * lambda * x + x - 9 * lambda;
    }

    @Override
    public double calcDerivativeOfAuxiliaryFunction(double x) {
        return 6 * lambda * Math.pow(x, 2) + 15 * lambda * x - 8 * lambda + 1;
    }

     */
}
