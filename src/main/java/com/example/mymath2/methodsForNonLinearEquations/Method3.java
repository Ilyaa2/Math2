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
        System.out.println("Метод простой итерации");
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
        System.out.println("");
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


}
