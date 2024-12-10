package it.unibo.es3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics {
	private final Set<Pair<Integer, Integer>> set;
	private final int size; 

	public LogicsImpl(int size) {
		this.size = size; 
		this.set = new HashSet<>();
		final Random r = new Random(); 
		while (set.size() < 3) {
			set.add(new Pair<>(r.nextInt(size), r.nextInt(size)));
		}
	}

	@Override
	public Set<Pair<Integer, Integer>> hit() {
		Set<Pair<Integer, Integer>> newPositions = new HashSet<>();
		this.set.forEach(pair -> {
				for (int i = pair.getX()-1; i <= pair.getX()+1; i++) {
					for (int j = pair.getY()-1; j <= pair.getY()+1; j++) {
						var position = new Pair<>(i, j); 
						if (!set.contains(position) && isConsistentPosition(position)) {
							newPositions.add(position);
						}
					}
				} 
			});
		this.set.addAll(newPositions);
		return newPositions; 
	}

	@Override
	public boolean toQuit() {
		return this.set.size() == this.size * this.size; 
	}

	@Override
	public Set<Pair<Integer, Integer>> init() {
		return Collections.unmodifiableSet(this.set);  
	}

	private boolean isConsistentPosition(Pair<Integer, Integer> pair) {
		return pair.getX() >= 0 && pair.getX() < this.size && pair.getY() >= 0 && pair.getY() < this.size;
	}

}