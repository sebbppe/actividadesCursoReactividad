package org.example;

import java.util.ArrayList;

public abstract class Subject {
    protected ArrayList<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public abstract void notifiy();

    public ArrayList<Observer> getObservers() {
        return observers;
    }


}
