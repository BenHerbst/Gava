package de.benherbst.gava;

import de.benherbst.gava.compiler.CompilerInfo;
import de.benherbst.gava.compiler.JavaFileCompiler;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Main.fxml")));
        primaryStage.setTitle("Gava - German with Java");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}