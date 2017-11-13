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

        Facts diccfacts = Facts.GetInstance();
        this.rules = Rules.GetInstance();

        boolean exception;

        this.rules.AddRule(new Rule("abuelo(X, Y, Z) :- varon(X), padre(X, Y), padre(Y,Z)."));

        Assert.assertFalse(this.rules.ExistQuery(new Fact("abuelo(pepe,hector)"),diccfacts));

        exception = false;

        try{
            this.rules.AddRule(new Rule("abuelo(X, Y, Z) :- varon(X), padre(X, Y), padre(Y,Z)."));
        } catch (RuleException ex){
            exception = true;
        }

        Assert.assertTrue(exception);
    }
}
