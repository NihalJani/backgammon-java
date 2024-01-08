package Game;
import java.util.ArrayList;

public class Point {
	enum Color {
		white, black, none;
	}	

	private ArrayList <Draught> draughtsOnPoint = new ArrayList<Draught>();
	private Color pointColor;
	//	private int numberWhite;
	//	private int numberBlack;

	public Point(Color color) {
		pointColor = color;
	}

	public Point() {
		pointColor = Color.none;
	}

	public int whiteDraughtsonPoint () {
		int count = 0;
		for(int i = 0; i < draughtsOnPoint.size(); i++) {
			if (draughtsOnPoint.get(i).color() == Color.white) {
				count ++;
			}
		}
		return count;

	}

	public int blackDraughtsonPoint () {
		int count = 0;
		for(int i = 0; i < draughtsOnPoint.size(); i++) {
			if (draughtsOnPoint.get(i).color() == Color.black) {
				count++;
			}
		}
		return count;

	}

	public boolean hasWhiteDoubledDraught () {
		if(draughtsOnPoint.size() >= 2) {
			for(int i = 0; i < draughtsOnPoint.size(); i++) {
				if (draughtsOnPoint.get(i).color() != Color.white) {
					return false;
				}
				else return true;				
			}			
		}
		return false;
	}

	public boolean hasBlackDoubledDraught () {
		if(draughtsOnPoint.size() >= 2) {
			for(int i = 0; i < draughtsOnPoint.size(); i++) {
				if (draughtsOnPoint.get(i).color() != Color.black) {
					return false;
				}
				else return true;				
			}			
		}
		return false;

	}

	public boolean hasWhiteBlot () {
		if (draughtsOnPoint.size() == 1 && draughtsOnPoint.get(0).color() == Color.white) {
			return true;
		}
		return false;
	}

	public boolean hasBlackBlot () {
		if (draughtsOnPoint.size() == 1 && draughtsOnPoint.get(0).color() == Color.black) {
			return true;
		}
		return false;
	}

	public void Draught(Draught d) {
		draughtsOnPoint.add(d);

	}

	public ArrayList<Draught> getPoint() {
		return draughtsOnPoint;
	}

	public void printString() {
		for (int i = 0; i < draughtsOnPoint.size(); i++) {
			System.out.print("" + draughtsOnPoint.get(i).color());
		}
	}


}
