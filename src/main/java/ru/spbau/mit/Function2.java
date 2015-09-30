package ru.spbau.mit;

public abstract class Function2 <T1, T2, R> {
	public abstract R apply(T1 arg1, T2 arg2);
	
	public <R2> Function2 <T1,T2, R2> compose(final Function1 <R, R2> outer) {
		final Function2<T1,T2, R> inner = this; 
		
		return new Function2<T1,T2, R2>() {
			public R2 apply(T1 newArg1, T2 newArg2) {
				return outer.apply(inner.apply(newArg1, newArg2));			
			}		
		};	
	}
	
	public Function1<T2, R> bind1(final T1 newArg1) {
		final Function2<T1, T2, R> function2 = this;
		return new Function1<T2, R>() {
			public R apply(T2 newArg2) {
				return function2.apply(newArg1, newArg2);
			}
		};
	}
	
	public Function1<T1, R> bind2(final T2 newArg2) {
		final Function2<T1, T2, R> function2 = this;
		return new Function1<T1, R>() {
			public R apply(T1 newArg1) {
				return function2.apply(newArg1, newArg2);
			}
		};
	}
	
	public Function1<T1, Function1<T2, R>> curry () {
		final Function2<T1, T2, R> function2 = this;
		return new Function1<T1, Function1<T2, R>>() {
			public Function1<T2, R> apply(T1 newArg1) {
				return function2.bind1(newArg1);
			}
		};
		
    
	}
}
