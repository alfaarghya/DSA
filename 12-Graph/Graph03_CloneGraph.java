/*
LC133: Clone Graph || https://leetcode.com/problems/clone-graph

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

 

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

 

Example 1:

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:

Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.

 

Constraints:

    The number of nodes in the graph is in the range [0, 100].
    1 <= Node.val <= 100
    Node.val is unique for each node.
    There are no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
  int val;
  List<Node> neighbors;

  Node() {
    this.val = 0;
    this.neighbors = new ArrayList<Node>();
  }

  Node(int val) {
    this.val = val;
    this.neighbors = new ArrayList<Node>();
  }

  Node(int val, List<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }
}

class CloneGraph {
  // Time complexity: O(V+E) || Space complexity: O(1)
  public Node cloneGraph(Node node) {
    // corner case
    if (node == null) {
      return null;
    }

    // create visited for marking visited Node
    Node[] visited = new Node[101];
    Arrays.fill(visited, null); // fill up with null

    // create new head of graph
    Node root = new Node(node.val);

    // deep clone
    dfs(node, root, visited);

    // return new head
    return root;
  }

  private void dfs(Node graph, Node curr, Node[] visited) {
    // mark as visited
    visited[curr.val] = curr;

    // loop on current node's neighbours => make clone of them into our graph
    for (Node edge : graph.neighbors) {
      if (visited[edge.val] == null) {
        /* T -> not visited this edge */

        // create new Node for current value
        Node newNode = new Node(edge.val);
        // connect it with cloned graph
        curr.neighbors.add(newNode);

        // visit the newNode
        dfs(edge, newNode, visited);
      } else {
        /* F -> already visited this edge */

        // connect it with our cloned graph
        curr.neighbors.add(visited[edge.val]);
      }
    }
  }
}

public class Graph03_CloneGraph {
  public static void main(String[] args) {
    CloneGraph obj = new CloneGraph();
    Node v1 = new Node(1);
    Node v2 = new Node(2);
    Node v3 = new Node(3);
    Node v4 = new Node(4);
    Node v5 = new Node(5);
    Node v6 = new Node(6);
    Node v7 = new Node(7);
    Node v8 = new Node(8);

    //v1 -> v2,v3
    v1.neighbors.add(v2);
    v1.neighbors.add(v3);

    //v2 -> v1,v4
    v2.neighbors.add(v1);
    v2.neighbors.add(v4);

    //v3 -> v1,v4
    v3.neighbors.add(v1);
    v3.neighbors.add(v4);

    //v4 -> v3,v5,v8
    v4.neighbors.add(v3);
    v4.neighbors.add(v5);
    v4.neighbors.add(v8);

    //v5 -> v4,v6,v8
    v5.neighbors.add(v4);
    v5.neighbors.add(v6);
    v5.neighbors.add(v8);

    //v6 -> v5,v7
    v6.neighbors.add(v5);
    v6.neighbors.add(v7);

    //v7 -> v3,v6
    v7.neighbors.add(v3);
    v7.neighbors.add(v6);

    //v8 -> v4,v5
    v8.neighbors.add(v4);
    v8.neighbors.add(v5);
    
    obj.cloneGraph(v1);

  }
}
