import java.util.ArrayList;

public class Board {

    private int whiteDraughtsOnBar;
    private int blackDraughtsOnBar;
    private boolean whiteAbleToBearOff;
    private boolean blackAbleToBearOff;
    private ArrayList<Point> boardArr;
    private int highestDraughtInWhiteHome;
    private int highestDraughtInBlackHome;

    /**
     * Constructor for Board.
     * Adds 26 points to the board.
     * Index 0 is the black home.
     * Indices 1 -> 24 is the points numbered 1 to 24 respectively.
     * Index 25 is the white home.
     */
    public Board() {
        whiteDraughtsOnBar = 0;
        blackDraughtsOnBar = 0;
        highestDraughtInWhiteHome = 0;
        highestDraughtInBlackHome = 0;
        whiteAbleToBearOff = false;
        blackAbleToBearOff = false;

        //the code below adds points to the board
        boardArr = new ArrayList<>(26);
        boardArr.add(0, new Point('b') );
        for(int i = 1; i <= 12; i++) {
            boardArr.add(i, new Point('g') );
            boardArr.add(i+1, new Point('y') );
        }
        boardArr.add(25, new Point('w'));

    }


    /**
     * Sets the board up as it would be initially in a backgammon game
     */
    public void initializeBoard() {

        boardArr.get(24).addWhiteDraught();
        boardArr.get(24).addWhiteDraught();

        boardArr.get(19).addBlackDraught();
        boardArr.get(19).addBlackDraught();
        boardArr.get(19).addBlackDraught();
        boardArr.get(19).addBlackDraught();
        boardArr.get(19).addBlackDraught();

        boardArr.get(17).addBlackDraught();
        boardArr.get(17).addBlackDraught();
        boardArr.get(17).addBlackDraught();

        boardArr.get(13).addWhiteDraught();
        boardArr.get(13).addWhiteDraught();
        boardArr.get(13).addWhiteDraught();
        boardArr.get(13).addWhiteDraught();
        boardArr.get(13).addWhiteDraught();

        boardArr.get(12).addBlackDraught();
        boardArr.get(12).addBlackDraught();
        boardArr.get(12).addBlackDraught();
        boardArr.get(12).addBlackDraught();
        boardArr.get(12).addBlackDraught();

        boardArr.get(8).addWhiteDraught();
        boardArr.get(8).addWhiteDraught();
        boardArr.get(8).addWhiteDraught();

        boardArr.get(6).addWhiteDraught();
        boardArr.get(6).addWhiteDraught();
        boardArr.get(6).addWhiteDraught();
        boardArr.get(6).addWhiteDraught();
        boardArr.get(6).addWhiteDraught();

        boardArr.get(1).addBlackDraught();
        boardArr.get(1).addBlackDraught();

    }

    /**
     * Used for testing until the gpu is working
     */
    public void displayBoardInText() {
        for(int i = 0; i < 26; i++) {
            System.out.print("White Numbering: " + i + " ---    ");
            for(int j = 0; j < boardArr.get(i).getPointList().size(); j++ ) {
                System.out.print(boardArr.get(i).getPointList().get(j).getColour() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Checks if white is able to bear off
     */
    public void whiteAbleToBearOffCheck() {
        boolean check = true;
        if(this.boardArr.get(25).getWhiteDraughtsOnPoint() > 0) {
            check = false;
        }
        for(int i = 7; i <= 24; i++){
            if(this.boardArr.get(i).getWhiteDraughtsOnPoint() != 0){
                check = false;
            }
        }
        this.whiteAbleToBearOff = check;
    }

    /**
     * Checks if black is able to bear off
     */
    public void blackAbleToBearOffCheck() {
        boolean check = true;
        if(this.boardArr.get(0).getBlackDraughtsOnPoint() > 0) {
            check = false;
        }
        for(int i = 1; i <= 18; i++){
            if(this.boardArr.get(i).getBlackDraughtsOnPoint() != 0){
                check = false;
            }
        }
        this.blackAbleToBearOff = check;
    }

    /**
     * Finds the largest point with a draught on it in
     * white's home board. Used for a specific backgammon rule where
     * for example if you roll a 6 and your highest draught is on point 5 you
     * can still bear off.
     */
    public void highestDraughtInWhiteHome() {
        int highestDraught = 6;
        for(int i = 1; i <= 6; i++) {
            if( boardArr.get(i).getWhiteDraughtsOnPoint() >= 1 ) {
                highestDraught = i;
            }
        }
        highestDraughtInWhiteHome = highestDraught;
    }

    /**
     * Finds the largest point with a draught on it in
     * black's home board. Used for a specific backgammon rule.
     */
    public void highestDraughtInBlackHome() {
        int highestDraught = 19;
        for(int i = 24; i >= 19; i--) {
            if( boardArr.get(i).getBlackDraughtsOnPoint() >= 1) {
                highestDraught = i;
            }
        }
        highestDraughtInBlackHome = highestDraught;
    }


    /**
     * Getter for boardArr
     *
     * @return boardArr
     */
    public ArrayList<Point> getBoardArr() {
        return boardArr;
    }

    /**
     * Getter for highestDraughtInWhiteHome
     *
     * @return highestDraughtInWhiteHome
     */
    public int getHighestDraughtInWhiteHome() {
        return highestDraughtInWhiteHome;
    }

    /**
     * Getter for highestDraughtInBlackHome
     *
     * @return highestDraughtInBlackHome
     */
    public int getHighestDraughtInBlackHome() {
        return highestDraughtInBlackHome;
    }

    /**
     * Getter for whiteAbleToBearOff
     *
     * @return whiteAbleToBearOff
     */
    public boolean isWhiteAbleToBearOff() {
        return whiteAbleToBearOff;
    }

    /**
     * Getter for blackAbleToBearOff
     *
     * @return blackAbleToBearOff
     */
    public boolean isBlackAbleToBearOff() {
        return blackAbleToBearOff;
    }

    /**
     * Checks if there is any white draughts left to determine if game is over
     *
     * @return
     */
    public boolean isWhiteDraughtRemaining() {
        boolean check = false;

        for(int i = 0; i < boardArr.size(); i++) {
            if(boardArr.get(i).getWhiteDraughtsOnPoint() >= 1)
            check = true;
        }
        return  check;
    }

    /**
     * Checks if there is any black draughts remaining to determine if game is over
     *
     * @return
     */
    public boolean isBlackDraughtRemaining() {
        boolean check = false;

        for(int i = 0; i < boardArr.size(); i++) {
            if(boardArr.get(i).getBlackDraughtsOnPoint() >= 1)
            check = true;
        }
        return  check;
    }

    /**
     * Checks if there are any of the inputted colour remaining
     *
     * @param colour
     * @return
     */
    public boolean isDraughtRemaining( char colour ) {
        if(colour == 'w')
            return isWhiteDraughtRemaining();
        else if(colour == 'b')
            return isBlackDraughtRemaining();
        else
            return true;
    }

}
