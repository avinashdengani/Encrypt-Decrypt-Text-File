import java.awt.Button;

public class EDButton extends Button {
    Encryption encryption;
    Decryption decryption;
    
    EDButton(Encryption encryption) {
        super();
        this.encryption = encryption;
        addActionListener(new EDActionEvent(this.encryption, this.decryption));
    }
    
    EDButton(String label, Encryption encryption) {
        super(label);
        this.encryption = encryption;
        addActionListener(new EDActionEvent(this.encryption, this.decryption));
    }

    EDButton(Decryption decryption) {
        super();
        this.decryption = decryption;
        addActionListener(new EDActionEvent(this.encryption, this.decryption));
    }
    
    EDButton(String label, Decryption decryption) {
        super(label);
        this.decryption = decryption;
        addActionListener(new EDActionEvent(this.encryption, this.decryption));
    }

    {
        setFont(EDFont.getFont());
        
    }
}
