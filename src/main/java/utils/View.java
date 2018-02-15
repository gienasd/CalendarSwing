package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.*;

public enum View {
    MONTH(date -> 1L, () -> MONTHS, LocalDate::lengthOfMonth, date -> date.with(TemporalAdjusters.firstDayOfMonth())),
    WEEK(date -> 7L,() -> DAYS, date -> 7, date -> date.with(DayOfWeek.MONDAY));

    private Function<LocalDate, Long> dateCalculationStrategy;
    private Supplier<TemporalUnit>  dateUnit;
    private Function<LocalDate, Integer> daysInView;
    private Function<LocalDate, LocalDate> startDateForView;

    View(Function<LocalDate, Long> dateCalculationStrategy, Supplier<TemporalUnit> dateUnit,
         Function<LocalDate, Integer> daysInView, Function<LocalDate, LocalDate> startDateForView) {
        this.dateCalculationStrategy = dateCalculationStrategy;
        this.dateUnit = dateUnit;
        this.daysInView = daysInView;
        this.startDateForView = startDateForView;
    }

    public Function<LocalDate, Long> getDateCalculationStrategy() {
        return dateCalculationStrategy;
    }

    public Supplier<TemporalUnit> getDateUnit() {
        return dateUnit;
    }

    public Function<LocalDate, Integer> getDaysInView() {
        return daysInView;
    }

    public Function<LocalDate, LocalDate> getStartDateForView() {
        return startDateForView;
    }
}