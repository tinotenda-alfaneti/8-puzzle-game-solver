import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class Search {

    public List<Node> breadthFirstSearch(Node root) {

        List<Node> shortestPathToSolution = new LinkedList<>();

        // LinkedList to store the children
        List<Node> uncheckedGameStates = new LinkedList<>();
        // LinkedList to store unvisited children
        List<Node> checkedGameStates = new LinkedList<>();

        uncheckedGameStates.add(root);
        boolean goalStateFound = false;

        int count = 0;

        while (!uncheckedGameStates.isEmpty() && goalStateFound != true) {
            
            // Queue structure implementation removing the one at the beginning and inserting at the end
            Node currentGameState = uncheckedGameStates.get(0);
            checkedGameStates.add(currentGameState);
            uncheckedGameStates.remove(0);

            currentGameState.expandGameState();

            if (count%500 == 0) System.out.println("Still Trying...");
            
            for(int i = 0; i<currentGameState.getChildren().size(); i++) {
                Node currentGameStateChild = currentGameState.getChildren().get(i);

                // checking if goal state is reached
                if(currentGameStateChild.goalStateTest()) {
                    System.out.println("Goal Found");
                    goalStateFound = true;
                    tracingPath(shortestPathToSolution, currentGameStateChild);
                    break;
                }

                // Adding the unique game state to the queue
                if (!WasStateSeenBefore(uncheckedGameStates, currentGameStateChild) && !WasStateSeenBefore(checkedGameStates, currentGameStateChild))
                    uncheckedGameStates.add(currentGameStateChild);
            }
            count++;
        }


        return shortestPathToSolution;
    }

    ///Solve the game with DFS (Very very very inefficient)
    //this method uses a stack to simulate the recursion
    public List<Node> depthFirstSearch(Node root){
        List<Node> PathToSolution = new LinkedList<>();

        // Stack to store the children
        Stack<Node> uncheckedGameStates = new Stack<>();
        // Stack to store unvisited children
        Stack<Node> checkedGameStates = new Stack<>();

        uncheckedGameStates.push(root);
        boolean goalStateFound = false;

        int count = 0;

        while (!uncheckedGameStates.isEmpty() && goalStateFound != true) {
            
            //Stack structure implementation removing the one at the beginning and inserting at the end
            Node currentGameState = uncheckedGameStates.pop();
            checkedGameStates.push(currentGameState);

            currentGameState.expandGameState();

            if (count%500 == 0) System.out.println("Still Trying...");
            
            for(int i = 0; i<currentGameState.getChildren().size(); i++) {
                Node currentGameStateChild = currentGameState.getChildren().get(i);

                // checking if goal state is reached
                if(currentGameStateChild.goalStateTest()) {
                    System.out.println("Goal Found");
                    goalStateFound = true;
                    tracingPath(PathToSolution, currentGameStateChild);
                    break;
                }

                // Adding the unique game state to the queue
                if (!WasStateSeenBefore(uncheckedGameStates, currentGameStateChild) && !WasStateSeenBefore(checkedGameStates, currentGameStateChild))
                    uncheckedGameStates.add(currentGameStateChild);
            }
            count++;
        }


        return PathToSolution;
    }

    /**Method to trace the solution path and the counting the number of steps
     * @param path the tree with the puzzles
     * @param sol the solution found
     */
    private void tracingPath (List<Node> path, Node sol) {
        
        int steps = 0;

        System.out.println("Finding shortest path");

        Node current = sol;

        path.add(current);

        while(current.getParent() != null) {
            current = current.getParent();
            path.add(current);
            steps++;
        }
        System.out.println("Moves: " + steps);


    }
    
    /**Method to check if the tree contains the game state that was found
     * @param list the tree of the game states
     * @param chil the found game state
     */
    private boolean WasStateSeenBefore(List<Node> list, Node chil) {
        boolean contains = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSamePuzzle(chil.getPuzzle())) {

                contains = true;
            }
        }
        return contains;

    }
    
}















