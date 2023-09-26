package src;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {



    public TasksManager tasksManager;


    public Window(){

        setTitle("ToDo List");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tasksManager = new TasksManager();

        add(tasksManager.textPanel, BorderLayout.CENTER );
        add(tasksManager.buttons, BorderLayout.SOUTH);


        setResizable(false);
        setVisible(true);


    }








}
