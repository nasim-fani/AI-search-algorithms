import java.util.ArrayList;
import java.util.List;

public class Bds {
    int goalState[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    Node root;
    Node goal = new Node(goalState, null, 0, 0);

    public Bds(Node root) {

        this.root = root;
    }

    public int solvePuzzle() {

        Node nodeRoot = null;
        Node nodeGoal = null;
        Node node = null;

        List<Node> fringeRoot = new ArrayList<>();
        List<Node> fringeGoal = new ArrayList<>();
        List<Node> path = new ArrayList<>();
        List<Node> pathRoot = new ArrayList<>();
        List<Node> pathGoal = new ArrayList<>();
        fringeRoot.add(root);
        fringeGoal.add(goal);


        while (!fringeRoot.isEmpty() || !fringeGoal.isEmpty()) {

            if (!fringeRoot.isEmpty()) {
                nodeRoot = popFirstElement(fringeRoot);
                if (nodeRoot.fringeEqual(fringeGoal) != -1) {
                    node = fringeGoal.get(nodeRoot.fringeEqual(fringeGoal));
                    pathRoot = nodeRoot.path();
                    pathGoal = node.path();
                    for (int i = pathRoot.size() - 1; i >= 0; i--) {
                        path.add(pathRoot.get(i));
                    }
                    pathGoal.remove(0);
                    path.addAll(pathGoal);
                    /////////////////////////
                    printPath(path);
                    return 0;

                }
                fringeRoot.addAll(nodeRoot.successor());
            }

            if (!fringeGoal.isEmpty()) {
                nodeGoal = popFirstElement(fringeGoal);
                if (nodeGoal.fringeEqual(fringeRoot) != -1) {
                    node = fringeRoot.get(nodeGoal.fringeEqual(fringeRoot));
                    pathGoal = nodeGoal.path();
                    pathRoot = node.path();
                    for (int i = pathGoal.size() - 1; i >= 0; i--) {
                        path.add(pathGoal.get(i));
                    }
                    pathRoot.remove(0);
                    path.addAll(pathRoot);
                    ////////////////////////////
                    printPath(path);
                    return 0;
                }
                fringeGoal.addAll(nodeGoal.successor());
            }

        }

        printPath(path);
        return 0;
    }

    public Node popFirstElement(List<Node> fringe) {
        Node node = fringe.get(0);
        fringe.remove(node);
        return node;
    }

    public static void printPath(List<Node> nodeList) {
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = 0; j < nodeList.get(i).state.length; j++) {
                for (int k = 0; k < nodeList.get(i).state.length; k++) {
                    System.out.print(nodeList.get(i).state[j][k] + ", ");
                }

            }
            System.out.println("");
        }
        System.out.println(nodeList.size());

    }
}
