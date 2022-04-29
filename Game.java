
import java.util.List;

public class Game {


    /**The method checks if the game state provided can be solved
     * @param puzzle the game state to be solve */
    public static boolean isGameSolvable(byte[] puzzle){
        int inversion = 0; // A pair of tiles form an inversion if the values on tiles are in reverse order of their appearance in goal state. 
        for(int i = 0 ; i < puzzle.length ; i++){
            if(puzzle[i] == 0) continue;
            for(int j = i+1 ; j < puzzle.length ; j++){
                if(puzzle[j] != 0 && puzzle[i] > puzzle[j]) inversion++;
            }
        }
        return (inversion % 2 == 0);
    }

    public static void main(String[] args) {

        byte[] puzzle = {
            1,2,3,4,5,6,7,0,8
        };

        for (int i = 0; i<args.length; i++) {
            puzzle[i] = (byte) Integer.parseInt(args[i]);
        }
        
        if (isGameSolvable(puzzle)) {
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

        } else {
            System.out.println("Sorry, the game state provided cannot be solved");
        }
        
    }
    
}
