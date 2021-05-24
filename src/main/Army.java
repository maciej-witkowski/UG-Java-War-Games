package main;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public final class Army implements Serializable {

    private Soldier[] army;
    private Integer armyStrength = 0;

    public Army(Soldier... args) {
        this.army = args;
        for (Soldier soldier: this.army) {
            this.armyStrength += soldier.combatPotential();
        }
    }

    private void updateArmyStrength() {
        this.armyStrength = 0;
        for (Soldier soldier: this.army) {
            this.armyStrength += soldier.combatPotential();
        }
    }

    public Soldier[] army() {
        return this.army;
    }

    public Integer armyStrength() {
        return this.armyStrength;
    }

    public Integer sumRanks() {
        int result = 0;
        for (Soldier soldier: this.army) {
            result += soldier.value();
        }
        return result;
    }

    public Integer sumRanks(String[] ids) {
        List<String> list = Arrays.asList(ids);
        int result = 0;
        for (Soldier soldier: this.army) {
            if (list.contains(soldier.id())) {
                result += soldier.value();
            }
        }
        return result;
    }

    public void assignSoldier(Soldier soldier) {
        this.army = Arrays.copyOf(this.army, this.army.length + 1);
        this.army[this.army.length - 1] = soldier;
        this.armyStrength += soldier.combatPotential();
    }

    public void dismissSoldier(String id) {
        int index = IntStream.range(0, this.army.length).filter(i -> this.army[i].id().equals(id)).findFirst().orElse(-1);
        this.armyStrength -= this.army[index].combatPotential();
        this.army = IntStream.range(0, this.army.length).filter(i -> i != index).mapToObj(i -> this.army[i]).toArray(Soldier[]::new);
    }

    public void maneuvers() {
        for (Soldier soldier: this.army) {
            soldier.increaseExp();
        }
        updateArmyStrength();
    }

    public void maneuvers(String[] ids) {
        List<String> list = Arrays.asList(ids);
        for (Soldier soldier: this.army) {
            if (list.contains(soldier.id())) {
                soldier.increaseExp();
            }
        }
        updateArmyStrength();
    }

    public void maintenance() {
        for (Soldier soldier: this.army) {
            if (!soldier.status()) {
                dismissSoldier(soldier.id());
            }
        }
    }

    public void spoilsOfWar() {
        for (Soldier soldier: this.army) {
            soldier.increaseExp();
        }
        updateArmyStrength();
    }

    public void warReparations() {
        for (Soldier soldier: this.army) {
            soldier.reduceExp();
        }
        updateArmyStrength();
    }

    public void warAttrition() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.army.length);
        this.army[randomIndex].die("draw");
    }

    public void info() {
        System.out.println("\nŻołnierze: ");
        System.out.println("###############################################");
        for (Soldier soldier: this.army) {
            soldier.info();
            System.out.println("\n###############################################");
        }
        System.out.println("Potencjał bojowy: " + this.armyStrength);
    }
}
