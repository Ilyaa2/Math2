package com.example.mymath2.methodsForNonLinearEquations;

import com.example.mymath2.abstraction.Equation;
import com.example.mymath2.abstraction.Method;

//метод хорд
public class Method1 extends Method {
    //нужен интерфейс принтер, который может писать либо в файл либо в документ

    public Method1(double a, double b, double precision, Equation equation){
        super(a,b,precision, equation);
    }

    public Method1(double a, double b, double precision, Equation equation, double init_approximation){
        super(a,b,precision, equation,init_approximation);
    }

    @Override
    public boolean check(){
        return preValidation(null);
    }


    @Override
    public double calculate() throws Exception {
        if (!check()) throw new Exception();
        //double resistant_end;
        double current_x;
        if (init_approximation == null) {
            if (equation.calcFirstDerivative(a) * equation.calcSecondDerivative(a) > 0) {
                current_x = a;
                //resistant_end = b;
            } else {
                current_x = b;
                //resistant_end = a;
            }
        } else {
            current_x = init_approximation;
        }

        //x = 0;

        double previous_x;
        do{
            count_of_iterations++;
            previous_x = current_x;

            current_x = (a * equation.calcFunc(b) - b * equation.calcFunc(a)) / (equation.calcFunc(b) - equation.calcFunc(a));
            System.out.println(a + "     " + b + "    " + current_x + "     " + equation.calcFunc(a) + "      " + equation.calcFunc(b)    + "        " + equation.calcFunc(current_x) + "      "+ Math.abs(current_x - previous_x));

            if (equation.calcFunc(current_x) * a > 0){
                a = current_x;
            } else{
                b = current_x;
            }

            //x = x - function.calcFunc(x) * (resistant_end - x) / (function.calcFunc(resistant_end) - function.calcFunc(x));
            //System.out.println(resistant_end + "       "+ x + "         "+ function.calcFunc(resistant_end)+"      "+ function.calcFunc(x) + "        "+ Math.abs(x - previous_x));
        } while(Math.abs(current_x - previous_x) > precision);

        return current_x;
    }

}
