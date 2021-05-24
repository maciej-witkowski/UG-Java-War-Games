package main;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Report report);
}
