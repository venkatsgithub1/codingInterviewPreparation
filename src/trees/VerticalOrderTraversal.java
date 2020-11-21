package trees;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = createData();
        System.out.print("[");
        for (List<Integer> list : verticalTraversal(root)) {
            System.out.print(list);
        }
        System.out.println("]");
    }

    private static TreeNode createData() {

        TreeNode leftLeaf = new TreeNode(15);
        TreeNode r8Leaf = new TreeNode(7);

        TreeNode root1Left = new TreeNode(9);
        TreeNode root1Right = new TreeNode(20, leftLeaf, r8Leaf);

        return new TreeNode(3, root1Left, root1Right);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // list to store results.
        List<List<Integer>> list = new ArrayList<>();
        // if root node is null, return empty list.
        if (root == null) {
            return list;
        }
        // queue to store nodes for level order traversal.
        Queue<TreeNodeWithDist> queue = new LinkedList<>();
        // treemap to store lists of nodes by distance.
        TreeMap<Integer, List<TreeNodeWithDist>> map = new TreeMap<>();
        // get root node.
        TreeNodeWithDist rootNode = new TreeNodeWithDist(root);
        // store in queue.
        queue.add(rootNode);
        List<TreeNodeWithDist> listroot = new ArrayList<>();
        listroot.add(rootNode);
        // place it in map with 0 distance.
        map.put(0, listroot);

        // iterate till queue is empty.
        while (!queue.isEmpty()) {
            // poll first node of queue
            TreeNodeWithDist node = queue.poll();
            // store level.
            int level = node.level + 1;
            // process left.
            if (node.node.left != null) {
                // distance of left = parent's dist - 1.
                int distance = node.distance - 1;
                TreeNodeWithDist nodex = new TreeNodeWithDist(node.node.left, distance, level);
                if (map.containsKey(distance)) {
                    map.get(distance).add(nodex);

                } else {
                    List<TreeNodeWithDist> tempList = new ArrayList<>();
                    tempList.add(nodex);
                    map.put(distance, tempList);
                }
                queue.add(nodex);
            }

            // process right.
            if (node.node.right != null) {
                // distance of right = parent's distance+1.
                int distance = node.distance + 1;
                TreeNodeWithDist nodex = new TreeNodeWithDist(node.node.right, distance, level);
                if (map.containsKey(distance)) {
                    map.get(distance).add(nodex);

                } else {
                    List<TreeNodeWithDist> tempList = new ArrayList<>();
                    tempList.add(nodex);
                    map.put(distance, tempList);
                }
                queue.add(nodex);
            }
        }

        for (Integer temp : map.keySet()) {
            // get list of nodes.
            List<TreeNodeWithDist> listx = map.get(temp);
            // sort them by level, if level is same sort them by values.
            listx.sort((nodex1, nodex2) -> {
                int sub = nodex1.level - nodex2.level;
                if (sub == 0) {
                    return nodex1.node.val - nodex2.node.val;
                }
                return sub;
            });

            List<Integer> t = new ArrayList<>();

            for (TreeNodeWithDist treeNodeWithDist : listx) {
                t.add(treeNodeWithDist.node.val);
            }

            list.add(t);
        }
        return list;
    }
}

class TreeNodeWithDist {
    TreeNodeWithDist(TreeNode node) {
        this.node = node;
    }

    TreeNodeWithDist(TreeNode node, int distance, int level) {
        this.node = node;
        this.distance = distance;
        this.level = level;
    }

    TreeNode node;
    int distance;
    int level;
}
