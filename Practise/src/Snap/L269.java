package Snap;

import java.util.*;

/**
 * Created by Swathi on 9/23/2017.
 */
public class L269 {

    public static String alienOrder(String[] words) {
        Map<Character, Boolean> visited = new HashMap<>();
        Map<Character, Character> map = new HashMap<>();
        for(String word:words){
            for(char ch : word.toCharArray()){
                visited.put(ch,false);
            }
        }
        for(int i=0;i<words.length-1;i++){
            String a = words[i];
            String b = words[i+1];
            int len = Math.min(a.length(),b.length());
            for(int j=0;j<len;j++){
                if(a.charAt(j)!=b.charAt(j)){
                    map.put(a.charAt(j),b.charAt(j));
                    break;
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        for(char c:visited.keySet()){
            if(!visited.get(c)){
                topologicalSort(c,visited,map,stack);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static void topologicalSort(char c, Map<Character, Boolean> visited, Map<Character, Character> map, Stack<Character> stack) {
        visited.put(c,true);
        if(map.containsKey(c)&&!visited.get(map.get(c))){
            topologicalSort(map.get(c),visited,map,stack);
        }
        stack.push(c);
    }

    public static void main(String[] args){
        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
}
