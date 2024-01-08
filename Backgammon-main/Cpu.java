import java.util.ArrayList;
import java.util.Random;

public class Cpu extends Player{
    Random rMoves = new Random();

public String cpuTakeTurn(ArrayList<String>list){
    return list.get(rMoves.nextInt(list.size()));
}
public Cpu(){
    super.setPieceColour('w');
    super.setName("Computer");
}
}
