import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        HashMap<String, Member> members = new HashMap<String, Member>();
        String[][] comands = { { "ADD_GOLFER", "Mr.", "Tiger Woods", "36.4" },
                { "ADD_GOLFER", "Mr.", "Victor Hovland", "12.7" }, { "ADD_SCORE", "Victor Hovland", "102" },
                { "ADD_SCORE", "Tiger Woods", "90" },
                { "ADD_SCORE", "Tiger Woods", "75" },
                { "ADD_SCORE", "Tiger Woods", "80" },
                { "ADD_SCORE", "Tiger Woods", "96" },
                { "GET_AVERAGE", "Tiger Woods" },
                { "GET_BEST", "Tiger Woods" },
                { "GET_BEST", "Victor Hovland" }
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
            }
        }

    }
}
