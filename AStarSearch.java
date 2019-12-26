import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AStarSearch implements GraphSearchAlgorithm {
    public Path search(State start, State goal) {

        PathPriorityQueue queue = new PathPriorityQueue();
        HashSet<State> frontier = new HashSet<State>();
        Path startPath = new Path(start);
        queue.add(startPath, totalCost(startPath, goal));
        while(!queue.isEmpty()) {
            Path currentPath = queue.poll();
            if(goal.equals(currentPath.getLastState())) {
                return currentPath;
            }
            frontier.add(currentPath.getLastState());
            List<Action> currentPathActions = currentPath.getLastState().getActions();
            for(Action action: currentPathActions) {
                if(!frontier.contains(action.getNextState())) {
                    Path path = new Path(currentPath, action);
                    queue.add(path, totalCost(path, goal));
                }
            }
        }
        return null;
    }



    public int totalCost(Path path, State goal) {
        return g(path) + h(path, goal);
    }
    public int g(Path path) {
        return path.getCost();
    }
    public int h(Path path, State goal) {
        return path.getLastState().heuristicTo(goal);
    }
}

	
