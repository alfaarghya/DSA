/*
LC210: Course Schedule II || https://leetcode.com/problems/course-schedule-ii/


There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

 

Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= numCourses * (numCourses - 1)
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    ai != bi
    All the pairs [ai, bi] are distinct.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseScheduleII {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < numCourses; i++) {
        graph.add(new ArrayList<>());
    }

    //calculate in-degree &  store graph points
    for(int[] edge: prerequisites) {
        inDegree[edge[0]]++;
        graph.get(edge[1]).add(edge[0]);
    }

    //store only 0 indegree nodes
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
        if(inDegree[i] == 0) {
            queue.add(i);
        }
    }


    //check for cycle in graph
    int courseComplete = 0;
    int[] ans = new int[numCourses]; //store the final ans
    int idx = 0; //pointer to track ans
    while(!queue.isEmpty()) {
        int source = queue.remove();
        courseComplete++;
        ans[idx++] = source;

        //visited -> decrease indegree by 1 for destination points
        for(int destination: graph.get(source)) {
            inDegree[destination]--;

            //if any detination point have indegree 0 now
            if(inDegree[destination] == 0) {
                queue.add(destination); 
            }
        }
    }

    //check if all course are complete or not
    return courseComplete == numCourses ? ans : new int[0];
}
}

public class Array39_CourseScheduleII {
  public static void main(String[] args) {
    CourseScheduleII obj = new  CourseScheduleII();
    int numCourse;
    int[][] prerequisites;

    //example 1
    System.out.println("----- example 1 -----");
    numCourse = 5;
    prerequisites = new int[][] {{2,0},{1,3},{3,4},{2,1},{2,3},{4,1},{3,0},{4,2}};
    System.out.println(Arrays.toString(obj.findOrder(numCourse, prerequisites)));

    //example 2
    System.out.println("----- example 2 -----");
    numCourse = 5;
    prerequisites = new int[][] {{2,0},{1,3},{2,1},{2,3},{4,1},{3,0},{4,2}};
    System.out.println(Arrays.toString(obj.findOrder(numCourse, prerequisites)));
  }
}
