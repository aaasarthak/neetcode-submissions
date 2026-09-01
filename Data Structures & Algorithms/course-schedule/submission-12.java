class Solution {
    Map<Integer, Boolean> cachedResults = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> coursesCanBeCompleted = new HashSet<>();

        for(int i=0; i<adjacencyList.size(); i++) {
            for(int j=0; j<adjacencyList.get(i).size(); j++) {
                if(!dfs(adjacencyList, adjacencyList.get(i).get(j), new HashSet<Integer>(List.of(i)), coursesCanBeCompleted)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjacencyList, int courseToBeChecked, Set<Integer> alreadyVisited, Set<Integer> coursesCanBeCompleted) {
        if(coursesCanBeCompleted.contains(courseToBeChecked)) return true;

        for(int i=0; i<adjacencyList.get(courseToBeChecked).size(); i++) {
            if(alreadyVisited.contains(adjacencyList.get(courseToBeChecked).get(i))) {
                return false;
            }
            Set<Integer> newAlreadyVisited = new HashSet<>(alreadyVisited);
            newAlreadyVisited.add(courseToBeChecked);
            if(!dfs(adjacencyList, adjacencyList.get(courseToBeChecked).get(i), newAlreadyVisited, coursesCanBeCompleted)) {
                return false;
            }
        }

        coursesCanBeCompleted.add(courseToBeChecked);
        return true;
    }
}
