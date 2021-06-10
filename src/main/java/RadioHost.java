import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioHost {
    private String name;
    private double workAgeHour;
    private boolean isInvitedRadioHost;
    private List<Translation> translationList = new LinkedList<>();

    RadioHost (String name, double workAgeHour, boolean isInvitedRadioHost){
        this.name = name;
        this.workAgeHour = workAgeHour;
        this.isInvitedRadioHost = isInvitedRadioHost;
    }

    void addTranslation (Translation translation){
        translationList.add(translation);
        workAgeHour+= TimeUnit.SECONDS.toHours(translation.getTranslationTime());
    }

    double getWorkAgeHour (){
        return workAgeHour;
    }

    String getName (){
        return name;
    }

    @Override
    public String toString() {
        return "RadioHost{" +
                "name='" + name + '\'' +
                ", workAgeHour=" + workAgeHour +
                ", isInvitedRadioHost=" + isInvitedRadioHost +
                ", translationList=" + translationList +
                '}';
    }
}
