// all pairs shortest path
class FloydWarshall {
    public int[][] allPairsShortestPath(int[][] graph) {
        for(int k = 0, i, j; k < graph.length; k++)
            for(i = 0; i < graph.length; i++)
                for(j = 0; j < graph.length; j++)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    
        return graph;
    }
    
    public boolean negativeWeightCycle(int[][] graph) {
        graph = allPairsShortestPath(graph);
        return negativeSelfPaths(graph);
    }
    
    public boolean negativeSelfPaths(int[][] graph) {
        for(int i = 0; i < graph.length; i++) 
            if(graph[i][i] < 0)
                return true;
        return false;
    }
}