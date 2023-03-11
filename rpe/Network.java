package rpe;

/** A network of neurons, implemented as a tree data structure. */
public class Network {

    /** The first element of linked neurons in the network.
     * Invariant: no neuron can point to `root` in its `next` field */
    private Neuron root;

    /** Number of neurons in the network.
     * Invariant: equals the number of unique neurons starting at null
     */
    public int size;

    /** Asserts class invariant */
    private void assertInv() {
    }

    /** Constructs an empty tree */
    public Network() {
        root = null;
        size = 0;
    }

    /** Converts generic tree to binary tree, returning a copy of the Network with at most
     * 2 connections for each Neuron */
    Network genericToBinary() {
        return new Network();
    }

}
