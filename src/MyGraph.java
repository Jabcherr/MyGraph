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

    public String getEdge(String vertex1, String vertex2){
        Vertex v1 = getVertexfromString(vertex1);
        Vertex v2 = getVertexfromString(vertex2);
        ArrayList<GraphPairing> gp = graph.get(v1);
        for (GraphPairing g: gp){
            if (g.getVertex() == v2){
                return g.getEdge().getName();
            }
        }
        return "Edge Does not Exist";
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

    private Vertex getVertexfromString(String s){
        Set<Vertex> vertices = graph.keySet();
        for (Vertex v: vertices){
            if (v.getName().equals(s))
                return v;
        }
        return null;
    }

    private Edge getEdgefromString(String s){
        Set<Vertex> vertices = graph.keySet();
        for(Vertex v: vertices){
            ArrayList<GraphPairing> gps = graph.get(v);
            if (gps != null){
                for (GraphPairing g: gps){
                    Edge e = g.getEdge();
                    if (e.getName().equals(s))
                        return e;
                }
            }
        }
        return null;
    }

    public String opposite(String vertex, String edge){
        Vertex v = getVertexfromString(vertex);
        Edge e = getEdgefromString(edge);

        ArrayList<GraphPairing> gps = graph.get(v);
        for (GraphPairing g: gps){
            if (g.getEdge() == e){
                return g.getVertex().getName();
            }
        }
        return null;
    }


    public int outDegree(String vertex){
        Vertex v = getVertexfromString(vertex);
        int num = 0;

        ArrayList<GraphPairing> gps = graph.get(v);
        for (GraphPairing g: gps){
            if (g.getVertex() != null){
                num++;
            }
        }
        return num;
    }

    public int inDegree(String vertex){
        Vertex v = getVertexfromString(vertex);
        int num = 0;

        ArrayList<GraphPairing> gps = graph.get(v);
        for (GraphPairing g: gps){
            if (g.getVertex() != null){
                num++;
            }
        }
        return num;
    }

    //Skipping for now
    public Set<String> vertecies(){
        return null;
    }

    public ArrayList<Edge> outgoingEdges(String vertex){
        Vertex v = getVertexfromString(vertex);

        ArrayList<GraphPairing> gps = graph.get(v);
        ArrayList<Edge> edges = new ArrayList<>();
        for (GraphPairing g: gps){
                edges.add(g.getEdge());
        }
        return edges;
    }

    public ArrayList<Edge> incomingEdges(String vertex){
        Vertex v = getVertexfromString(vertex);

        ArrayList<GraphPairing> gps = graph.get(v);
        ArrayList<Edge> edges = new ArrayList<>();
        for (GraphPairing g: gps){
            edges.add(g.getEdge());
        }
        return edges;
    }

    public String[] endVertices(String edge){
        String[] vertices = new String[2];
        Edge e = getEdgefromString(edge);

        Set<Vertex> vertexList = graph.keySet();
        ArrayList<String> string = new ArrayList<>();
        for (Vertex v: vertexList){
            ArrayList<GraphPairing> gps = graph.get(v);
            for (GraphPairing g : gps){
                if (g.getEdge() == e){
                    if(g.getVertex() != null)
                     string.add(g.getVertex().getName());
                }
            }
        }
        for (int i = 0; i < string.size(); i++)
             vertices[i] = string.get(i);

        return vertices;
    }

    //kinda broken returns null for vertex but edges don't delete
    public void removeVertex(String vertex){
        Vertex v = getVertexfromString(vertex);
        graph.remove(v);

        for (Vertex vert: vertices()){
            ArrayList<GraphPairing> gps = graph.get(v);
            for (GraphPairing g: gps){
                if(g.getVertex() == v){
                    graph.remove(vert);
                }
            }
        }

        System.out.println("Vertex " + vertex + " was deleted");
    }
}
