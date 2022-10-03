import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EDActionEvent implements ActionListener{
    
    Encryption encryption;
    Decryption decryption;

    EDActionEvent(Encryption encryption, Decryption decryption) {
        this.encryption = encryption;
        this.decryption = decryption;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
