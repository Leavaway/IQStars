package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

/**
 * A very simple viewer for game states in the IQ-Stars game.
 * <p>
 * NOTE: This class is separate from your main game class. This
 * class does not play a game, it just illustrates various game
 * states.
 */
public class Viewer extends Application {

    /* board layout */
    private static final double VIEWER_WIDTH = 1545;
    private static final double VIEWER_HEIGHT = 795;

    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField textField;

    void makePieceMove(){
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

        ImageView imageViewp = new ImageView();
        imageViewp.setImage(preview);
        imageViewp.setX(1200);
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
                if(mouseX>1200&&mouseX<1350&&mouseY>10&&mouseY<130){
                    imageViewR.setX(mouseX);
                    imageViewR.setY(mouseY);
                    root.getChildren().add(imageViewR);
                    isF[0] = true;
                }else if(mouseX>1355&&mouseX<1520&&mouseY>10&&mouseY<130){
                    imageViewB.setX(mouseX);
                    imageViewB.setY(mouseY);
                    root.getChildren().add(imageViewB);
                    isF[1] = true;
                }else if(mouseX>1200&&mouseX<1350&&mouseY>130&&mouseY<280){
                    imageViewO.setX(mouseX);
                    imageViewO.setY(mouseY);
                    root.getChildren().add(imageViewO);
                    isF[2] = true;
                }else if(mouseX>1355&&mouseX<1520&&mouseY>140&&mouseY<300){
                    imageViewP.setX(mouseX);
                    imageViewP.setY(mouseY);
                    root.getChildren().add(imageViewP);
                    isF[3] = true;
                }else if(mouseX>1200&&mouseX<1350&&mouseY>290&&mouseY<440){
                    imageViewG.setX(mouseX);
                    imageViewG.setY(mouseY);
                    root.getChildren().add(imageViewG);
                    isF[4] = true;
                }else if(mouseX>1355&&mouseX<1520&&mouseY>320&&mouseY<450){
                    imageViewI.setX(mouseX);
                    imageViewI.setY(mouseY);
                    root.getChildren().add(imageViewI);
                    isF[5] = true;
                }else if(mouseX>1200&&mouseX<1400&&mouseY>480&&mouseY<590){
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
                System.out.println(isF);
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
                for (boolean s:isF
                     ) {
                    System.out.println(s);
                }
                System.out.println("----");
                for (int i = 0; i < isF.length; i++) {
                    isF[i]=false;
                }
            }
        });
        root.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {

            }
        });
        root.getChildren().add(imageViewp);
    }

    /**
     * Draw a game state in the window, removing any previously drawn one
     *
     * @param gameStateString A valid game state string
     */
    void makeGameState(String gameStateString) {

        //Set the path to pictures of pieces and wizard pieces.
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
        imageView.setFitHeight(700-50);
        imageView.setFitWidth(1194);

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

        //Set the initial variables of pieces.
        var x = 42;
        var y = 50;
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
                    imageViewRW.setX(x+mov_x*159);
                    imageViewRW.setY(y+y_pos*138);
                }else if(p.equals("p")){
                    imageViewPW.setImage(Wpink);
                    imageViewPW.setX(x+mov_x*159);
                    imageViewPW.setY(y+y_pos*138);
                }else if(p.equals("y")){
                    imageViewYW.setImage(Wyellow);
                    imageViewYW.setX(x+mov_x*159);
                    imageViewYW.setY(y+y_pos*138);
                }else if(p.equals("b")){
                    imageViewBW.setImage(Wblue);
                    imageViewBW.setX(x+mov_x*159);
                    imageViewBW.setY(y+y_pos*138);
                }else if(p.equals("i")){
                    imageViewIW.setImage(Windigo);
                    imageViewIW.setX(x+mov_x*159);
                    imageViewIW.setY(y+y_pos*138);
                }else if(p.equals("o")){
                    imageViewOW.setImage(Worange);
                    imageViewOW.setX(x+mov_x*159);
                    imageViewOW.setY(y+y_pos*138);
                }else if(p.equals("g")){
                    imageViewGW.setImage(Wgreen);
                    imageViewGW.setX(x+mov_x*159);
                    imageViewGW.setY(y+y_pos*138);
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
                    imageViewR.setX(x+mov_x*159);
                    imageViewR.setY(y+y_pos*138);
                    rotateR.setPivotX(x+mov_x*159+80);
                    rotateR.setPivotY(y+y_pos*138+69);
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
                    imageViewP.setX(x+mov_x*159);
                    imageViewP.setY(y+y_pos*138);
                    rotateP.setPivotX(x+mov_x*159+80);
                    rotateP.setPivotY(y+y_pos*138+69);
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
                    imageViewO.setX(x+mov_x*159);
                    imageViewO.setY(y+y_pos*138);
                    rotateO.setPivotX(x+mov_x*159+80);
                    rotateO.setPivotY(y+y_pos*138+69);
                    rotateO.setAngle(60*rot);
                }else if(p.equals("i")){
                    imageViewI.setImage(indigo);
                    imageViewI.getTransforms().addAll(rotateI);
                    imageViewI.setX(x+mov_x*159);
                    imageViewI.setY(y+y_pos*138);
                    rotateI.setPivotX(x+mov_x*159+80);
                    rotateI.setPivotY(y+y_pos*138+69);
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
                    imageViewG.setX(x+mov_x*159);
                    imageViewG.setY(y+y_pos*138);
                    rotateG.setPivotX(x+mov_x*159+80);
                    rotateG.setPivotY(y+y_pos*138+69);
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
                    imageViewB.setX(x+mov_x*159);
                    imageViewB.setY(y+y_pos*138);
                    rotateB.setPivotX(x+mov_x*159+80);
                    rotateB.setPivotY(y+y_pos*138+69);
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
                    imageViewY.setX(x+mov_x*159);
                    imageViewY.setY(y+y_pos*138);
                    rotateY.setPivotX(x+mov_x*159+80);
                    rotateY.setPivotY(y+y_pos*138+69);
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
                    imageViewRW.setX(x+mov_x*159);
                    imageViewRW.setY(y+y_pos*138);
                }else if(p.equals("p")){
                    imageViewPW.setImage(Wpink);
                    imageViewPW.setX(x+mov_x*159);
                    imageViewPW.setY(y+y_pos*138);
                }else if(p.equals("y")){
                    imageViewYW.setImage(Wyellow);
                    imageViewYW.setX(x+mov_x*159);
                    imageViewYW.setY(y+y_pos*138);
                }else if(p.equals("b")){
                    imageViewBW.setImage(Wblue);
                    imageViewBW.setX(x+mov_x*159);
                    imageViewBW.setY(y+y_pos*138);
                }else if(p.equals("i")){
                    imageViewIW.setImage(Windigo);
                    imageViewIW.setX(x+mov_x*159);
                    imageViewIW.setY(y+y_pos*138);
                }else if(p.equals("o")){
                    imageViewOW.setImage(Worange);
                    imageViewOW.setX(x+mov_x*159);
                    imageViewOW.setY(y+y_pos*138);
                }else if(p.equals("g")){
                    imageViewGW.setImage(Wgreen);
                    imageViewGW.setX(x+mov_x*159);
                    imageViewGW.setY(y+y_pos*138);
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

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Game State:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makeGameState(textField.getText());
                makePieceMove();
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IQ Stars Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
