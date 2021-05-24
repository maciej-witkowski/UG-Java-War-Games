package main;

public class ManeuversReport extends ReportGeneral {
    private final Integer price;
    private final Boolean result;
    private final String[] soldiers;

    public ManeuversReport(General general, Integer price, Boolean result, String[] ids) {
        super(general);
        this.price = price;
        this.result = result;
        this.soldiers = ids;
    }

    public ManeuversReport(General general, Integer price, Boolean result) {
        super(general);
        this.price = price;
        this.result = result;
        this.soldiers = new String[0];
    }

    @Override
    public String ready() {
        StringBuilder army = new StringBuilder();
        if (this.soldiers.length == 0) {
            army = new StringBuilder("całej armii");
        } else {
            army.append("następujących żołnierzy (");
            for (int i = 0; i < this.soldiers.length; i++) {
                if (i == 0) {
                    army.append(this.soldiers[i]);
                } else {
                    army.append(", ").append(this.soldiers[i]);
                }
            }
            army.append(")");
        }

        return super.ready() + ((this.result) ? "Z powodzeniem" : "Z niepowodzeniem") + " przeprowadzono manewry bojowe " + army + " na kwotę " + this.price + " zł.";
    }
}
