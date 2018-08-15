package OOPrinciples;

import java.util.ArrayList;

public class Graduate extends Employee implements UniversityStudent {

    private String name;
    private String id;
    public String faveLanguage;
    public String university;

    public Graduate(String name, String id, int salary) {
        super(salary);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFaveLanguage() {
        return faveLanguage;
    }

    public void setFaveLanguage(String faveLanguage) {
        this.faveLanguage = faveLanguage;
    }

    @Override
    public String getUniversity() {
        return this.university;
    }

    @Override
    public void setUniversity(String uni) {
        this.university = uni;
    }

}

