package prj.clark.cs.dsa.algo.graph;

import prj.clark.cs.dsa.struct.bag.Bag;
import prj.clark.cs.dsa.struct.bag.StackBag;

public class EdgeWeightedGraph {
    private final int vertices;
    private int edges;

    private Bag<Edge>[] adjacencyLists;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacencyLists = (Bag<Edge>[]) (new Bag[vertices]);
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void addEdge(Edge e) {
        int i = e.either();
        int j = e.other(i);

        adjacencyLists[i].add(e);
        adjacencyLists[j].add(e);

        edges++;
    }

    public Iterable<Edge> adjacents(int k) {
        return adjacencyLists[k];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new StackBag<>();
        for (int i = 0; i < vertices; ++i) {
            for (Edge e : adjacencyLists[i]) {
                if (e.other(i) > i) {
                    edges.add(e);
                }
            }
        }

        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Edge edge : edges()) {
            sb.append(edge);
        }

        return sb.toString();
    }
}