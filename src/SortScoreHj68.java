import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SortScoreHj68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = 0,n = 0,isOrder = 0;
        String key = null;
        ArrayList<Score> scores = new ArrayList<>();
        while (scanner.hasNext()) {
            String str = scanner.next();
//            System.out.println("k: "+k+" n: "+n+" str: "+str+" key: "+key);

            if (k==0){
                n = Integer.parseInt(str);
            } else if (k == 1) {
                isOrder = Integer.parseInt(str);
            } else {
                if (k % 2 == 0) {
                    key = str;
                } else {
                    Score score = new Score(key, Integer.parseInt(str));
                    scores.add(score);
                }

            }
            if (k == n*2+1) {
//                System.out.println("scores: " + scores);
                sortByScore(scores,isOrder);
                scores.clear();
                k=-1;
            }
            if(k != -1) k++; else k =0;

        }
    }

    static class Score{
        String name;
        int score;

        public Score() {
        }

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void sortByScore(ArrayList<Score> scores,int isOrder) {
//        System.out.println("scores: " + scores);
        if (isOrder == 1) scores.sort(Comparator.comparing(a -> a.score));
        else scores.sort((a, b) -> b.score - a.score);
        for (Score score : scores) {
            System.out.println(score.name + " " + score.score);
        }
    }
}
