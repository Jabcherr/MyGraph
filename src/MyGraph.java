import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MyGraph {
    private int numVerticies;
    private int numEdges;
    private HashMap<Vertex, ArrayList<GraphPairing>> graph;

    public MyGraph() {
        numEdges = 0;
        numVerticies = 0;
        graph = new HashMap<>();
    }

    public void print(){
        Set<Vertex> vertexList = graph.keySet();
        for(Vertex v: vertexList){
            System.out.print(v + ": ");
            System.out.println(graph.get(v));
        }
    }

    public int numVerticies(){
        return numVerticies;
    }

    public int numEdges(){
        return numEdges;
    }
    public void insertVertex(String name){
        Vertex temp = new Vertex(name);
        //assume for now that the given name DNE in the map
        graph.put(temp, null);
        numVerticies++;
    }

    public Set<Vertex> vertices(){
        return graph.keySet();
    }


    public void insertEdge(String v1, String v2, String edgeName){
        Vertex vertex1 = null;
        Vertex vertex2 = null;
        Set<Vertex> vertecies = graph.keySet();
        for (Vertex v: vertecies){
            if(v.compareTo(new Vertex(v1)) == 0) {
                vertex1 = v;
            }
            if(v.compareTo(new Vertex(v2)) == 0){
                vertex2 = v;
            }
        }

        Edge edge = new Edge(edgeName);

        ArrayList<GraphPairing> v1EdgeList = graph.get(vertex1);
        if (v1EdgeList == null)
            graph.put(vertex1, new ArrayList<>());
        graph.get(vertex1).add(new GraphPairing(vertex2, edge));

        ArrayList<GraphPairing> v2EdgeList = graph.get(vertex2);
        if (v2EdgeList == null)
            graph.put(vertex2, new ArrayList<>());
        graph.get(vertex2).add(new GraphPairing(vertex1, edge));

        numEdges++;
    }

}
