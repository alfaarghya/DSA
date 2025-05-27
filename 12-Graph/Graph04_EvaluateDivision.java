/*
LC399: Evaluate Division || https://leetcode.com/problems/evaluate-division/

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

 

Constraints:

    1 <= equations.length <= 20
    equations[i].length == 2
    1 <= Ai.length, Bi.length <= 5
    values.length == equations.length
    0.0 < values[i] <= 20.0
    1 <= queries.length <= 20
    queries[i].length == 2
    1 <= Cj.length, Dj.length <= 5
    Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class EvaluateDivision {
  // Time Complexity => O(m * (E+V)), m = size of queries, (E+V) = dfs traversal
  // Space Complexity => O(v + g), v = visited size, g = graph size
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
    int n = equations.size(), m = queries.size();

    // create ans array sith size of m
    double[] ans = new double[m];

    for (int i = 0; i < m; i++) {
      String source = queries.get(i).get(0);
      String dest = queries.get(i).get(1);

      if (!graph.containsKey(source) || !graph.containsKey(dest)) {
        // source or dest not present in graph so -> no ans
        ans[i] = -1.0;
      } else {
        // calcualte actual values
        HashSet<String> visited = new HashSet<>();
        double[] val = { -1.0 };
        double temp = 1.0;
        dfs(source, dest, graph, visited, val, temp);
        ans[i] = val[0];
      }
    }

    return ans;
  }

  private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      String source = equations.get(i).get(0);
      String dest = equations.get(i).get(1);
      double cost = values[i];

      // connect source --(cost)--> dest
      graph.putIfAbsent(source, new HashMap<>());
      graph.get(source).put(dest, cost);

      // connect dest --(1/cost)--> source
      graph.putIfAbsent(dest, new HashMap<>());
      graph.get(dest).put(source, 1.0 / cost);
    }

    return graph;
  }

  private void dfs(String source, String dest, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited,
      double[] ans, double temp) {
    // check source is already visited or not
    if (visited.contains(source)) {
      return;
    }

    // mark as visited
    visited.add(source);

    // check if we reach source again
    if (source.equals(dest)) {
      ans[0] = temp;
      return;
    }

    // calculate
    for (Map.Entry<String, Double> entry : graph.get(source).entrySet()) {
      String newSource = entry.getKey();
      double val = entry.getValue();
      dfs(newSource, dest, graph, visited, ans, temp * val);
    }
  }
}

public class Graph04_EvaluateDivision {
  public static void main(String[] args) {
    EvaluateDivision obj = new EvaluateDivision();
    List<List<String>> equations;
    double[] values;
    List<List<String>> queries;

    //example 1
    System.out.println("----- example 1 -----");
    equations = new ArrayList<>(List.of(List.of("a", "b"), List.of("b", "c"), List.of("ab", "d")));
    values = new double[] {2.0, 3.0, 5.0};
    queries = new ArrayList<>(List.of(List.of("c", "a"), List.of("d", "c"), List.of("b", "d"), List.of("c", "b"), List.of("b", "ab")));
    System.out.println(Arrays.toString(obj.calcEquation(equations, values, queries)));

    //example 2
    System.out.println("----- example 2 -----");
    equations = new ArrayList<>(List.of(List.of("a", "b"), List.of("c", "a"), List.of("b", "c"), List.of("b", "d"), List.of("d", "c")));
    values = new double[] {2.0, 3.0, 4.0, 5.0, 6.0};
    queries = new ArrayList<>(List.of(List.of("a", "d"), List.of("x", "a"), List.of("c", "b"), List.of("d", "a")));
    System.out.println(Arrays.toString(obj.calcEquation(equations, values, queries)));

    //example 3
    System.out.println("----- example 3 -----");
    equations = new ArrayList<>(List.of(List.of("a","b"), List.of("b","c"), List.of("bc","cd")));
    values = new double[] {1.5,2.5,5.0};
    queries = new ArrayList<>(List.of(List.of("a","c"), List.of("c","b"), List.of("bc","cd"), List.of("cd","bc")));
    System.out.println(Arrays.toString(obj.calcEquation(equations, values, queries)));

  }
}