package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class KBTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;
    private KnowledgeBase knowledgeBase2;

    @Before
    public void setUp() throws Exception {
        initMocks(KnowledgeBase.class);


    }

    @Test
    public void test() {

        this.knowledgeBase = new KnowledgeBase("./src/main/resources/rules.db");

        Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
        Assert.assertFalse(this.knowledgeBase.answer("mujer(carla) ."));
        Assert.assertTrue(this.knowledgeBase.answer("padre(juan, pepe)."));
        Assert.assertFalse(this.knowledgeBase.answer("padre(juan, javier)."));
        Assert.assertTrue(this.knowledgeBase.answer("hijo(pepe,juan)"));
        Assert.assertTrue(this.knowledgeBase.answer("hermano(nicolas, roberto)."));
        Assert.assertTrue(this.knowledgeBase.answer("tio(nicolas, alejandro, roberto)."));
        Assert.assertFalse(this.knowledgeBase.answer("varon (javier"));
        Assert.assertFalse(this.knowledgeBase.answer("varon (javier) :- padre(X,Y)."));

        this.knowledgeBase2 = new KnowledgeBase("./src/main/resources/badrules.db");

        Assert.assertFalse(this.knowledgeBase2.answer("padre(juan, pepe)."));
    }
}
