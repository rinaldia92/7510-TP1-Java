package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FR {
    protected String fr;
    protected String name;
    protected List<String> parameters;

    public FR(String fr){
        this.fr = fr;
    }

    protected void PreProcess(){
        String regex = " ";
        String replace = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.fr);
        this.fr = matcher.replaceAll(replace);
        regex = "\t";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(this.fr);
        this.fr = matcher.replaceAll(replace);
    }

    protected void ProcessName(){
        String regex = "\\(.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.fr);
        this.name = matcher.replaceAll("");
    }

    protected void ProcessArguments(){
        String regex;
        String replace;
        String aux;
        Pattern pattern;
        Matcher matcher;

        regex = "^.*\\(";
        replace = "";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(this.fr);
        aux = matcher.replaceFirst(replace);

        regex = "\\).*$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(aux);
        aux = matcher.replaceFirst(replace);
        this.parameters = Arrays.asList(aux.split(",",0));
    }


    public String ObtainName(){
        return this.name;
    }

    public List<String> ObtainParameters(){
        return  this.parameters;
    }
}
