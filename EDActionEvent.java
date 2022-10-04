import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.FileDialog;

public class EDActionEvent implements ActionListener{
    EDFrame frame;
    
    private Encryption encryption;
    private Decryption decryption;

    private EDDialog dialog;
    private FileDialog fileDialog;
    private boolean isEncryption;


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
            if (this.encryption.getOpenFileName() == null
                    || this.encryption.getOpenFileDirectory() == null
                    || this.encryption.getSaveFileName() == null
                    || this.encryption.getSaveFileDirectory() == null) {
                this.showErrorDialog("Please Choose All The Files For Encryption");
            } else {
                submitEncryption();
            }
            
        } else {

            if (this.decryption.getOpenFileName() == null
                    || this.decryption.getOpenFileDirectory() == null
                    || this.decryption.getSaveFileName() == null
                    || this.decryption.getSaveFileDirectory() == null) {
                this.showErrorDialog("Please Choose All The Files For Decryption");
            } else {
                submitDecryption();
            }
        }
    }

    private void showErrorDialog(String message) {
        dialog = new EDDialog(this.frame, "Error", true);

        dialog.add(new EDLabel(message));
        dialog.setSize(800, 200);
        dialog.setVisible(true);
    }

    private void showSuccessDialog(String message) {
        dialog = new EDDialog(this.frame, "Success", true);
        dialog.add(new EDLabel(message));
        dialog.setSize(800, 200);
        dialog.setVisible(true);
    }

    private void submitEncryption() {
        String encryptedText = this.encryption.getEncryptedText();
        File newFile = new File(this.encryption.getSaveFileDirectory(), this.encryption.getSaveFileName());
        
        if(saveFileAfterSubmitting(newFile, encryptedText)) {
            showSuccessDialog("Your Encrypted file has been saved Succesfully!");
            encryption.resetFields();
        }
        
    }

    private void submitDecryption() {
        String decryptedText = this.decryption.getDecryptedText();
        File newFile = new File(this.decryption.getSaveFileDirectory(), this.decryption.getSaveFileName());
    
        if(saveFileAfterSubmitting(newFile, decryptedText)) {
            showSuccessDialog("Your Decrypted file has been saved Succesfully!");
            decryption.resetFields();
        }
    }

    private boolean saveFileAfterSubmitting(File file, String text) {
        try {
            file.createNewFile();
            EDFileWriter.setTextInFile(file, text);
            return true;
        } catch(Exception e) {
            showErrorDialog("Some Error Occured! Try Again");
            return false;
        }
    }
}
