package it.unibo.es3;

import java.util.Set;

public interface Logics {
	/**
	 * @return a set of the positions that have been changed
	 */
	Set<Pair<Integer, Integer>> hit();

	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();

	/**
	 * @return a set of the positions of the three random '*' at the beginning
	 */
	Set<Pair<Integer, Integer>> init();
}
