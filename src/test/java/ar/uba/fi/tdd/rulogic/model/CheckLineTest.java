package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class CheckLineTest {

    @InjectMocks
    private CheckLine cl;

    @Before
    public void setUp() throws Exception {
        initMocks(CheckLine.class);
    }

    @Test
    public void test() {

        this.cl = new CheckLine();

        Assert.assertEquals(this.cl.CheckType("varon  ( juan ) ."),"Fact");
        Assert.assertEquals(this.cl.CheckType("hijo(X, Y) :- varon(X), padre(Y, X)."),"Rule");
        Assert.assertEquals(this.cl.CheckType("varon  ( juan )"),"Fact");
        Assert.assertEquals(this.cl.CheckType("varon  ( jua"),null);
    }



}
