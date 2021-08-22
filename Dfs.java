import java.util.ArrayList;
import java.util.List;

public class Dfs {
    Node root;


    public Dfs(Node root) {
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

            List<Node> children = new ArrayList<>();
            children.addAll(node.successor());
            for (Node child :
                    children) {
                List<Node> parentList = new ArrayList<>();
                parentList = child.path();
                parentList.remove(0);
                if (!child.equal(parentList)) fringe.add(0, child);
            }

        }
        PrintPath.printPath(node.path());

    }

    public Node popFirstElement(List<Node> fringe) {
        Node node = fringe.get(0);
        fringe.remove(node);
        return node;
    }
}


