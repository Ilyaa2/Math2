package com.example.mymath2;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import com.example.mymath2.util.Switch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;

public class MainAppController implements Initializable {

    Switch sw;

    //Это объект на разметке, который имеет грид, рисунок
    @FXML
    private LineChart<Double, Double> lineGraph;

    //Это аккумулятор точек
    private MyGraph mathsGraph;


    //Здесь можно получить функцию
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        sw = new Switch();
        sw.doSwitch();
        mathsGraph = new MyGraph(lineGraph, 10); //range влияет на точность графика
        lineGraph.setVisible(true);
        if (sw.getEquation() != null){
            mathsGraph.plotLine(x -> sw.getEquation().calcFunc(x));
        } else{
            //в силу симметричности первых функций:
            mathsGraph.plotLine(x -> sw.getSystemOfEquations().resultOfFirstFunc(x));
            mathsGraph.plotLine(x -> -sw.getSystemOfEquations().resultOfFirstFunc(x));

            mathsGraph.plotLine(x -> sw.getSystemOfEquations().resultOfSecondFunc(x));
        }

    }

}