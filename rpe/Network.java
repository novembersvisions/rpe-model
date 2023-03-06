package rpe;
import java.util.ArrayList;
import java.util.List;

/** A network of neurons, implemented as a linked list. 
 * Invariant: no neuron in the network can be null */
public class Network<Neuron> {

    /** The first element of linked neurons in the network.
     * Invariant: no neuron can point to `first` in its `next` field */
    Neuron first;

    /** The last element of linked neurons in the network.
     * Invariant: the `next` field of this neuron must be null */
    Neuron last;

    /** Number of neurons in the network.
     * Invariant: equals the number of unique neurons starting at null
     */
    public int size;

    /** List of unique neurons in the network.
     * Invariant: each element must be unique; each element in the list must equal
     * a corresponding element in the network, and vice versa.
     */
    public List<Neuron> unique = new ArrayList<Neuron>();

}
