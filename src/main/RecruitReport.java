package main;

public class RecruitReport extends ReportGeneral {
    private final Integer rank;
    private final Integer amount;
    private final Integer price;

    public RecruitReport(General general, Integer rank, Integer amount, Integer price) {
        super(general);
        this.rank = rank;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String ready() {
        return super.ready() + "Zwerbowano " + this.amount + " żołnierzy o randze nr. " + this.rank + ", za kwotę " + this.price + " zł.";
    }
}
