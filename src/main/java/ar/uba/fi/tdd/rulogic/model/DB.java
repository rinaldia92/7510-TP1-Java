package ar.uba.fi.tdd.rulogic.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DB {

    private String file;
    private List<String> lines;

    public DB(String file){
        this.file = file;
        this.lines = new ArrayList<>();
        ParseLines();
    }

    private void ParseLines(){
        try (Stream<String> stream = Files.lines(Paths.get(this.file))) {
            stream.forEach(this.lines::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> GetLines() {
        return lines;
    }
}
