package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.geometry.Pos.BASELINE_CENTER;

public class Main extends Application {

    private Stage stage;
    private TextField newTask;
    ListView<String> taskList;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Get things done!");
//        Text header = new Text("");

        Button newBtn = new Button("New task");
        Button doneBtn = new Button("Mark task done");
        Button showBtn = new Button("Show all tasks");

        HBox hBox = new HBox(10);
        hBox.setAlignment(BASELINE_CENTER);
        hBox.getChildren().addAll(newBtn, doneBtn, showBtn);

//        showBtn.setOnAction(event -> {
//             printList();
//            });

        Scene scene = new Scene(hBox, 640, 480);

//šis uz leju ir scene uzdevuma pievienošanai

        newTask = new TextField("Add a new task!");
        HBox addedTask = new HBox();
        Button addBtn = new Button("Add task");
        addedTask.getChildren().addAll(newTask, addBtn);
        Scene addScene = new Scene(addedTask, 640, 480);
        newBtn.setOnAction(event -> {
            stage.setScene(addScene);
        });
        addBtn.setOnAction(event -> {
            try {
                addTask(); //norāda uzdevuma pievienošanas metodi
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //šeit uz leju ir scene Mark as done

        VBox taskDone = new VBox();
        taskList = new ListView<>();
        taskList.getItems();

        Button saveBtn = new Button("Save");
        taskDone.getChildren().addAll(saveBtn);
        Scene doneScene = new Scene(taskDone, 640, 480);
        doneBtn.setOnAction(event -> {
        markDone();
        });


        stage.setScene(scene);
        primaryStage.show();
    }


    private void addTask() throws IOException { //pati uzdevuma pievienošanas metode
        String newTaskString = newTask.getText();
        TaskList.addTask(newTaskString);

        System.out.println("Your task was added!");
        stage.close();
    }


    private void markDone() {

    }
}
//
//    public void printList() {
////        for (Task list : tasks) {
////            System.out.println(list);
//        }



