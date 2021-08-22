import java.util.List;


public class Main {
    public static void main(String[] args) {
//        int rootState[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
//        int rootState[][] = {{1, 2, 3, 4}, {5, 0, 6, 7}, {9, 10, 11, 8}, {13, 14, 15, 12}};
//        int rootState[][] = {{1, 3, 2, 4}, {13, 6, 7, 8}, {9, 10, 11, 12}, {5, 14, 15, 0}};
//        int rootState[][] = {{6, 5, 1, 9}, {12, 0, 2, 10}, {8, 11, 13, 15}, {4, 3, 7, 14}};
//        int rootState[][] = {{2, 3, 4, 0}, {1, 5, 6, 7}, {9, 10, 11, 8}, {13, 14, 15, 12}};
//        int rootState[][] = {{1, 10, 6, 2}, {0, 5, 11, 3}, {9, 14, 7, 4}, {13, 12, 15, 8}};
//        int rootState[][] = {{5, 1, 2, 4}, {9, 6, 3, 7}, {11, 8, 12, 15}, {10, 0, 13, 14}};
//        int rootState[][] = {{5, 6, 1, 4}, {7, 2, 3, 8}, {13, 9, 11, 12}, {0, 10, 14, 15}};


        int rootState[][] = ReadMatrix.readMatrixByUser();
        Node root = new Node(rootState, null, 0, 0);

//        Bfs bfs = new Bfs(root);
//        bfs.solvePuzzle();

//        Dfs dfs = new Dfs(root);
//        dfs.solvePuzzle();
//
        Bds bds = new Bds(root);
        bds.solvePuzzle();
//
//        AStar astar = new AStar(root,0);
//        astar.solvePuzzle();
//
//        IDAStar idaStar = new IDAStar(root, 1);
//        idaStar.solvePuzzle();
//
//        UCS ucs = new UCS(root);
//        ucs.solvePuzzle();


        //System.out.println(MD.md(rootState));
        //System.out.println(LC.lc(rootState));

    }
}
