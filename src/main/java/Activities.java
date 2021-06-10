import java.util.concurrent.TimeUnit;

public abstract class Activities {
    long time;
    double price;

    double takeProfit (){
        double result = 0;
        result = time * price;
        return result;
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
}