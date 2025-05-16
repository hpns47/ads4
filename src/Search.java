import java.util.List;

public abstract class Search<V> {
    protected Vertex<V> start;

    public Search(Vertex<V> start) {
        this.start = start;
    }

    public abstract List<Vertex<V>> getPathTo(Vertex<V> destination);
}