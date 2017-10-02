import java.util.*;

/**
 * Created by Swathi on 8/30/2017.
 */
class Folder{
    int id;
    boolean confidential;
    Set<Integer> cows = new HashSet<>();
    List<Folder> children = new ArrayList<>();
}
public class Dropbox {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_cows=sc.nextInt();
        int num_shared = sc.nextInt();
        int num_conf = sc.nextInt();
        List<Folder> folders = new ArrayList<>();
        Map<Integer,Folder> id_folder_map = new HashMap<>();
        List<Integer> cows = new ArrayList<>();
        for(int i=0;i<num_cows;i++){
            cows.add(i);
        }
        for(int i=1;i<=num_shared;i++){
            Folder f = new Folder();
            f.id = sc.nextInt();
            f.confidential = false;
            folders.add(f);
            id_folder_map.put(f.id,f);
            int n = sc.nextInt();
            for(int j=1;j<=n;j++){
                f.cows.add(sc.nextInt());
            }
        }
        for(int i=1;i<=num_conf;i++){
            Folder f = new Folder();
            f.id = sc.nextInt();
            f.confidential = true;
            folders.add(f);
            id_folder_map.put(f.id,f);
            int n = sc.nextInt();
            for(int j=1;j<=n;j++){
                f.cows.add(sc.nextInt());
            }
        }
        int next_num = sc.nextInt();
        for(int i=0;i<next_num;i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            Folder p = id_folder_map.get(parent);
            Folder c = id_folder_map.get(child);
            p.children.add(c);
            if(!c.confidential){
                c.cows.addAll(p.cows);
            }
        }
        sc.close();
        List<Integer> res = new ArrayList<>();
        for(Folder f:folders){
            if(f.children.size()==0){
                for(int i:cows){
                    if(!f.cows.contains(i)){
                        res.add(i);
                    }
                }
            }
        }
        for(Integer i : res){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
