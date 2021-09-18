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

    //pieceLocations中有几个location
    int locationNumber;

    //map将颜色和形状对应起来
    Map<Character,int[]> colorNumbers = new HashMap<>();
    //在构造函数中使用此函数初始化colorNumbers
    public void setColorNumbers() {
        colorNumbers.put('r',new int[]{0,2,3});
        colorNumbers.put('o',new int[]{0,3});
        colorNumbers.put('y',new int[]{0,1,2});
        colorNumbers.put('g',new int[]{0,3,5});
        colorNumbers.put('b',new int[]{0,1,3});
        colorNumbers.put('i',new int[]{0,1});
        colorNumbers.put('p',new int[]{0,3,4});
    }

    //构造函数1
    public Piece(char color, int orientation, int x, int y){
        this.color = color;
        this.orientation = orientation;
        this.x = x;
        this.y = y;
        setColorNumbers();
        setPieceLocations();
    }

    //构造函数2
    public Piece(String pieceStateString){
        this.color = pieceStateString.charAt(0);
        this.orientation = Integer.parseInt(String.valueOf(pieceStateString.charAt(1)));
        this.x = Integer.parseInt(String.valueOf(pieceStateString.charAt(2)));
        this.y = Integer.parseInt(String.valueOf(pieceStateString.charAt(3)));
        setColorNumbers();
        setPieceLocations();
    }

    public void setPieceLocations(){
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
        
        pieceLocations[0] = new Location(x,y);
        locationNumber = 1;
        for (int i : colorNumbers.get(color)){
            if (allLocations[i] != null){
                pieceLocations[locationNumber] = allLocations[i][orientation];
                locationNumber += 1;}
        }

        x = x1;
        y = y1;
    }

    public Location[] getPieceLocations(){
        return pieceLocations;
    }
}
