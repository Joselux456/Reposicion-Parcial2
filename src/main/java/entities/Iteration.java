package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Iteration {

    private String goal;
    private Project project;
    private List<Activity> activities;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
    /**
     * Counts how many open activities there are.
     *
     * @return Amount of open activities
     */
    public int countOpenActivities() {
        int count=0;
        for(Activity a : this.activities)
            if(a.isActive()) {
                count += 1;
            }
        return count;
    }

    /**
     * It give the duration (in days) of a given iteration if it has activities.
     *
     * @return Duration.ofDays()
     * @throws SabanaResearchException
     */

    public Duration getDuration() throws SabanaResearchException{
        if(this.activities.size() == 0){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_ITERATION);
        }
        else
            for (Activity a: this.activities)
                a.getDuration();

        return Duration.ofDays(0);
    }

}
