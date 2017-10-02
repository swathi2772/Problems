import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Swathi on 9/19/2017.
 */
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
public class L253 {
    public static int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });

        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end-b.end;
            }
        });

        heap.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval prev = heap.poll();
            if(intervals[i].start>=prev.end){
                prev.end = intervals[i].end;
            }else{
                heap.offer(intervals[i]);
            }
            heap.offer(prev);
        }
        return heap.size();
    }

    public static void main(String[] args){
        Interval one = new Interval(5,10);
        Interval two = new Interval(15,20);
        Interval three = new Interval(0,30);
        int size = minMeetingRooms(new Interval[]{one,two,three});
        System.out.println(size);
    }
}
