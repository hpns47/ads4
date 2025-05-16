import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distances = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

    public DijkstraSearch(Vertex<V> start) {
        super(start);
        dijkstra(start);
    }

    private void dijkstra(Vertex<V> source) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        distances.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double newDist = distances.get(current) + neighborEntry.getValue();
                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPathTo(Vertex<V> destination) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = destination; at != null; at = previous.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}