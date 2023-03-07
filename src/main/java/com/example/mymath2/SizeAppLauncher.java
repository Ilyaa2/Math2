package com.example.mymath2;

import com.example.mymath2.util.Switch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class SizeAppLauncher extends Application {

    public static void main(String[] args) {
        //Application.launch(SizeAppLauncher.class, args);

        //new Switch().doSwitch();
        launch(args);
    }

    @Override
    public void start(Stage stage){
        try {
            URL url = Paths.get("C:\\Users\\User\\IdeaProjects\\myMath2\\src\\main\\resources\\com\\example\\mymath2\\SizeApp.fxml").toUri().toURL();
            final Parent root = FXMLLoader.load(url);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Size Example");
            /*
            stage.setMinHeight(250);
            stage.setMinWidth(500);
            stage.setMaxHeight(500);
            stage.setMaxWidth(1000);

             */

            stage.setMinHeight(500);
            stage.setMinWidth(1000);

            stage.setMaxHeight(1000);
            stage.setMaxWidth(1500);

            stage.show();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}