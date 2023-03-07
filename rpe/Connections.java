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
    }

    /**
     * Removes `neuron` from this bag and returns true.
     * If it is not in the bag, returns false.
     */
    boolean remove(Neuron neuron) {
        if (!contains(neuron)) {
            int i = 0;
            while (i < items.length) {
                if (items[i].equals(neuron)) {
                    shiftLeft(i);
                    break;
                }
                i += 1;
            }
            size--;
            assertInv();
            return true;
        }
        return false;
    }

    /**
     * Helper method for remove.
     * Shifts all elements in items to the left, starting from `pos`.
     */
    private void shiftLeft(int pos) {
        while (items[pos+1] != null) {
            items[pos] = items[pos+1];
            pos += 1;
        }
    }

    /**
     * Removes all items from the bag.
     */
    void removeAll() {
        for (int i=0; i < items.length; i++) {
            items[i] = null;
            i += 1;
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
     * Returns true if the bag contains `neuron`.
     */
    boolean contains(Neuron neuron) {
        int i = 0;
        while (i < items.length) {
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
     * Return an array containing all the items in the bag.
     * Items are not ordered in any particular way.
     */
    Neuron[] toArray() {
        return items;
    }

}