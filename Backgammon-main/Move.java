import java.util.Random;
import java.util.Scanner;
public class Move {

        public Board board;
        private final int moveFrom;
        private final int die;
        private char movingDraughtColor;
        private boolean legalMove;
        private boolean hitBlot;
        Random random = new Random();

        /**
         * Constructor for move.
         * In later methods, moveFrom is the point number that the draught will be moved from.
         * Die is the value of the die rolled.
         *
         * Ex. If moveFrom is 5 and die is 3.
         * A white draught would be moved to point 2.
         * A black draught would be moved to point 8.
         *
         *
         * @param colour which colour draught will be moved
         * @param b
         * @param moveFrom point that will be moved from
         * @param die die that is used to move the draught
         */
        public Move(char colour, Board b, int moveFrom, int die) {
            movingDraughtColor = colour;
            board = b;
            this.moveFrom = moveFrom;
            this.die = die;
            isHitBlot();
        }


        /**
         * Moves one draught from the point moveFrom the value of j.
         * Ex, if j = 3 and moveFrom = 10, will move white to 7 and black to 13
         *
         * @param die dice that is used to move the singular draught
         */
        private void moveDraught(int moveFrom, int die) {
            if(movingDraughtColor == 'w') {
                if( this.hitBlot ) {
                    board.getBoardArr().get(moveFrom - die).removeBlackDraught();
                    board.getBoardArr().get(0).addBlackDraught();
                }
                moveWhiteDraught( moveFrom, moveFrom - die);
            }

            if(movingDraughtColor == 'b') {
                if(this.hitBlot) {
                    board.getBoardArr().get(moveFrom + die).removeWhiteDraught();
                    board.getBoardArr().get(25).addWhiteDraught();
                }
                moveBlackDraught(moveFrom, moveFrom + die);
            }
        }

        /**
         * Moves a single white draught from point i to point j, used in make move
         * if j is <= 0, doesn't place it since it is bore off
         *
         * @param i point number that draught is moved from
         * @param j point number that draught is moved to
         */
        private void moveWhiteDraught(int i, int j) {
            board.getBoardArr().get(i).removeWhiteDraught();
            if(j >= 1){
                board.getBoardArr().get(j).addWhiteDraught();
            }

        }

        /**
         * Moves a single black draught from point i to point j,
         * if j is > 24, doesn't place the draught since it is bore off
         * used in makeMove
         *
         * @param i point number that draught is moved from
         * @param j point number that draught is moved to
         */
        private void moveBlackDraught(int i, int j){
            board.getBoardArr().get(i).removeBlackDraught();
            if(j <= 24){
                board.getBoardArr().get(j).addBlackDraught();
            }
        }


        /**
         * The method that actually allows moving of draughts.
         * Simulates a full turn, will allow 2 draughts to move without doubles and
         * 4 draughts to move with doubles.
         * If invalid input is entered, will say Error, please try again.
         *
         * USES SCANNER FOR NOW UNTIL GUI IS DONE AND TO ALLOW TESTING
         *
         * This method looks really long but it's basically the same code
         * 4 times so that up to 4 draughts can be moved.
         *
         * @param b board that moves are made on
         * @param colour colour that is being moved
         * @param dice dice array from dice class
         */
        public static void makeMove(Board b, char colour, int[] dice) {
            Scanner scanner = new Scanner(System.in);
            int counter = 0;
            boolean check = false;
            boolean doubles = (dice[0] == dice[1]);
            int usedDice;
            b.displayBoardInText();

            do{
                if(counter != 0) {
                    System.out.println("ERROR! Illegal move, please try again");
                }
                counter++;

                System.out.println("Where would you like to move from?");
                int x = scanner.nextInt();

                System.out.println("Which dice are you using? " + dice[0] + " or " + dice[1]);
                int y = scanner.nextInt();

                Move m1 = new Move(colour, b, x, y);
                m1.legalMoveCheck(b, dice[0], dice[1]);
                if( m1.legalMove ) {
                    check = true;
                    m1.moveDraught(x,y);
                    b.displayBoardInText();
                    System.out.println("Successfully moved draught");
                }
            } while( !check );

            b.displayBoardInText();
            check = false;
            counter  = 0;

            do{
                if(counter != 0) {
                    System.out.println("ERROR! Illegal move, please try again");
                }
                counter++;

                System.out.println("Where would you like to move from?");
                int x = scanner.nextInt();

                System.out.println("Which dice are you using? " + dice[0] + " or " + dice[1]);
                int y = scanner.nextInt();

                Move m1 = new Move(colour, b, x, y);
                m1.legalMoveCheck(b, dice[0], dice[1]);
                if( m1.legalMove ) {
                    check = true;
                    m1.moveDraught(x,y);
                    b.displayBoardInText();
                    System.out.println("Successfully moved draught");
                }
            } while( !check );

            b.displayBoardInText();
            check = false;
            counter = 0;

            if(doubles) {
                do{
                    if(counter != 0) {
                        System.out.println("ERROR! Illegal move, please try again");
                    }
                    counter++;

                    System.out.println("Where would you like to move from?");
                    int x = scanner.nextInt();
                    int y = dice[1];

                    Move m1 = new Move(colour, b, x, y);
                    m1.legalMoveCheck(b, dice[0], dice[1]);
                    if( m1.legalMove ) {
                        check = true;
                        m1.moveDraught(x,y);
                        b.displayBoardInText();
                        System.out.println("Successfully moved draught");
                    }
                } while( !check );

                b.displayBoardInText();
                counter = 0;
                check = false;

                do{
                    if(counter != 0) {
                        System.out.println("ERROR! Illegal move, please try again");
                    }
                    counter++;

                    System.out.println("Where would you like to move from?");
                    int x = scanner.nextInt();
                    int y = dice[1];

                    Move m1 = new Move(colour, b, x, y);
                    m1.legalMoveCheck(b, dice[0], dice[1]);
                    if( m1.legalMove ) {
                        check = true;
                        m1.moveDraught(x,y);
                        b.displayBoardInText();
                        System.out.println("Successfully moved draught");
                    }
                } while( !check );
            }

        }

        /**
         * Determines if a move is legal for a white draught to make
         * Used in legalMoveCheck
         *
         * @param board board that moves are made on
         * @param die1 die1
         * @param die2 die2
         */
        private void legalMoveCheckWhite(Board board, int die1, int die2){
            boolean isLegal = true;

            if(this.getDie() != die1 && this.getDie() != die2){
                isLegal = false;
            }

            if(board.getBoardArr().get(25).getWhiteDraughtsOnPoint() > 0 && this.getMoveFrom() != 25){
                isLegal = false;
            }

            if(board.getBoardArr().get(this.getMoveFrom()).getWhiteDraughtsOnPoint() == 0){
                isLegal = false;
            }

            try{
                if(board.getBoardArr().get(this.getMoveFrom() - this.getDie()).getBlackDraughtsOnPoint() > 1){
                    isLegal = false;
                }
            } catch(IndexOutOfBoundsException ignored) {}

            board.whiteAbleToBearOffCheck();
            board.highestDraughtInWhiteHome();

            //add isAbleToBEarOFF ??
            if( ( this.getMoveFrom() - this.getDie() ) < 0 && board.getHighestDraughtInWhiteHome() != this.getMoveFrom() ){
                isLegal = false;
            }

            if( (this.getMoveFrom() - this.getDie()) == 0 && !board.isWhiteAbleToBearOff()){
                isLegal = false;
            }

            this.legalMove = isLegal;
        }

        /**
         * Determines if a move is legal for a black draught to make
         * Used in legalMoveCheck
         *
         * @param board board that is being moved on
         * @param die1 die1
         * @param die2 die2
         */
        public void legalMoveCheckBlack(Board board, int die1, int die2) {
            boolean isLegal = true;

            if(this.getDie() != die1 && this.getDie() != die2){
                isLegal = false;
            }

            if(board.getBoardArr().get(0).getBlackDraughtsOnPoint() > 0 && this.getMoveFrom() != 0){
                isLegal = false;
            }

            if(board.getBoardArr().get(this.getMoveFrom()).getBlackDraughtsOnPoint() == 0){
                isLegal = false;
            }

            try {
                if (board.getBoardArr().get(this.getMoveFrom() + this.getDie()).getWhiteDraughtsOnPoint() > 1) {
                    isLegal = false;
                }
            } catch (Exception ignored) {}

            board.blackAbleToBearOffCheck();
            board.highestDraughtInBlackHome();

            if( ( this.getMoveFrom() + this.getDie() ) > 25 && board.getHighestDraughtInBlackHome() != this.getMoveFrom() ){
                isLegal = false;
            }

            if( (this.getMoveFrom() + this.getDie()) == 25 && !board.isBlackAbleToBearOff()){
                isLegal = false;
            }

            this.legalMove = isLegal;
        }

        /**
         * Determines if a move is legal. Uses this' colour to determine which method to call
         *
         * @param b board that is being moved on
         * @param die1 die1
         * @param die2 die2
         */
        public void legalMoveCheck(Board b, int die1, int die2) {
            if(movingDraughtColor == 'w'){
                legalMoveCheckWhite(b, die1, die2);
            }

            if(movingDraughtColor == 'b'){
                legalMoveCheckBlack(b, die1, die2);
            }
        }


        /**
         * Getter for moveFrom
         *
         * @return moveFrom
         */
        public int getMoveFrom() {
            return moveFrom;
        }

        /**
         * Getter for Die
         *
         * @return die that is inputted for a single move
         */
        public int getDie() {
            return die;
        }

        /**
         * Determines if a move hits a blot so that the blot will be removed.
         *
         * Has the try catch blocks in case index is out of bounds (in the case of bearing off),
         * exception is ignored since if you are bearing off you aren't hitting blots.
         */
        private void isHitBlot() {
            hitBlot = false;

            try{
                if(movingDraughtColor == 'w'
                        && this.board.getBoardArr().get(this.moveFrom - this.die).getBlackDraughtsOnPoint() == 1 ){
                    hitBlot = true;
                }
            } catch(Exception ignored) {}

            try{
                if(movingDraughtColor == 'b'
                        && this.board.getBoardArr().get(this.moveFrom + this.die).getWhiteDraughtsOnPoint() == 1 ){
                    hitBlot = true;
                }
            } catch(Exception ignored) {}

        }

    /**
     * repeat of same thing 4 times with random selection
     * all you need to do is just call cpuMakemove
     */
    public void cpuMakemove() {
          Dice dice = new Dice();
          Scanner scanner = new Scanner(System.in);
          int counter = 0;
          boolean check = false;
          boolean doubles = (dice.array[0] == dice.array[1]);
          int usedDice;
          this.board.displayBoardInText();
          do {
              if (counter != 0) {
                  System.out.println("ERROR! Illegal move, please try again");
              }
              counter++;
              // int x is moveFrom
            int x = random.nextInt(24);
            //int y is what dice is going to be used
            int y = dice.array[random.nextInt(2)];

            Move m1 = new Move('w', this.board, x, y);
            m1.legalMoveCheck(this.board, dice.array[0], dice.array[1]);
            if (m1.legalMove) {
                check = true;
                m1.moveDraught(x, y);
                this.board.displayBoardInText();
                System.out.println("Successfully moved draught");
            }
        } while (!check);

        this.board.displayBoardInText();
        check = false;
        counter = 0;

        do{
            if(counter != 0) {
                System.out.println("ERROR! Illegal move, please try again");
            }
            counter++;

            //Where would you like to move from
            int x = random.nextInt(24);

            //Which dice are you using
            int y = dice.array[random.nextInt(2)];

            Move m1 = new Move('w', this.board, x, y);
            m1.legalMoveCheck(this.board, dice.array[0], dice.array[1]);
            if( m1.legalMove ) {
                check = true;
                m1.moveDraught(x,y);
                this.board.displayBoardInText();
                System.out.println("Successfully moved draught");
            }
        } while( !check );

        this.board.displayBoardInText();
        check = false;
        counter = 0;

        if(doubles) {
            do{
                if(counter != 0) {
                    System.out.println("ERROR! Illegal move, please try again");
                }
                counter++;

                int x = random.nextInt(24);
                int y = dice.array[1];

                Move m1 = new Move('w', this.board, x, y);
                m1.legalMoveCheck(this.board, dice.array[0], dice.array[1]);
                if( m1.legalMove ) {
                    check = true;
                    m1.moveDraught(x,y);
                    this.board.displayBoardInText();
                    System.out.println("Successfully moved draught");
                }
            } while( !check );

            this.board.displayBoardInText();
            counter = 0;
            check = false;

            do{
                if(counter != 0) {
                    System.out.println("ERROR! Illegal move, please try again");
                }
                counter++;

                int x = random.nextInt(24);
                int y = dice.array[1];

                Move m1 = new Move('w', this.board, x, y);
                m1.legalMoveCheck(this.board, dice.array[0], dice.array[1]);
                if( m1.legalMove ) {
                    check = true;
                    m1.moveDraught(x,y);
                    this.board.displayBoardInText();
                    System.out.println("Successfully moved draught");
                }
            } while( !check );
        }

    }
}


