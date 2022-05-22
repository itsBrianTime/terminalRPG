package terminalrpg.magicterminal;

public class MagicConsole {

    public MagicConsole() {

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
    
}
