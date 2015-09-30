package ru.spbau.mit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ������ on 30.09.2015.
 */
public class PredicateTest {

    Predicate<Integer> f = new Predicate<Integer>() {
       @Override
        public Boolean apply(Integer arg) {
           return (Boolean)(arg > 0);
       }
    };

    Predicate<Integer> g = new Predicate<Integer>() {
        @Override
        public Boolean apply(Integer arg) {
            return (Boolean)(arg < -10);
        }
    };

    @Test
    public void testOr() throws Exception {
        assertEquals(f.or(g).apply(1), (Boolean)true);
        assertEquals(f.or(g).apply(-100), (Boolean)true);
        assertEquals(f.or(g).apply(-5), (Boolean)false);
    }

    @Test
    public void testAnd() throws Exception {
        assertEquals(f.and(g).apply(1), (Boolean)false);
    }

    @Test
    public void testNot() throws Exception {
        assertEquals(f.not().apply(1), (Boolean)false);
        assertEquals(g.not().apply(1), (Boolean)true);

    }
}