package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GetPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph1 = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph1));
        int[][] graph2 = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(graph2));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // list to store paths.
        List<List<Integer>> list = new ArrayList<>();
        // list to store individual path.
        List<Integer> path = new ArrayList<>();
        path.add(0);
        traverse(graph, 0, list, path);
        return list;

    }

    static void traverse(int[][] graph, int node, List<List<Integer>> list, List<Integer> path) {
        if (node == graph.length - 1) {
            // node reached target,store path in result and return.
            list.add(new ArrayList<>(path));
            return;
        }
        for (int neighbor : graph[node]) {
            // traverse for each neighbor of node.Add current node to path first.
            path.add(neighbor);
            // traverse neighbor
            traverse(graph, neighbor, list, path);
            // remove neighbor traversed from path.
            path.remove(path.size() - 1);
        }
    }
}
