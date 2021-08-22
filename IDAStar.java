import java.util.ArrayList;
import java.util.List;

public class IDAStar {
    Node root;
    int heuristic;
    int nextCutOff;

    public IDAStar(Node root, int heuristic) {
        this.root = root;
        this.heuristic = heuristic;
    }

    public void solvePuzzle() {
        int cutOff=0;

        Node node = null;
        List<Node> fringe = new ArrayList<>();
        if(heuristic==0){
        cutOff = MD.md(root.state);}
        if(heuristic==1){
            cutOff= MD.md(root.state)+LC.lc(root.state);
        }
        fringe.add(root);
        List<Node> visitedList = new ArrayList<>();
        nextCutOff = Integer.MAX_VALUE;
        while (!fringe.isEmpty()) {
            node = chooseElement(fringe,cutOff);
            if(node==null){
                cutOff=nextCutOff;
                node=root;
                fringe.removeAll(fringe);
                fringe.add(node);
                visitedList.removeAll(visitedList);
                continue;
            }

            visitedList.add(node);
            if (node.goalTest()) {
                break;
            }

            List<Node> children = new ArrayList<>();
            children.addAll(node.successor());
            for (Node child :
                    children) {
                if (!child.equal(visitedList)) fringe.add( child);
            }

        }
        PrintPath.printPath(node.path());

    }

    public Node chooseElement(List<Node> fringe,int cutOff) {
        int h = 0;
        int f;
        Node selected = null;
        if (heuristic == 0) {
            //MD
            for (Node node :
                    fringe) {
                h = MD.md(node.state);
                f = h + node.depth;
                if (f<= cutOff) {

                    selected = node;
                    break;
                }
                else{
                    if(f<nextCutOff){
                        nextCutOff =f;
                    }
                }
            }

        }

        if (heuristic == 1) {
            //MD+LC
            for (Node node :
                    fringe) {
                h = MD.md(node.state)+LC.lc(node.state);
                f = h + node.depth;
                if (f <= cutOff) {

                    selected = node;
                    break;
                }
                else{
                    if(f<nextCutOff){
                        nextCutOff =f;
                    }
                }
            }

        }

        if (heuristic == 2) {

        }
        fringe.remove(selected);
        return selected;
    }
}
