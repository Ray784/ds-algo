package com.java.dsa.graphs;

// max flow
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    public int maxFlow(int[] src, int[] tgt, int[][] graph) {
        int[][] dummyGraph = new int[graph.length + 2][graph.length + 2];
        for(int i = 0; i < graph.length; i++)
            for(int j = 0; j < graph.length; j++)
                dummyGraph[i + 1][j + 1] = graph[i][j];

        for(int i = 0; i < src.length; i++)
            dummyGraph[0][src[i] + 1] = getOutPaths(graph, src[i]);
        
        int dest = graph.length + 1;
        for(int i = 0; i < tgt.length; i++)
            dummyGraph[tgt[i] + 1][dest] = getOutPaths(graph, tgt[i]);

        return maxFlow(0, dest, graph);
    }

    private int getOutPaths(int[][] graph, int src) {
        int outPaths = 0;
        for(int i = 0; i < graph.length; i++)
            outPaths += graph[src][i];
        return outPaths;
    }

    public int maxFlow(int src, int tgt, int[][] graph) {
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);
        int maxFlow = 0;

        while(pathToTargetExists(src, tgt, graph, parent)){
            int pathFlow = Integer.MAX_VALUE;
            for(int v = tgt, u; v != src; v = parent[v]){
                u = parent[v];
                pathFlow = Math.min(pathFlow, graph[u][v]);
            }
            maxFlow += pathFlow;

            // reverse paths so that they aren't traversed again
            for(int v = tgt, u; v != src; v = parent[v]){
                u = parent[v];
                graph[u][v] -= pathFlow;
                graph[v][u] += pathFlow;
            }
        }
        return maxFlow;
    }

    private boolean pathToTargetExists(int src, int tgt, int[][] graph, int[] parent) {
        boolean[] visited = new boolean[graph.length];
        int u; 
        int v;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        parent[src] = -1;

        while(!q.isEmpty()){
            u = q.poll();
            if(! visited[u]) {
                visited[u] = true;
                for(v = 0; v < graph.length; v++){
                    if(!visited[v] && graph[u][v] > 0){
                        q.add(v);
                        parent[v] = u;
                        if(v == tgt) return true;
                    }
                }
            }
        }
        return false;
    }
}