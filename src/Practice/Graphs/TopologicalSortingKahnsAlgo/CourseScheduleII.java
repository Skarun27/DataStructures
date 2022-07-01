package Practice.Graphs.TopologicalSortingKahnsAlgo;
import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        int[] courseOrder = new int[numCourses];
        int count = 0;
        
        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] preReq : prerequisites) {
            adjList.get(preReq[1]).add(preReq[0]);
            inDegree[preReq[0]]++;
        }
        
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                System.out.println(i);
            }
        }
        
        if(queue.isEmpty()) return new int[0];
        
        while(!queue.isEmpty()) {
            
            int currCourse = queue.poll();
            visited[currCourse] = true;
            courseOrder[count++] = currCourse;
            ArrayList<Integer> list = adjList.get(currCourse);
            if(list.size() > 0) {
                for(int dependentCourse : list) {
                    if(!visited[dependentCourse]) {
                        inDegree[dependentCourse]--;
                        if(inDegree[dependentCourse] == 0)
                            queue.add(dependentCourse);
                    }
                }
            }
        }
        if(count < numCourses) return new int[0];
        return courseOrder;
    }
}