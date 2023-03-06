import java.util.ArrayList;
import java.util.List;

public class Neuron {

    /** A list of neurons this neuron is connected to.
     * Invariant: a neuron cannot be connected to itself or null */
    List<Neuron> next = new ArrayList<Neuron>();

    /** Stores whether the neuron is excitatory or inhibitory.
     * Invariant: `type` must either be "excite" or "inhibit" */
    String type;

    /** Stores the membrane potential of a neuron in mV. Initialized at -70.0. */
    double potential;

}
