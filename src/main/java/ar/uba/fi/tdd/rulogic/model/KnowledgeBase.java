package ar.uba.fi.tdd.rulogic.model;

import java.util.List;

public class KnowledgeBase {

    private DB db;
    private CheckLine checkline;
	private Facts facts;
	private Rules rules;

    private boolean dbstate;

	public KnowledgeBase(String file){
        List<String> lines;
        String type;
	    this.dbstate = true;
	    this.db = new DB(file);
        this.checkline = new CheckLine();
        this.facts = Facts.GetInstance();
        this.rules = Rules.GetInstance();

        lines = db.GetLines();

        for (String line : lines){
            type = this.checkline.CheckType(line);

            if (type == null){
                this.dbstate = false;
                break;
            }

            if(type.equals("Fact")){
                facts.AddFact(new Fact(line));
            } else {
                rules.AddRule(new Rule(line));
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
