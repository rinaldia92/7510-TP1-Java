package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;


public class RulesTest {

    @InjectMocks
    private Rules rules;

    @Before
    public void setUp() throws Exception {
        initMocks(Rules.class);
    }

    @Test
    public void test() {

        Facts diccfacts = new Facts();
        this.rules = new Rules();

        boolean exception;

        diccfacts.AddFact(new Fact("varon  ( juan ) ."));
        diccfacts.AddFact(new Fact("varon(pepe)."));
        diccfacts.AddFact(new Fact("varon(hector)."));
        diccfacts.AddFact(new Fact("varon(roberto)."));
        diccfacts.AddFact(new Fact("varon(alejandro)."));
        diccfacts.AddFact(new Fact("mujer(maria) ."));
        diccfacts.AddFact(new Fact("mujer(cecilia)."));
        diccfacts.AddFact(new Fact("padre(juan, pepe)."));
        diccfacts.AddFact(new Fact("padre(juan, pepa)."));

        this.rules.AddRule(new Rule("hijo(X, Y) :- varon(X), padre(Y, X)."));

        Assert.assertTrue(this.rules.ExistQuery(new Fact("hijo(pepe,juan)"),diccfacts));
        Assert.assertFalse(this.rules.ExistQuery(new Fact("hijo(pepe,hector)"),diccfacts));
        Assert.assertFalse(this.rules.ExistQuery(new Fact("hijo(pepe,hector,roberto)"),diccfacts));
        Assert.assertFalse(this.rules.ExistQuery(new Fact("hija(pepe,hector)"),diccfacts));

        exception = false;

        try{
            this.rules.AddRule(new Rule("hijo(X, Y) :- varon(X), padre(Y, X)."));
        } catch (RuleException ex){
            exception = true;
        }

        Assert.assertTrue(exception);
    }
}
