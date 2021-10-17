package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.scene.input.MouseButton.SECONDARY;

public class Board extends Application {

    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    private final Group root = new Group();

    void makePieceMove(){
        final double[] pos={0,0};
        final boolean[] isF = {false,false,false,false,false,false,false};
        Image red = new Image("file:assets\\redPiece.png");
        Image pink = new Image("file:assets\\pinkPiece.png");
        Image orange = new Image("file:assets\\orangePiece.png");
        Image indigo = new Image("file:assets\\indigoPiece.png");
        Image green = new Image("file:assets\\greenPiece.png");
        Image blue = new Image("file:assets\\bluePiece.png");
        Image yellow = new Image("file:assets\\yellowPiece.png");
        Image preview = new Image("file:E:assets\\preview.png");
        ImageView imageViewR = new ImageView();
        Rotate rotateR = new Rotate();
        imageViewR.getTransforms().addAll(rotateR);
        imageViewR.setImage(red);
        ImageView imageViewP = new ImageView();
        Rotate rotateP = new Rotate();
        imageViewP.setImage(pink);
        ImageView imageViewO = new ImageView();
        Rotate rotateO = new Rotate();
        imageViewO.setImage(orange);
        ImageView imageViewI = new ImageView();
        Rotate rotateI = new Rotate();
        imageViewI.setImage(indigo);
        ImageView imageViewG = new ImageView();
        Rotate rotateG = new Rotate();
        imageViewG.setImage(green);
        ImageView imageViewB = new ImageView();
        Rotate rotateB = new Rotate();
        imageViewB.setImage(blue);
        ImageView imageViewY = new ImageView();
        Rotate rotateY = new Rotate();
        imageViewY.setImage(yellow);
        imageViewB.setFitWidth(474.0/2);
        imageViewB.setFitHeight(275.0/2);
        imageViewG.setFitWidth(473.0/2);
        imageViewG.setFitHeight(411.0/2);
        imageViewI.setFitWidth(474.0/2);
        imageViewI.setFitHeight(137.0/2);
        imageViewO.setFitWidth(394.0/2);
        imageViewO.setFitHeight(275.0/2);
        imageViewR.setFitWidth(394.0/2);
        imageViewR.setFitHeight(275.0/2);
        imageViewY.setFitWidth(474.0/2);
        imageViewY.setFitHeight(275.0/2);
        imageViewP.setFitWidth(393.0/2);
        imageViewP.setFitHeight(413.0/2);

        ImageView imageViewp = new ImageView();
        imageViewp.setImage(preview);
        imageViewp.setX(1200.0/2);
        imageViewp.setY(0);
        Image test = new Image("file:assets\\test.png");
        ImageView imageViewt = new ImageView();
        imageViewt.setImage(test);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double mouseX = mouseEvent.getSceneX();
                double mouseY = mouseEvent.getSceneY();
                System.out.println(mouseEvent.getSceneX());
                System.out.println(mouseEvent.getSceneY());
                if(mouseX>1200.0-597&&mouseX<1350.0-597&&mouseY>10.0&&mouseY<130.0){
                    imageViewR.setX(mouseX);
                    imageViewR.setY(mouseY);
                    root.getChildren().add(imageViewR);
                    isF[0] = true;
                }else if(mouseX>1355.0-597&&mouseX<1520.0-597&&mouseY>10.0&&mouseY<130.0){
                    imageViewB.setX(mouseX);
                    imageViewB.setY(mouseY);
                    root.getChildren().add(imageViewB);
                    isF[1] = true;
                }else if(mouseX>1200.0-597&&mouseX<1350.0-597&&mouseY>130.0&&mouseY<280.0){
                    imageViewO.setX(mouseX);
                    imageViewO.setY(mouseY);
                    root.getChildren().add(imageViewO);
                    isF[2] = true;
                }else if(mouseX>1355.0-597&&mouseX<1520.0-597&&mouseY>140.0&&mouseY<300.0){
                    imageViewP.setX(mouseX);
                    imageViewP.setY(mouseY);
                    root.getChildren().add(imageViewP);
                    isF[3] = true;
                }else if(mouseX>1200.0-597&&mouseX<1350.0-597&&mouseY>290.0&&mouseY<440.0){
                    imageViewG.setX(mouseX);
                    imageViewG.setY(mouseY);
                    root.getChildren().add(imageViewG);
                    isF[4] = true;
                }else if(mouseX>1355.0-597&&mouseX<1520.0-597&&mouseY>320.0&&mouseY<450.0){
                    imageViewI.setX(mouseX);
                    imageViewI.setY(mouseY);
                    root.getChildren().add(imageViewI);
                    isF[5] = true;
                }else if(mouseX>1200.0-597&&mouseX<1400.0-597&&mouseY>480.0&&mouseY<590.0){
                    imageViewY.setX(mouseX);
                    imageViewY.setY(mouseY);
                    root.getChildren().add(imageViewY);
                    isF[6] = true;
                }
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double mouseX = mouseEvent.getSceneX();
                double mouseY = mouseEvent.getSceneY();
                if(isF[0]){
                    imageViewR.setX(mouseX);
                    imageViewR.setY(mouseY);
                }else if(isF[1]){
                    imageViewB.setX(mouseX);
                    imageViewB.setY(mouseY);
                }else if(isF[2]){
                    imageViewO.setX(mouseX);
                    imageViewO.setY(mouseY);
                }else if(isF[3]){
                    imageViewP.setX(mouseX);
                    imageViewP.setY(mouseY);
                }else if(isF[4]){
                    imageViewG.setX(mouseX);
                    imageViewG.setY(mouseY);
                }else if(isF[5]){
                    imageViewI.setX(mouseX);
                    imageViewI.setY(mouseY);
                }else if(isF[6]){
                    imageViewY.setX(mouseX);
                    imageViewY.setY(mouseY);
                }
            }
        });
        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                for (boolean s:isF
//                ) {
//                    System.out.println(s);
//                }
                System.out.println("----");
                for (int i = 0; i < isF.length; i++) {
                    isF[i]=false;
                }
            }
        });
//        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                if(mouseEvent.getButton()==SECONDARY){
//                    System.out.println('c');
//                }
//            }
//        });
        root.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
//                rot(pos,imageViewR);
//                if(pos[0]==0){
//                    imageViewR.setRotate(60);
//                    pos[0]++;
//                }else if(pos[0]==1){
//                    imageViewR.setRotate(120);
//                    pos[0]++;
//                }else if(pos[0]==2){
//                    imageViewR.setRotate(180);
//                    pos[0]++;
//                }else if(pos[0]==3){
//                    imageViewR.setRotate(240);
//                    pos[0]++;
//                }else if(pos[0]==4){
//                    imageViewR.setRotate(300);
//                    pos[0]++;
//                }else if(pos[0]==5){
//                    imageViewR.setRotate(360);
//                    pos[0]++;
//                }else if(pos[0]==6){
//                    imageViewR.setRotate(60);
//                    pos[0]-=5;
//                }
                if(isF[0]){
                    rot(pos,imageViewR);
                }else if(isF[1]){
                    rot(pos,imageViewB);
                }else if(isF[2]){
                    rot(pos,imageViewO);
                }else if(isF[3]){
                    rot(pos,imageViewP);
                }else if(isF[4]){
                    rot(pos,imageViewG);
                }else if(isF[5]){
                    rot(pos,imageViewI);
                }else if(isF[6]){
                    rot(pos,imageViewY);
                }
                System.out.println("cool");
            }
        });
        root.getChildren().add(imageViewp);
    }
    public void rot(double[] pos,ImageView s){
        if(pos[0]==0){
            s.setRotate(60);
            pos[0]++;
        }else if(pos[0]==1){
            s.setRotate(120);
            pos[0]++;
        }else if(pos[0]==2){
            s.setRotate(180);
            pos[0]++;
        }else if(pos[0]==3){
            s.setRotate(240);
            pos[0]++;
        }else if(pos[0]==4){
            s.setRotate(300);
            pos[0]++;
        }else if(pos[0]==5){
            s.setRotate(360);
            pos[0]++;
        }else if(pos[0]==6){
            s.setRotate(60);
            pos[0]-=5;
        }
    }

    public void initial(){
        String gameStateString = "o322p151W";
        Image blankBoard = new Image("file:assets\\blankBoardNumbered.png");
        Image red = new Image("file:assets\\redPiece.png");
        Image pink = new Image("file:assets\\pinkPiece.png");
        Image orange = new Image("file:assets\\orangePiece.png");
        Image indigo = new Image("file:assets\\indigoPiece.png");
        Image green = new Image("file:assets\\greenPiece.png");
        Image blue = new Image("file:assets\\bluePiece.png");
        Image yellow = new Image("file:assets\\yellowPiece.png");
        Image Wred = new Image("file:assets\\red.png");
        Image Wpink = new Image("file:assets\\pink.png");
        Image Worange = new Image("file:assets\\orange.png");
        Image Windigo = new Image("file:assets\\i.png");
        Image Wgreen = new Image("file:E:assets\\green.png");
        Image Wblue = new Image("file:E:assets\\blue.png");
        Image Wyellow = new Image("file:E:assets\\yellow.png");


        //Use the class Imageview to show different pieces and use Class Rotate to rotate the pieces.
        ImageView imageView = new ImageView();
        imageView.setImage(blankBoard);
        imageView.setFitHeight((700-50.0)/2);
        imageView.setFitWidth(1194.0/2);

        ImageView imageViewR = new ImageView();
        Rotate rotateR = new Rotate();
        ImageView imageViewP = new ImageView();
        Rotate rotateP = new Rotate();
        ImageView imageViewO = new ImageView();
        Rotate rotateO = new Rotate();
        ImageView imageViewI = new ImageView();
        Rotate rotateI = new Rotate();
        ImageView imageViewG = new ImageView();
        Rotate rotateG = new Rotate();
        ImageView imageViewB = new ImageView();
        Rotate rotateB = new Rotate();
        ImageView imageViewY = new ImageView();
        Rotate rotateY = new Rotate();

        ImageView imageViewRW = new ImageView();
        ImageView imageViewPW = new ImageView();
        ImageView imageViewOW = new ImageView();
        ImageView imageViewIW = new ImageView();
        ImageView imageViewGW = new ImageView();
        ImageView imageViewBW = new ImageView();
        ImageView imageViewYW = new ImageView();

        imageViewB.setFitWidth(474.0/2);
        imageViewB.setFitHeight(275.0/2);
        imageViewG.setFitWidth(473.0/2);
        imageViewG.setFitHeight(411.0/2);
        imageViewI.setFitWidth(474.0/2);
        imageViewI.setFitHeight(137.0/2);
        imageViewO.setFitWidth(394.0/2);
        imageViewO.setFitHeight(275.0/2);
        imageViewR.setFitWidth(394.0/2);
        imageViewR.setFitHeight(275.0/2);
        imageViewY.setFitWidth(474.0/2);
        imageViewY.setFitHeight(275.0/2);
        imageViewP.setFitWidth(393.0/2);
        imageViewP.setFitHeight(413.0/2);
        imageViewBW.setFitWidth(158.0/2);
        imageViewBW.setFitHeight(138.0/2);
        imageViewGW.setFitWidth(158.0/2);
        imageViewGW.setFitHeight(138.0/2);
        imageViewIW.setFitWidth(158.0/2);
        imageViewIW.setFitHeight(138.0/2);
        imageViewOW.setFitWidth(158.0/2);
        imageViewOW.setFitHeight(138.0/2);
        imageViewRW.setFitWidth(158.0/2);
        imageViewRW.setFitHeight(138.0/2);
        imageViewPW.setFitWidth(158.0/2);
        imageViewPW.setFitHeight(138.0/2);
        imageViewYW.setFitWidth(156.0/2);
        imageViewYW.setFitHeight(137.0/2);

        //Set the initial variables of pieces.
        var x = 42/2;
        var y = 50/2;
        boolean isW = false;
        boolean com = false;

        //Divide the gameStateString into different strings.
        ArrayList<String> pieces = new ArrayList<>();
        if(gameStateString.substring(0,1).equals("W")){
            isW = true;
            for (int i = 1; i <= gameStateString.length()-3; i+=3){
                pieces.add(gameStateString.substring(i,i+3));
            }
        }else if(gameStateString.length()<=29){
            for (int i = 0; i < gameStateString.length()-4; i+=4){
                pieces.add(gameStateString.substring(i,i+4));
            }
        }else if(gameStateString.length()>29){
            com = true;
            for (int i = 0; i < 25; i+=4){
                pieces.add(gameStateString.substring(i,i+4));
            }
        }

        //Iterate pieces and move the pieces.
        for(String s : pieces){
            //Consider the Wizard challenge.
            if(isW){
                double mov_x = Integer.parseInt(s.substring(1,2));
                double y_pos = Integer.parseInt(s.substring(2));
                if(y_pos%2!=0) mov_x+=0.5;
                String p = s.substring(0,1);
                if(p.equals("r")){
                    imageViewRW.setImage(Wred);
                    imageViewRW.setX(x+mov_x*159.0/2);
                    imageViewRW.setY(y+y_pos*138.0/2);
                }else if(p.equals("p")){
                    imageViewPW.setImage(Wpink);
                    imageViewPW.setX(x+mov_x*159.0/2);
                    imageViewPW.setY(y+y_pos*138/2);
                }else if(p.equals("y")){
                    imageViewYW.setImage(Wyellow);
                    imageViewYW.setX(x+mov_x*159.0/2);
                    imageViewYW.setY(y+y_pos*138/2);
                }else if(p.equals("b")){
                    imageViewBW.setImage(Wblue);
                    imageViewBW.setX(x+mov_x*159.0/2);
                    imageViewBW.setY(y+y_pos*138/2);
                }else if(p.equals("i")){
                    imageViewIW.setImage(Windigo);
                    imageViewIW.setX(x+mov_x*159.0/2);
                    imageViewIW.setY(y+y_pos*138/2);
                }else if(p.equals("o")){
                    imageViewOW.setImage(Worange);
                    imageViewOW.setX(x+mov_x*159.0/2);
                    imageViewOW.setY(y+y_pos*138/2);
                }else if(p.equals("g")){
                    imageViewGW.setImage(Wgreen);
                    imageViewGW.setX(x+mov_x*159.0/2);
                    imageViewGW.setY(y+y_pos*138/2);
                }
            }else {
                // Consider the other challenges
                int rot = Integer.parseInt(s.substring(1,2));
                double mov_x = Integer.parseInt(s.substring(2,3));
                double y_pos = Integer.parseInt(s.substring(3));
                if(y_pos%2!=0) mov_x+=0.5;
                String p = s.substring(0,1);
                if(p.equals("r")){
                    if(rot == 2) mov_x++;
                    imageViewR.setImage(red);
                    imageViewR.getTransforms().addAll(rotateR);
                    imageViewR.setX(x+mov_x*159.0/2);
                    imageViewR.setY(y+y_pos*138.0/2);
                    rotateR.setPivotX(x+mov_x*159.0/2+40);
                    rotateR.setPivotY(y+y_pos*138.0/2+69.0/2);
                    rotateR.setAngle(60*rot);
                }else if(p.equals("p")){
                    if(rot==3) {
                        mov_x++;
                        y_pos+=2;
                    }else if(rot==4){
                        y_pos+=2;
                    }else if(rot==5){
                        mov_x-=0.5;
                        y_pos++;
                    }else if(rot==2) mov_x+=2;
                    imageViewP.setImage(pink);
                    imageViewP.getTransforms().addAll(rotateP);
                    imageViewP.setX(x+mov_x*159.0/2);
                    imageViewP.setY(y+y_pos*138/2);
                    rotateP.setPivotX(x+mov_x*159.0/2+40);
                    rotateP.setPivotY(y+y_pos*138/2+69.0/2);
                    rotateP.setAngle(60*rot);
                }else if(p.equals("o")){
                    if(rot == 5){
                        mov_x-=0.5;
                        y_pos++;
                    }else if(rot==3){
                        mov_x+=1.5;
                        y_pos++;
                    }else if(rot==4) y_pos+=2;
                    imageViewO.setImage(orange);
                    imageViewO.getTransforms().addAll(rotateO);
                    imageViewO.setX(x+mov_x*159.0/2);
                    imageViewO.setY(y+y_pos*138/2);
                    rotateO.setPivotX(x+mov_x*159.0/2+40);
                    rotateO.setPivotY(y+y_pos*138/2+69.0/2);
                    rotateO.setAngle(60*rot);
                }else if(p.equals("i")){
                    imageViewI.setImage(indigo);
                    imageViewI.getTransforms().addAll(rotateI);
                    imageViewI.setX(x+mov_x*159.0/2);
                    imageViewI.setY(y+y_pos*138/2);
                    rotateI.setPivotX(x+mov_x*159.0/2+40);
                    rotateI.setPivotY(y+y_pos*138/2+69.0/2);
                    rotateI.setAngle(60*rot);
                }else if(p.equals("g")){
                    if(rot==5){
                        mov_x-=0.5;
                        y_pos++;
                    }else if(rot==3){
                        mov_x+=2;
                        y_pos+=2;
                    }else if(rot==4){
                        mov_x-=0.5;
                        y_pos+=3;
                    }
                    imageViewG.setImage(green);
                    imageViewG.getTransforms().addAll(rotateG);
                    imageViewG.setX(x+mov_x*159.0/2);
                    imageViewG.setY(y+y_pos*138/2);
                    rotateG.setPivotX(x+mov_x*159.0/2+40);
                    rotateG.setPivotY(y+y_pos*138/2+69.0/2);
                    rotateG.setAngle(60*rot);
                }else if(p.equals("b")){
                    if(rot==5){
                        mov_x--;
                        y_pos+=2;
                    }else if(rot==3){
                        mov_x+=1.5;
                        y_pos++;
                    }else if(rot==4){
                        mov_x++;
                        y_pos+=2;
                    }
                    imageViewB.setImage(blue);
                    imageViewB.getTransforms().addAll(rotateB);
                    imageViewB.setX(x+mov_x*159.0/2);
                    imageViewB.setY(y+y_pos*138/2);
                    rotateB.setPivotX(x+mov_x*159.0/2+40);
                    rotateB.setPivotY(y+y_pos*138/2+69.0/2);
                    rotateB.setAngle(60*rot);
                }else if(p.equals("y")){
                    if(rot==3) {
                        y_pos++;
                        mov_x+=0.5;
                    }else if(rot==4){
                        mov_x++;
                        y_pos+=2;
                    }else if(rot==5){
                        mov_x--;
                        y_pos+=2;
                    }else if(rot==2) mov_x++;
                    imageViewY.setImage(yellow);
                    imageViewY.getTransforms().addAll(rotateY);
                    imageViewY.setX(x+mov_x*159.0/2);
                    imageViewY.setY(y+y_pos*138/2);
                    rotateY.setPivotX(x+mov_x*159.0/2+40);
                    rotateY.setPivotY(y+y_pos*138/2+69.0/2);
                    rotateY.setAngle(60*rot);
                }
            }
        }
        if(com){
            ArrayList<String> pieces2 = new ArrayList<>();
            for (int i = 29; i < gameStateString.length()-3; i+=3){
                pieces2.add(gameStateString.substring(i,i+3));
            }
            for(String s:pieces2){
                double mov_x = Integer.parseInt(s.substring(1,2));
                double y_pos = Integer.parseInt(s.substring(2));
                if(y_pos%2!=0) mov_x+=0.5;
                String p = s.substring(0,1);
                if(p.equals("r")){
                    imageViewRW.setImage(Wred);
                    imageViewRW.setX(x+mov_x*159.0/2);
                    imageViewRW.setY(y+y_pos*138/2);
                }else if(p.equals("p")){
                    imageViewPW.setImage(Wpink);
                    imageViewPW.setX(x+mov_x*159.0/2);
                    imageViewPW.setY(y+y_pos*138/2);
                }else if(p.equals("y")){
                    imageViewYW.setImage(Wyellow);
                    imageViewYW.setX(x+mov_x*159.0/2);
                    imageViewYW.setY(y+y_pos*138/2);
                }else if(p.equals("b")){
                    imageViewBW.setImage(Wblue);
                    imageViewBW.setX(x+mov_x*159.0/2);
                    imageViewBW.setY(y+y_pos*138/2);
                }else if(p.equals("i")){
                    imageViewIW.setImage(Windigo);
                    imageViewIW.setX(x+mov_x*159.0/2);
                    imageViewIW.setY(y+y_pos*138/2);
                }else if(p.equals("o")){
                    imageViewOW.setImage(Worange);
                    imageViewOW.setX(x+mov_x*159.0/2);
                    imageViewOW.setY(y+y_pos*138/2);
                }else if(p.equals("g")){
                    imageViewGW.setImage(Wgreen);
                    imageViewGW.setX(x+mov_x*159.0/2);
                    imageViewGW.setY(y+y_pos*138/2);
                }
            }
        }

        root.getChildren().add(imageView);
        root.getChildren().add(imageViewR);
        root.getChildren().add(imageViewP);
        root.getChildren().add(imageViewO);
        root.getChildren().add(imageViewI);
        root.getChildren().add(imageViewG);
        root.getChildren().add(imageViewB);
        root.getChildren().add(imageViewY);
        root.getChildren().add(imageViewRW);
        root.getChildren().add(imageViewPW);
        root.getChildren().add(imageViewOW);
        root.getChildren().add(imageViewIW);
        root.getChildren().add(imageViewGW);
        root.getChildren().add(imageViewBW);
        root.getChildren().add(imageViewYW);


        // FIXME Task 5 (CR): implement the simple game state viewer
    }

    // FIXME Task 8 (CR): Implement a basic playable IQ Stars game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 9 (D): Implement challenges (you may use the set of challenges in the Games class)

    // FIXME Task 11 (HD): Implement hints (should become visible when the user presses '/' -- see gitlab issue for details)

    // FIXME Task 12 (HD): Generate interesting challenges (each challenge must have exactly one solution)

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IQ Stars");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        initial();
        makePieceMove();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
