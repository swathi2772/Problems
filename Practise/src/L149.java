import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Swathi on 8/21/2017.
 */
class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
public class L149 {
    public static void main(String[] args){
        System.out.println(maxPoints(new Point[]{
                new Point(4,0),new Point(4,1),new Point(4,-1)
        }));
    }

    public static int maxPoints(Point[] points) {
        if(points.length<2){
            return points.length;
        }
        Map<Double,Set<Point>> slopes = new HashMap<>();
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                double slope = 1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x);
                if(slope==-0.0){
                    slope = 0;
                }else if(slope==Double.NEGATIVE_INFINITY){
                    slope = Double.POSITIVE_INFINITY;
                }
                if(slopes.containsKey(slope)){
                    Set<Point> set = slopes.get(slope);
                    set.add(points[j]);
                }else{
                    Set<Point> set = new HashSet<>();
                    set.add(points[i]);
                    set.add(points[j]);
                    slopes.put(slope,set);
                }
            }
        }
        int max = 0;
        for(Set<Point> set: slopes.values()){
            max= Math.max(max,set.size());
        }
        return max;

    }
}
