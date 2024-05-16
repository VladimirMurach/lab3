package lab3;

import java.util.ArrayList;

public class Storage {
    
    private ArrayList<ReactorType> reactorTypes;
    private ArrayList<Reactor> reactors;

    public ArrayList<Reactor> getReactors() {
        return reactors;
    }

    public void setReactors(ArrayList<Reactor> reactors) {
        this.reactors = reactors;
    }

    public ArrayList<ReactorType> getReactorTypes() {
        return reactorTypes;
    }

    public void setReactorTypes(ArrayList<ReactorType> reactorTypes) {
        this.reactorTypes = reactorTypes;
    }
}
