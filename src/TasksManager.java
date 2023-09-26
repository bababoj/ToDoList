package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.util.Objects;



public class TasksManager extends JPanel implements ActionListener //implements ActionListener {
{
    public JLabel label;
    public JButton add;
    public JButton delete;
    public JTextField textField;
    public JList<String> tasks;
    public DefaultListModel<String> taskListModel;
    public JScrollPane scrollPane;

    JPanel textPanel;
    JPanel buttons;


    public TasksManager(){

        label = new JLabel();
        label.setText(" My Tasks:");
        label.setFont(createFont("resources/LEMONMILK-Light.otf", 34));
        label.setOpaque(false);

        add = new JButton("add");
        add.setFont(createFont("resources/LEMONMILK-Light.otf", 26));
        add.setPreferredSize(new Dimension(200, 60));
        add.setBackground(new Color(255, 192,203));
        add.setFocusable(false);
        add.setBorder(null);
        add.addActionListener(e -> {
            String taskText = textField.getText().trim();
            if (!taskText.isEmpty()) {
                taskListModel.addElement("•" + taskText);
                textField.setText("");
            }
        });

        delete = new JButton("delete");
        delete.setFont(createFont("resources/LEMONMILK-Light.otf", 26));
        delete.setBackground(new Color(255, 192,203));
        delete.setFocusable(false);
        delete.setBorder(null);
        delete.addActionListener(e -> {
                int selectedIndex = tasks.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                }
        });

        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(250, 30));
        textField.setFont(createFont("resources/LEMONMILK-Light.otf", 16));
        textField.setBorder(null);

        taskListModel = new DefaultListModel<>();
        tasks = new JList<>(taskListModel);
        tasks.setFont(createFont("resources/LEMONMILK-Light.otf", 26));

        scrollPane = new JScrollPane(tasks);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        scrollPane.setBorder(null);


        textPanel = new JPanel();
        textPanel.add(label, BorderLayout.NORTH);
        textPanel.add(scrollPane, BorderLayout.CENTER);
        textPanel.add(textField, BorderLayout.SOUTH);
        textPanel.setBackground(new Color(255, 192,203));


        buttons = new JPanel(new FlowLayout());
        buttons.add(add);
        buttons.add(delete);
        buttons.setLayout(new GridLayout(1, 2));

    }
    public Font createFont(String resource, float size){

        String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(resource)).getPath();

        if(filePath.contains("%20")){
            filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(resource)).getPath()
                    .replaceAll("%20", " ");
        }

        try{
            File customFontFile = new File(filePath);
            return Font.createFont(Font.TRUETYPE_FONT, customFontFile).deriveFont(size);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

