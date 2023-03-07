package rpe;

/** A neuron with an excitatory/inhibitory type, membrane potential, and list of connected neurons. */
public class Neuron {

    /** A list of neurons this neuron is connected to.
     * Invariant: a neuron cannot be connected to itself; neurons in the list must be unique */
    private Connections next = new Connections();

    /** Stores whether the neuron is excitatory or inhibitory.
     * Invariant: `type` must either be "excite" or "inhibit" */
    private String type;

    /** Stores the membrane potential of a neuron in mV. Initialized at -70.0. */
    private double potential;

    /** Asserts class invariants.*/
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
     @param type specifies the type of neuron; must be "excite" or "inhibit"
     @param next list of neurons this object is connected to
     */
    public Neuron(String type, Connections next) {
        this.type = type;
        this.next = next;
        potential = 70.0;
        assertInv();
    }

    /**
     * Returns the list of connected neurons in `next`
     */
    public Connections next() {
        return next;
    }

    /**
     * Returns the type of neuron
     */
    public String type() {
        return type;
    }

    /**
     * Calculates membrane potential in mV using the Goldman–Hodgkin–Katz equation.
     * Modifies the value of field `potential`.
     */
    public void setPotential() {

    }

    /** Allows the neuron to fire, returning true if the membrane potential has reached the threshold.
     * If the neuron is excitatory, it depolarizes the connected neurons in `next`,
     * setting membrane potential accordingly.
     * If the neuron is inhibitory, it repolarizes the membrane potential of connected neurons. */
    public boolean fire() {
        if (potential < -55.0) {
            return false;
        }
        else {
            return true;
        }
    }

}
