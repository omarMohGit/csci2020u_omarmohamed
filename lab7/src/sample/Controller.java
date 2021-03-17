package sample;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.io.FileReader;
import java.util.Collection;
import java.io.BufferedReader;
import java.util.HashMap;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
    private HashMap<String,Integer> diffTypes= new HashMap<>();
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};
    @FXML  public GraphicsContext gc;
    @FXML  private Canvas mCanvas;

    @FXML
    public void initialize(){
        gc=mCanvas.getGraphicsContext2D();
        warn("weatherwarnings-2015.csv");
        drawPie();
    }

    private void warn (String fileName) {
        String text = "";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((text= reader.readLine()) != null) {
                String [] nl = text.split(",");
                String diffWarn= nl[5];

                if(diffTypes.containsKey(diffWarn)){
                    int prev=diffTypes.get(diffWarn);
                    diffTypes.replace(diffWarn,prev+1);
                }
                else{
                    diffTypes.put(diffWarn,1);
                }
            }
            reader.close();

        }catch(Exception except){
            except.printStackTrace();
        }
    }


    private void drawPie(){

       int nwTypes= diffTypes.keySet().size();
       double []ang=new double[nwTypes];
       int num=0;
       //counts slot
       for(String diffWarn: diffTypes.keySet()){
            num=num+1;
       }


       int b=0;
       int tCirc=num;
       int arc= tCirc*360/num;
       //fills,calculates
       for(String diffWarn: diffTypes.keySet()){
           gc.setFill(Color.BLACK);
           gc.fillText(diffWarn,120, 65+b*28);
           gc.setFill(pieColours[b]);
           gc.fillRect(65,35+b*25,35,35);

           //filling in lectu
           gc.fillArc(300,80,200,200,0,arc, ArcType.ROUND);
           //tCirc=tCirc-diffTypes.get(diffWarn);
           b++;


           //What I need to do after midterm
           //fix order of text & spliting into angles for everything
        }

    }
}
