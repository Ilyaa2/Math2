package com.example.mymath2.abstraction;

public abstract class Method {
    protected double a;
    protected double b;
    protected final double precision;
    protected final Equation equation;
    protected int count_of_iterations = 0;
    protected Double init_approximation;

    public Method(double a, double b, double precision, Equation equation){
        this.a = a;
        this.b = b;
        this.precision = precision;
        this.equation = equation;
    }

    public Method(double a, double b, double precision, Equation equation, double init_approximation){
        this.a = a;
        this.b = b;
        this.precision = precision;
        this.equation = equation;
        this.init_approximation = init_approximation;
    }

    public abstract double calculate() throws Exception;

    public abstract boolean check();

    public int getCount_of_iterations() {
        return count_of_iterations;
    }



    public boolean preValidation(Validation validation){

        if (equation.calcFunc(a) * equation.calcFunc(b) > 0){
            System.out.println("На введенном интервале либо нет корней, либо корень не единственный");
            return false;
            //System.exit(-1);
        }

        if (a == b && Math.abs(equation.calcFunc(a)) < precision){
            System.out.println("Вы уже и так знаете ответ, зачем мучать программу???");
            return false;
            //System.exit(-1);
        }

        double init_derivative = equation.calcFirstDerivative(a);
        double step;
        double min;
        double max;
        if (Math.abs(a) > Math.abs(b)){
            step = Math.abs(b) * 0.1;
        } else {
            step = Math.abs(a) * 0.1;
        }

        if (a > b){
            max = a; min = b;
        } else {
            max = b; min = a;
        }

        while(min < max){
            if (init_derivative * equation.calcFirstDerivative(min) < 0){
                System.out.println("Корень на указанном промежутке не единственный");
                return false;
                //System.exit(-1);
            }
            if (validation != null) {
                if (!validation.valid(min)) {
                    return false;
                }
            }
            min = min + step;
        }
        return true;
    }
}
