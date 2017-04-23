import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);

        ImageIcon iia = new ImageIcon("area.png");
        Image image = iia.getImage();
        this.setImage(image);
    }
}
