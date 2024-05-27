import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data){
        this.data = data;
        adjacentVertices = new HashMap<>();
    }
    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacentVertices.put(destination, weight);
    }
    public boolean hasEdge(Vertex v){
        return adjacentVertices.containsKey(v);
    }

    public List<Vertex<V>> getAdjacencyList(){
        List<Vertex<V>> adjacencyList = new ArrayList<>();
        for(var n : adjacentVertices.entrySet()){
            adjacencyList.add(n.getKey());
        }
        return adjacencyList;
    }
    public Map<Vertex<V>, Double> getAdjacentVertices(){
        return adjacentVertices;
    }

    public int size(){
        return adjacentVertices.size();
    }
    public V getData(){
        return data;
    }
    public void setData(V data){
        this.data = data;
    }

}
