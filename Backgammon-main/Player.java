import java.util.ArrayList;

public class Player {
     private String name;
     private char pieceColour;

     public Player(String name, char pieceColour) {
         this.name = name;
         while(pieceColour == 'b' || pieceColour == 'w'){
             this.pieceColour = pieceColour;
         }
     }
     public Player() {
         this.name = "Player";
         this.pieceColour = ' ';
     }
     public char getPieceColour() {
         return pieceColour;
     }
     public void setPieceColour(char pieceColour) {
         this.pieceColour = pieceColour;
     }
     public void setName(String name){
         this.name = name;
     }
    // public void takeTurn(ArrayList<String> list){
    //     for(int i = 0; i<list.size();i++){
    //         String [] parts = new String[list.size()];
    //         parts [i] = list.get(i);
    //         parts [i] .split(",");
    //    }

    // }
 }

