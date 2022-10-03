import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;

public class EDFrame extends Frame{
    Panel encryptionPanel;
    Panel decryptionPanel;

    public EDFrame(String title) {
        super(title);
        
        Dimension dimension = new Dimension(1100, 850);
        
        this.setSize(dimension);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2, 6, 6));
        this.setBackground(Color.BLACK);
        this.setMinimumSize(dimension);;

        this.addWindowListener(new EDWindowClosing(this));

        this.encryptionPanel = new Panel(new BorderLayout(200, 150));
        this.decryptionPanel = new Panel(new BorderLayout(200, 150));

        this.encryptionPanel.setBackground(Color.LIGHT_GRAY);
        this.decryptionPanel.setBackground(Color.LIGHT_GRAY);

        this.add(this.encryptionPanel);
        this.add(this.decryptionPanel);

        new Encryption(this, this.encryptionPanel);
        new Decryption(this, this.decryptionPanel);
   
    }
    public Insets getInsets() {
		return new Insets(80, 80, 80, 80);
	}
}
