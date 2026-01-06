class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree =new int[numCourses];
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]p : prerequisites){
            int course =p[0];
            int prereq =p[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i= 0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int finishedCount = 0;
        while(!queue.isEmpty()){
            int current =queue.poll();
            finishedCount++;
            for(int nextCourse : adj.get(current)){
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0){
                    queue.offer(nextCourse);
                }
            }

        }
        return finishedCount==numCourses;
    }
}