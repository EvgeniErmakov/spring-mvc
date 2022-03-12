package ermakov.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "fill in the field")
    @Size(max = 10, message = "no more then 10 symbols")
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
