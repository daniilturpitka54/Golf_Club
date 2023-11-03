
public class Member {
    String name;
    String title;
    float handicap;
    int gamesPlayed;
    float avgScore;
    int[] scores;
    int bestScore;

    Member(String nm, String tit, float hc) {
        name = nm;
        title = tit;
        handicap = hc;
        scores = new int[15];
    }

    void AddScore(int newscore) {
        if (gamesPlayed == scores.length) {
            int[] temp = scores;
            scores = new int[scores.length * 2];
            for (int i = 0; i <= temp.length; i++) {
                scores[i] = temp[i];
            }
            scores[gamesPlayed] = newscore;
            gamesPlayed++;
            bestScore = Math.min(bestScore, newscore);

        } else {
            scores[gamesPlayed] = newscore;
            if (gamesPlayed > 0) {
                bestScore = Math.min(bestScore, newscore);
            } else {
                bestScore = newscore;
            }
            avgScore = (avgScore * gamesPlayed + newscore) / (gamesPlayed + 1);
            gamesPlayed++;
        }
    }

    float getAverage() {
        return avgScore;
    }

    int bestScore() {
        if (gamesPlayed > 0) {
            return bestScore;
        } else {
            return -1;
        }

    }
}