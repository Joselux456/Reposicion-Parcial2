package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DocumentedActivity extends Activity {

    private NormalActivity activity;
    private List<Question> questions;

    public DocumentedActivity(String name, String state, Iteration iteration, NormalActivity activity) {
        super(name, state, iteration);
        this.activity = activity;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * Gives the duration of the activity (in days) if it has associated questions and activities.
     *
     * @return Duration.ofDays()
     * @throws SabanaResearchException
     */

    @Override
    public Duration getDuration() throws SabanaResearchException {
        if(this.questions.size()== 0){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY);
        }
        else
            if(this.activity == null)
                throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY_WITHOUT_NORMAL_QUESTION);
            else
                activity.getDuration();
                for(Question q: this.questions)
                    q.getDedication();

        return Duration.ofDays(0);
    }
}
