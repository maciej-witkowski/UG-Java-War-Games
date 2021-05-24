package main;

public class DeathReport extends ReportSoldier {
    private final String cause;

    public DeathReport(Soldier soldier, String cause) {
        super(soldier);
        this.cause = cause;
    }

    @Override
    public String ready() {
        return super.ready() + "Żołnierz został zgładzony" + ((this.cause.equals("battle")) ? " podczas walk." : " w wyniku konferencji pokojowej.");
    }
}

