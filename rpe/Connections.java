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
     * Adds `newNeuron` to this bag. Requires `newNeuron` is not null
     * and `newNeuron` is not already in the bag.
     */
    void add(Neuron newNeuron) {
        assert newNeuron != null && !contains(newNeuron);
        if (items.length == size) {
            expandBag();
        }
        items[size] = newNeuron;
        size++;
        assertInv();
    }

    /** Helper method for add. Expands the capacity of the bag if it is full. */
    private void expandBag() {
        Neuron[] newArr = new Neuron[size*2];
        for (int i=0; i < size; i++) {
            newArr[i] = items[i];
        }
        items = newArr;
    }

    /**
     * Removes `neuron` from this bag and returns true.
     * If it is not in the bag, returns false.
     */
    boolean remove(Neuron neuron) {
        if (contains(neuron)) {
            int i = 0;
            while (i < size) {
                if (items[i].equals(neuron)) {
                    items[i] = null;
                    if (items[i+1] != null) {
                        shiftLeft(i);
                    }
                    size--;
                    assertInv();
                    return true;
                }
                i += 1;
            }
        }
        return false;
    }

    /**
     * Helper method for remove.
     * Shifts all elements in items to the left, starting from `pos`.
     */
    private void shiftLeft(int pos) {
        while (pos < items.length-1) {
            items[pos] = items[pos+1];
            pos += 1;
        }
    }

    /**
     * Removes all items from the bag.
     */
    void removeAll() {
        for (int i=0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
        assertInv();
    }

    /**
     * The number of items in the bag.
     */
    int size() {
        return size;
    }

    /**
     * Returns the neuron at index `pos`.
     * Requires `pos` < size.
     */
    Neuron get(int pos) {
        assert pos < size;
        return items[pos];
    }

    /**
     * Returns true if the bag contains `neuron`.
     */
    boolean contains(Neuron neuron) {
        int i = 0;
        while (i < size) {
            if (items[i] == null) {
                return false;
            }
            if (items[i].equals(neuron)) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    /**
     * Returns a string with each item in the bag, represented as their types.
     * Items are not ordered in any particular way.
     */
    @Override
    public String toString() {
        int i = 0;
        String types = "";
        while (i < size) {
            types += items[i].type();
            if (i < size-1) {
                types += ", ";
            }
            i += 1;
        }
        return types;
    }

}