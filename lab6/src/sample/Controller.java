package sample;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {
    @FXML  public GraphicsContext gc;
    @FXML  private Canvas mCanvas;


    private static double [] avgHousingPricesByYear = {247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7};
    private static double [] avgCommercialPricesByYear = { 1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3};
    private static String [] ageGroups = {"18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int [] purchasesByAgeGroup = {648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};


    @FXML
    public void initialize(){
        gc=mCanvas.getGraphicsContext2D();
        drawBar(125,230,avgHousingPricesByYear,avgCommercialPricesByYear,Color.RED,Color.BLUE,150);
        drawPie(purchasesByAgeGroup,pieColours);
    }
    public void drawBar(int x, int y, double [] purchaseInfo, double [] comInfo, Color color1,Color color2,int base){
        double maxed = Double.NEGATIVE_INFINITY;
        double min = Double.MAX_VALUE;

        //Determines the biggest value in avgHousingpricesByYear
        for(double newVal:purchaseInfo){
            if(newVal > maxed){
                maxed=newVal;
            }
            if(newVal < min){
                min=newVal;
            }
        }

        //Determines the biggest value in avgCommercialPricesByYear
        for(double newVal:comInfo){
            if(newVal > maxed){
                maxed=newVal;
            }
            if(newVal < min){
                min=newVal;
            }
        }

        //creates main bargraph (blue)
        double space= x/purchaseInfo.length;
        double begin = base;
        gc.setFill(color1);
        for(double val : purchaseInfo){
            double height = ((val - min) / (maxed - min)) * y;
            gc.fillRect(begin - 80, (y - height) + 200, space, height+20);
            begin += space * 2.5;
        }

        //creates 2nd bar graph (red)
        gc.setFill(color2);
        begin = 150 + space;
        for(double val : comInfo){
            double height = ((val - min) / (maxed - min)) * y;
            gc.fillRect(begin - 80, (y - height) + 200, space, height+20);
            begin += space * 2.5;
        }

    }

    public void drawPie(int[]purchaseInfo,Color[]pColors){
        double sum = 0;
        double angleBeg = 0;
        //determines how many slots there are in the piegraph
        for (int slot : purchaseInfo) {
            sum += slot;
        }
        //determines how big the slot should be and create/fill it
        for (int b = 0; b < purchaseInfo.length; b++) {
            gc.setFill(pColors[b]);
            double newAng=360*(purchaseInfo[b]/sum);
            gc.fillArc(400,5,300,300,angleBeg,newAng,ArcType.ROUND);
            angleBeg=angleBeg+newAng;
        }
    }
}
