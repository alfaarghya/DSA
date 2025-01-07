import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Edge {
  int source;
  int destination;
  int weight;

  Edge(int source, int destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
}

class Graph {

  int vertex;
  ArrayList<Edge>[] graph;

  @SuppressWarnings("unchecked")
  Graph(int vertex) {
    this.vertex = vertex;
    this.graph = new ArrayList[vertex];

    for (int i = 0; i < vertex; i++) {
      this.graph[i] = new ArrayList<>();
    }
  }

  public void add(int source, int destination, int weight) {
    graph[source].add(new Edge(source, destination, weight));
  }

  /*---- Breath First search ----*/
  public List<Integer> BFS() { // TC -> O(V+E)
    List<Integer> ans = new ArrayList<>();
    boolean[] visited = new boolean[vertex];

    for (int i = 0; i < vertex; i++) {
      if (!visited[i]) {
        BFSutil(visited, ans);
      }
    }

    return ans;
  }

  private void BFSutil(boolean[] visited, List<Integer> ans) {
    Queue<Integer> q = new LinkedList<>();
    // step1 => add start point in queue
    q.add(0);
    // step2 => run a loop until queue is empty
    while (!q.isEmpty()) {
      // step3 => remove first value from queue
      int removeVal = q.remove();
      // step4 => check if Node is already visited or not
      if (!visited[removeVal]) {
        // step5 => print the value & mark visited as true
        ans.add(removeVal);
        visited[removeVal] = true;
        // step6 => run a loop on current Node and add all Node value in Queue
        for (int i = 0; i < graph[removeVal].size(); i++) {
          Edge e = graph[removeVal].get(i);
          q.add(e.destination);
        }
      }
    }
  }
  /*---- ----*/

  /*---- Depth First Search ----*/
  public List<Integer> DFS() { // TC -> O(V+E)
    List<Integer> ans = new ArrayList<>();
    boolean[] visited = new boolean[vertex];

    for (int i = 0; i < vertex; i++) {
      if (!visited[i]) {
        DFSutil(i, visited, ans);
      }
    }

    return ans;
  }

  private void DFSutil(int curr, boolean[] visited, List<Integer> ans) {
    // step1 => print the value & mark visited as true
    ans.add(curr);
    visited[curr] = true;
    // step2 => run a loop on current Node and
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      // if next Node is not visited visit that Node
      if (!visited[e.destination]) {
        DFSutil(e.destination, visited, ans);
      }
    }
  }
  /*---- ----*/

}

public class Implement_Graph {
  public static void main(String[] args) {
    Graph graph = new Graph(7);

    graph.add(0, 1, 1);
    graph.add(0, 2, 1);

    graph.add(1, 0, 1);
    graph.add(1, 3, 1);

    graph.add(2, 0, 1);
    graph.add(2, 4, 1);

    graph.add(3, 1, 1);
    graph.add(3, 4, 1);
    graph.add(3, 5, 1);

    graph.add(4, 2, 1);
    graph.add(4, 3, 1);
    graph.add(4, 5, 1);

    graph.add(5, 3, 1);
    graph.add(5, 4, 1);
    graph.add(5, 6, 1);

    graph.add(6, 5, 1);

    System.out.println(graph.BFS());
    System.out.println(graph.DFS());

  }
}