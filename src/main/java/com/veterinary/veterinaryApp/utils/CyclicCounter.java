package com.veterinary.veterinaryApp.utils;

public class CyclicCounter {
  private long counter;
  private final long start;
  private final long end;

  public CyclicCounter(long start, long end) {
    this.start = start;
    this.end = end;
    this.counter = start;
  }

  public synchronized long next() {
    long currentValue = counter;
    counter++;
    if (counter > end) {
      counter = start;
    }
    return currentValue;
  }
}
