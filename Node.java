import java.util.LinkedList;
import java.util.List;

public class Node {

    private List<Node> children = new LinkedList<>();
    private Node parent;
    private int[] puzzle = new int[9];
    private int x = 0;
    private int col = 3;
    private final int[] goal = {1,2,3,4,5,6,7,8,0};

    ValidateMove move = new ValidateMove();


    public Node(int[] p) {

        puzzle = p;

    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public int[] getPuzzle() {
        return puzzle;
    }

    public void expandMove() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) x = i;
        }

        boolean r = move.moveToRight(puzzle, x);
        boolean l = move.moveToLeft(puzzle, x);
        boolean u = move.moveToUp(puzzle, x);
        boolean d = move.moveToDown(puzzle, x);

        if (r) addChild(move.rpuz);
        if (l) addChild(move.lpuz);
        if (u) addChild(move.upuz);
        if (d) addChild(move.dpuz);
    }

    public void addChild(int[] pc) {

        Node child = new Node(pc);
            children.add(child);
            child.parent = this;

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