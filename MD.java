public class MD {
    public static int md(int state[][]){
        int value = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                if(state[i][j]!=0)
                value += Math.abs(i-((state[i][j]-1)/4)) + Math.abs(j-((state[i][j]-1)%4));
            }
        }
        return value;
    }
}
