
import java.util.List;

public class Game {

    public static void main(String[] args) {

        int[] puzzle = {
            1,2,3,4,5,6,7,0,8
        };

        for (int i = 0; i<args.length; i++) {
            puzzle[i] = Integer.parseInt(args[i]);
        }
        

        Node root = new Node(puzzle);
        Search algorithm = new Search();
        List<Node> solution = algorithm.breadthFirstSearch(root);

        if (solution.size() > 0) {
            for (int i = solution.size() - 1; i >= 0 ; i--) {
                solution.get(i).printPuzzle();
            }
        }
        else {
            System.out.println("No path to solution found");
        }
    }
    
}
