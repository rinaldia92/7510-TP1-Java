package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facts {

    private Map<String,List<List<String>>> facts;

    public Facts(){
        this.facts = new HashMap<>();
    }

    public void AddFact(Fact fact){
        String name;
        List<String> parameters;

        List<List<String>> listparameters;

        name = fact.ObtainName();
        parameters = fact.ObtainParameters();

        if(this.facts.containsKey(name)){
            this.facts.get(name).add(parameters);
        } else {
            listparameters = new ArrayList<>();
            listparameters.add(parameters);
            this.facts.put(name,listparameters);
        }
    }

    public boolean ExistQuery(Fact fact){

        String name;
        List<String> parameters;

        name = fact.ObtainName();
        parameters = fact.ObtainParameters();

        if(this.facts.containsKey(name)){
            if(this.facts.get(name).contains(parameters)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

}
