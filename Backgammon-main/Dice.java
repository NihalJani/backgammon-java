import java.security.SecureRandom;

public class Dice {
    /**
     * This class creates the dice by creating an int array of four numbers. To simulate real dice I used SecureRandom
     * so the dice would be truly random. If the first two dice are equal to each other it makes the other two dice which
     * are both zero and makes the equal to the first dice. The array needs to be broken down into individual integers
     * in the board class.
     */
    int[] array = {0, 0, 0, 0};

    public Dice() {
        this.array = array;
    }

    /**
     * Is the part that makes the numbers on the array random and makes sure that if there are double dice the rules for
     * Backgammon are followed
     * @return array: which is the value of all four dice.
     */
    public int[] filler() {
        SecureRandom rand = new SecureRandom();

        for(int i = 0; i < 2; i++) {
            array[i] = rand.nextInt(5)+1;
        }
        if(array[0] == array[1]){
            for(int i = 2; i < 4; i++) {
                array[i] = array[0];
            }
        }
        return array;
    }
}



