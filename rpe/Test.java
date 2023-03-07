package rpe;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RPETest {

    /**
     * Test constructor
     */
    @Test
    void testConstructor() {
        Neuron n = new Neuron("excite",null);
        ArrayList<Neuron> iList = new ArrayList<Neuron>(Arrays.asList(n));

        Neuron i = new Neuron("inhibit", iList);
        System.out.println(i);
        System.out.println(n);
        System.out.println(i.next);
    }

}