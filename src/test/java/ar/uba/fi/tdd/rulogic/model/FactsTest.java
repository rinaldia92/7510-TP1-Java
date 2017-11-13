package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;


public class FactsTest {

    @InjectMocks
    private Facts facts;

    @Before
    public void setUp() throws Exception {
        initMocks(Facts.class);
    }

    @Test
    public void test() {

        this.facts = new Facts();

        this.facts.AddFact(new Fact("varon  ( juan ) ."));
        this.facts.AddFact(new Fact("varon(pepe)."));
        this.facts.AddFact(new Fact("varon(hector)."));
        this.facts.AddFact(new Fact("varon(roberto)."));
        this.facts.AddFact(new Fact("varon(alejandro)."));
        this.facts.AddFact(new Fact("mujer(maria) ."));
        this.facts.AddFact(new Fact("mujer(cecilia)."));

        Assert.assertTrue(this.facts.ExistQuery(new Fact("varon(juan).")));
        Assert.assertFalse(this.facts.ExistQuery(new Fact("mujer(juan).")));
        Assert.assertFalse(this.facts.ExistQuery(new Fact("hermano(juan).")));

    }



}
