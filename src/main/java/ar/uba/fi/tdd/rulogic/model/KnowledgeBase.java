package ar.uba.fi.tdd.rulogic.model;

import java.util.List;

public class KnowledgeBase {

    private DB db;
    private CheckLine checkline;
	private Facts facts;
	private Rules rules;

    private boolean dbstate;

	public KnowledgeBase(){
        List<String> lines;
        String type;
	    this.dbstate = true;
	    this.db = new DB("./src/main/resources/rules.db");
        this.checkline = new CheckLine();
        this.facts = new Facts();
        this.rules = new Rules();

        lines = db.GetLines();

        for (String line : lines){
            type = this.checkline.CheckType(line);

            if(type.equals("Fact")){
                facts.AddFact(new Fact(line));
            } else {
                if(type.equals("Rule")){
                    rules.AddRule(new Rule(line));
                } else {
                    this.dbstate = false;
                    break;
                }
            }
        }
    }

	public boolean answer(String query) {

	    String typequery;
	    boolean result;
	    Fact fact;

	    if(!this.dbstate)
	        return false;

	    typequery =  this.checkline.CheckType(query);

	    if(typequery == null)
	        return false;

	    if(typequery.equals("Fact")){
	        fact = new Fact(query);
	        result = this.facts.ExistQuery(fact);
	        if(result){
	            return result;
            } else {
	            return this.rules.ExistQuery(fact,this.facts);
            }

        } else {
	        return false;
        }

	}

}
