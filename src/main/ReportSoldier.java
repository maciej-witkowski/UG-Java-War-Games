package main;

abstract class ReportSoldier extends Report {

    private final Soldier soldier;

    public ReportSoldier(Soldier soldier) {
        super();
        this.soldier = soldier;
    }

    @Override
    public String authorId() {
        return this.soldier.id();
    }

    @Override
    public String ready() {
        return super.ready() + ", " + this.soldier.personalInfo() + ": ";
    }
}
