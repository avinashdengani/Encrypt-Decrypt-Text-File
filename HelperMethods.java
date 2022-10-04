public class HelperMethods {

    public static boolean isAlphabetic(char ch) {
        if( isUpperCase(ch) ||  isLowerCase(ch)) {
            return true;
        }
        return false;
    }

    public static boolean isSpace(char ch) {
        return (ch == ' ');
    }
    public static boolean isEnter(char ch) {
        return (ch == '\n');
    }
    public static boolean isUpperCase(char ch) {
        if ((ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }

    public static boolean isLowerCase(char ch) {
        if ((ch >= 'a' && ch <= 'z')) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(char ch) {
        if ((ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }  
}
