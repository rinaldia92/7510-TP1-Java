package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule extends FR{

    private List<Fact> facts;

    public Rule(String rule){
        super (rule);
        this.facts = new ArrayList<>();
        PreProcess();
        ProcessName();
        ProcessArguments();
        ParseFactsofRule();
    }

    public String ObtainRule(){ return this.fr; }

    public List<Fact> ObtainFacts(){
        return this.facts;
    }

    private void ParseFactsofRule(){
        String regex;
        String replace;
        String aux;
        Pattern pattern;
        Matcher matcher;
        List<String> auxfacts;

        regex = ".*:-";
        replace = "";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(this.fr);
        aux = matcher.replaceAll(replace);

        regex = "\\)\\.$";
        replace = ")";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(aux);
        aux = matcher.replaceAll(replace);

        regex = "\\),";
        replace = "\\) ";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(aux);
        aux = matcher.replaceAll(replace);

        auxfacts = Arrays.asList(aux.split(" ",0));

        for(String sfact : auxfacts){
            this.facts.add(new Fact(sfact));
        }
    }

    @Override
    protected void ProcessArguments(){
        String regex;
        String replace;
        String aux;
        Pattern pattern;
        Matcher matcher;

        regex = "\\):-.*";
        replace = "";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(this.fr);
        aux = matcher.replaceFirst(replace);
        regex = "^.*\\(";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(aux);
        aux = matcher.replaceFirst(replace);
        this.parameters = Arrays.asList(aux.split(",",0));
    }

}
