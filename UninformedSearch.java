import java.util.List;
import java.util.LinkedList;

public class UninformedSearch {

    public UninformedSearch() {

    }

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
            Node currNode = openList.get(0);
            closedList.add(currNode);
            openList.remove(0);

            currNode.expandMove();

            if (count%500 == 0) System.out.println("Still Trying...");
            
            for(int i = 0; i<currNode.children.size(); i++) {
                Node currChild = currNode.children.get(i);
                if(currChild.goalTest()) {
                    System.out.println("Goal Found");
                    goalFound = true;
                    pathTrace(pathToSolution, currChild);
                    break;
                }

                if (!Contains(openList, currChild) && !Contains(closedList, currChild))
                    openList.add(currChild);
            }
            count++;
        }


        return pathToSolution;
    }

    public void pathTrace (List<Node> path, Node n) {
        
        int steps = 0;

        System.out.println("Tracing path");

        Node current = n;
        path.add(current);
        while(current.parent != null) {
            current = current.parent;
            path.add(current);
            steps++;
        }
        System.out.println("Moves: " + steps);


    }
    public static boolean Contains(List<Node> list, Node c) {
        boolean contains = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSamePuzzle(c.puzzle)) {

                contains = true;
            }
        }
        return contains;

    }
    
}















