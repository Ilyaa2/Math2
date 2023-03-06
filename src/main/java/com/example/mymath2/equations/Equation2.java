package com.example.mymath2.equations;

import com.example.mymath2.abstraction.Equation;

public class Equation2 extends Equation {

    public Equation2(double a, double b) {
        super(a, b);
    }

    public double calcFunc(double x) {
        return Math.pow(x, 3) - x + 4;
    }

    @Override
    public double calcFirstDerivative(double x) {
        return 3 * Math.pow(x, 2) - 1;
    }

    @Override
    public double calcSecondDerivative(double x) {
        return 6 * x;
    }

    /*
    @Override
    public double calcAuxiliaryFunction(double x) {
        //return x * 12 / 11 - Math.pow(x, 3) / 11 - 4d / 11d;
        return lambda * Math.pow(x, 3) - lambda * x + x + 4 * lambda;
    }

    @Override
    public double calcDerivativeOfAuxiliaryFunction(double x) {
        //return -Math.pow(x, 2) * 3 / 11 + 12d / 11;
        return 3 * lambda * Math.pow(x, 2) - lambda + 1;
    }

     */

}
