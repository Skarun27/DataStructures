package SDESheet.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectCycleUsingDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // course -> list of next courses
        HashMap<Integer, ArrayList<Integer>> courseDict = new HashMap<>();

        for (int[] relation : prerequisites) {
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                ArrayList<Integer> nextCourses = new ArrayList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }

        boolean[] visited = new boolean[numCourses];
        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if(visited[currCourse] == false)
                if (this.isCyclic(currCourse, -1, courseDict, visited))
                    return false;
        }

        return true;
    }

    /*
     * postorder DFS check that no cycle would be formed starting from currCourse
     */
    protected boolean isCyclic(
            Integer currCourse, int parent, HashMap<Integer, ArrayList<Integer>> courseDict, boolean[] visited) {

        visited[currCourse] = true;
        if(!courseDict.containsKey(currCourse)) return false;
        ArrayList<Integer> list = courseDict.get(currCourse);
        for(Integer val: list) {
            if(!visited[val]) {
                if(isCyclic(val, currCourse, courseDict, visited))
                    return true;
            }
            else if(val != parent) {
                return true;
            }
        }
        return false;
    }
}
