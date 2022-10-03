import java.awt.Choice;

public class EDDropdown extends Choice{
    final int CEASER_CIPHER_PLAIN_INDEX = 0;
    final int CEASER_CIPHER_APLHABETIC_INDEX = 1;
    
    EDDropdown() {
        this.add("Ceaser Cipher");
        this.add("Ceaser Cipher Alphabetic");

        this.setFont(EDFont.getFont());
    }
}
