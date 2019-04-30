package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TaskList {
    private static String fileName = "TaskList.csv";

    public static String addTask(
            String newTask

    ) throws IOException {

        File f = new File(fileName);
        FileWriter fw = new FileWriter(f, true);
        fw.write(newTask + System.lineSeparator());
        fw.flush();

        return newTask;
    }




}
