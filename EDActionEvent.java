import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FileDialog;

public class EDActionEvent implements ActionListener{
    
    Encryption encryption;
    Decryption decryption;

    FileDialog fileDialog;
    EDFrame frame;
    String fileDirectory;
    String fileName;
    boolean isEncryption;
    String fileText;

    EDActionEvent(Encryption encryption, Decryption decryption) {
        this.encryption = encryption;
        this.decryption = decryption;

        if(this.encryption != null) {
            this.isEncryption = true;
            this.frame = this.encryption.frame;
        } else if(this.decryption != null) {
            this.isEncryption = false;
            this.frame = this.decryption.frame;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(this.isEncryption) {

            if(ae.getSource() == this.encryption.getOpenBtn()) {
                this.handleOpenFile("Choose File to Encrypt");
            } else if(ae.getSource() == this.encryption.getSaveBtn()) {
                this.handleSaveFile("Save Encrypted File");
            }

        } else {
            if(ae.getSource() == this.decryption.getOpenBtn()) {
                this.handleOpenFile("Choose File to Decrypt");
            } else if(ae.getSource() == this.decryption.getSaveBtn()) {
                this.handleSaveFile("Save Decrppt File");
            } 
        }
    }

    private void handleOpenFile(String title) {
        this.fileDialog = new FileDialog(this.frame, title, FileDialog.LOAD);
        this.fileDialog.setVisible(true);

        if(this.fileDialog.getFile() != null) {

            if(isEncryption) {
                this.encryption.getOpenFileLabel().setText(fileName);
                this.encryption.setOpenFileDirectory(this.fileDialog.getDirectory());
                this.encryption.setOpenFileName(this.fileDialog.getFile());
            } else {
                this.decryption.getOpenFileLabel().setText(fileName);
                this.decryption.setOpenFileDirectory(this.fileDialog.getDirectory());
                this.decryption.setOpenFileName(this.fileDialog.getFile());
            }
        }

    }

    private void handleSaveFile(String title) {
        this.fileDialog = new FileDialog(this.frame, title, FileDialog.SAVE);
        this.fileDialog.setVisible(true);

        if(this.fileDialog.getFile() != null) {

            if(isEncryption) {
                this.encryption.getSaveFileLabel().setText(fileName);
                this.encryption.setSaveFileDirectory(this.fileDialog.getDirectory());
                this.encryption.setSaveFileName(this.fileDialog.getFile());
            } else {
                this.decryption.getSaveFileLabel().setText(fileName);
                this.decryption.setSaveFileDirectory(this.fileDialog.getDirectory());
                this.decryption.setSaveFileName(this.fileDialog.getFile());
            }
        }

    }
}
