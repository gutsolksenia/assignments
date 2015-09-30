package ru.spbau.mit;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static <T, R> Iterable<R> map(final Function1<? super T,? extends R> function, final Iterable<T> collection) {
        ArrayList<R> answ = new ArrayList<R>();
        for (T el : collection) {
            answ.add(function.apply(el));
        }
        return (Iterable)answ;
    }
    
    public static <T> Iterable<T> filter(final Predicate<? super T> pred, final Iterable<T> collection) {
        ArrayList<T> answ = new ArrayList<T>();
        for (T el : collection) {
        	if (pred.apply(el).booleanValue()) {
        		answ.add(el);
        	}
        }
        return (Iterable)answ;
    }
    
    public static <T> Iterable<T> takeWhile(final Predicate<? super T> pred, final Iterable<T> collection) {
        ArrayList<T> answ = new ArrayList<T>();
        for (T el : collection) {
        	if (pred.apply(el).booleanValue()) {
                answ.add(el);
            } else {
        		break;
        	 }
        }
        return (Iterable)answ;
    }
    
    public static <T> Iterable<T> takeUnless(final Predicate<? super T> pred, final Iterable<T> collection) {
        ArrayList<T> answ = new ArrayList<T>();
        for (T el : collection) {
            if (pred.apply(el).booleanValue()) {
                break;
            } else {
                answ.add(el);
            }
        }
        return (Iterable)answ;
    }
    
    private static <T1, T2> T2 foldr(final Function2<? super T1, ? super T2, T2> function, T2 init, final Iterator<T1>iterator) {
        if (!iterator.hasNext()) {
    		return init;
    	}
    	
    	T1 el = iterator.next();
    	return function.apply(el, foldr(function, init, iterator));
    }
    
    public static <T1, T2> T2 foldr(final Function2<? super T1, ? super T2, T2> function, T2 init, final Iterable<T1> collection) {
        return foldr(function, init, collection.iterator());
    }
    
    public static <T1, T2> T1 foldl(final Function2<? super T1, ? super T2, ? extends T1> function, T1 init, final Iterable<T2> collection) {
    	T1 answ = init;
        Iterator<T2> iterator = collection.iterator();
        while(iterator.hasNext()) {
            answ = function.apply(answ, iterator.next());
        }
		return answ;
    }  
}
