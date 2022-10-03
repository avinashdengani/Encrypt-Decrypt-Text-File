import java.awt.BorderLayout;
import java.awt.Panel;

public class Decryption {
    EDFrame frame;
    private Panel panel;
    private EDLabel openFileLabel;
    private EDLabel saveFileLabel;
    private EDButton openBtn;
    private EDButton saveBtn;
    private EDButton submitBtn;
    private EDDropdown dropdown;

    Decryption(EDFrame frame, Panel panel) {
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

}
