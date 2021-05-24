package main;

public class PromotionReport extends ReportSoldier {

    private final String rank;

    public PromotionReport(Soldier soldier, String rank) {
        super(soldier);
        this.rank = rank;
    }

    @Override
    public String ready() {
        return super.ready() + "Żołnierz awansował na stopień: " + this.rank;
    }
}
