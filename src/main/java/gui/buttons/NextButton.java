package gui.buttons;

import controllers.Controller;
import utils.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class NextButton extends Button {

    private Controller controller = Controller.getInstance();
    private View view = View.WEEK;
    private LocalDate date = LocalDate.now();

    public NextButton(){
        super();
        setBounds(350,10,50,30);
        setText(">");

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
        date = date.plus(view.getDateCalculationStrategy().apply(date), view.getDateUnit().get());
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