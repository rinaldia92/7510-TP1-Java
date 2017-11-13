package ar.uba.fi.tdd.rulogic.model;

public class Fact extends FR {

    public Fact(String fact){
        super (fact);
        PreProcess();
        ProcessName();
        ProcessArguments();
    }
}
