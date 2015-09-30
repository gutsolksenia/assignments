package ru.spbau.mit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ������ on 30.09.2015.
 */
public class Function1Test {

    Function1<Integer, Integer> f = new Function1<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg  * arg - 2 * arg + 1;
        }
    };

    Function1<Integer, Integer> g = new Function1<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg - 5;
        }
    };

    @Test
    public void testCompose() throws Exception {
        assertEquals(f.compose(g).apply(10), (Integer)76);
        assertEquals(g.compose(f).apply(10), (Integer)16);
    }
}