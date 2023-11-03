import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TeeTime {
    int[] players = { 0, 0, 0, 0 };
    Date date;
    int resId;

    int carts;

    TeeTime(int[] ps, String dt, int cts, int rid) {
        for (int i = 0; i < players.length; i++) {
            players[i] = ps[i];
        }
        resId = rid;
        carts = cts;
        try {
            SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-mm-dd-HH-MM");
            date = dateForm.parse(dt);
        } catch (java.text.ParseException exc) {
            System.out.println(exc);
        }

    }

}
