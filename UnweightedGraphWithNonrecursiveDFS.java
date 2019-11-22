package CH28;

/*
Tree dfs(vertex v) {
    push v into the stack;

    while (the stack is not empty) {
        pop a vertex, say u, from the stack
        visit u;
        mark u visited;
        for each neighbor w of u if (w has not been visited)
        push w into the stack;
    }
 }
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V> {
    public UnweightedGraphWithNonrecursiveDFS(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    /** non-recursive method for DFS search
     * @return*/
    public SearchTree dfs(V v) {
        boolean[] isVisited = new boolean[vertices.size()];
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // Initialize parent[i] to -1
        Stack<V> vertexStack = new Stack<V>();
        List<Integer> searchOrder = new ArrayList<>();
        vertexStack.push(v);
        isVisited[getIndex(v)] = true; // vertex v is on the stack so it is visited


        while(!vertexStack.empty()) {
            V currentlyVisiting = vertexStack.pop();
            searchOrder.add(getIndex(currentlyVisiting));
            for (int neighborIndex : getNeighbors(getIndex(currentlyVisiting))){
                if(!isVisited[neighborIndex]) {
                    parent[neighborIndex] = getIndex(currentlyVisiting);
                    vertexStack.push(getVertex(neighborIndex));
                    isVisited[neighborIndex] = true;
                }
            }
        }
        return new SearchTree(getIndex(v), parent, searchOrder);
    }

}
