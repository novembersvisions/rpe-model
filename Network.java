import java.util.ArrayList;
import java.util.List;

public class Network<Neuron> {

    /** Invariant: no neuron in the network can be null */

    /** The first element of linked neurons in the network.
     * Invariant: no neuron can point to `head` in its `next` field */
    Neuron first;

    /** The last element of linked neurons in the network.
     * Invariant: the `next` field of this neuron must be null */
    Neuron last;

    /** Number of neurons in the network.
     * Invariant: equals the number of unique neurons starting at null
     */
    int size;

    /** List of unique neurons in the network.
     * Invariant: each element must be unique; each element in the list must equal
     * a corresponding element in the network, and vice versa.
     */
    List<Neuron> unique = new ArrayList<Neuron>();

}
