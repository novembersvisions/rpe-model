package rpe;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RPETest {

    /**
     * Test Connections class
     */
    @Test
    void connectConstructor() {
        new Connections();
    }
    @Test
    void connectAdd() {
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            next.add(n);
            assertEquals(1, next.size());
        }
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            Neuron i = new Neuron("excite", null);
            next.add(n);
            next.add(i);
            assertEquals(2, next.size());
            System.out.println(next.toString());
        }
        {
            Connections next = new Connections();
            for (int i=0;i<15;i++) {
                Neuron n = new Neuron("excite", null);
                next.add(n);
            }
            System.out.println(next.toString());
            assertEquals(15, next.size());
        }
    }

    /**
     * Test Neuron constructor
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