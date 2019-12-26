public class Action {

    private String name;
    private int cost;
    private State nextState;

    public Action(String name, int cost, State nextState) {
        this.name = name;
        this.cost = cost;
        this.nextState = nextState;
    }

    public int getCost() {
        return this.cost;
    }

    public State getNextState() {
        return this.nextState;
    }

    public String toString() {
        return this.name;
    }

}