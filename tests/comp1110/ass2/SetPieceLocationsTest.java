package comp1110.ass2;

import org.junit.jupiter.api.Test;

import static comp1110.ass2.Games.ALL_CHALLENGES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetPieceLocationsTest {


    @Test
    private void testTopLeft(String pieceStateString){
        Piece testPiece = new Piece(pieceStateString);
        Location[] testLocation = testPiece.getPieceLocations();
        for (Location i :testLocation){
            if (i == null){
                break;
            }
            assertTrue(i.getY() >= testPiece.y,"it is not the top left of the piece");
            if (i.getY() == testPiece.y){
                assertTrue(i.getX() >= testPiece.x,"it is not the top left of the piece");
            }
        }
    }

    @Test
    public void testAllTopLeft(){
        for (int i = 0;i < 96;i++){
            testTopLeft(ALL_CHALLENGES[i].substring(0,4));
        }
    }

    @Test
    private void testRepetition(String pieceStateString){
        int[][] board = new int[4][];
        board[0] = new int[7];
        board[1] = new int[6];
        board[2] = new int[7];
        board[3] = new int[6];
        Piece testPiece = new Piece(pieceStateString);
        Location[] testLocation = testPiece.getPieceLocations();
        for (Location i :testLocation){
            if (i == null){
                break;
            }
            assertTrue(board[i.getY()][i.getX()] == 0,"there are two same locations");
            board[i.getY()][i.getX()] = 1;
        }
    }

    @Test
    public void testAllRepetition(){
        for (int i = 0;i < 96;i++){
            testRepetition(ALL_CHALLENGES[i].substring(0,4));
        }
    }
}
