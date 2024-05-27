public class Main {
    public static void main(String[] args) {
        WeightedGraph<Vertex> graph = new WeightedGraph<>(true);
        Vertex<Integer> first = new Vertex<>(1);
        Vertex<Integer> second = new Vertex<>(2);
        Vertex<Integer> third  = new Vertex<>(3);
        Vertex<Integer> fourth = new Vertex<>(4);
        Vertex<Integer> fifth = new Vertex<>(5);
        Vertex<Integer> six = new Vertex<>(6);
        graph.addVertex(first);
        graph.addVertex(second);
        graph.addVertex(third);
        graph.addVertex(fourth);
        graph.addVertex(fifth);
        graph.addVertex(six);
        graph.addEdge(first, second, 2.5);
        graph.addEdge(second, third, 5);
        graph.addEdge(third, fourth, 2);
        graph.addEdge( fourth, fifth, 3.5);
        graph.addEdge(fifth, six, 7);
        System.out.println(graph.hasEdge(first, second));
        DijkstraSearch<Vertex<Integer>> dijkstraSearch = new DijkstraSearch<>(graph, first);
        dijkstraSearch.dijkstra();
        System.out.println(dijkstraSearch.getShortestDistance(six));






    }

}