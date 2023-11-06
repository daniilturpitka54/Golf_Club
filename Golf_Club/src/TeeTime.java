import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TeeTime {
    String[] players = { "", "", "", "" };
    Date date;
    int resId;

    int carts;

    TeeTime(String ps, String dt, String cts, int rid) {
        String[] pls = ps.split(", ", 4);
        for (int i = 0; i < pls.length; i++) {
            players[i] = pls[i];
        }
        resId = rid;
        carts = Integer.parseInt(cts);
        try {
            SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd/HH-mm");
            date = dateForm.parse(dt);
        } catch (java.text.ParseException exc) {
            System.out.println(exc);
        }

    }

}
