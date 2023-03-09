public class Edge extends GraphObject {

    public Edge(String name) {
        super(name);
    }

    public Edge(String name, int weight) {
        super(name, weight);
    }

    public boolean equals(Edge other){
        return this.getName().equals(other.getName());
    }

    public String toString() {
        return    "Edge{" +
                "name='" + this.getName() + '\'' +
                ", weight=" + this.getWeight() +
                '}';
    }
}
