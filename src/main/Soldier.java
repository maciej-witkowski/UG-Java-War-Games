package main;

public class Soldier extends Person {

    private final Rank rank;
    private Integer experience = 1;
    private Integer combatPotential;
    private Boolean status = true;
    private final General general;

    public Soldier(Integer rank, General general) throws Exception {
        super();
        this.rank = new Rank(rank);
        this.combatPotential = this.experience * this.rank.value();
        this.general = general;
    }

    public String rank() {
        return this.rank.rank();
    }

    public Integer value() {
        return this.rank.value();
    }

    public Integer experience() {
        return this.experience;
    }

    public Integer combatPotential() {
        return this.combatPotential;
    }

    public Boolean status() {
        return this.status;
    }

    private void updateCombatPotential() {
        this.combatPotential = this.experience * this.rank.value();
    }

    private void reset() {
        this.experience = 1;
        updateCombatPotential();
    }

    public void die(String cause) {
        this.status = false;
        updateCombatPotential();
        this.general.sendRaport(new DeathReport(this, cause));
    }

    public void promotion() {
        this.rank.update();
        reset();
        this.general.sendRaport(new PromotionReport(this, rank()));
    }

    public void increaseExp() {
        this.experience += 1;
        updateCombatPotential();
        if (this.experience == this.rank.value() * 5) {
            promotion();
        }
    }

    public void reduceExp() {
        this.experience -= 1;
        updateCombatPotential();
        if (this.experience == 0) {
            die("battle");
        }
    }

    @Override
    public void info() {
        super.info();
        System.out.println(
            "Stopień wojskowy:" +
            "\n\tRanga > " + this.rank.rank() +
            "\n\tWartość > " + this.rank.value() +
            "\nDoświadczenie: " + this.experience + " XP" +
            "\nSiła: " + this.combatPotential + " DMG" +
            "\nStatus: " + ((this.status) ? "Żyje" : "Nie żyje")
        );
    }
}
