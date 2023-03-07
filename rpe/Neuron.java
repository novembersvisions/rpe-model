package rpe;

/** A neuron with an excitatory/inhibitory type, membrane potential, and list of connected neurons. */
public class Neuron {

    /** A list of neurons this neuron is connected to.
     * Invariant: a neuron cannot be connected to itself; neurons in the list must be unique */
    private Connections next;

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
        assert type.equals("excite") || type.equals("inhibit");
    }

    /** Creates an instance of Neuron.
     @param type specifies the type of neuron; must be "excite" or "inhibit"
     @param next list of neurons this object is connected to
     */
    public Neuron(String type, Connections next) {
        this.type = type;
        this.next = next;
        potential = -70.0;
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

    /**
     * If `potential` is less than -55.0 mV, it is set to -55.0, the threshold value.
     */
    public void depolarize() {
        if (potential < -55.0) {
            potential = -55.0;
        }
    }

    /** Allows the neuron to fire, returning true if the membrane potential has reached the threshold.
     * If the neuron is excitatory, it depolarizes the connected neurons in `next`,
     * propagating the action potential.
     * If the neuron is inhibitory, it repolarizes the membrane potential of connected neurons. */
    public boolean fire() {
        System.out.println(this);
        if (potential < -55.0) {
            System.out.println("Repolarized at "+potential+" mV");
            return false;
        }
        else {
            System.out.println("Depolarized at "+potential+" mV");
            if (type.equals("excite") && next != null) {
                for (int i=0;i< next.size();i++) {
                    next.get(i).depolarize();
                    next.get(i).fire();
                }
            } if (type.equals("inhibit") && next != null) {
                for (int i=0;i< next.size();i++) {
                    if (next.get(i).potential >= -55.0) {
                        next.get(i).potential = -70.0;
                    }
                }
            }
            return true;
        }
    }

}
