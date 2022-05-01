import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Node extends Move {

    private List<Node> children = new LinkedList<>();
    private Node parent;
    private byte[] puzzle = new byte[9];
    int emptyPos = 0;
    private final byte[] goal = {1,2,3,4,5,6,7,8,0};

    //Move move = new Move();


    public Node(byte[] p) {

        puzzle = p;

    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public byte[] getPuzzle() {
        return puzzle;
    }

    /**Method for eemptyPosanding the board, creating the subboards from the current state */
    public void expandGameState() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) emptyPos = i;
        }
        boolean right = moveToRight(puzzle, emptyPos);
        boolean left = moveToLeft(puzzle, emptyPos);
        boolean up = moveToUp(puzzle, emptyPos);
        boolean down = moveToDown(puzzle, emptyPos);

        if (right) addChild(rpuz); // right moved puzzle
        if (left) addChild(lpuz); // left moved puzzle
        if (up) addChild(upuz); // up moved puzzle
        if (down) addChild(dpuz); // down moved puzzle
    }

    /**Method for adding a board ot the tree
     * @param pc The game state after a move
    */
    private void addChild(byte[] pc) {

        Node child = new Node(pc);
        children.add(child);
        child.parent = this;

    }

    /**Method for printing the current puzzle state */
    public void printPuzzle() {
        System.out.println();
        int m = 0;
        int col = 3;
        
        System.out.println("-----------------");
        for (int i = 0; i<col; i++) {
            System.out.println(" ___________");
            for (int j = 0; j<col; j++) {
                if (j == 0) System.out.print("| ");
                System.out.print(puzzle[m] + " | ");
                m++;
            }
            
            System.out.println();
        }
        System.out.println(" ____________");
        System.out.println("\n-----------------\n");
    }

    /**Method for checking the if the puzzle or the game state is the same as the current to avoid repetition
     * @return if the puzzle is the same or different
     */
    public boolean isSamePuzzle(byte[] p) {

        return Arrays.equals(puzzle, goal);

    }

    /**Method to check if the given puzzle state has been reached
     * @return True if found and false otherwise
     */
    public boolean goalStateTest() {
        
        return Arrays.equals(puzzle, goal);

    }
}