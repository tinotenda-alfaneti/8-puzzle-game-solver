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
    private void duplicatePuzzle(byte[] a, byte[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    /**Method to swap the values during making a move
     * @param pc the puzzle to make the swap
     * @param a the first value for swapping
     * @param b the second value to swap with
     */
    private void swap(byte[] pc, int a, int b) {
        byte temp = pc[a];
        pc[a] = pc[b];
        pc[b] = temp;
        
    }

    /**Method to make a right move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToRight(byte[] p, int i) {

        if(i % col < col - 1) {
            byte[] pc = new byte[9];
            duplicatePuzzle(pc, p);
             
            // swapping positions
            swap(pc, i+1, i);

            rpuz = pc;
            return true;
        }
        return false; 

    }

    /**Method to make a left move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */

    public boolean moveToLeft(byte[] p, int i) {

        if(i % col > 0) {
            byte[] pc = new byte[9];
            duplicatePuzzle(pc, p);

            swap(pc, i-1, i);

            lpuz = pc;

            return true;
        }
        return false; 
    }

    /**Method to make a up move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToUp(byte[] p, int i) {

        if( i - col >= 0) {
            byte[] pc = new byte[9];
            duplicatePuzzle(pc, p);

            swap(pc, i-3, i);

            upuz = pc;
            return true;
        }
        return false; 
        
    }

    /**Method to make a right move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToDown(byte[] p, int i) {

        if( i + col < p.length) {
            byte[] pc = new byte[9];
            
            duplicatePuzzle(pc, p);

            swap(pc, i+3, i);

            dpuz = pc;

            return true;
        }
        return false;  
    }

}
