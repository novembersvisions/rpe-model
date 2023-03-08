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

    @Test
    void connectRemove() {
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            Neuron i = new Neuron("excite", null);
            next.add(n);
            next.add(i);
            assertEquals(true, next.remove(next.get(0)));
            assertEquals(1, next.size());
        }
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            Neuron i = new Neuron("excite", null);
            Neuron f = new Neuron("inhibit", null);
            next.add(n);
            next.add(i);
            assertEquals(false, next.remove(f));
            assertEquals(2, next.size());
        }
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            Neuron i = new Neuron("excite", null);
            Neuron f = new Neuron("inhibit", null);
            next.add(n);
            next.add(i);
            next.add(f);
            assertEquals(true, next.remove(i));
            assertEquals(2, next.size());
        }
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            Neuron i = new Neuron("excite", null);
            Neuron f = new Neuron("inhibit", null);
            Neuron g = new Neuron("inhibit", null);
            next.add(n);
            next.add(i);
            next.add(f);
            next.add(g);
            assertEquals(true, next.remove(n));
            assertEquals(3, next.size());
        }
        {
            Connections next = new Connections();
            Neuron n = new Neuron("excite", null);
            Neuron i = new Neuron("excite", null);
            Neuron f = new Neuron("inhibit", null);
            Neuron g = new Neuron("inhibit", null);
            next.add(n);
            next.add(i);
            next.add(f);
            next.add(g);
            next.removeAll();
            assertEquals(0, next.size());
        }
    }

    /**
     * Test Neuron class
     */
    @Test
    void neuronConstructor() {
        Neuron n = new Neuron("excite",null);

        Connections iList = new Connections();
        iList.add(n);
        Neuron i = new Neuron("inhibit", iList);

        System.out.println(i.type());
        System.out.println(i.next());
    }

    @Test
    void neuronFire() {
        // one neuron, below threshold
        {
            Neuron i = new Neuron("excite",null);
            Boolean[] values = new Boolean[]{false};
            assertEquals(values, i.fire());
        }
        // excitatory neuron, above threshold
        {
            Neuron i = new Neuron("excite",null);
            i.depolarize();

            assertEquals(true, i.fire());
        }
        // inhibitory neuron, above threshold
        {
            Neuron i = new Neuron("inhibit",null);
            i.depolarize();

            assertEquals(true, i.fire());
        }
        // excitatory neurons
        {
            Connections next = new Connections();
            for (int i = 0; i < 15; i++) {
                Neuron n = new Neuron("excite", null);
                next.add(n);
            }
            Neuron i = new Neuron("excite",next);
            i.depolarize();
            Boolean[] values = new Boolean[]{true,true,true,true,true,true,true,
            true,true,true,true,true,true,true,true,true};
            assertEquals(values, i.fire());
        }

    }

    @Test
    void test1() {
        int numb = 1;
        String str = "h";
        System.out.println(numb + str);
    }

}