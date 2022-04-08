
import java.util.List;

public class Game {

    public static void main(String[] args) {

        int[] puzzle = {
            1,2,4,6,5,3,7,8,0
        };

        for (int i = 0; i<args.length; i++) {
            puzzle[i] = Integer.parseInt(args[i]);
        }
        

        Node root = new Node(puzzle);
        UninformedSearch ui = new UninformedSearch();
        List<Node> solution = ui.breadthFirstSearch(root);

        if (solution.size() > 0) {
            for (int i = 0; i < solution.size(); i++) {
                solution.get(i).printPuzzle();
            }
        }
        else {
            System.out.println("No path to solution found");
        }
    }
    
}
