package gui.buttons;

import controllers.Controller;
import observers.DateObserver;
import observers.ViewObserver;

import javax.swing.*;

abstract class Button extends JButton implements DateObserver, ViewObserver {

    Button(){
        Controller controller = Controller.getInstance();
        controller.registerViewObservers(this);
        controller.registerDateObservers(this);
    }

    abstract void onButtonClicked();
}
