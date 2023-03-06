package com.example.mymath2;

import com.example.mymath2.abstraction.*;
import com.example.mymath2.equations.*;
import com.example.mymath2.methodsForNonLinearEquations.*;
import com.example.mymath2.util.GaussMethod;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.util.Arrays;

public class HelloApplication extends Application{

    public static void main(String[] args) {
        launch(args);
        //begin();
        //supplySystem();
        //SystemSolver systemSolver = new SystemSolver(new SystemOfEquations1(),1,2, 0.01);
        //SystemSolver systemSolver = new SystemSolver(new SystemOfEquations2(),-1,3, 0.01);
        //systemSolver.solve();
    }

    @Override
    public void start(Stage stage) {

        // установка надписи
        Text text = new Text("Hello METANIT.COM!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(80);   // установка положения надписи по оси X

        Group group = new Group(text);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }

    private static void supplySystem(){
        int n = 3;
        double[][] A = {{4,2,1},{7,8,9},{9,1,3}};
        double[] b = {1,1,2};

        double[] answers = GaussMethod.solveSystem(n, A, b);
        System.out.println(Arrays.toString(answers));
    }

    private static void begin(){
        /* функция 1
        double a = -5;
        double b = -3;

         */

        /* функция 2
         */
        double a = -2;
        double b = -1;

        /* функция 3

        double a = 0.3;
        double b = 5;

         */
        Method method1 = new Method3(a,b, 0.01,new Equation2(a, b));
        try {
            method1.calculate();
            System.out.println("count of iterations:" + method1.getCount_of_iterations());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}