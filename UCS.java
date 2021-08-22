import java.util.ArrayList;
import java.util.List;

public class UCS {
    Node root;

    public UCS(Node root) {
        this.root = root;
    }

    public void solvePuzzle() {
        Node node = null;
        List<Node> fringe = new ArrayList<>();
        fringe.add(root);
        while (!fringe.isEmpty()) {
            node = chooseElement(fringe);
            if (node.goalTest()) {
                break;
            }
            fringe.addAll(node.successor());


        }
        PrintPath.printPath(node.path());
    }

    public Node chooseElement(List<Node> fringe) {
        int min = Integer.MAX_VALUE;
        Node selected = null;
        for (Node node :
                fringe) {
            if (node.cost < min) {
                min = node.cost;
                selected = node;
            }

        }
        fringe.remove(selected);
        return selected;

    }
}
