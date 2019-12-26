// FIXME add imports here

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch implements GraphSearchAlgorithm {

    public Path search(State start, State goal) {
        PathPriorityQueue pri = new PathPriorityQueue();
        LinkedList<Path> unvisitedQueue = new LinkedList<Path>();
        LinkedList<Path> results = new LinkedList<Path>();
        //ArrayList<State> visited = new ArrayList<State>();
        HashSet<State> visited1 = new HashSet<State>();
        Path currentPath = new Path(start);
        unvisitedQueue.add(currentPath);
        while (unvisitedQueue.size() > 0){ // comparison between states
            currentPath = unvisitedQueue.pop();
            visited1.add(currentPath.getLastState());
          //  visited.add(currentPath.getLastState());
            List<Action> actions = currentPath.getLastState().getActions();
            for (Action action: actions){
                if (!visited1.contains(action.getNextState())){
                    Path newPath = new Path(currentPath, action);
                    unvisitedQueue.add(newPath);
                    if ((goal.equals(newPath.getLastState())) ){
                        return (newPath);//pri.add(newPath, newPath.getCost()); // return out immediately when
                    }
                }
               // visited.add(currentPath.getLastState());
                visited1.add(currentPath.getLastState());



            }

        }
        return null;


    }

}



/*

 */