package observers;

import java.time.LocalDate;

public interface DateObserver {
    void onDateUpdate(LocalDate date);
}