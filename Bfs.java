import java.util.ArrayList;
import java.util.List;

public class Bfs {

    Node root;


    public Bfs(Node root) {
        this.root = root;
    }

    public void solvePuzzle() {

        Node node = null;
        List<Node> fringe = new ArrayList<>();
        fringe.add(root);
        while (!fringe.isEmpty()) {
            node = popFirstElement(fringe);

            if (node.goalTest()) {
                break;
            }

            fringe.addAll(node.successor());

        }
        PrintPath.printPath(node.path());

    }

    public Node popFirstElement(List<Node> fringe) {
        Node node = fringe.get(0);
        fringe.remove(node);
        return node;
    }
}
