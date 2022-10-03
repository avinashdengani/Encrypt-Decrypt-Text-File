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

    Encryption(EDFrame frame, Panel panel) {
        this.frame = frame;
        this.panel = panel;

        this.openFileLabel = new EDLabel("Select File", EDLabel.CENTER);
        this.saveFileLabel = new EDLabel("Save File", EDLabel.CENTER);

        this.openBtn = new EDButton("Choose", this);
        this.saveBtn = new EDButton("Save", this);

        this.dropdown = new EDDropdown();

        this.submitBtn = new EDButton("Submit", this);
    }

}
