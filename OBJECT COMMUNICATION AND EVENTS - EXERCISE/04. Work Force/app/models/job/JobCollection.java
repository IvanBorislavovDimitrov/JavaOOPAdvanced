package app.models.job;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;

public class JobCollection extends ArrayList<Job> implements EventListener {

    public JobCollection() {
        super();
    }

    public void addJob(Job job) {
        this.add(job);
    }

    public String passWeek() {
        StringBuilder sb = new StringBuilder();
        List<Job> jobsToRemove = new ArrayList<>();
        for (Job job : this) {
            String update = job.update();
            if (update != null) {
                sb.append(update).append(System.lineSeparator());
                jobsToRemove.add(job);
            }
        }

        this.removeAll(jobsToRemove);

        return sb.toString().trim().equals("") ? null : sb.toString().trim();
    }

    public String status() {
        StringBuilder sb = new StringBuilder();
        for (Job job : this) {
            sb.append(job.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
