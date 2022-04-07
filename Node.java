import java.util.LinkedList;
import java.util.List;

public class Node {

    public List<Node> children = new LinkedList<>();
    public Node parent;
    public int[] puzzle = new int[9];
    public int x = 0;
    public int col = 3;
    public int[] goal = new int[9];

    public Node(int[] p) {

        puzzle = p;

    }
    public void setGoal(int[] g) {
        goal = g;
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
    
    public void moveToRight(int[] p, int i) {

        if(i % col < col - 1) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            int temp = pc[i +1];
            pc[i + 1] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;

        }

    }

    public void moveToLeft(int[] p, int i) {

        if(i % col > 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            int temp = pc[i -1];
            pc[i - 1] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;

        }
        
    }

    public void moveToUp(int[] p, int i) {

        if( i - col >= 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            int temp = pc[i - 3];
            pc[i - 3] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
        
    }

    public void moveToDown(int[] p, int i) {

        if( i + col < puzzle.length) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            int temp = pc[i + 3];
            pc[i + 3] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
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

        for(int i = 1; i<puzzle.length; i++ ) {
            if (puzzle[i] != goal[i]) {
                isGoal = false;
                break;
            }
        }
        return isGoal;
    }



}