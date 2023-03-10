import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyGraph g = new MyGraph();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");
        g.insertVertex("F");
        g.insertVertex("G");
        g.insertVertex("H");
        g.insertVertex("I");
        g.insertVertex("J");
        g.insertVertex("K");
        g.insertVertex("L");
        g.insertVertex("M");
        g.insertVertex("N");
        g.insertVertex("O");
        g.insertVertex("P");

        g.insertEdge("A","B","1");
        g.insertEdge("C","D","2");
        g.insertEdge("A","F","3");
        g.insertEdge("B","G","4");
        g.insertEdge("G","D","5");
        g.insertEdge("D","H","6");
        g.insertEdge("E","F","7");
        g.insertEdge("G","H","8");
        g.insertEdge("E","I","9");
        g.insertEdge("E","J","10");
        g.insertEdge("J","G","11");
        g.insertEdge("G","K","12");
        g.insertEdge("H","L","13");
        g.insertEdge("I","J","14");
        g.insertEdge("K","L","15");
        g.insertEdge("I","M","16");
        g.insertEdge("J","N","18");
        g.insertEdge("K","P","19");
        g.insertEdge("M","N","20");
        g.insertEdge("O","P","21");

        g.print();
        System.out.println("Edge between A and B is " + g.getEdge("A","B"));
        System.out.println("Edge between K and P is " + g.getEdge("K","P"));
        System.out.println("End Vertices of 1 are " + Arrays.toString(g.endVertices("1")));
        System.out.println("End Vertices of 20 are " + Arrays.toString(g.endVertices("20")));
        System.out.println("Opposite Vertex of A and 1 is " + g.opposite("A", "1"));
        System.out.println("Opposite Vertex of G and 11 is " + g.opposite("G", "11"));
        System.out.println("Out Degree of B is " + g.outDegree("B"));
        System.out.println("In Degree of G is " + g.inDegree("G"));
        System.out.println("Outgoing Edge(s) from F: " + g.outgoingEdges("F"));
        System.out.println("Incoming Edge(s) from I: " + g.incomingEdges("I"));
        g.removeVertex("O");
        System.out.println("End Vertices of 21 are " + Arrays.toString(g.endVertices("21")));
    }

}
