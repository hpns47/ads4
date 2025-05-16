public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(c, d, 1);

        System.out.println("BFS from A to D:");
        Search<String> bfs = new BreadthFirst<>(a);
        bfs.getPathTo(d).forEach(System.out::println);

        System.out.println("\nDijkstra from A to D:");
        Search<String> dijkstra = new DijkstraSearch<>(a);
        dijkstra.getPathTo(d).forEach(System.out::println);
    }
}