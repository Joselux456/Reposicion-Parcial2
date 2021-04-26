package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends Activity {

    private List<Step> steps;

    public NormalActivity(String name, String state, Iteration iteration) {
        super(name, state, iteration);
        this.steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

    /**
     * Gives the duration (in days) of a given Normal Activity
     * throws an exception if it does not have steps.
     *
     * @return Duration.ofDays()
     * @throws SabanaResearchException
     */

    @Override
    public Duration getDuration() throws SabanaResearchException {
        if(this.steps.size() == 0){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_NORMAL_ACTIVITY);
        }

            return Duration.ofDays(0);
    }
}
