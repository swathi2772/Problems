import java.util.HashMap;
import java.util.Map;

/**
 * Created by Swathi on 8/21/2017.
 */

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class L138 {
    public static void main(String[] args){
        RandomListNode n1 = new RandomListNode(5);
        n1.next = new RandomListNode(8);
        n1.next.next = new RandomListNode(2);
        n1.next.next.next = new RandomListNode(1);
        RandomListNode copy = copyRandomList(n1);
        System.out.println(copy);
    }
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode orig = head;
        Map<Integer,RandomListNode> map = new HashMap<>();
        RandomListNode copy=new RandomListNode(0);
        RandomListNode tmp = copy;
        while(orig!=null){
            tmp.next = new RandomListNode(orig.label);
            tmp = tmp.next;
            map.put(tmp.label,tmp);
            orig = orig.next;
        }
        orig = head;
        tmp = copy.next;
        while(orig!=null){
            RandomListNode node = map.get(orig.label);
            tmp.random = node;
            orig = orig.next;
            tmp=tmp.next;
        }
        return copy.next;

    }
}
