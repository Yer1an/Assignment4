import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class WeightedGraph<V> {
    private final boolean undirected;
    private final ArrayList<Vertex> list = new ArrayList<>();
    public WeightedGraph() {
        this(true);
    }
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v))
            return;
        list.add(v);
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);
        if (!hasVertex(dest))
            addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops
        source.addAdjacentVertex(dest, weight);
        if (undirected)
            dest.addAdjacentVertex(source, weight);
    }

    public int getVerticesCount() {
        return list.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : list) {
            count += v.size();
        }
        if (undirected)
            count /= 2;
        return count;
    }
    public boolean hasVertex(Vertex v) {
        return list.contains(v);
    }
    public boolean hasEdge(Vertex source, Vertex dest) {
        return source.hasEdge(dest);
    }
    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;
        return v.getAdjacencyList();
    }

    public Iterable<Map<Vertex, Double>> getEdges(Vertex v) {
        if (!hasVertex(v)) return null;
        return (Iterable<Map<Vertex, Double>>) v.getAdjacentVertices();
    }
}
