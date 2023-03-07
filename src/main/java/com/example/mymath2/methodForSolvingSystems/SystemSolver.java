package com.example.mymath2.methodForSolvingSystems;


import com.example.mymath2.abstraction.SystemOfEquations;
import com.example.mymath2.util.GaussMethod;

public class SystemSolver {
    private int count_of_iterations = 0;
    private final int count_of_lines = 2;
    private final SystemOfEquations systemOfEquations;
    private double precision = 0.01;

    private double x;
    private double y;

    private double[][] matrix;
    private double[] product;

    public SystemSolver(SystemOfEquations systemOfEquations, double x, double y, double precision) {
        this.systemOfEquations = systemOfEquations;
        this.x = x;
        this.y = y;
        matrix = new double[count_of_lines][count_of_lines];
        product = new double[count_of_lines];
        this.precision = precision;
    }

    public void solve() {
        double[] answers = {1d, 1d};
        while (Math.abs(answers[0]) > precision || Math.abs(answers[1]) > precision) {
            count_of_iterations++;
            for (int i = 0; i < count_of_lines; i++) {
                matrix[i][0] = systemOfEquations.getMatrix().get(i).get(0).apply(x);
                matrix[i][1] = systemOfEquations.getMatrix().get(i).get(1).apply(y);
                product[i] = systemOfEquations.getArray().get(i).apply(x, y);
            }

            answers = GaussMethod.solveSystem(2, matrix, product);
            if (answers == null || count_of_iterations > 10000) {
                System.out.println("нету решений системы, возможно введено плохое приближение");
                return;
            }
            x = x + answers[0];
            y = y + answers[1];
        }
        printAnswer(answers);
    }

    public void printAnswer(double[] answers) {
        System.out.println("count_of_iterations: " + count_of_iterations);
        System.out.println(x + "     " + y);
        System.out.println(Math.abs(answers[0]) + "    " + Math.abs(answers[1]));
    }
}