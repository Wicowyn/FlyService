package bean;

/**
 * Created by KaadArloon on 13/02/2015.
 */
public class Advertising {
    private Flight flight;

    public Advertising() {}
    public Advertising(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void previsualisationAdvertising(){}
}
