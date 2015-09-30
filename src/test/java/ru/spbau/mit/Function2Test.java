package ru.spbau.mit;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ������ on 30.09.2015.
 */
public class Function2Test {

    Function2<Integer, Integer, Integer> f = new Function2<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer arg1, Integer arg2) {
            return arg1 - arg2;
        }
    };

    Function1<Integer, Integer> g = new Function1<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * arg;
        }
    };


    @Test
    public void testCompose() throws Exception {
        assertEquals(f.compose(g).apply(10, 2), (Integer)64);
    }

    @Test
    public void testBind1() throws Exception {
        assertEquals(f.bind1(5).apply(2), (Integer)3);
    }

    @Test
    public void testBind2() throws Exception {
        assertEquals(f.bind2(5).apply(10), (Integer)5);
    }

    @Test
    public void testCurry() throws Exception {
        assertEquals(f.curry().apply(7).apply(3), (Integer)4);
    }
}