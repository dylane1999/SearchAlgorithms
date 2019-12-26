// FIXME add imports here

import java.util.*;


public class DepthFirstSearch implements GraphSearchAlgorithm {



    public Path search(State start, State goal) {
        LinkedList<Path> frontier = new LinkedList<>();
        PathPriorityQueue pq = new PathPriorityQueue();
        ArrayList<State> visited = new ArrayList<State>();
        LinkedList<Path> results = new LinkedList<Path>();
        HashSet<State> visited1 = new HashSet<State>();
        frontier.add(new Path(start));
        while (!frontier.isEmpty()){
            Path currentPath = frontier.removeLast();
            if(goal.equals(currentPath.getLastState())){
                return currentPath;
            }
            List<Action> actions = currentPath.getLastState().getActions();
            for (Action a: actions){
                if (!visited1.contains(a.getNextState())){
                    Path newPath = new Path(currentPath, a);
                    frontier.add(newPath);
                   // if (goal.equals(newPath.getLastState())){
                      //  return newPath;
                   // }
                }
                visited1.add(currentPath.getLastState());
            }
            /*
            for (int i = actions.size(); i > 0 ; i--) {
                if (!visited.contains(actions.get(i-1).getNextState())){
                    Path newPath = new Path(currentPath, actions.get(i-1));
                    frontier.add(newPath);
                    if (goal.equals(newPath.getLastState())){
                        return newPath;
                    }
                }
                visited.add(currentPath.getLastState());

            }
            */


        }




        return null;
    }

}
