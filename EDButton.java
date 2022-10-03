import java.awt.Button;

public class EDButton extends Button {
    Encryption encryption;
    Decryption decryption;
    
    EDButton(Encryption encryption) {
        super();
        this.encryption = encryption;
    }
    
    EDButton(String label, Encryption encryption) {
        super(label);
        this.encryption = encryption;
    }

    EDButton(Decryption decryption) {
        super();
        this.decryption = decryption;
    }
    
    EDButton(String label, Decryption decryption) {
        super(label);
        this.decryption = decryption;
    }

    {
        setFont(EDFont.getFont());
        addActionListener(new EDActionEvent(this.encryption, this.decryption));
    }
}
