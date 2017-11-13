package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class KnowledgeTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(KnowledgeBase.class);
        this.knowledgeBase = new KnowledgeBase();

    }

    @Test
    public void test() {

        Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
        Assert.assertFalse(this.knowledgeBase.answer("mujer(carla) ."));
        Assert.assertTrue(this.knowledgeBase.answer("padre(juan, pepe)."));
        Assert.assertFalse(this.knowledgeBase.answer("padre(juan, javier)."));
        Assert.assertTrue(this.knowledgeBase.answer("hijo(pepe,juan)"));
        Assert.assertTrue(this.knowledgeBase.answer("hermano(nicolas, roberto)."));
        Assert.assertTrue(this.knowledgeBase.answer("tio(nicolas, alejandro, roberto)."));
        Assert.assertFalse(this.knowledgeBase.answer("varon (javier"));
        Assert.assertFalse(this.knowledgeBase.answer("varon (javier) :- padre(X,Y)."));

    }
}
