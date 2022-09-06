public class Move {

    public Move() {}

    int col = 3;

    // to save game states after making a move
    byte[] rpuz = new byte[9]; // right
    byte[] lpuz = new byte[9]; // left
    byte[] dpuz = new byte[9]; // down
    byte[] upuz = new byte[9]; // up


    /**Method to copy the puzzle in order to make a move 
     * @param a puzzle to copy to
     * @param b puzzle to copy from
    */
    private void duplicatePuzzle(byte[] puzzle_a, byte[] puzzle_b) {
        for (int i = 0; i < puzzle_b.length; i++) {
            puzzle_a[i] = puzzle_b[i];
        }
    }

    /**Method to swap the values during making a move
     * @param pc the puzzle to make the swap
     * @param a the first value for swapping
     * @param b the second value to swap with
     */
    private void swap(byte[] puzzle, int first_val, int sec_val) {
        byte temp = puzzle[first_val];
        puzzle[first_val] = puzzle[sec_val];
        puzzle[sec_val] = temp;
        
    }

    /**Method to make a right move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToRight(byte[] puzzle, int indx) {

        if(indx % col < col - 1) {
            byte[] temp_puz = new byte[9];
            duplicatePuzzle(temp_puz, puzzle);
             
            // swapping positions
            swap(temp_puz, indx+1, indx);

            rpuz = temp_puz;
            return true;
        }
        return false; 

    }

    /**Method to make a left move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */

    public boolean moveToLeft(byte[] puzzle, int indx) {

        if(indx % col > 0) {
            byte[] temp_puz = new byte[9];
            duplicatePuzzle(temp_puz, puzzle);

            swap(temp_puz, indx-1, indx);

            lpuz = temp_puz;

            return true;
        }
        return false; 
    }

    /**Method to make a up move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToUp(byte[] puzzle, int indx) {

        if( indx - col >= 0) {
            byte[] temp_puz = new byte[9];
            duplicatePuzzle(temp_puz, puzzle);

            swap(temp_puz, indx-3, indx);

            upuz = temp_puz;
            return true;
        }
        return false; 
        
    }

    /**Method to make a right move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToDown(byte[] puzzle, int indx) {

        if( indx + col < puzzle.length) {
            byte[] temp_puz = new byte[9];
            
            duplicatePuzzle(temp_puz, puzzle);

            swap(temp_puz, indx+3, indx);

            dpuz = temp_puz;

            return true;
        }
        return false;  
    }

}
