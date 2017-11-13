package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class DBTest {

    @InjectMocks
    private DB db;

    @Before
    public void setUp() throws Exception {
        initMocks(DB.class);
    }

    @Test
    public void test() {

        List<String> lines;

        CheckLine checkLine;

        this.db = new DB("./src/main/resources/rules.db");
        checkLine = new CheckLine();
        lines = db.GetLines();

        for(String line:lines){
            System.out.println(checkLine.CheckType(line));
        }


    }
}
