import java.awt.Frame;

public class EDFrame extends Frame{
    
    public EDFrame(String title) {
        super(title);
        setSize(800, 600);
        setLocationRelativeTo(null);

        addWindowListener(new EDWindowClosing(this));
    }
}
