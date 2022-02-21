import java.time.LocalDate;

public class Car {
    private String numPlate;
    private LocalDate entryDate;

    public Car(final String numPlate, final LocalDate fixDate) {
        this.numPlate = numPlate;
        this.entryDate = fixDate;
    }

    public String getNumPlate() {
        return numPlate;
    }

    public Car setNumPlate(final String numPlate) {
        this.numPlate = numPlate;
        return this;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public Car setEntryDate(final LocalDate entryDate) {
        this.entryDate = entryDate;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %02d/%02d%n%s: %02d/%02d",
                "Numero de matricula", getNumPlate(),
                "Fecha de entrada", getEntryDate().getDayOfMonth(), getEntryDate().getMonthValue(),
                "Fecha de reparación", getEntryDate().plusDays(7).getDayOfMonth(), getEntryDate().plusDays(7).getMonthValue());
    }
}
