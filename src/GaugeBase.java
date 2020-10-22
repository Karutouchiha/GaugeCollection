import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class GaugeBase extends Group {

    private int width = 100;
    private int height = 100;
    private int value = 0;

    public GaugeBase()
    {
        //nothing to do here
    }

    public void redraw()
    {
        Rectangle battery = new Rectangle();
        battery.setX(0);
        battery.setY(0);
        battery.setWidth(220);
        battery.setHeight(60);
        battery.setFill(Color.GRAY);

        Rectangle bar_1 = new Rectangle();
        bar_1.setFill(Color.RED);
        bar_1.setX(0);
        bar_1.setY(0);
        bar_1.setWidth(20);
        bar_1.setHeight(60);
        bar_1.setArcWidth(20);
        bar_1.setArcHeight(20);

        Text t = new Text();
        t.setText(String.valueOf(this.value));
        t.setFont(Font.font ("Verdana", 20));
        t.setFill(Color.BLACK);

        //measure the text
        double w = t.getLayoutBounds().getWidth();
        double h = t.getLayoutBounds().getHeight();

        //calculate center
        //t.setX(this.width / 2.0 - w / 2.0);
        //t.setY(this.height / 2 - h / 2.0);

        this.getChildren().addAll(battery,bar_1,t);
    }

    public void init(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.redraw();
    }

    public void setValue(int v)
    {
        this.value = v;
        this.redraw();
    }
}