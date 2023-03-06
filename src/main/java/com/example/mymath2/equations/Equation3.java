package com.example.mymath2.equations;


import com.example.mymath2.abstraction.Equation;

public class Equation3 extends Equation {
    //0.1e^x -5 + 0.05x^2;

    public Equation3(double a, double b){
        super(a,b);
    }

    @Override
    public double calcFunc(double x) {
        return 0.1 * Math.exp(x) - 5 + 0.05 * Math.pow(x,2);
    }

    @Override
    public double calcFirstDerivative(double x) {
        return 0.1*x + 0.1 * Math.exp(x);
    }

    @Override
    public double calcSecondDerivative(double x) {
        return 0.1 * Math.exp(x) + 0.1;
    }

    /*
    @Override
    public double calcAuxiliaryFunction(double x) {
        return calcFunc(x) * lambda + x;
    }

    @Override
    public double calcDerivativeOfAuxiliaryFunction(double x) {
        return calcFirstDerivative(x) * lambda + 1;
    }

     */
}
