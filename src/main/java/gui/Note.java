package gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

 class Note extends JFrame{

    private String content = "";
    private final JTextArea textArea = new JTextArea();

    Note(){
        setBounds(800, 400, 200, 200);
        setVisible(false);

        textArea.setColumns(3);
        textArea.setRows(3);

        add(textArea);
        textArea.setText(content);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                content = textArea.getText();
            }
        });
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public String getContent() {
        return content;
    }
}