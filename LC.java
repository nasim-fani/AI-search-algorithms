public class LC {
    public static int lc(int state[][]){
        int value = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                if(state[i][j]!=0){
                    if((state[i][j]-1)/4==i){
                        int row =i;
                        int column = j;
                        while(column<3) {
                            if (state[row][column + 1] != 0) {
                                if ((state[row][column + 1] - 1) / 4 == row) {
                                    if (state[row][column + 1] < state[i][j])
                                        value++;
                                }

                            }
                            column++;
                        }
                    }
                    if((state[i][j]-1)%4==j){
                        int row =i;
                        int column = j;
                        while(row<3) {
                            if (state[row+1][column] != 0) {
                                if ((state[row + 1][column] - 1) % 4 == column) {
                                    if (state[row + 1][column] < state[i][j])
                                        value++;
                                }

                            }
                            row++;
                        }
                    }
                }

                else{

                }
            }
        }
        return 2*value;
    }
}
