package gui;

import controllers.Controller;
import observers.DateObserver;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DatePicker implements DateObserver {

    private JTextField textField;
    private Controller controller = Controller.getInstance();
    private LocalDate date = LocalDate.now();

    public DatePicker(){
        textField = new JTextField(date.toString());
        textField.setBounds(250,10,100,30);

        controller.registerDateObservers(this);

        textField.addActionListener(e -> controller.actionOnDateUpdate(date));

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterKeyListener();
                }
            }
        });
    }

    public JTextField getTextField() {
        return textField;
    }

    @Override
    public void onDateUpdate(LocalDate date) {
        this.date = date;
        textField.setText(date.toString());
    }

    private void enterKeyListener(){
        try {
            date = LocalDate.parse(textField.getText());
            textField.setText(date.toString());
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(textField, "Date in incorrect form! Use yyyy-mm-dd format!");
        }
    }
}