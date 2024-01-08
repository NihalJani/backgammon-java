public class Game {
    private String outcome;
    private int go;

    /**
     * The alternating char value is for which turn it is. Ideally black will be zero and white will be one.
     * @param nextTurn takes in the value for turn which will be either one or zero.
     * @return go
     */
    public int turn(int nextTurn) {
        switch(nextTurn) {
            case 0:
                go = 1;
                break;
            case 1:
                go = 0;
        }
        return go;
    }

    /**
     * This checks the conditions that
     * @param blackDraughts the value of the black draughts bore off.
     * @param whiteDraughts the value of the white draughts bore off.
     * @return the string value of who won, I still need a way to determine how to shut down the entire program after
     * win in declared.
     */
    public String winConditions(int blackDraughts, int whiteDraughts) {
        if(blackDraughts == 15 || whiteDraughts == 15) {
            if(blackDraughts >= 1) {
                outcome = "White wins, GAMMON";
            }
            if(whiteDraughts >= 1) {
                outcome = "Black wins, GAMMON";
            }
            if(blackDraughts == 0) {
                outcome = "White wins, BACKGAMMON";
            }
            if(whiteDraughts == 0) {
                outcome = "Black wins, BACKGAMMON";
            }
            else if(whiteDraughts == blackDraughts){
                outcome = "!!ERROR IN THE INPUT!!";
            }
        }
        return outcome;
    }
}
