import java.util.List;

public class Game {

    public static void main(String[] args) {
        int[] puzzle = {
            1,2,3,
            4,5,6,
            8,7,0
        };
        
        int[] goal = {1,2,3,4,5,6,7,8,0};

        Node root = new Node(puzzle);
        root.setGoal(goal);
        UninformedSearch ui = new UninformedSearch();
        List<Node> solution = ui.breadthFirstSearch(root);

        if (solution.size() > 0) {
            System.out.println("Testing");
            for (int i = 0; i < solution.size(); i++) {
                solution.get(i).printPuzzle();
            }
        }
        else {
            System.out.println("No path to solution found");
        }
    }
    
}
