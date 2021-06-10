import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Translation {
    private String name;
    private long translationTime;
    private RadioHost radioHost;
    private List<Activities> translationActivities = new LinkedList<>();

    Translation(String name ,String time, RadioHost radioHost){
        this.name = name;
        translationTime = convertToSecond(time);
        this.radioHost = radioHost;
    }

    long convertToSecond (String time){
        long result;
        long hours = 0;
        long minutes;
        long seconds ;
        String[] temp = time.split(":");
        seconds = Long.parseLong(temp[temp.length-1]);
        minutes = Long.parseLong(temp[temp.length-2]);
        if (temp.length==3){
            hours = Long.parseLong(temp[0]);
        }
        result = TimeUnit.HOURS.toSeconds(hours)+TimeUnit.MINUTES.toSeconds(minutes)+seconds;
        return result;
    }

    public long getTranslationTime() {
        return translationTime;
    }

    boolean addActivities (Activities newActivities){
        long totalActivitiesTime = getTotalActivitiesTime();
        long totalPaymentTime = getTotalPaymentTime();

        if (totalActivitiesTime + newActivities.time<=translationTime) {
            if (newActivities.price>0){
                if (totalPaymentTime+ newActivities.time<translationTime/2){
                    translationActivities.add(newActivities);
                    return true;
                } else{
                    System.out.println("You don't have enough time for this activities");
                    return false;
                }
            } else {
                translationActivities.add(newActivities);
                return true;
            }
        } else {
            System.out.println("You don't have enough time for this activities");
            return false;
        }
    }

    long getTotalActivitiesTime(){
        long result = 0;
        for (Activities temp : translationActivities){
            result+=temp.time;
        }
        return result;
    }

    long getTotalPaymentTime(){
        long result = 0;
        for (Activities temp : translationActivities){
            if (temp.price>0){
                result+=temp.time;
            }
        }
        return result;
    }

    void startTranslation (){
        System.out.println(this.name + " start");
        for (Activities temp : translationActivities){
            System.out.println(temp);
        }
        System.out.println(this.name + " end");
        radioHost.addTranslation(this);

    }

    void showProfit (){
        double result = 0;
        for (Activities temp : translationActivities){
            if (temp.price>0){
                result+= temp.takeProfit();
            }
        }
        System.out.println(this.name+" profit "+result);
    }
}
