package main;

public class AttackReport extends ReportGeneral {
    private final String result;
    private final General enemy;

    public AttackReport(General general, General enemy, String result) {
        super(general);
        this.result = result;
        this.enemy = enemy;
    }

    @Override
    public String ready() {
        return super.ready() + "Atak na armię generała: " + this.enemy.personalInfo() + ", rezultat: " + this.result;
    }
}
