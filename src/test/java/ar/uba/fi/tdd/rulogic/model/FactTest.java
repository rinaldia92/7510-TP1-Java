package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class FactTest {

    @InjectMocks
    private Fact fact;

    @Before
    public void setUp() throws Exception {
        initMocks(Fact.class);
    }

    @Test
    public void test() {

        this.fact = new Fact("varon  ( javier,javier    ,   javier ) .");

        List<String> result = new ArrayList<String>();

        result.add("javier");
        result.add("javier");
        result.add("javier");

        Assert.assertEquals(this.fact.ObtainName(),"varon");
        Assert.assertEquals(this.fact.ObtainParameters(),result);

        this.fact = new Fact("varon  ( javier,javier    ,   javier )");
        Assert.assertEquals(this.fact.ObtainName(),"varon");

    }

}
