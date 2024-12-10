package it.unibo.es2;

public interface Logics {
	/**
	 * @return the number of buttons (except Print)
	 */
	int size();
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	boolean hit(Pair<Integer, Integer> pair);

	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
