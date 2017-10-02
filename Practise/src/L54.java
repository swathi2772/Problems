import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swathi on 9/30/2017.
 */
public class L54 {
    public static void main(String[] args){
        List<Integer> res = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(int i : res){
            System.out.println(i);
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return res;
        }
        int imin = 0;
        int imax = matrix.length-1;
        int jmin = 0;
        int jmax = matrix[0].length-1;
        int size = matrix.length*matrix[0].length;
        while(res.size()<size){
            for(int j = jmin;j<=jmax;j++){
                res.add(matrix[imin][j]);
            }
            imin++;
            for(int i = imin;i<=imax;i++){
                res.add(matrix[i][jmax]);
            }
            jmax--;
            for(int j = jmax;j>=jmin;j--){
                res.add(matrix[imax][j]);
            }
            imax--;
            for(int i = imax;i>=imin;i--){
                res.add(matrix[i][jmin]);
            }
            jmin++;
        }
        return res;
    }
}
