package rpe;
import java.util.ArrayList;
import java.util.List;

/** A neuron with an excitatory/inhibitory type, membrane potential, and list of connected neurons. */
public class Neuron {

    /** A list of neurons this neuron is connected to.
     * Invariant: a neuron cannot be connected to itself */
    public List<Neuron> next = new ArrayList<Neuron>();

    /** Stores whether the neuron is excitatory or inhibitory.
     * Invariant: `type` must either be "excite" or "inhibit" */
    private String type;

    /** Stores the membrane potential of a neuron in mV. Initialized at -70.0. */
    private double potential;

    /** Asserts class invariants. */
    private void assertInv() {
        int i = 0;
        if (next != null) {
            while (i < next.size()) {
                assert next.get(i) != this;
                i += 1;
            }
        }
        assert type == "excite" || type == "inhibit";
    }

    /** Creates an instance of Neuron.
     @param type: specifies the type of neuron; must be "excite" or "inhibit"
     @param next: list of neurons this object is connected to
     */
    Neuron(String type, List<Neuron> next) {
        this.type = type;
        this.next = next;
        assertInv();
    }

}
