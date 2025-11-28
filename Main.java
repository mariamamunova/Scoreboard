import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scoreboard game = new Scoreboard("Red", "Blue");

        System.out.println(game.getScore());
        game.recordPlay(1);
        System.out.println(game.getScore());
        game.recordPlay(0);
        System.out.println(game.getScore());
        System.out.println(game.getScore());
        game.recordPlay(3);
        System.out.println(game.getScore());
        game.recordPlay(1);
        game.recordPlay(0);
        System.out.println(game.getScore());
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        System.out.println(game.getScore());

        Scoreboard match = new Scoreboard("Lions", "Tigers");
        System.out.println(match.getScore());
        System.out.println(game.getScore());

    }

    private void solution() throws FileNotFoundException {
        int[] wins = new int[7];

        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);

        for (int i = 0; i < 1000; i++){
            int[] scores = new int[2];

            int teamOne = team(s.next());
            int teamTwo = team(s.next());

            int currentTeam = 0;

            while (s.hasNextInt()) {
                int score = s.nextInt();

                if (score > 0) scores[currentTeam] += score;
                else
                {
                    currentTeam = currentTeam == 0 ? 1 : 0;
                }
            }

            if (scores[0] > scores[1]) wins[teamOne] += 1;
            else if (scores[0] < scores[1]) wins[teamTwo] += 1;
        }

        int mostWins = 0;
        int mostWinsTeam = 0;
        for (int i = 0; i < 7; i++){
            if (wins[i] > mostWins) {
                mostWins = wins[i];
                mostWinsTeam = i;
            }
        }

        System.out.println(wins[mostWinsTeam]);

        int leastWins = Integer.MAX_VALUE;
        int leastWinsTeam = 0;
        for (int i = 0; i < 7; i++){
            if (wins[i] < leastWins) {
                leastWins = wins[i];
                leastWinsTeam = i;
            }
        }

        System.out.println(leastWinsTeam);

    }

    private static int team(String team){
        return switch (team) {
            case "Orange" -> 0;
            case "Yellow" -> 1;
            case "Red" -> 2;
            case "Green" -> 3;
            case "Blue" -> 4;
            case "Indigo" -> 5;
            case "Violet" -> 6;
            default -> 7;
        };
    }
}