package utils;

public class Print {

    private static final String BLACK = "30";
    private static final String RED = "31";
    private static final String GREEN = "32";
    private static final String YELLOW = "33";
    private static final String BLUE= "34";
    private static final String MAGENTA = "35";
    private static final String CYAN = "36";
    private static final String WHITE = "37";

    public String black(String s) {
        return ansiString(BLACK) + s + ansiString("");
    }

    public String red(String s) {
        return ansiString(RED) + s + ansiString("");
    }

    public String green(String s) {
        return ansiString(GREEN) + s + ansiString("");
    }

    public String yellow(String s) {
        return ansiString(YELLOW) + s + ansiString("");
    }

    public String blue(String s) {
        return ansiString(BLUE) + s + ansiString("");
    }

    public String magenta(String s) {
        return ansiString(MAGENTA) + s + ansiString("");
    }

    public String cyan(String s) {
        return ansiString(CYAN) + s + ansiString("");
    }

    public String white(String s) {
        return ansiString(WHITE) + s + ansiString("");
    }

    private String ansiString(String color) {
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            return "";
        } else {
            return "\u001B[" + color + "m";
        }
    }
}
