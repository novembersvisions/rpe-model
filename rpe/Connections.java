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
     * Add `newItem` to this bag. Requires `newItem` is not null
     * and `newItem` is not already in the bag.
     */
    void add(T newItem) {
        assert newItem != null;
        if (items.length == size) {
            //TODO: make new array
        }
        size++;
        assertInv();
    }

    /**
     * Removes `item` from this bag. Requires `item` is not null.
     */
    void remove(T item) {
        size--;
        assertInv();
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
        return size;
    }

    /**
     * Checks if the bag contains `item`.
     */
    boolean contains(T item) {
        return false;
    }

    /**
     * Return an array containing all the items in the bag.
     * Items are not ordered in any particular way.
     */
    T[] toArray() {
        return null;
    }

}