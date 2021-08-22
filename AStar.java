import java.util.ArrayList;
import java.util.List;

public class AStar {

    Node root;
    int heuristic;

    public AStar(Node root, int heuristic) {
        this.root = root;
        this.heuristic = heuristic;
    }

    public void solvePuzzle() {

        Node node = null;
        List<Node> fringe = new ArrayList<>();
        fringe.add(root);
        List<Node> visitedList = new ArrayList<>();

        while (!fringe.isEmpty()) {
            node = chooseElement(fringe);
            visitedList.add(node);
            if (node.goalTest()) {
                break;
            }

            List<Node> children = new ArrayList<>();
            children.addAll(node.successor());
            for (Node child :
                    children) {
                if (!child.equal(visitedList)) fringe.add(child);
            }

        }
        PrintPath.printPath(node.path());

    }

    public Node chooseElement(List<Node> fringe) {
        int h = 0;
        int min = Integer.MAX_VALUE;
        int f;
        Node selected = null;
        if (heuristic == 0) {
            //MD
            for (Node node :
                    fringe) {
                h = MD.md(node.state);
                f = h + node.depth;
                if (f < min) {
                    min = f;
                    selected = node;
                }
            }

        }

        if (heuristic == 1) {
            //MD+LC
            for (Node node :
                    fringe) {
                h = MD.md(node.state) + LC.lc(node.state);
                f = h + node.depth;
                if (f < min) {
                    min = f;
                    selected = node;
                }
            }

        }

        if (heuristic == 2) {

        }
        fringe.remove(selected);
        return selected;
    }
}




