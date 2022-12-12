import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static final int MAX_N = 100000;
    static ArrayList<Integer> g[] = new ArrayList[MAX_N];
    static boolean[]visited;
    static void init(){
        for(int i = 1 ; i <= MAX_N ; ++i){
            g[i] = new ArrayList<>();
        }
    }
    static void addEgde(int a, int b){
        g[a].add(b);
        g[a].add(b); //Si es no dirigido  
    }
    static void dfs(int node){
        for(int e : g[node]){
            if(!visited[e]){
                dfs(e);
            }
        }
    }
    static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(q.isEmpty()){
            node = q.poll();
            visited[node] = true;
            for( int e : g[node]){
                if(!visited[e]){
                    q.add(e);
                }
            }   
        }
    }
}
