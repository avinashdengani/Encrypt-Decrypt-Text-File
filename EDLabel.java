import java.awt.Label;

public class EDLabel extends Label{
    EDLabel()  {
        super();
    }
    EDLabel(String text) {
        super(text);
    }
    EDLabel(String text, int alignment) {
        super(text, alignment);
    }

    {
        setSize(15, 15);
        setFont(EDFont.getFont());
    }
}
