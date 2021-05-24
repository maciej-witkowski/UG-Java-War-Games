package main;

public class DefendReport extends ReportGeneral {
    private final String result;
    private final General invader;

    public DefendReport(General general, General invader, String result) {
        super(general);
        this.result = result;
        this.invader = invader;
    }

    @Override
    public String ready() {
        return super.ready() + "Obrona przeciwko armii generała: " + this.invader.personalInfo() + ", rezultat: " + this.result;
    }
}
