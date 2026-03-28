import java.text.SimpleDateFormat;
import java.util.Date;
public class DigitalClock {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        String lastTime = "";
        while (true) {
            String currentTime = sdf.format(new Date());
            if (!currentTime.equals(lastTime)) {
                System.out.print("\rCurrent Time: " + currentTime);
                lastTime = currentTime;
            }
        }
    }
}