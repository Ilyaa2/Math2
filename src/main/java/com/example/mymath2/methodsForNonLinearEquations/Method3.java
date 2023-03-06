package com.example.mymath2.methodsForNonLinearEquations;


import com.example.mymath2.abstraction.Equation;
import com.example.mymath2.abstraction.Method;

public class Method3 extends Method {
    public Method3(double a, double b, double precision, Equation equation){
        super(a,b,precision, equation);
    }

    public Method3(double a, double b, double precision, Equation equation, double init_approximation) {
        super(a, b, precision, equation, init_approximation);
    }

    //проверить чек (проверка того, что дал пользователь, а так же проверка в каждом методе своих особенностей)
    // добавить еще функций

    @Override
    public double calculate() throws Exception {
        if (!check()) throw new Exception();
        double current_x;
        double previous_x;
        if (init_approximation == null) {
            if (equation.calcFirstDerivative(a) > equation.calcFirstDerivative(b)) {
                current_x = a;
            } else {
                current_x = b;
            }
        } else {
            current_x = init_approximation;
        }
        do {
            count_of_iterations++;
            previous_x = current_x;
            current_x = equation.calcAuxiliaryFunction(previous_x);
            System.out.println(previous_x + "     " + current_x +"      "+"       "+ equation.calcAuxiliaryFunction(current_x) + "      " + equation.calcFunc(current_x) + "     " + Math.abs(current_x - previous_x));
        }while(Math.abs(current_x - previous_x) > precision);

        return current_x;
    }

    @Override
    public boolean check() {
        return preValidation(
                (min) -> {
                    if (!(equation.calcDerivativeOfAuxiliaryFunction(min) >= 0 && equation.calcDerivativeOfAuxiliaryFunction(min) < 1)){
                        System.out.println("Не соблюдается достаточное условие сходимости на интервале");
                        return false;
                    }
                    return true;
                }
        );
    }

    /*
    @Override
    public boolean preValidation() {
        if (function.calcFunc(a) * function.calcFunc(b) > 0){
            System.out.println("На введенном интервале либо нет корней, либо корень не единственный");
            return false;
        }

        if (a == b && function.calcFunc(a)==0){
            System.out.println("Вы уже и так знаете ответ, зачем мучать программу???");
            return false;
        }

        double init_derivative = function.calcFirstDerivative(a);
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
            if (init_derivative * function.calcFirstDerivative(min) < 0){
                System.out.println("Корень на указанном промежутке не единственный");
                return false;
            }
            if (!(function.calcDerivativeOfAuxiliaryFunction(min) >= 0 && function.calcDerivativeOfAuxiliaryFunction(min) < 1)){
                System.out.println("Не соблюдается достаточное условие сходимости на интервале");
                return false;
            }
            min = min + step;
        }
        return true;
    }

     */



}
