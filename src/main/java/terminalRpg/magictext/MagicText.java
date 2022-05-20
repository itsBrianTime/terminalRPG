/*
 * MagicText.java is a class that handles formating terminal text to look better
 * than just black and white. It can move and delete text in the terminal. It can 
 * draw colored text to the terminal. It can either directly draw it or return a 
 * string with the correct color coded text.
 * 
 * @author Brian Bessler
 * @version 1.2
 * @since 05-19-2022
 * 
 */

package terminalrpg.magictext;

public class MagicText {
    
    // Reset
    public final String RESET = "\u001b[0m";

    // Color text
    public final String BLACK = "black";  
    public final String RED = "red";     
    public final String GREEN = "green";   
    public final String YELLOW = "yellow";  
    public final String BLUE = "blue";    
    public final String PURPLE = "purple";  
    public final String CYAN = "cyan";    
    public final String WHITE = "white";
    public final String RAINBOW = "rainbow";
    
    // formatting constants
    public final int REGULAR = 0;      
    public final int BRIGHT = 1;     
    public final int BACKGROUND = 2;  
    public final int BACKGROUNDBRIGHT = 3;    
    
    // Styles
    public final String BOLD = "\u001b[1m";
    public final String UNDERLINED = "\u001b[4m";
    public final String REVERSED = "\u001b[7m";

    // formatting arrays
    private String[] BlACK_TEXT = {"\u001b[30m", "\u001b[30;1m", 
        "\u001b[40m", "\u001b[40;1m"};

    private String[] RED_TEXT = {"\u001b[31m", "\u001b[31;1m", 
        "\u001b[41m", "\u001b[41;1m"};

    private String[] GREEN_TEXT = {"\u001b[32m", "\u001b[32;1m", 
        "\u001b[42m", "\u001b[42;1m"};

    private String[] YELLOW_TEXT = {"\u001b[33m", "\u001b[33;1m", 
        "\u001b[43m", "\u001b[43;1m"};

    private String[] BLUE_TEXT = {"\u001b[34m", "\u001b[34;1m", 
        "\u001b[44m", "\u001b[44;1m"};
    
    private String[] PURPLE_TEXT = {"\u001b[35m", "\u001b[35;1m", 
        "\u001b[45m", "\u001b[45;1m"};

    private String[] CYAN_TEXT = {"\u001b[36m", "\u001b[36;1m", 
        "\u001b[46m", "\u001b[46;1m"};

    private String[] WHITE_TEXT = {"\u001b[37m", "\u001b[37;1m", 
        "\u001b[47m", "\u001b[47;1m"};   
    
    private String[] RAINBOW_TEXT = {"\u001b[31;1m", "\u001b[33;1m", 
        "\u001b[34;1m", "\u001b[36;1m", "\u001b[32;1m", "\u001b[35;1m"};

    public MagicText() {

    }
    
    /** 
     * Draws colored text to the terminal based on the choices given. It can be
     * colored, bright, background colored, or bright background colored. Can also
     * add bold, underlined and/or reversed style
     * @param text What you want to display in the terminal
     * @param color Which color you want to pick, black, red, green, yellow,
     *      blue, purple, cyan or white.
     * @param format int that represents the text formatting desired
     * @param bold adds bold to text
     * @param underlined adds underline to text
     * @param reversed reverses colors with background
     */
    public boolean drawColoredText(String text, String color, int format, 
        boolean bold, boolean underlined, boolean reversed) {

        String coloredCode = colorPicker(color, format, text);
        coloredCode = coloredCode + stylePicker(bold, underlined, reversed);
        // must use RESET or all text after will be that color
        System.out.println(coloredCode + RESET); 
        return true;
    }

    
    /** 
     * returns colored text based on the choices given. It can be
     * colored, bright, background colored, or bright background colroed
     * @param text What you want to display in the terminal
     * @param color Which color you want to pick, black, red, green, yellow,
     *      blue, purple, cyan or white.
     * @param format int that represents the text formatting desired
     */
    public String getColoredText(String text, String color, int format,
        boolean bold, boolean underlined, boolean reversed) {

        String coloredCode = stylePicker(bold, underlined, reversed);
        coloredCode = coloredCode + colorPicker(color, format, text);;
        // must use RESET or all text after will be that color
        return coloredCode + RESET;
    }

    /** 
     * Moves cursor up and delete the line.
     * @param lines lines to move
     */
    public boolean resetLines(int lines) {
        // runs an extra time to clear current line
        for (int l = 0; l <= lines; l++) {
            cursorUp(1);
            clearLine(2);
        }
        return true;
    }   

    /** 
     * Moves cursor up.
     * @param numLines lines to move
     */
    public boolean cursorUp(int numLines) {
        System.out.print("\u001b[" + numLines + "A");
        return true;
    }

    /** 
     * Moves cursor down.
     * @param numLines lines to move
     */
    public boolean cursorDown(int numLines) {
        System.out.print("\u001b[" + numLines + "B");
        return true;
    }

    /** 
     * Moves cursor right.
     * @param numSpaces spaces to move
     */
    public boolean cursorRight(int numSpaces) {
        System.out.print("\u001b[" + numSpaces + "C");
        return true;
    }
    
    /** 
     * Moves cursor left.
     * @param numSpaces spaces to move
     */
    public boolean cursorLeft(int numSpaces) {
        System.out.print("\u001b[" + numSpaces + "D");
        return true;
    }
    
    /** 
     * Moves curosr to beginning of the next line.
     * @param numLines lines to move down
     */
    public boolean nextLine(int numLines) {
        System.out.print("\u001b[" + numLines + "E");
        return true;
    }

    /** 
     * Moves cursor to beginning of the pevious line.
     * @param numLines lines to move up
     */
    public boolean previousLine(int numLines) {
        System.out.print("\u001b[" + numLines + "F");
        return true;
    }

    /** 
     * Moves cursor to column.
     * @param column value of desired column
     */
    public boolean setCursorColumn(int column) {
        System.out.print("\u001b[" + column + "G");
        return true;
    }

    /** 
     * Moves cursor to (row, column).
     * @param row number of left/right desired position
     * @param col number of up/down desired position
     */
    public boolean setCursorPosition(int row, int col) {
        System.out.print("\u001b[" + row + ";" + col + "H");
        return true;
    }

    /** 
     * Can clear the console so new art/text can be displayed.
     * @param cursorLocation chooses clear from cursor until the end of the 
     *     screen (0), chooses clear from cursor to beginning of screen (1),
     *     chooses to clear entire screen (2)
     */
    public boolean clearScreen(int cursorLocation) {
        System.out.print("\u001b[" + cursorLocation + "J");
        System.out.flush();
        return true;
    }

    /** 
     * Clears the current line.
     * @param clearFrom Choose to clear from cursor to end of line (0), Choose
     *     to clear from cursor to start of line (1). Clear entire line (2)
     */
    public boolean clearLine(int clearFrom) {
        System.out.print("\u001b[" + clearFrom + "K");
        return true;
    }

    /** 
     * Saves the position the cursor is in. 
     */
    public boolean saveCursorPosition() {
        System.out.print("\u001b[s");
        return true;
    }
    
    /** 
     * Loads the position the cursor was in when it was saved. 
     */
    public boolean loadCursorPosition() {
        System.out.print("\u001b[u");
        return true;
    }
    
    private String colorPicker(String color, int format, String text) {
        switch (color) {
            case BLACK:
                return BlACK_TEXT[format] + text;
            
            case RED: 
                return RED_TEXT[format] + text;

            case GREEN:
                return GREEN_TEXT[format] + text;

            case YELLOW:
                return YELLOW_TEXT[format] + text;

            case BLUE:
                return BLUE_TEXT[format] + text;

            case PURPLE:
                return PURPLE_TEXT[format] + text;

            case CYAN:
                return CYAN_TEXT[format] + text;

            case WHITE:
                return WHITE_TEXT[format] + text;
            case RAINBOW:
                return rainbowColor(text);

            default:
                return RESET;
        }
    }

    private String rainbowColor(String text) {
        String newRainbowText = "";
        int rainbowIterator = 0;
        int rainbowMultiplier = 1;
        int rainbowMaxSize = RAINBOW_TEXT.length;
        for (int c = 0; c < text.length(); c++) {
            if (c >= rainbowMaxSize) {
                rainbowIterator = 0;
                rainbowMultiplier++;
                rainbowMaxSize = RAINBOW_TEXT.length * rainbowMultiplier;
            }
            if (text.charAt(c) != ' ') {
                newRainbowText += RAINBOW_TEXT[rainbowIterator] + text.charAt(c);
                rainbowIterator++;
            } else {
                newRainbowText += text.charAt(c);
            }
        }
        return newRainbowText;
    }   

    private String stylePicker(boolean bold, boolean underlined, boolean reversed) {
        String addedStyle = "";
        if (bold) {
            addedStyle += BOLD;
        }
        if (underlined) {
            addedStyle += UNDERLINED;
        }

        if (reversed) {
            addedStyle += REVERSED;
        }
        return addedStyle;
    }
}
