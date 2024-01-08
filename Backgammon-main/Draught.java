public class Draught {

	//enum to hold all possible colors for a draught object
	enum Color {
		white, black, none;
	}
	
	private static Color draughtColor;
	
	public Draught(Color color) {
		draughtColor = color;
	}
	
	public Draught() {
		draughtColor = Color.none;
	}
	
	public Color getColor() {
		return draughtColor;
	}
	
	public Color color() {
		return draughtColor;
	}
	
	public void setColor(Color color) {
		draughtColor = color;
	}
	
	/*
	THis method checks if two draughts are equal/unequal and if either of the two objects have 'none' as color.
	*/
	public boolean isEqualTo(Draught second) {
		if(this.color() == second.getColor() && this.color()!= Color.none && second.color()!=Color.none)
			return true;
		else if(this.color() == second.getColor() && (this.color()== Color.none || second.color()==Color.none)) {
			System.out.println("Either Draught colour non binary");
			return true;
		}
		else if(this.color() != second.getColor() && (this.color()== Color.none || second.color()==Color.none)) {
			System.out.println("Either Draught colour non binary");
			return false;
		}
		else
			return false;
	}

}
