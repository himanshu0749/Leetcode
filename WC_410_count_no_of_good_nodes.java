import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int count = 0;
    
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;  // Since there are n-1 edges, there are n nodes
        
        // Build the adjacency list representation of the tree
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // Start DFS from node 0 (root) with parent -1 (no parent)
        dfs(0, -1, adjList);
        
        return count;
    }
    
    private int dfs(int node, int parent, List<List<Integer>> adjList) {
        int subtreeSize = 1;  // Each node itself counts as size 1
        int childSize = -1;   // To check if all child subtrees are of the same size
        boolean isGood = true;
        
        // Traverse all children
        for (int child : adjList.get(node)) {
            if (child != parent) {  // Avoid going back to the parent node
                int size = dfs(child, node, adjList);
                if (childSize == -1) {
                    childSize = size;
                } else if (childSize != size) {
                    isGood = false;  // If any child subtree size differs, mark as not good
                }
                subtreeSize += size;
            }
        }
        
        if (isGood) {
            count++;  // Increment count if the node is good
        }
        
        return subtreeSize;
    }
}
