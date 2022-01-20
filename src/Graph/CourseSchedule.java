package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

    /*
    Approach: Postorder DFS (Depth-First Search)

    Algorithm:
    We could implement the postorder DFS based on the above backtracking algorithm, by simply adding another bitmap
    (i.e. checked[node_index]) which indicates whether we have done the cyclic check starting from a particular node.

    Here are the breakdowns of the algorithm, where the first 2 steps are the same as in the previous backtracking
    algorithm.

    Step 1). We build a graph data structure from the given list of course dependencies.
    Step 2). We then enumerate each node (course) in the constructed graph, to check if we could form a dependency cycle
             starting from the node.
    Step 3.1).We check if the current node has been checked before, otherwise we enumerate through its child nodes
              via backtracking, where we breadcrumb our path (i.e. mark the nodes we visited) to detect if we come across
              a previously visited node (hence a cycle detected). We also remove the breadcrumbs for each iteration.
    Step 3.2). Once we visited all the child nodes (i.e. postorder), we mark the current node as checked.
     */
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // course -> list of next courses
            HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

            // build the graph first
            for (int[] relation : prerequisites) {
                // relation[0] depends on relation[1]
                if (courseDict.containsKey(relation[1])) {
                    courseDict.get(relation[1]).add(relation[0]);
                } else {
                    List<Integer> nextCourses = new LinkedList<>();
                    nextCourses.add(relation[0]);
                    courseDict.put(relation[1], nextCourses);
                }
            }

            boolean[] checked = new boolean[numCourses];
            boolean[] path = new boolean[numCourses];

            for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
                if (this.isCyclic(currCourse, courseDict, checked, path))
                    return false;
            }

            return true;
        }


        /*
         * postorder DFS check that no cycle would be formed starting from currCourse
         */
        protected boolean isCyclic(
                Integer currCourse, HashMap<Integer, List<Integer>> courseDict,
                boolean[] checked, boolean[] path) {

            // bottom cases
            if (checked[currCourse])
                // this node has been checked, no cycle would be formed with this node.
                return false;
            if (path[currCourse])
                // come across a previously visited node, i.e. detect the cycle
                return true;

            // no following courses, no loop.
            if (!courseDict.containsKey(currCourse))
                return false;

            // before backtracking, mark the node in the path
            path[currCourse] = true;

            boolean ret = false;
            // postorder DFS, to visit all its children first.
            for (Integer child : courseDict.get(currCourse)) {
                ret = this.isCyclic(child, courseDict, checked, path);
                if (ret)
                    break;
            }

            // after the visits of children, we come back to process the node itself
            // remove the node from the path
            path[currCourse] = false;

            // Now that we've visited the nodes in the downstream,
            // we complete the check of this node.
            checked[currCourse] = true;
            return ret;
        }
    }
