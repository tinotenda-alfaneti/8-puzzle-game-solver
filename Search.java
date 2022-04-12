import java.util.List;
import java.util.LinkedList;

public class Search {

    public List<Node> breadthFirstSearch(Node root) {

        List<Node> pathToSolution = new LinkedList<>();

        // LinkedList to store the children
        List<Node> openList = new LinkedList<>();
        // LinkedList to store unvisited children
        List<Node> closedList = new LinkedList<>();

        openList.add(root);
        boolean goalFound = false;

        int count = 0;

        while (!openList.isEmpty() && goalFound != true) {
            
            // Queue structure implementation removing the one at the beginning and inserting at the end
            Node currNode = openList.get(0);
            closedList.add(currNode);
            openList.remove(0);

            currNode.expandMove();

            if (count%500 == 0) System.out.println("Still Trying...");
            
            for(int i = 0; i<currNode.getChildren().size(); i++) {
                Node currChild = currNode.getChildren().get(i);

                // checking if goal state is reached
                if(currChild.goalTest()) {
                    System.out.println("Goal Found");
                    goalFound = true;
                    pathTrace(pathToSolution, currChild);
                    break;
                }

                // Adding the unique game state to the queue
                if (!Contains(openList, currChild) && !Contains(closedList, currChild))
                    openList.add(currChild);
            }
            count++;
        }


        return pathToSolution;
    }

    /**Method to trace the solution path and the counting the number of steps
     * @param path the tree with the puzzles
     * @param n the solution found
     */
    public void pathTrace (List<Node> path, Node n) {
        
        int steps = 0;

        System.out.println("Tracing path");

        Node current = n;
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
     * @param c the found game state
     */
    public static boolean Contains(List<Node> list, Node c) {
        boolean contains = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSamePuzzle(c.getPuzzle())) {

                contains = true;
            }
        }
        return contains;

    }
    
}















