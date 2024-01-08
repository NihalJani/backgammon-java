import java.util.ArrayList;


public class Point {

    private char color;
    private int whiteDraughtsOnPoint;
    private int blackDraughtsOnPoint;
    private boolean hasWhiteDoubledDraught;
    private boolean hasBlackDoubledDraught;
    private boolean hasWhiteBlot;
    private boolean hasBlackBlot;
    private ArrayList<Draught> pointList = new ArrayList<Draught>();
    private static Board b;


    //constructor for a point
    public Point(char colour) {
        this.color = colour;
        whiteDraughtsOnPoint = 0;
        blackDraughtsOnPoint = 0;
        hasWhiteDoubledDraught = false;
        hasBlackDoubledDraught = false;
        hasWhiteBlot = false;
        hasBlackBlot = false;
    }

    //adds a white draught to the point, increases whiteDraughtsOnPoint
    public void addWhiteDraught() {
        this.pointList.add( Draught.createWhiteDraught() );
        this.whiteDraughtsOnPoint = this.whiteDraughtsOnPoint + 1;
        pointBooleanUpdater();
    }

    //adds black draught to the point, increase blackDraughtsOnPoint
    public void addBlackDraught() {
        this.pointList.add( Draught.createBlackDraught() );
        this.blackDraughtsOnPoint = this.blackDraughtsOnPoint + 1;
        pointBooleanUpdater();
    }

    //removes white draught from point, decreases whiteDraughtsOnPoint by one
    public void removeWhiteDraught() {
        if( this.pointList.size() >= 1 && this.pointList.get(pointList.size() - 1).getColour() == 'w') {
            pointList.remove( pointList.size() - 1 );
            this.whiteDraughtsOnPoint = this.whiteDraughtsOnPoint - 1;
        } else { //for troubleshooting
            System.out.println("Error occurred removing white draught");
        }
    }

    //removes black draught from point, decreases blackDraughtsOnPoint by one
    public void removeBlackDraught() {
        if( this.pointList.size() >= 1 && this.pointList.get(pointList.size() - 1).getColour() == 'b') {
            pointList.remove( pointList.size() - 1 );
            this.blackDraughtsOnPoint = this.blackDraughtsOnPoint - 1;
        } else { //for troubleshooting
            System.out.println("Error occurred removing black draught");
        }
    }

    // Checks and updates the following booleans of the point: hasBlackBlot, hasWhiteBlot, hasBlackDoubledDraught, has whiteDoubledDraught
    private void pointBooleanUpdater() {
        hasBlackBlot = false;
        hasWhiteBlot = false;
        hasBlackDoubledDraught = false;
        hasWhiteDoubledDraught = false;

        int wCounter = 0;
        int bCounter = 0;

        for(int i = 0; i < pointList.size(); i++) {
            if( pointList.get(i).getColour() == 'w') {
                wCounter = wCounter + 1;
            }
            if( pointList.get(i).getColour() == 'b') {
                bCounter = bCounter + 1;
            }
        }

        if( wCounter == 1) {
            hasWhiteBlot = true;
        }
        if( bCounter == 1) {
            hasBlackBlot = true;
        }

        if( wCounter >= 2) {
            hasWhiteDoubledDraught = true;
        }
        if( bCounter >= 2) {
            hasBlackDoubledDraught = true;
        }

    }

    //below this is getters for the member variables
    public char getColor() {
        return color;
    }

    public int getWhiteDraughtsOnPoint() {
        return whiteDraughtsOnPoint;
    }

    public int getBlackDraughtsOnPoint() {
        return blackDraughtsOnPoint;
    }

    public boolean getHasWhiteDoubledDraught() {
        return hasWhiteDoubledDraught;
    }

    public boolean getHasBlackDoubledDraught() {
        return hasBlackDoubledDraught;
    }

    public boolean getHasWhiteBlot() {
        return hasWhiteBlot;
    }

    public boolean getHasBlackBlot() {
        return hasBlackBlot;
    }

    public ArrayList<Draught> getPointList() {
        return pointList;
    }

}
