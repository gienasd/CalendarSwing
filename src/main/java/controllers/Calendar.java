package controllers;

import gui.*;
import gui.buttons.NextButton;
import gui.buttons.PreviousButton;

import javax.swing.*;

public class Calendar extends JFrame {

    private PreviousButton previous = new PreviousButton();
    private NextButton next = new NextButton();
    private DatePicker datePicker = new DatePicker();
    private ComboBox comboBox = new ComboBox();
    private DownPanel downPanel = new DownPanel();

    public Calendar(){
        super("Calendar");
        getContentPane().setLayout(null);
        setBounds(500,200,900,620);
        setVisible(true);
        setResizable(false);

        getContentPane().add(datePicker.getTextField());
        getContentPane().add(comboBox.getComboBox());
        getContentPane().add(previous);
        getContentPane().add(next);
        getContentPane().add(downPanel);
    }
}