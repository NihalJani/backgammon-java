public class Draught {

    private char colour;

    private Draught(char colour) {
        this.colour = colour;
    }

    public static Draught createWhiteDraught() {
        return new Draught('w');
    }

    public static Draught createBlackDraught() {
        return new Draught('b');
    }

    public char getColour() {
        return colour;
    }


}
