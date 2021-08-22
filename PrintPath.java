import java.util.List;

public class PrintPath {
    public  static  void printPath(List<Node> nodeList){
        for (int i = nodeList.size()-1; i >=0 ; i--) {
            for (int j = 0; j < nodeList.get(i).state.length; j++) {
                for (int k = 0; k < nodeList.get(i).state.length; k++) {
                    System.out.print(nodeList.get(i).state[j][k]+", ");


                }

            }
            System.out.println("");
        }
        System.out.println(nodeList.size());
        //System.out.println(nodeList.get(0).cost);
    }
}
