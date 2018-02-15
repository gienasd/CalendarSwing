package gui;

import controllers.Controller;
import observers.ViewObserver;
import utils.View;

import javax.swing.*;

public class ComboBox implements ViewObserver {

    private static final View[] SELECTION_MODE = View.values();
    private JComboBox<View> comboBox;
    private View view = View.WEEK;
    private Controller controller = Controller.getInstance();

    public ComboBox(){
        comboBox = new JComboBox<>(SELECTION_MODE);
        comboBox.setBounds(410,10,100,30);
        comboBox.setSelectedItem(view);

        controller.registerViewObservers(this);
        comboBox.addActionListener(e -> {
            View newView = (View) comboBox.getSelectedItem();
            view = newView;
            controller.actionOnViewUpdate(newView);
        });
    }

    public JComboBox<View> getComboBox() {
        return comboBox;
    }

    @Override
    public void onViewUpdate(View view) {
        this.view = view;
    }
}