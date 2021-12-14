package Models.syndicates;

import java.io.Serializable;
import java.time.LocalDate;

public class AdditionalTax implements Serializable {
    private LocalDate date;
    private Double value;

    public AdditionalTax(LocalDate _date) {
        this.date = _date;
    }
}
