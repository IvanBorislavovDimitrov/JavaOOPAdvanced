package app;

import java.util.ArrayList;
import java.util.List;

public class Institution extends Id {

    private List<String> subjects;
    private List<String> changes;
    private String name;

    public Institution(String id, String name) {
        super(id);
        this.name = name;
        this.subjects = new ArrayList<>();
        this.changes = new ArrayList<>();
    }

    public List<String> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getChanges() {
        return this.changes;
    }

    public void setChanges(List<String> changes) {
        this.changes = changes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
