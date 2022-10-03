import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.BorderLayout;

public class EDFrame extends Frame{
    Panel encryptionPanel;
    Panel decryptionPanel;

    public EDFrame(String title) {
        super(title);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());
        addWindowListener(new EDWindowClosing(this));

        this.encryptionPanel = new Panel(new BorderLayout());
        this.decryptionPanel = new Panel(new BorderLayout());

        this.add(this.encryptionPanel);
        this.add(this.decryptionPanel);

        new Encryption(this, this.encryptionPanel);
        new Decryption(this, this.decryptionPanel);
    }
}
