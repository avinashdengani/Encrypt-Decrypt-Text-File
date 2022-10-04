import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.FileDialog;

public class EDActionEvent implements ActionListener{
    
    Encryption encryption;
    Decryption decryption;

    FileDialog fileDialog;
    EDFrame frame;
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
            } else if(ae.getSource() == this.encryption.getSubmitButton()) {
                this.handleSubmit();
            }

        } else {
            if(ae.getSource() == this.decryption.getOpenBtn()) {
                this.handleOpenFile("Choose File to Decrypt");
            } else if(ae.getSource() == this.decryption.getSaveBtn()) {
                this.handleSaveFile("Save Decrppt File");
            }  else if(ae.getSource() == this.decryption.getSubmitButton()) {
                this.handleSubmit();
            }
        }
    }

    private void handleOpenFile(String title) {
        this.fileDialog = new FileDialog(this.frame, title, FileDialog.LOAD);
        this.fileDialog.setVisible(true);

        if(this.fileDialog.getFile() != null) {
            String fileText = EDFileReader.getTextFromFile(new File(this.fileDialog.getDirectory(), this.fileDialog.getFile()));

            if(isEncryption) {
                this.encryption.getOpenFileLabel().setText(this.fileDialog.getFile());
                this.encryption.setOpenFileDirectory(this.fileDialog.getDirectory());
                this.encryption.setOpenFileName(this.fileDialog.getFile());
            
                this.encryption.setFileText(fileText);
            } else {
                this.decryption.getOpenFileLabel().setText(this.fileDialog.getFile());
                this.decryption.setOpenFileDirectory(this.fileDialog.getDirectory());
                this.decryption.setOpenFileName(this.fileDialog.getFile());
                this.decryption.setFileText(fileText);
            }
        }

    }

    private void handleSaveFile(String title) {
        this.fileDialog = new FileDialog(this.frame, title, FileDialog.SAVE);
        this.fileDialog.setVisible(true);

        if(this.fileDialog.getFile() != null) {

            if(isEncryption) {
                this.encryption.getSaveFileLabel().setText(this.fileDialog.getFile());
                this.encryption.setSaveFileDirectory(this.fileDialog.getDirectory());
                this.encryption.setSaveFileName(this.fileDialog.getFile());
            } else {
                this.decryption.getSaveFileLabel().setText(this.fileDialog.getFile());
                this.decryption.setSaveFileDirectory(this.fileDialog.getDirectory());
                this.decryption.setSaveFileName(this.fileDialog.getFile());
            }
        }

    }
    private void handleSubmit() {

        if(isEncryption) {
            String encryptedText = this.encryption.getEncrpytedText();
            
            File newFile = new File(this.encryption.getSaveFileDirectory(), this.encryption.getSaveFileName());
            
            try {
                newFile.createNewFile();
                EDFileWriter.setTextInFile(newFile, encryptedText);
            } catch(Exception e) {
                System.out.println("Some Error Occurred");
            }

        } else {
            String decryptedText =  this.decryption.getDecrpytedText();
            File newFile = new File(this.decryption.getSaveFileDirectory(), this.decryption.getSaveFileName(decryptedText));
            
            try {
                newFile.createNewFile();
                EDFileWriter.setTextInFile(newFile, decryptedText);
            } catch(Exception e) {
                System.out.println("Some Error Occurred");
            }
        }
    }
}
