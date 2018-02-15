package gui;

import controllers.Controller;
import observers.DateObserver;
import observers.ViewObserver;
import utils.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DownPanel extends JPanel implements ViewObserver, DateObserver {

    private LocalDate date;
    private View view;
    private Controller controller = Controller.getInstance();
    private Map<String, Note> notes = new HashMap<>();

    public DownPanel (){
        setBounds(0, 50, 900, 550);
        setLayout(new GridLayout(6,7));

        view = View.WEEK;
        date = LocalDate.now();

        controller.registerViewObservers(this);
        controller.registerDateObservers(this);
        controller.actionOnViewUpdate(view);
        controller.actionOnDateUpdate(date);
    }

    @Override
    public void onDateUpdate(LocalDate date) {
        this.date = date;
        createButtons();
    }

    @Override
    public void onViewUpdate(View view) {
        this.view = view;
        createButtons();
    }

    private void createButtons() {
        removeAll();

        creatingCalendar(view.getDaysInView().apply(date), view.getStartDateForView().apply(date));

        updateUI();
    }

    private void creatingCalendar(int daysInPeriod, LocalDate startDate) {
        for (int i = 0; i < daysInPeriod; i++){
            JButton button = new JButton(startDate.plusDays(i).toString());
            add(button);
            highlightButtonForActualDate(button);
            onMouseClicked(button);
        }
    }

    private void onMouseClicked(JButton button){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    actionOnButtonClicked(button);
                }
                if(e.getButton() == MouseEvent.BUTTON3){
                    actionOnButtonClicked(button);
                    createNotes(button);
                }
            }
        });
    }

    private void actionOnButtonClicked(JButton button) {
        date = LocalDate.parse(button.getText());
        controller.actionOnDateUpdate(date);
    }

    private void createNotes(JButton button) {
        if (!notes.containsKey(button.getText())) {
            Note note = new Note();
            note.getTextArea().setText(date.toString());
            notes.put(date.toString(), note);
            note.setVisible(true);
        } else {
            Note getNote = notes.get(date.toString());
            getNote.getTextArea().setText(getNote.getContent());
            getNote.setVisible(true);
        }
    }

    private void highlightButtonForActualDate(JButton button){
        if(button.getText().equals(date.toString())){
            button.setBackground(Color.ORANGE);
        }
    }
}