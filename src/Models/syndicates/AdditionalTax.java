package Models.syndicates;

import java.time.LocalDate;

public class AdditionalTax {
    private LocalDate date;
    private Double value;

    public AdditionalTax(LocalDate _date) {
        this.date = _date;
    }
}
