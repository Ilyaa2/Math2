package com.example.mymath2.util;

import com.example.mymath2.abstraction.Equation;
import com.example.mymath2.abstraction.Method;
import com.example.mymath2.abstraction.SystemOfEquations;
import com.example.mymath2.equations.Equation1;
import com.example.mymath2.equations.Equation2;
import com.example.mymath2.equations.Equation3;
import com.example.mymath2.methodForSolvingSystems.SystemSolver;
import com.example.mymath2.methodsForNonLinearEquations.Method1;
import com.example.mymath2.methodsForNonLinearEquations.Method2;
import com.example.mymath2.methodsForNonLinearEquations.Method3;
import com.example.mymath2.systemsOfNonLinearEquations.SystemOfEquations1;
import com.example.mymath2.systemsOfNonLinearEquations.SystemOfEquations2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Switch {
    private Equation equation = null;
    private SystemOfEquations systemOfEquations = null;

    public void doSwitch(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eсли Вы хотите вводить данные из клавиатуры, нажмите 1");
        System.out.println("Eсли Вы хотите вводить данные из файла, нажмите 2");
        int option = 0;
        try {
            option = scanner.nextInt();
             if (!(option == 1 || option == 2)) throw new Exception();
        } catch (Exception e){
            System.out.println("Вы ввели неправильное число");
            System.exit(-1);
        }
        //ТУТ СПРАШИВАЮ КУДА ВЫВЕСТИ?
        // В МЕТОДЫ123 ЗАПИСАТЬ ИНТЕРФЕЙСНОЕ ПОЛЕ, ПРИ СОЗДАНИИ В КОНСТРУКТОРЕ ЗАПРАШИВАТЬ ЭТО ГОВНО И ЗАМЕНИТЬ SOUT  НА INTEERFACE.WRITE()
        //В SYSTEMSOLVER ТОЖЕ ТАК ЖЕ
        //В МЕТОДЫ НИЖЕ СКИДЫВАЮ ЗАРАНЕЕ СОЗДАННЫЙ WRITER

        if (option == 1){
            enterFromKeyboard(scanner);
        }
        scanner.close();
        if (option == 2){
            enterFromFile();
        }

    }

    private void enterFromFile() {
        try(FileReader fr = new FileReader("C:\\Users\\User\\IdeaProjects\\myMath2\\src\\main\\java\\com\\example\\mymath2\\file");
            Scanner scan = new Scanner(fr)){
            var option = scan.nextInt();
            var which_equation = scan.nextInt();
            var a = scan.nextDouble();
            var b = scan.nextDouble();
            var precision = scan.nextDouble();


            if (option ==1){
                if (which_equation == 1){
                    equation = new Equation1(a,b);
                } else if (which_equation ==2){
                    equation = new Equation2(a,b);
                } else if (which_equation == 3){
                    equation = new Equation3(a,b);
                }else{
                    throw new Exception();
                }
                ArrayList<Method> list_of_methods = new ArrayList<>(){{
                    add(new Method1(a,b,precision,equation));
                    add(new Method2(a,b,precision,equation));
                    add(new Method3(a,b,precision,equation));
                }};
                for (Method method: list_of_methods){
                    method.calculate();
                }
            } else if (option == 2){
                if (which_equation ==1){
                    systemOfEquations = new SystemOfEquations1();
                } else if(which_equation == 2){
                    systemOfEquations = new SystemOfEquations1();
                } else{
                    throw new Exception();
                }
                SystemSolver systemSolver = new SystemSolver(systemOfEquations, a,b,precision);
                systemSolver.solve();
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Либо не найден файл, либо данные некорректны");
            System.exit(-1);
        }
    }

    private void enterFromKeyboard(Scanner scanner){
        System.out.println("Если Вы хотите решить нелинейное уравнение, нажмите 1");
        System.out.println("Если Вы хотите решить систему нелинейных уравнение, нажмите 2");
        int option = 0;
        try {
            option = scanner.nextInt();
            if (!(option ==1 || option==2)) throw new Exception();
        } catch(Exception e){
            System.out.println("Вы ввели неправильное число");
            System.exit(-1);
        }

        if (option ==1){
            equation(scanner);
        } else{
            systemOfEquation(scanner);
        }
    }

    private void equation(Scanner scanner){
        var option = 0;
        System.out.println("Укажите цифрой какое уравнение вы хотите решить:");
        System.out.println("1) 2x^3 + 7.5x^2 - 8x - 9 = 0");
        System.out.println("2) x^3 - x + 4 = 0");
        System.out.println("3) 0.1e^x -5 + 0.05x^2 = 0;");

        try {
            option = scanner.nextInt();
            if (!(option ==1 || option==2 || option==3)) throw new Exception();
        } catch(Exception e){
            System.out.println("Вы ввели неправильное число");
            System.exit(-1);
        }

        double a=0d;
        double b=0d;
        double precision=0d;
        try{
            System.out.println("Введите промежуток");
            System.out.println("Введите a");
            a = scanner.nextDouble();
            System.out.println("Введите b");
            b = scanner.nextDouble();
            System.out.println("Введите точность");
            precision = scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Вы ввели неправильные числа");
            System.exit(-1);
        }


        if (option ==1){
            equation= new Equation1(a,b);
        } else if(option ==2){
            equation = new Equation2(a,b);
        } else{
            equation = new Equation3(a,b);
        }

        //specificMethod(scanner,a,b, precision, equation);
        ArrayList<Method> list_of_methods = allMethods(a,b,precision,equation);
        for (Method method: list_of_methods){
            try{
                method.calculate();
                System.out.println("count of iterations:" + method.getCount_of_iterations());
            } catch (Exception e){
                System.exit(-1);
            }
        }
    }

    private Method specificMethod(Scanner scanner, double a, double b, double precision, Equation equation){
        System.out.println("Укажите цифрой каким методом вы хотите решить уравнение");
        int option = 0;
        try {
            option = scanner.nextInt();
            if(!(option == 1 || option == 2 || option ==3)) throw new Exception();
        } catch (Exception e){
            System.out.println("Вы ввели неправильное число");
            System.exit(-1);
        }
        if (option==1){
            return new Method1(a,b,precision,equation);
        } else if (option == 2){
            return new Method2(a,b,precision,equation);
        } else {
            return new Method3(a,b,precision,equation);
        }
    }

    private ArrayList<Method> allMethods(double a, double b, double precision, Equation equation){
        return new ArrayList<>(){{
            add(new Method1(a,b,precision,equation));
            add(new Method2(a,b,precision,equation));
            add(new Method3(a,b,precision,equation));
        }};
    }

    private void systemOfEquation(Scanner scanner){
        var option = 0;
        System.out.println("Укажите цифрой какую систему уравнений вы хотите решить:");
        System.out.println("1:");
        System.out.println("x^2 + y^2 - 4 =0\n" + "-3x^2 + y =0");
        System.out.println("");
        System.out.println("2:");
        System.out.println(" y^2 + x - 8 =0\n" + "x^2 + y + 5x =0");

        try {
            option = scanner.nextInt();
            if (!(option ==1 || option==2)) throw new Exception();
        } catch(Exception e){
            System.out.println("Вы ввели неправильное число");
            System.exit(-1);
        }

        System.out.println("Введите начальные приближения для системы уравнений");
        double x=0;
        double y=0;
        double precision=0;
        try {
            System.out.println("Введите x");
            x = scanner.nextDouble();
            System.out.println("Введите y");
            y = scanner.nextDouble();
            System.out.println("Введите точность");
            precision = scanner.nextDouble();
        } catch(Exception e){
            System.out.println("Вы ввели неправильные числа");
            System.exit(-1);
        }
        SystemSolver systemSolver;
        if (option == 1){
            systemOfEquations = new SystemOfEquations1();
            systemSolver = new SystemSolver(systemOfEquations, x,y,precision);
        } else{
            systemOfEquations = new SystemOfEquations2();
            systemSolver = new SystemSolver(systemOfEquations, x,y,precision);
        }
        systemSolver.solve();
    }

    public Equation getEquation() {
        return equation;
    }

    public SystemOfEquations getSystemOfEquations() {
        return systemOfEquations;
    }
}
