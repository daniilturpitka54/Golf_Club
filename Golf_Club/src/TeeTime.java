import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TeeTime {
    String[] players = { "", "", "", "" };
    Date date;
    int resId;
    int numPlayers = 0;
    int carts;

    TeeTime(String[] ps, String gt, String cts) {
        for (int i = 0; i < ps.length; i++) {
            players[i] = ps[i];
            numPlayers++;
        }
        carts = Integer.parseInt(cts);
        String gameTime = gt;
    }

    public String listPlayers() {
        String retplayers = "";
        for (int i = 0; i < this.numPlayers; i++) {
            retplayers = retplayers.concat(this.players[i]);
            retplayers = retplayers.concat(", ");
        }
        return retplayers;
    }

}
