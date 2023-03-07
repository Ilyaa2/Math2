package com.example.mymath2.methodsForNonLinearEquations;


import com.example.mymath2.abstraction.Equation;
import com.example.mymath2.abstraction.Method;

public class Method2 extends Method {
    public Method2(double a, double b, double precision, Equation equation){
        super(a,b,precision, equation);
    }

    public Method2(double a, double b, double precision, Equation equation, double init_approximation){
        super(a,b,precision, equation,init_approximation);
    }

    @Override
    public double calculate() throws Exception {
        System.out.println("Метод секущих");
        if (!check()) throw new Exception();
        double next_x;
        double current_x;
        double previous_x;

        if (equation.calcFunc(a) * equation.calcSecondDerivative(a) > 0){
            previous_x = a;
        } else if (equation.calcFunc(b) * equation.calcSecondDerivative(b) > 0){
            previous_x = b;
        } else {
            throw new Exception("Функция не будет сходиться");
        }

        if (init_approximation != null){
            previous_x = init_approximation;
        }

        next_x = (a + b) / 2;

        do{
            current_x = next_x;
            count_of_iterations++;
            next_x = current_x - equation.calcFunc(current_x) * (current_x - previous_x) / (equation.calcFunc(current_x) - equation.calcFunc(previous_x));
            System.out.println(previous_x + "    " + current_x + "    " + next_x +"    " + equation.calcFunc(next_x) + "     " + Math.abs(next_x - current_x));
            previous_x = current_x;
        }while(Math.abs(next_x - current_x) > precision);

        System.out.println("");
        return next_x;
    }

    @Override
    public boolean check() {
        return preValidation(null);
    }

    public int getCount_of_iterations() {
        return count_of_iterations;
    }
}
