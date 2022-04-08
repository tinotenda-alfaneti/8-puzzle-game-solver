import java.util.LinkedList;
import java.util.List;

public class Node {

    public List<Node> children = new LinkedList<>();
    public Node parent;
    public int[] puzzle = new int[9];
    public int x = 0;
    public int col = 3;
    private final int[] goal = {1,2,3,4,5,6,7,8,0};

    public Node(int[] p) {

        puzzle = p;

    }

    public void expandMove() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) x = i;
        }

        moveToRight(puzzle, x);
        moveToLeft(puzzle, x);
        moveToUp(puzzle, x);
        moveToDown(puzzle, x);
    }

    private void addChild(int[] pc) {

        Node child = new Node(pc);
            children.add(child);
            child.parent = this;

    }

    private void swap(int[] pc, int a, int b) {
        int temp = pc[a];
        pc[a] = pc[b];
        pc[b] = temp;
        
    }
    
    public void moveToRight(int[] p, int i) {

        if(i % col < col - 1) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);
            
            // swapping positions
            swap(pc, i+1, i);
            

            addChild(pc);

        }

    }

    public void moveToLeft(int[] p, int i) {

        if(i % col > 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            swap(pc, i-1, i);

            addChild(pc);

        }
        
    }

    public void moveToUp(int[] p, int i) {

        if( i - col >= 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            swap(pc, i-3, i);

            addChild(pc);
        }
        
    }

    public void moveToDown(int[] p, int i) {

        if( i + col < puzzle.length) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            swap(pc, i+3, i);

            addChild(pc);
        }
        
    }

    public void printPuzzle() {
        System.out.println();
        int m = 0;
        
        for (int i = 0; i<col; i++) {
            for (int j = 0; j<col; j++) {
                System.out.print(puzzle[m] + " ");
                m++;
            }
            System.out.println();
        }
    }

    public boolean isSamePuzzle(int[] p) {
        
        boolean samePuzzle = true;
        for(int i = 0; i < p.length; i++) {
            if (puzzle[i] != p[i]) {
                samePuzzle = false;
                break;
            }
        }
        return samePuzzle;
    }

    public void copyPuzzle(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    public boolean goalTest() {
        
        boolean isGoal = true;

        for(int i = 0; i<puzzle.length; i++) {
            if (puzzle[i] != goal[i]) {
                isGoal = false;
                break;
            }
        }
        return isGoal;
    }



}