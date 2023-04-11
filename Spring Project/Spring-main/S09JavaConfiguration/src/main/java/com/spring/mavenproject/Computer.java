package com.spring.mavenproject;

public class Computer {
	int cput;
	String memory;
	String storage;
	public Computer(int cpu, String memory, String storage) {
		super();
		this.cput = cpu;
		this.memory = memory;
		this.storage = storage;
	}
	@Override
	public String toString() {
		return "Computer [cpucores=" + cput + ", memorySize=" + memory + ", storageSize=" + storage + "]";
	}
	
}
