package ar.uba.fi.tdd.rulogic.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rules {

    private Map<String,List<String>> rulesparameters;
    private Map<String,String> rules;

    private static Rules instance = null;

    public static Rules GetInstance(){
        if (instance == null)
            instance = new Rules();
        return instance;
    }

    private Rules(){
        this.rulesparameters = new HashMap<>();
        this.rules = new HashMap<>();
    }

    public void AddRule(Rule rule){
        String name;
        String srule;
        List<String> parameters;

        name = rule.ObtainName();
        srule = rule.ObtainRule();
        parameters = rule.ObtainParameters();

        if(this.rulesparameters.containsKey(name)){
            throw new RuleException();
        } else {
            this.rulesparameters.put(name,parameters);
            this.rules.put(name,srule);
        }
    }

    public boolean ExistQuery(Fact fact, Facts diccfacts){
        String name;
        List<String> queryparameters;
        List<String> ruleparameters;
        String rule;

        int i,size;
        Pattern pattern;
        Matcher matcher;

        List<Fact> facts;
        Rule completerule;

        boolean exits;

        name = fact.ObtainName();

        if(this.rules.containsKey(name)){
            queryparameters = fact.ObtainParameters();
            ruleparameters = this.rulesparameters.get(name);
            rule = this.rules.get(name);

            size = ruleparameters.size();

            if(size == queryparameters.size()){

                for(i = 0; i < size; i++){
                    pattern = Pattern.compile(ruleparameters.get(i));
                    matcher = pattern.matcher(rule);
                    rule = matcher.replaceAll(queryparameters.get(i));
                }

                exits = true;

                completerule = new Rule(rule);
                facts = completerule.ObtainFacts();

                for(Fact auxfact: facts){
                    exits = exits && diccfacts.ExistQuery(auxfact);
                }
                return exits;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


}
