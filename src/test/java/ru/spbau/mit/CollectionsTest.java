package ru.spbau.mit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by ������ on 30.09.2015.
 */
public class CollectionsTest {
    Iterable<Integer> a = Arrays.asList(1, 3, 4, - 5, 1000, -1);

    Predicate<Integer> f = new Predicate<Integer>() {
        @Override
        public Boolean apply(Integer arg) {
            return (Boolean)(arg > 0);
        }
    };

    Function1<Integer, Integer> g = new Function1<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg - 5;
        }
    };

    Function2<Integer, Integer, Integer> f2 = new Function2<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer arg1, Integer arg2) {
            return arg1 - arg2;
        }
    };

    @Test
    public void testMap() throws Exception {
        Iterable<Integer> b = Arrays.asList(-4, -2, -1, -10, 995, -6);
        assertEquals(Collections.map(g, a), b);
    }

    @Test
    public void testFilter() throws Exception {
        Iterable<Integer> b = Arrays.asList(1, 3, 4, 1000);
        assertEquals(Collections.filter(f, a), b);
    }

    @Test
    public void testTakeWhile() throws Exception {
        Iterable<Integer> b = Arrays.asList(1, 3, 4);
        assertEquals(Collections.takeWhile(f, a), b);
    }

    @Test
    public void testTakeUnless() throws Exception {
        Iterable<Integer> b = Arrays.asList(1, 3, 4);
        assertEquals(Collections.takeUnless(f.not(), a), b);
    }

    @Test
    public void testFoldr() throws Exception {
        assertEquals(Collections.foldr(f2, (Integer)0, a), (Integer)1008);
    }

    @Test
    public void testFoldl() throws Exception {
        assertEquals(Collections.foldl(f2, (Integer)0, a), (Integer)(-1002));
    }
}