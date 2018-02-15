package controllers;

import observers.DateObserver;
import observers.ViewObserver;
import utils.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    private Controller() {
    }

    private List<ViewObserver> viewObservers = new ArrayList<>();
    private List<DateObserver> dateObservers = new ArrayList<>();

    public void registerViewObservers(ViewObserver viewObserver){
        viewObservers.add(viewObserver);
    }

    public void actionOnViewUpdate(View view){
        viewObservers.forEach(s -> s.onViewUpdate(view));
    }

    public void registerDateObservers(DateObserver dateObserver){
        dateObservers.add(dateObserver);
    }

    public void actionOnDateUpdate(LocalDate date){
        dateObservers.forEach(s -> s.onDateUpdate(date));
    }
}