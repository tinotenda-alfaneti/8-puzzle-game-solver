public class ValidateMove {

    private int col = 3;

    int[] rpuz = new int[9];
    int[] lpuz = new int[9];
    int[] dpuz = new int[9];
    int[] upuz = new int[9];

    public void copyPuzzle(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    private void swap(int[] pc, int a, int b) {
        int temp = pc[a];
        pc[a] = pc[b];
        pc[b] = temp;
        
    }

    public boolean moveToRight(int[] p, int i) {

        if(i % col < col - 1) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);
            
            // swapping positions
            swap(pc, i+1, i);

            rpuz = pc;
            return true;
        }
        return false; 

    }

    public boolean moveToLeft(int[] p, int i) {

        if(i % col > 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            swap(pc, i-1, i);

            lpuz = pc;

            return true;
        }
        return false; 
    }

    public boolean moveToUp(int[] p, int i) {

        if( i - col >= 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            swap(pc, i-3, i);

            upuz = pc;
            return true;
        }
        return false; 
        
    }

    public boolean moveToDown(int[] p, int i) {

        if( i + col < p.length) {
            int[] pc = new int[9];
            
            copyPuzzle(pc, p);

            swap(pc, i+3, i);

            dpuz = pc;

            return true;
        }
        return false;  
    }

}
