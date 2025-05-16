import java.util.*;

public class BreadthFirst<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> visited = new HashMap<>();

    public BreadthFirst(Vertex<V> start) {
        super(start);
        bfs(start);
    }

    private void bfs(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPathTo(Vertex<V> destination) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = destination; at != null; at = visited.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
