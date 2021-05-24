package main;

abstract class ReportGeneral extends Report {

    private final General general;

    public ReportGeneral(General general) {
        super();
        this.general = general;
    }

    @Override
    public String authorId() {
        return this.general.id();
    }

    @Override
    public String ready() {
        return super.ready() + ", " + this.general.personalInfo() + ": ";
    }
}
