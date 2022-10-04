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
                this.showErrorDialog();
            } else {
                submitEncryption();
            }
            
        } else {

            if (this.decryption.getOpenFileName() == null
                    || this.decryption.getOpenFileDirectory() == null
                    || this.decryption.getSaveFileName() == null
                    || this.decryption.getSaveFileDirectory() == null) {
                this.showErrorDialog();
            } else {
                submitDecryption();
            }
        }
    }

    private void showErrorDialog() {
        dialog = new EDDialog(this.frame, "Error", true);

        if(isEncryption) {
            dialog.add(new EDLabel("Please Choose All The Files For Encryption"));
        } else {
            dialog.add(new EDLabel("Please Choose All The Files For Decryption"));
        }

        dialog.setSize(700, 200);
        dialog.setVisible(true);
    }
    private void submitEncryption() {
        String encryptedText = this.encryption.getEncryptedText();
        File newFile = new File(this.encryption.getSaveFileDirectory(), this.encryption.getSaveFileName());
        
        saveFileAfterSubmitting(newFile, encryptedText);
    }

    private void submitDecryption() {
        String decryptedText = this.decryption.getDecryptedText();
        File newFile = new File(this.decryption.getSaveFileDirectory(), this.decryption.getSaveFileName());
    
        saveFileAfterSubmitting(newFile, decryptedText);
    }

    private void saveFileAfterSubmitting(File file, String text) {
        try {
            file.createNewFile();
            EDFileWriter.setTextInFile(file, text);
        } catch(Exception e) {
            dialog = new EDDialog(this.frame, "Error", true);
            
            dialog.add(new EDLabel("Some Error Occured! Try Againn"));
            
            dialog.setVisible(true);
        }
    }
}
