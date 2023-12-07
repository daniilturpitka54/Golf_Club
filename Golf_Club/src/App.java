import java.util.HashMap;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        HashMap<String, Member> members = new HashMap<String, Member>();
        HashMap<String, TeeTime> teeTimes = new HashMap<String, TeeTime>();
        String[] availableTimes = new String[] { "5:00", "5:10", "5:20", "5:30", "5:40", "5:50", "6:00", "6:10", "6:20",
                "6:30", "6:40", "6:50", "7:00" };
        HashMap<Date, TeeTime> tthourh = new HashMap<Date, TeeTime>();
        int teeTimeIds = 1;
        String[][] comands = { { "ADD_GOLFER", "Mr.", "Tiger Woods", "36.4" },
                { "ADD_GOLFER", "Mr.", "Victor Hovland", "12.7" }, { "ADD_SCORE", "Victor Hovland", "102" },
                { "ADD_SCORE", "Tiger Woods", "90" },
                { "ADD_SCORE", "Tiger Woods", "75" },
                { "ADD_SCORE", "Tiger Woods", "80" },
                { "ADD_SCORE", "Tiger Woods", "96" },
                { "GET_AVERAGE", "Tiger Woods" },
                { "GET_BEST", "Tiger Woods" },
                { "GET_BEST", "Victor Hovland" },
                { "NEW_TEETIME", "Tiger Woods, Daniil Turpitka", "5:40", "2" },
                { "NEW_TEETIME", "John Dally, Dustin Johnson, John Ram", "5:40", "2" },
                { "NEW_TEETIME", "Daniil Turpitka", "5:40", "2" }
        };
        for (int i = 0; i < comands.length; i++) {
            String comand = comands[i][0];
            if (comand == "ADD_GOLFER") {
                Member temp = new Member(comands[i][2], comands[i][1], Float.parseFloat(comands[i][3]));
                members.put(comands[i][2], temp);
            } else if (comand == "ADD_SCORE") {
                Member temp = members.get(comands[i][1]);
                temp.AddScore(Integer.parseInt(comands[i][2]));
            } else if (comand == "GET_AVERAGE") {
                Member temp = members.get(comands[i][1]);
                System.out.println(temp.getAverage());
            } else if (comand == "GET_BEST") {
                Member temp = members.get(comands[i][1]);
                System.out.println(temp.bestScore());
            } else if (comand == "NEW_TEETIME") {
                String[] pls = comands[i][1].split(", ", 4);
                int numPlayers = pls.length;
                TeeTime tempTT = teeTimes.get(comands[i][2]);
                if (teeTimes.containsKey((comands[i][2]))) {
                    if (4 - tempTT.numPlayers >= numPlayers) {
                        System.out.println(
                                "Your teetime is confirmed. You will be paierd up with: " + tempTT.listPlayers());
                        for (int j = 0; j < pls.length; j++) {
                            tempTT.players[j + numPlayers] = pls[j];
                            tempTT.numPlayers++;
                        }

                    } else {
                        System.out.println("This teetime cannot fit your party. Choose a different teetime.");
                    }
                } else {
                    teeTimes.put(comands[i][2], new TeeTime(pls, comands[i][2], comands[i][3]));
                    System.out.println("Your teetime is confirmed");
                }

            }

        }

    }
}
