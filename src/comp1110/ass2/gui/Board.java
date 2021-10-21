package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static javafx.scene.input.MouseButton.SECONDARY;

public class Board extends Application {

    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    private final Group root = new Group();

    void makePieceMove(){
        /*
        Use some mouseevents to let pieces move. And drag the piece by the mouse. And it will judge when the mouse
        releases.
         */
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
        imageViewP.setImage(pink);
        ImageView imageViewO = new ImageView();
        imageViewO.setImage(orange);
        ImageView imageViewI = new ImageView();
        imageViewI.setImage(indigo);
        ImageView imageViewG = new ImageView();
        imageViewG.setImage(green);
        ImageView imageViewB = new ImageView();
        imageViewB.setImage(blue);
        ImageView imageViewY = new ImageView();
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
            /*
            When mouse presses on the piece picture area, the piece will be added to root.
             */
            @Override
            public void handle(MouseEvent mouseEvent) {
                double mouseX = mouseEvent.getSceneX();
                double mouseY = mouseEvent.getSceneY();
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
            /*
            Let the piece follow the mouse when drag.
             */
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
                for (int i = 0; i < isF.length; i++) {
                    isF[i]=false;
                }
            }
        });
        root.setOnScroll(new EventHandler<ScrollEvent>() {
            /*
            Let the piece rotate when scroll.
             */
            @Override
            public void handle(ScrollEvent scrollEvent) {
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
            }
        });
        root.getChildren().add(imageViewp);
    }
    public void rot(double[] pos,ImageView s){
        /*
        Let the piece rotate.
         */
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

    public void initial(String gameStateString){
        /*
        This part is similar to task 5, and some Height and width variables are changed.
         */
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
        /*
        This method initial the scene and it uses several buttons to launch the game.
         */
        final String[] rand = new String[1];
        primaryStage.setTitle("IQ Stars");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        Button b1 = new Button("Starter");
        Button b2 = new Button("Junior");
        Button b3 = new Button("Expert");
        Button b4 = new Button("Master");
        Button b5 = new Button("Wizard");
        b1.setLayoutX(60);
        b1.setLayoutY(350);
        b1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HashSet<String> Starter = new HashSet<>();
                Starter.add("y322g262b100i010p340W");
                Starter.add("r220y200g512b260p440W");
                Starter.add("r101y250g000b020i013W");
                Starter.add("r241o020y200b511i040W");
                Starter.add("r030o010y400i033p202W");
                Starter.add("o100y511g130i241p010W");
                Starter.add("r240o302b121i260p242W");
                Starter.add("r220y200g540b312p041W");
                Starter.add("r101o232g262i000p231W");
                Starter.add("o140y250g262b400p202W");
                Starter.add("r042o100g110b450i020W");
                Starter.add("r010o222g130b100i040W");
                Starter.add("r101y040b420p151W");
                Starter.add("y400b342i040p202W");
                Starter.add("r022o302y000b030W");
                Starter.add("r250o401b331i020W");
                Starter.add("y521g110i040p020W");
                Starter.add("r151g540i023p202W");
                Starter.add("r020o100y352b312W");
                Starter.add("o302y250g262i231W");
                Starter.add("r010o302g262i100W");
                Starter.add("r002y000b260p242W");
                Starter.add("o302g262b400i040W");
                Starter.add("r242g540b010p041W");
                int index=(int)(Math.random()*Starter.size());
                rand[0] = (String) Starter.toArray()[index];
                initial(rand[0]);
            }
        });
        b2.setLayoutX(60);
        b2.setLayoutY(400);
        b2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HashSet<String> Junior = new HashSet<>();
                Junior.add("y002g020b040W");
                Junior.add("r030b322i120W");
                Junior.add("r010y250i231W");
                Junior.add("r010y040p130W");
                Junior.add("r020b400i040W");
                Junior.add("r130y240b000W");
                Junior.add("o151b332p202W");
                Junior.add("r020o100y040W");
                Junior.add("o302g262i010W");
                Junior.add("r151g540b000W");
                Junior.add("y040b000p301W");
                Junior.add("o100b040i010W");
                Junior.add("r002g252W");
                Junior.add("o540g512W");
                Junior.add("g000p341W");
                Junior.add("o310b100W");
                Junior.add("o321i260W");
                Junior.add("g000i030W");
                Junior.add("y322p331W");
                Junior.add("g130p111W");
                Junior.add("o540y000W");
                Junior.add("g252p301W");
                Junior.add("r130o140W");
                Junior.add("b130i040W");
                int index=(int)(Math.random()*Junior.size());
                rand[0] = (String) Junior.toArray()[index];
                initial(rand[0]);
            }
        });
        b3.setLayoutX(60);
        b3.setLayoutY(450);
        b3.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HashSet<String> Expert = new HashSet<>();
                Expert.add("r212b450W");
                Expert.add("r220i040W");
                Expert.add("r030p301W");
                Expert.add("o460i030W");
                Expert.add("y141b450W");
                Expert.add("r252g232W");
                Expert.add("r151y200W");
                Expert.add("y030b000W");
                Expert.add("o322p151W");
                Expert.add("b450i010W");
                Expert.add("r002p222W");
                Expert.add("o302y342W");
                Expert.add("o460g232W");
                Expert.add("o401i033W");
                Expert.add("r021i010W");
                Expert.add("o262p121W");
                Expert.add("r222g540W");
                Expert.add("b342p011W");
                Expert.add("b531p202W");
                Expert.add("i000p450W");
                Expert.add("r240i010W");
                Expert.add("g311i032W");
                Expert.add("g231i003W");
                Expert.add("o222y040W");
                int index=(int)(Math.random()*Expert.size());
                rand[0] = (String) Expert.toArray()[index];
                initial(rand[0]);
            }
        });
        b4.setLayoutX(60);
        b4.setLayoutY(500);
        b4.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HashSet<String> Master = new HashSet<>();
                Master.add("o522W");
                Master.add("b011W");
                Master.add("g240W");
                Master.add("o240W");
                Master.add("y130W");
                Master.add("o520W");
                Master.add("p411W");
                Master.add("p421W");
                Master.add("p320W");
                Master.add("g250W");
                Master.add("y421W");
                Master.add("b520W");
                Master.add("g521W");
                Master.add("i250W");
                Master.add("b021W");
                Master.add("p211W");
                Master.add("i131W");
                Master.add("o531W");
                Master.add("o211W");
                Master.add("y220W");
                Master.add("y230W");
                Master.add("b521W");
                Master.add("y032W");
                int index=(int)(Math.random()*Master.size());
                rand[0] = (String) Master.toArray()[index];
                initial(rand[0]);
            }
        });
        b5.setLayoutX(60);
        b5.setLayoutY(550);
        b5.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HashSet<String> Wizard = new HashSet<>();
                Wizard.add("Wr22o13b21");
                Wizard.add("Wg11g32i00p43");
                Wizard.add("Wg11b13p31");
                Wizard.add("Wr10o30i00");
                Wizard.add("Wr43o42i33");
                Wizard.add("Wy50b30p10");
                Wizard.add("Wo32g31p30");
                Wizard.add("Wg62i30p02");
                Wizard.add("Wr62g22i42");
                Wizard.add("Wo53y13p31");
                Wizard.add("Wo12p21");
                Wizard.add("Wg01i23");
                Wizard.add("Wy13b43i30");
                Wizard.add("Wb32i21");
                Wizard.add("Wy53p00");
                Wizard.add("Wb01i51");
                Wizard.add("Wo21y31");
                Wizard.add("Wr40g20b60");
                Wizard.add("Wy50b21i43");
                Wizard.add("Wr40i12");
                Wizard.add("Wy22i23");
                Wizard.add("Wo52y32");
                Wizard.add("Wr30y23");
                Wizard.add("Wo40y20");
                int index=(int)(Math.random()*Wizard.size());
                rand[0] = (String) Wizard.toArray()[index];
                initial(rand[0]);
            }
        });
        Button b6 = new Button("Restart");
        b6.setLayoutX(60);
        b6.setLayoutY(600);
        b6.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                root.getChildren().addAll(b1,b2,b3,b4,b5,b6);
                makePieceMove();
                initial(rand[0]);
            }
        });
        root.getChildren().addAll(b1,b2,b3,b4,b5,b6);
        makePieceMove();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
