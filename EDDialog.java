import java.awt.Dialog;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.FlowLayout;
import java.awt.Font;

public class EDDialog extends Dialog{
    
    EDDialog(EDFrame frame, String title) {
        super(frame, title);
    }
    EDDialog(EDFrame frame, String title, boolean modal) {
        super(frame, title, modal);
    }

    //Intializer block
    {
        setSize(400, 200);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        
        setFont(new Font("Times New Roman", Font.PLAIN, 25));

        addWindowListener(new WindowAdapter() {
           @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}
