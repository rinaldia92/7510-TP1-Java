package ar.uba.fi.tdd.rulogic.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckLine {

    public CheckLine(){
    }

    public String CheckType(String line){
        String regex;
        Pattern pattern;
        Matcher matcher;

        regex = ".*\\(.*\\).*:-.*\\(.*\\).*\\.";

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(line);

        if(matcher.find()){
            return "Rule";
        } else {
            regex = ".*\\(.*\\).*";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(line);
            if(matcher.find()){
                return "Fact";
            } else {
                return null;
            }
        }

    }
}
