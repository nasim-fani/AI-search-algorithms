import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    int state[][];
    int goal[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    Node parent;
    int depth;
    int cost;


    public Node(int[][] state, Node parent, int depth, int cost) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.cost = cost;

    }


    public List<Node> successor() {
        List<Node> children = new ArrayList<>();
        int index[] = findEmpty();
        int row = index[0];
        int column = index[1];
        int upCost = 2, downCost = 100, rightCost = 100, leftCost = 100;

        if (row != 0) {
            Node child = new
                    Node(swap(row, column, row - 1, column), this, this.depth + 1, this.cost + upCost);
            children.add(child);
        }
        if (row != 3) {
            Node child = new
                    Node(swap(row, column, row + 1, column), this, this.depth + 1, this.cost + downCost);
            children.add(child);
        }
        if (column != 0) {
            Node child = new
                    Node(swap(row, column, row, column - 1), this, this.depth + 1, this.cost + leftCost);
            children.add(child);
        }
        if (column != 3) {
            Node child = new
                    Node(swap(row, column, row, column + 1), this, this.depth + 1, this.cost + rightCost);
            children.add(child);
        }

        return children;


    }


    public boolean equal(List<Node> visited) {
        if (visited.size() == 0) return false;


        boolean flag = true;
        for (Node node :
                visited) {

            if (flag == false) flag = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (node.state[i][j] != this.state[i][j]) {
                        flag = false;
                    }
                }
            }
            if (flag == true) return true;
        }


        return flag;
    }

    public int fringeEqual(List<Node> visited) {
        if (visited.size() == 0) return -1;


        boolean flag = true;
        for (int k = 0; k < visited.size(); k++) {

            if (flag == false) flag = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (visited.get(k).state[i][j] != this.state[i][j]) {
                        flag = false;
                    }
                }
            }
            if (flag) return k;
        }


        return -1;
    }


    public int[][] swap(int emptyRow, int emptyColumn, int destRow, int destColumn) {
        int array1[][] = {{-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array1[i][j] = state[i][j];
            }
        }
        array1[emptyRow][emptyColumn] = array1[destRow][destColumn];
        array1[destRow][destColumn] = 0;
        return array1;
    }

    public int[] findEmpty() {
        int index[] = {-1, -1};
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                if (state[i][j] == 0) {
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }

    public boolean goalTest() {

        for (int i = 0; i < goal.length; i++) {

            if (!Arrays.equals(goal[i], state[i])) {
                return false;
            }
        }
        return true;
    }

    public List<Node> path() {
        List<Node> path = new ArrayList<>();
        Node node = this;
        path.add(node);
        while (node.parent != null) {
            path.add(node.parent);
            node = node.parent;
        }

        return path;
    }

}
