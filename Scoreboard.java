public class Scoreboard {

    private String teamOne;
    private String teamTwo;

    private String activeTeam;

    private int teamOneScore = 0;
    private int teamTwoScore = 0;

    public Scoreboard(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;

        activeTeam = this.teamOne;
    }

    public void recordPlay(int points) {
        if (points > 0) {
            if (activeTeam.equals(teamOne)) {
                teamOneScore += points;
            }
            else
                teamTwoScore += points;
        }
        else
        if (activeTeam.equals(teamOne)) {
            activeTeam = teamTwo;
        }
        else
            activeTeam = teamOne;
    }

    public String getScore() {
        return teamOneScore + "-" + teamTwoScore + "-" + activeTeam;
    }
}