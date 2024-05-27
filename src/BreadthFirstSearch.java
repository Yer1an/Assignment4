import java.util.*;
public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph graph, Vertex source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(WeightedGraph graph, Vertex<V> current) {
        marked.add(current);


        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current); //[0]

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove(); // []

            for (var vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add((Vertex<V>) vertex);
                    edgeTo.put((Vertex<V>) vertex, v);
                    queue.add((Vertex<V>) vertex);
                }
            }
        }
    }

}
