package comp1110.ass2;

import java.util.HashMap;
import java.util.Map;

public class Piece {
    char color;
    int orientation;
    int x;
    int y;

    //contains all locations that the piece occupies
    private Location[] pieceLocations = new Location[7];

    //means how many locations pieceLocations has in it
    int locationNumber;

    //corresponding colors and shapes
    Map<Character,int[]> colorNumbers = new HashMap<>();

    //use this function in the constructor to initialize colorNumbers
    public void setColorNumbers() {
        colorNumbers.put('r',new int[]{0,2,3});
        colorNumbers.put('o',new int[]{0,3});
        colorNumbers.put('y',new int[]{0,1,2});
        colorNumbers.put('g',new int[]{0,3,5});
        colorNumbers.put('b',new int[]{0,1,3});
        colorNumbers.put('i',new int[]{0,1});
        colorNumbers.put('p',new int[]{0,3,4});
    }

    //constructor1
    public Piece(char color, int orientation, int x, int y){
        this.color = color;
        this.orientation = orientation;
        this.x = x;
        this.y = y;
        setColorNumbers();
        setPieceLocations();
    }

    //constructor2
    public Piece(String pieceStateString){
        this.color = pieceStateString.charAt(0);
        this.orientation = Integer.parseInt(String.valueOf(pieceStateString.charAt(1)));
        this.x = Integer.parseInt(String.valueOf(pieceStateString.charAt(2)));
        this.y = Integer.parseInt(String.valueOf(pieceStateString.charAt(3)));
        setColorNumbers();
        setPieceLocations();
    }

    //get all the locations occupied by the piece by the information contained in the pieceStateString
    /*The general idea is to regard pieces of the same color and different orientations as new pieces
     obtained after rotating the piece(orientation = 0) around the origin point(the point at the upper left corner when orientation = 0).
     Therefore, the coordinates of the origin, color, and orientation can be used to calculate all
     locations the piece occupies.*/
    public void setPieceLocations(){

        //convert the coordinates in pieceStateString to the coordinates of the origin point of the piece
        Location[][] allLocations = new Location[6][];
        int x1 = x;
        int y1 = y;

        if (y == 0||y == 2){
            if (color == 'r'){if (orientation == 2){x = x + 1;}}
            if (color == 'o'){
                if (orientation == 3){x = x + 1;y = y + 1;}
                if (orientation == 4){y = y + 2;}
                if (orientation == 5){x = x - 1;y = y + 1;}

            }
            if (color == 'y'){
                if (orientation == 2){x = x + 1;}
                if (orientation == 3){y = y + 1;}
                if (orientation == 4){x = x + 1;y = y + 2;}
                if (orientation == 5){x = x - 1;y = y + 2;}
            }
            if (color == 'g'){
                if (orientation == 3){x = x + 2;y = y + 2;}
                if (orientation == 4){x = x - 1;y = y + 3;}
                if (orientation == 5){x = x - 1;y = y + 1;}
            }
            if (color == 'b'){
                if (orientation == 3){x = x + 1;y = y + 1;}
                if (orientation == 4){x = x + 1;y = y + 2;}
                if (orientation == 5){x = x - 1;y = y + 2;}
            }
            if (color == 'p'){
                if (orientation == 2){x = x + 2;}
                if (orientation == 3){x = x + 1;y = y + 2;}
                if (orientation == 4){y = y + 2;}
                if (orientation == 5){x = x - 1;y = y + 1;}
            }
        }

        else if (y == 1||y == 3){
            if (color == 'r'){if (orientation == 2){x = x + 1;}}
            if (color == 'o'){
                if (orientation == 3){x = x + 2;y = y + 1;}
                if (orientation == 4){y = y + 2;}
                if (orientation == 5){y = y + 1;}
            }
            if (color == 'y'){
                if (orientation == 2){x = x + 1;}
                if (orientation == 3){x = x + 1;y = y + 1;}
                if (orientation == 4){x = x + 1;y = y + 2;}
                if (orientation == 5){x = x - 1;y = y + 2;}
            }
            if (color == 'g'){
                if (orientation == 3){x = x + 2;y = y + 2;}
                if (orientation == 4){y = y + 3;}
                if (orientation == 5){y = y + 1;}
            }
            if (color == 'b'){
                if (orientation == 3){x = x + 2;y = y + 1;}
                if (orientation == 4){x = x + 1;y = y + 2;}
                if (orientation == 5){x = x - 1;y = y + 2;}
            }
            if (color == 'p'){
                if (orientation == 2){x = x + 2;}
                if (orientation == 3){x = x + 1;y = y + 2;}
                if (orientation == 4){y = y + 2;}
                if (orientation == 5){y = y + 1;}
            }
        }

        //use the origin coordinates to calculate all the locations that may be occupied by pieces with different colors and different orientations
        if (y == 0||y == 2){
            allLocations = new Location[][]{
                    {new Location(x + 1, y), new Location(x, y + 1), new Location(x - 1, y + 1), new Location(x - 1, y), new Location(x - 1, y - 1), new Location(x, y - 1)},
                    {new Location(x + 2, y), new Location(x + 1, y + 2), new Location(x - 1, y + 2), new Location(x - 2, y), new Location(x - 1, y - 2), new Location(x + 1, y - 2)},
                    {new Location(x, y + 1), new Location(x - 1, y + 1), new Location(x - 1, y), new Location(x - 1, y - 1), new Location(x, y - 1), new Location(x + 1, y)},
                    {new Location(x + 1, y + 1), new Location(x, y + 2), new Location(x - 2, y + 1), new Location(x - 2, y - 1), new Location(x, y - 2), new Location(x + 1, y - 1)},
                    {new Location(x + 1, y + 2), new Location(x - 1, y + 2), new Location(x - 2, y), new Location(x - 1, y - 2), new Location(x + 1, y - 2), new Location(x + 2, y)},
                    {new Location(x + 2, y + 2), new Location(x - 1, y + 3), new Location(x - 3, y + 1), new Location(x - 2, y - 2), new Location(x, y - 3), new Location(x + 2, y - 1)}
            };
        }

        if (y == 1||y == 3){
            allLocations = new Location[][]{
                    {new Location(x+1,y),new Location(x+1,y+1),new Location(x,y+1),new Location(x-1,y),new Location(x,y-1),new Location(x+1,y-1)},
                    {new Location(x+2,y),new Location(x+1,y+2),new Location(x-1,y+2),new Location(x-2,y),new Location(x-1,y-2),new Location(x+1,y-2)},
                    {new Location(x+1,y+1),new Location(x,y+1),new Location(x-1,y),new Location(x,y-1),new Location(x+1,y-1),new Location(x+1,y)},
                    {new Location(x+2,y+1),new Location(x,y+2),new Location(x-1,y+1),new Location(x-1,y-1),new Location(x,y-2),new Location(x+2,y-1)},
                    {new Location(x+1,y+2),new Location(x-1,y+2),new Location(x-2,y),new Location(x-1,y-2),new Location(x+1,y-2),new Location(x+2,y)},
                    {new Location(x+2,y+2),new Location(x,y+3),new Location(x-2,y+1),new Location(x-2,y-2),new Location(x+1,y-3),new Location(x+3,y-1)}
            };
        }

        //identify which positions in allLocations belong to this piece through the color and orientation of the piece
        pieceLocations[0] = new Location(x,y);
        locationNumber = 1;
        for (int i : colorNumbers.get(color)){
            if (allLocations[i] != null){
                //store the successfully identified locations into pieceLocations
                pieceLocations[locationNumber] = allLocations[i][orientation];
                locationNumber += 1;}
        }

        //restore the coordinates in pieceStateString to the right state
        x = x1;
        y = y1;
    }

    //get all locations occupied by this piece
    public Location[] getPieceLocations(){
        return pieceLocations;
    }
}
