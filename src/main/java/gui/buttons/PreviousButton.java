package gui.buttons;

import controllers.Controller;
import utils.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class PreviousButton extends Button {

    private View view = View.WEEK;
    private LocalDate date = LocalDate.now();
    private Controller controller = Controller.getInstance();

    public PreviousButton(){
        super();
        setBounds(200,10,50,30);
        setText("<");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onButtonClicked();
                controller.actionOnDateUpdate(date);
            }
        });
    }

    @Override
    void onButtonClicked() {
        date = date.minus(view.getDateCalculationStrategy().apply(date), view.getDateUnit().get());
    }

    @Override
    public void onDateUpdate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void onViewUpdate(View view) {
        this.view = view;
    }
}