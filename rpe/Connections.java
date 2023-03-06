package rpe;

/** Implements a Bag ADT. Serves as a non-ordered list for the `next` field of Neuron. */
public class Connections<T> {

    /** List of items in the bag. Indices 0 to size-1 must be non-null.
     * Indices size to items.length-1 must be null. */
    private T[] items;

    /** Number of items in the bag */
    private int size;

    /** Asserts class invariant. */
    private void assertInv() {
        for (int i=0; i < size; i++) {
            assert items[i] != null;
        }
        for (int i=size; i < items.length; i++) {
            assert items[i] == null;
        }
    }

    /** Constructs an instance of Connections. */
    public Connections() {
        final int capacity = 10;
        items = (T[]) new Object[capacity];
    }

    /**
     * Add `newItem` to this bag. Requires `newItem` is not null.
     */
    void add(T newItem) {
    }

    /**
     * Removes `item` from this bag. Requires `item` is not null.
     */
    void remove(T item) {
    }

    /**
     * Removes all items from the bag.
     */
    void removeAll() {
    }

    /**
     * The number of items in the bag.
     */
    int size() {
        return 0;
    }

    /**
     * The number of copies of `item` this bag contains.
     */
    int frequencyOf(T item) {
        return 0;
    }

    /**
     * Return an array containing all the items in the bag.
     * Items are not ordered in any particular way.
     */
    T[] toArray() {
        return null;
    }

}