package rpe;

/** Implements a Bag ADT. Serves as a non-ordered list for the `next` field of Neuron. */
public class Connections {

    /** List of items in the bag. Indices 0 to size-1 must be non-null.
     * Indices size to items.length-1 must be null. */
    private Neuron[] items;

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
        items = new Neuron[10];
    }

    /**
     * Add `newNeuron` to this bag. Requires `newNeuron` is not null
     * and `newNeuron` is not already in the bag.
     */
    void add(Neuron newNeuron) {
        assert newNeuron != null;
        if (items.length == size) {
            //TODO: make new array
        }
        size++;
        assertInv();
    }

    /**
     * Removes `neuron` from this bag. Requires `neuron` is not null.
     */
    void remove(Neuron neuron) {
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
     * Checks if the bag contains `neuron`.
     */
    boolean contains(Neuron neuron) {
        return false;
    }

    /**
     * Return an array containing all the items in the bag.
     * Items are not ordered in any particular way.
     */
    Neuron[] toArray() {
        return items;
    }

}