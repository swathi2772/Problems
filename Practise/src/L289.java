/**
 * Created by Swathi on 9/19/2017.
 */
public class L289 {
    public static void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int lives = countLiveNeighbours(i,j,board);
                if((board[i][j]&1)==1 && (lives==2||lives==3)){
                    board[i][j]=3;
                }else if((board[i][j]&1)==0 && lives==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]>>=1;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.println(board[i][j]);
            }
        }

    }
    public static int countLiveNeighbours(int i,int j, int[][] board){
        int count = 0;
        for(int m = i-1;m<=i+1;m++){
            for(int n = j-1;n<=j+1;n++){
                if((m==i&&n==j)||(m<0||m>=board.length)||(n<0||n>=board[0].length)){
                    continue;
                }
                if((board[m][n]&1)==1) count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        gameOfLife(new int[][]{{1,1},{1,0}});
    }
}
