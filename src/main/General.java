package main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class General extends Person implements Observable {
    private String name;
    private String surname;
    private Army army = new Army();
    private Double budget = 200d;
    private Set<Observer> secretaries = new HashSet<>();

    @Override
    public void attach(Observer observer) {
        secretaries.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        secretaries.remove(observer);
    }

    @Override
    public void notifyObservers(Report report) {
        for (Observer observer: secretaries) {
            observer.update(report);
        }
    }

    public Set<Observer> secretaries() {
        return this.secretaries;
    }

    public void sendRaport(Report report) {
        notifyObservers(report);
    }

    public General(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public String personalInfo() {
        return this.name + ' ' + this.surname;
    }

    public void army() {
        this.army.info();
    }

    public Double budget() {
        return this.budget;
    }

    public void recruit(Integer rank, Integer amount) throws Exception {
        int price = (10 * rank) * amount;
        if (price <= this.budget) {
            for (int i = 0; i < amount; i++) {
                this.army.assignSoldier(new Soldier(rank, this));
            }
            this.budget -= price;
            sendRaport(new RecruitReport(this, rank, amount, price));
        }
    }

    public void commandManeuvers(String... ids) {
        if (ids.length == 0) {
            int price = this.army.sumRanks();
            if (price <= this.budget) {
                this.budget -= price;
                this.army.maneuvers();
                sendRaport(new ManeuversReport(this, price, true));
            } else {
                sendRaport(new ManeuversReport(this, price, false));
            }
        } else {
            int price = this.army.sumRanks(ids);
            if (price <= this.budget) {
                this.budget -= price;
                this.army.maneuvers(ids);
                sendRaport(new ManeuversReport(this, price, true, ids));
            } else {
                sendRaport(new ManeuversReport(this, price, false, ids));
            }
        }
    }

    public void attack(General general) {
        int myStrength = this.army.armyStrength();
        int enemyStrength = general.army.armyStrength();
        if (myStrength > enemyStrength) {
            double money = general.budget() * 0.1;
            battleWon(money);
            general.battleLost(money);
            sendRaport(new AttackReport(this, general, "Zwycięstwo"));
            general.sendRaport(new DefendReport(general, this, "Porażka"));
        } else if (myStrength < enemyStrength) {
            double money = budget() * 0.1;
            battleLost(money);
            general.battleWon(money);
            sendRaport(new AttackReport(this, general, "Porażka"));
            general.sendRaport(new DefendReport(general, this, "Zwycięstwo"));
        } else {
            battleDraw();
            general.battleDraw();
            sendRaport(new AttackReport(this, general, "Remis"));
            general.sendRaport(new DefendReport(general, this, "Remis"));
        }
    }

    private void battleWon(Double money) {
        double scale = Math.pow(10, 2);
        this.budget += Math.round(money * scale) / scale;
        this.army.spoilsOfWar();
        this.army.maintenance();
    }

    private void battleLost(Double money) {
        double scale = Math.pow(10, 2);
        this.budget -= Math.round(money * scale) / scale;
        this.army.warReparations();
        this.army.maintenance();
    }

    private void battleDraw() {
        this.army.warAttrition();
        this.army.maintenance();
    }

    @Override
    public void info() {
        super.info();
        System.out.println(
                "Imię i nazwisko: " + this.name + ' ' + this.surname +
                "\nBudżet: " + this.budget + " zł"
        );
    }

    public void save() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./saves/save_" + format.format(new Date())))) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./saves/save_"))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String file) {
        General deserialized;
        try (ObjectInputStream inputStream  = new ObjectInputStream(new FileInputStream("./saves/" + file))) {
            deserialized = (General) inputStream.readObject();
            this.name = deserialized.name;
            this.surname = deserialized.surname;
            this.army = deserialized.army;
            this.budget = deserialized.budget;
            this.secretaries = deserialized.secretaries;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
