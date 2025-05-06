/*
LC207: Course Schedule || https://leetcode.com/problems/course-schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

  For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

  Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 

Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
  // TC => O(c+p) || SC => O(c+p)
  // where c -> number of courses, p -> number of prerequisites
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    // calculate in-degree & store graph points
    for (int[] edge : prerequisites) {
      inDegree[edge[0]]++;
      graph.get(edge[1]).add(edge[0]);
    }

    // store only 0 indegree nodes
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    // check for cycle in graph
    int courseComplete = 0;
    while (!queue.isEmpty()) {
      int source = queue.remove();
      courseComplete++;

      // visited -> decrease indegree by 1 for destination points
      for (int destination : graph.get(source)) {
        inDegree[destination]--;

        // if any detination point have indegree 0 now
        if (inDegree[destination] == 0) {
          queue.add(destination);
        }
      }
    }

    // check if all course are complete or not
    return courseComplete == numCourses;
  }
}

public class Array30_CourseSchedule {
  public static void main(String[] args) {
    CourseSchedule obj = new CourseSchedule();
    int numCourse;
    int[][] prerequisites;


    //example 1
    System.out.println("----- example 1 -----");
    numCourse = 5;
    prerequisites = new int[][] {{2,0},{1,3},{3,4},{2,1},{2,3},{4,1},{3,0},{4,2}};
    System.out.println(obj.canFinish(numCourse, prerequisites));

    //example 2
    System.out.println("----- example 2 -----");
    numCourse = 5;
    prerequisites = new int[][] {{2,0},{1,3},{2,1},{2,3},{4,1},{3,0},{4,2}};
    System.out.println(obj.canFinish(numCourse, prerequisites));

  }
}
