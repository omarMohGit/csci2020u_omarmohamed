package midterm2021;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {
    private Canvas canvas;
    //animation
    // 35,50,9,120,95,0
    private int frameWidth = 95;
    private int frameHeight = 50;
    private int numFrames = 9;
    private int sourceHeightOffset = 120;
    private int sourceWidthOffset = 95;
    private int frameIndex = 0;
//QUACK QUACK QUACK QUACK QUACK QUACK QUACK QUACK
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("CSCI2020U - Midterm");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);




//      Creating the menu buttons
        Button btApp1 = new Button("Animation");
        btApp1.setPrefWidth(200);
        Button btApp2 = new Button("2D Graphics");
        btApp2.setPrefWidth(200);
        Button btApp3 = new Button("About");
        btApp3.setPrefWidth(200);

        Button btApp4 = new Button("Go to main menu");
        btApp3.setPrefWidth(200);







//        setting the Event handlers for each buttons
        btApp1.setOnAction(new EventHandler<ActionEvent>() {
            private void drawAnimation(Group root) {

                GraphicsContext gc = canvas.getGraphicsContext2D();
                Image image = new Image(getClass().getClassLoader().getResource("midterm2021/ducks.png").toString());
                Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        gc.setFill(Color.BLACK);
                        gc.fillRect(200, 50, frameWidth, frameHeight);
                        gc.drawImage(image, sourceWidthOffset, sourceHeightOffset, frameWidth, frameHeight, 200, 50, frameWidth, frameHeight);
                        frameIndex = (frameIndex+1) % numFrames;
                        sourceHeightOffset = frameHeight*frameIndex;

                    }
                }
                )
                );

                timeline.playFromStart();
            }

            @Override
            public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                      Display the "Animation" in the CENTER,
//                      and a "Back to Main" on the TOP
                Group root = new Group();
                Scene scene = new Scene(root, 1000, 600);
                canvas = new Canvas();
                canvas.widthProperty().bind(primaryStage.widthProperty());
                canvas.heightProperty().bind(primaryStage.heightProperty());
                root.getChildren().add(canvas);

                primaryStage.setTitle(" Animation ");
                primaryStage.setScene(scene);
                primaryStage.show();
                drawAnimation(root);

                 System.out.println("On Animation button");
            }
        });








        btApp2.setOnAction(new EventHandler<ActionEvent>() {
            private void draw(Group root) {
                GraphicsContext gc = canvas.getGraphicsContext2D();

                gc.setStroke(Color.RED);
                gc.strokeOval(350, 175, 100, 100);
                gc.strokeOval(450, 265, 10, 10);
                gc.strokeOval(650, 265, 10, 10);
                gc.fillOval(450, 265, 10, 10);
                gc.fillOval(650, 265, 10, 10);

                gc.strokeLine(500,200,545,300);
                gc.strokeLine(605,200,545,300);

                gc.strokeLine(500,200,500,410);
                gc.strokeLine(600,200,600,410);


            }

            @Override
            public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                    Display the "2D Drawing" in the CENTER,
//                    and a "Back to Main" on the TOP
                Group root = new Group();
                Scene scene = new Scene(root,850, 750);
                canvas = new Canvas();
                canvas.widthProperty().bind(primaryStage.widthProperty());
                canvas.heightProperty().bind(primaryStage.heightProperty());
                root.getChildren().add(canvas);
                System.out.println("Clicked on Graphics 2D button");

                primaryStage.setScene(scene);
                primaryStage.show();
                draw(root);


            }
        });



        btApp3.setOnAction(new EventHandler<ActionEvent>() {
            private void fReader() {
                try{
                    File fxMF=new File("resources/studInfo.fxml");
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder(fxMF);
                    Document doc= docBuilder.parse(fxMF);
                    NodeList nodes= doc.getElementsByTagName("info");
                    int length= nodes.getLength();
                    for(int a =0; a<length;a++){
                        Element elemT=(Element)nodes.item(a);
                        String ID=getTagValue("student ID", elemT);
                        String Name=getTagValue("name", elemT);
                        String desc=getTagValue("software-description", elemT);
                        String email=getTagValue("email", elemT);
                    }
                }catch(Exception except){
                    except.printStackTrace();
                }
                //output to template, finush lecture video
            }


            @Override
            public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                    Display the "About" in the CENTER,
//                    and a "Back to Main" on the TOP
                grid.setAlignment(Pos.CENTER);
                grid.setVgap(8);
                grid.setHgap(8);
                Scene scene= new Scene (grid,1000,800);
                primaryStage.setScene(scene);
                fReader();
            }
        });












//        Add the menu buttons to the grid
        grid.add(btApp1, 0,1);
        grid.add(btApp2, 0,2);
        grid.add(btApp3, 0,3);

        // main App Scene
        Scene mainScene = new Scene(grid, 300, 275);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
