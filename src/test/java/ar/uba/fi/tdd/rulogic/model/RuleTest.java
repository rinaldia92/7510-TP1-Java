package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class RuleTest {

    @InjectMocks
    private Rule rule;

    @Before
    public void setUp() throws Exception {
        initMocks(Rule.class);
    }

    @Test
    public void test() {

        this.rule = new Rule("hijo(X, Y) :- varon(X), padre(Y, X).");

        List<String> resultparam = new ArrayList<String>();
        List<Fact> resultfact = new ArrayList<Fact>();
        List<Fact> aux;
        resultparam.add("X");
        resultparam.add("Y");

        resultfact.add(new Fact("varon(X)"));
        resultfact.add(new Fact("padre(Y,X)"));

        Assert.assertEquals(this.rule.ObtainName(),"hijo");
        Assert.assertEquals(this.rule.ObtainParameters(),resultparam);
        aux = this.rule.ObtainFacts();
        int i = 0;
        for (Fact fact: aux){
            Assert.assertEquals(fact.ObtainName(),resultfact.get(i).ObtainName());
            Assert.assertEquals(fact.ObtainParameters(),resultfact.get(i).ObtainParameters());
            i++;
        }

    }

}
