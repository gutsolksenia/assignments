package ru.spbau.mit;

public abstract class Predicate<T> extends Function1<T, Boolean> {
	 public static final Predicate<?> ALWAYS_TRUE = new Predicate<Object> () {
		public Boolean apply(Object arg) {
			return (Boolean)true;
		}
	};
	
	 public static final Predicate<?> ALWAYS_FALSE = new Predicate<Object> () {
		public Boolean apply(Object arg) {
			return (Boolean)true;
		}
	};
	
	public Predicate<T> or(final Predicate<T> pred1) {
		final Predicate<T> pred2 = this;
		return new Predicate<T> () {
			public Boolean apply(T arg) {
				return (Boolean) (pred1.apply(arg) || pred2.apply(arg));
			}
		};
	}
	
	public Predicate<T> and(final Predicate<T> pred1) {
		final Predicate<T> pred2 = this;
		return new Predicate<T> () {
			public Boolean apply(T arg) {
				return (Boolean) (pred1.apply(arg) && pred2.apply(arg));
			}
		};
	}
	
	public Predicate<T> not() {
		final Predicate<T> pred = this;
		return new Predicate<T> () {
			public Boolean apply(T arg) {
				return (Boolean) (!(pred.apply(arg)));
			}
		};
	}
}
