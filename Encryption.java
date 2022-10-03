import java.awt.BorderLayout;
import java.awt.Panel;

public class Encryption {
    EDFrame frame;
    private Panel panel;
    private EDLabel openFileLabel;
    private EDLabel saveFileLabel;
    private EDButton openBtn;
    private EDButton saveBtn;
    private EDButton submitBtn;
    private EDDropdown dropdown;
    private String openFileDirectory;
    private String openFileName;
    private String saveFileDirectory;
    private String saveFileName;
    private String fileText;

    Encryption(EDFrame frame, Panel panel) {
        this.frame = frame;
        this.panel = panel;

        this.openFileLabel = new EDLabel("Select File", EDLabel.CENTER);
        this.saveFileLabel = new EDLabel("Save File", EDLabel.CENTER);

        this.openBtn = new EDButton("Choose", this);
        this.saveBtn = new EDButton("Save", this);

        this.dropdown = new EDDropdown();

        this.submitBtn = new EDButton("Submit", this);

        Panel openFilePanel = new Panel();
        Panel dropDownPanel = new Panel();
        Panel saveFilePanel = new Panel();
        Panel submitPanel = new Panel();
        Panel centerPanel = new Panel(new BorderLayout());

        openFilePanel.add(this.openFileLabel);
        openFilePanel.add(this.openBtn);

        dropDownPanel.add(this.dropdown);

        saveFilePanel.add(this.saveFileLabel);
        saveFilePanel.add(this.saveBtn);

        centerPanel.add(dropDownPanel, BorderLayout.NORTH);
        centerPanel.add(saveFilePanel, BorderLayout.SOUTH);

        submitPanel.add(submitBtn);

        this.panel.add(openFilePanel, BorderLayout.NORTH);
        this.panel.add(centerPanel, BorderLayout.CENTER);
        this.panel.add(submitPanel, BorderLayout.SOUTH);

    }


    //GETTERS
    public EDButton getOpenBtn() {
        return this.openBtn;
    }
    public EDButton getSaveBtn() {
        return this.saveBtn;
    }
    public EDButton getSubmitButton() {
        return this.submitBtn;
    }
    public EDLabel getOpenFileLabel() {
        return this.openFileLabel;
    }
    public EDLabel getSaveFileLabel() {
        return this.saveFileLabel;
    }
    public EDDropdown getEdDropdown() {
        return this.dropdown;
    }
    public String getOpenFileDirectory() {
        return this.openFileDirectory;
    }
    public void setOpenFileDirectory(String dir) {
        this.openFileDirectory = dir;
    }

    public String getSaveFileDirectory() {
        return this.saveFileDirectory;
    }
    public void setSaveFileDirectory(String dir) {
        this.saveFileDirectory = dir;
    }

    public String getOpenFileName() {
        return this.openFileName;
    }
    public void setOpenFileName(String name) {
        this.openFileName = name;
    }

    public String getSaveFileName(String name) {
        return this.saveFileName;
    }
    public void setSaveFileName(String name) {
        this.saveFileName = name;
    }
    public String getFileText() {
        return this.fileText;
    }
    public void setFileText(String text) {
        this.fileText = text;
    }
}
