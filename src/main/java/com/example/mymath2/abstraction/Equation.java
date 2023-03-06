package com.example.mymath2.abstraction;

public abstract class Equation {
    protected double lambda;

    public Equation(double a, double b){
        if (Math.abs(calcFirstDerivative(a)) > Math.abs(calcFirstDerivative(b))){
            lambda = - 1 / Math.abs(calcFirstDerivative(a));
        } else{
            lambda = - 1 / Math.abs(calcFirstDerivative(b));
        }
    }

    public abstract double calcFunc(double x);

    public abstract double calcFirstDerivative(double x);

    public abstract double calcSecondDerivative(double x);

    public double calcAuxiliaryFunction(double x) {
        return calcFunc(x) * lambda + x;
    }

    public double calcDerivativeOfAuxiliaryFunction(double x) {
        return calcFirstDerivative(x) * lambda + 1;
    }
}
