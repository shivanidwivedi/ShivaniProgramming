package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author shivanidwivedi on 07/08/20
 * @project JavaProgramming
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B,
 * such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
 * Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i,
 * and it doesn't contain any element twice.
 *
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 *
 * Time Complexity: O(N+E), where N is the number of nodes in the graph, and E is the number of edges.
 * We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.
 *
 * Space Complexity: O(N), the space used to store the color.
 */

//Approach : Graph coloring using DFS

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        //initially all graph are uncolored, so all entries are -1.
        Arrays.fill(color,-1);

        for(int start = 0; start < n; start++){
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            color[start] = 0; // 0 represents some color
            while (!stack.isEmpty()){
                Integer node = stack.pop();
                if (color[node] == -1){
                    for (int adj : graph[node]){
                        if (color[adj] == -1){
                            stack.push(adj);
                            color[adj] = color[node] ^ 1; // color all the adjacent nodes with different color
                        }else if (color[adj] == color[node]){ // if adj nodes color is same, return false.
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
