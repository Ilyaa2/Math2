package com.example.mymath2.systemsOfNonLinearEquations;


import com.example.mymath2.abstraction.SystemOfEquations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class SystemOfEquations1 implements SystemOfEquations {
    /*
    x^2 + y^2 - 4 =0
    -3x^2 + y =0
     */

    private static final List<List<UnaryOperator<Double>>> matrix_of_derivative = new ArrayList<>(){{
        add(new ArrayList<>(){{
            add((x) -> 2*x);
            add((y) -> 2*y);
        }});
        add(new ArrayList<>(){{
            add((x) -> -6*x);
            add((y) -> 1d);
        }});
    }};

    private static final List<BinaryOperator<Double>> array_of_functions = new ArrayList<>(){{
        add( (x,y) -> -(x*x + y*y - 4) );
        add( (x,y) -> -(-3*x*x + y) );
    }};

    @Override
    public List<List<UnaryOperator<Double>>> getMatrix(){
        return matrix_of_derivative;
    }

    @Override
    public List<BinaryOperator<Double>> getArray(){
        return array_of_functions;
    }

}
