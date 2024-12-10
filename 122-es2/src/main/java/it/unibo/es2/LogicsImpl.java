package it.unibo.es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {
	private final List<List<Boolean>> list;

	public LogicsImpl(final int size) {
		list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			// Crea una nuova lista per ogni riga
			List<Boolean> row = new ArrayList<>(Collections.nCopies(size, false));
			list.add(row);
		}
	}

	@Override
	public int size() {
		return this.list.size(); 
	}

	@Override
	public boolean hit(Pair<Integer, Integer> pair) {
		var value = list.get(pair.getX()).get(pair.getY());
		list.get(pair.getX()).set(pair.getY(), !value);
		return !value;
	}

	@Override
	public boolean toQuit() {
		return Stream.iterate(0, i -> i < list.size(),  i -> i + 1)
			.anyMatch(i -> {
				boolean allInRow = list.get(i).stream().allMatch(s -> s);
				boolean allInColumn = list.stream().allMatch(row -> row.get(i));
				return allInRow || allInColumn; 
			});
	}
}
