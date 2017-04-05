package com.github.jlawrynowicz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ListBenchmark {

	private static final int NUMBER_OF_ELEMENTS_TO_INSERT = 1_000_000;

	private List<Integer> arrayListForIteration;
	private List<Integer> linkedListForIteration;

	@Setup
	public void setup() {
		arrayListForIteration = addToArrayList();
		linkedListForIteration = addToLinkedList();
	}

	@Benchmark
	public List<Integer> addToArrayList() {
		List<Integer> list = new ArrayList<>();
		addBillionInts(list);
		return list;
	}

	@Benchmark
	public List<Integer> addToArrayListPreallocated() {
		List<Integer> list = new ArrayList<>(NUMBER_OF_ELEMENTS_TO_INSERT);
		addBillionInts(list);
		return list;
	}

	@Benchmark
	public List<Integer> addToLinkedList() {
		List<Integer> list = new LinkedList<>();
		addBillionInts(list);
		return list;
	}

	@Benchmark
	public long iterateArrayList() throws Exception {
		long sum = 0;

		for (Integer integer : arrayListForIteration) {
			sum += integer;
		}
		return sum;
	}

	@Benchmark
	public long iterateLinkedList() throws Exception {
		long sum = 0;

		for (Integer integer : linkedListForIteration) {
			sum += integer;
		}
		return sum;
	}

	private void addBillionInts(List<Integer> list) {
		for (int i = 0; i < NUMBER_OF_ELEMENTS_TO_INSERT; i++) {
			list.add(i);
		}
	}

}
