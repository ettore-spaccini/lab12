package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {
	private final List<Integer> list;

	public LogicsImpl(final int size) {
		this.list = new ArrayList<>(Collections.nCopies(size, 0));
	}

	@Override
	public int size() {
		return this.list.size(); 
	}

	@Override
	public List<Integer> values() {
		return list;
	}

	@Override
	public List<Boolean> enablings() {
		return list.stream()
			.map(value -> value < this.list.size())
			.toList();
	}

	@Override
	public int hit(final int elem) {
		final var value = this.list.get(elem) + 1;
		list.set(elem, value);
		return value;
	}

	@Override
	public String result() {
		return list.stream()
			.map(String::valueOf)
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return list.stream()
			.allMatch(i -> i == list.getFirst());
	}
}
