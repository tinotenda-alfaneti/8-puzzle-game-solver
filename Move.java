public class Move {

    int col = 3;

    // to save game states after making a move
    int[] rpuz = new int[9]; // right
    int[] lpuz = new int[9]; // left
    int[] dpuz = new int[9]; // down
    int[] upuz = new int[9]; // up


    /**Method to copy the puzzle in order to make a move 
     * @param a puzzle to copy to
     * @param b puzzle to copy from
    */
    private void duplicatePuzzle(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    /**Method to swap the values during making a move
     * @param pc the puzzle to make the swap
     * @param a the first value for swapping
     * @param b the second value to swap with
     */
    private void swap(int[] pc, int a, int b) {
        int temp = pc[a];
        pc[a] = pc[b];
        pc[b] = temp;
        
    }

    /**Method to make a right move
     * @param p the puzzle to shift the value in
     * @param i the index to make the move/index with zero
     */
    public boolean moveToRight(int[] p, int i) {

        if(i % col < col - 1) {
            int[] pc = new int[9];
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

    public boolean moveToLeft(int[] p, int i) {

        if(i % col > 0) {
            int[] pc = new int[9];
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
    public boolean moveToUp(int[] p, int i) {

        if( i - col >= 0) {
            int[] pc = new int[9];
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
    public boolean moveToDown(int[] p, int i) {

        if( i + col < p.length) {
            int[] pc = new int[9];
            
            duplicatePuzzle(pc, p);

            swap(pc, i+3, i);

            dpuz = pc;

            return true;
        }
        return false;  
    }

}
