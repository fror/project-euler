/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.collect;

import java.util.Arrays;

/**
 *
 * @author Olivier Grégoire <fror@users.noreply.github.com>
 */
public class IntList {

  private static final int DEFAULT_CAPACITY = 10;
  private static final int[] EMPTY_ELEMENTDATA = {};
  private static final int[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

  transient int[] elementData;
  transient int size;

  public IntList(int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = new int[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elementData = EMPTY_ELEMENTDATA;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: "
          + initialCapacity);
    }
  }

  public IntList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
  }

  public void ensureCapacity(int minCapacity) {
    int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
        // any size if not default element table
        ? 0
        // larger than default for default empty table. It's already
        // supposed to be at default size.
        : DEFAULT_CAPACITY;

    if (minCapacity > minExpand) {
      ensureExplicitCapacity(minCapacity);
    }
  }

  private void ensureCapacityInternal(int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
      minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }

    ensureExplicitCapacity(minCapacity);
  }

  private void ensureExplicitCapacity(int minCapacity) {
    // overflow-conscious code
    if (minCapacity - elementData.length > 0) {
      grow(minCapacity);
    }
  }

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0) {
      newCapacity = minCapacity;
    }
    if (newCapacity - MAX_ARRAY_SIZE > 0) {
      newCapacity = hugeCapacity(minCapacity);
    }
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
    {
      throw new OutOfMemoryError();
    }
    return (minCapacity > MAX_ARRAY_SIZE)
        ? Integer.MAX_VALUE
        : MAX_ARRAY_SIZE;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean contains(int o) {
    return indexOf(o) >= 0;
  }

  public int indexOf(int o) {
    for (int i = 0; i < size; i++) {
      if (o == elementData[i]) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(int o) {
    for (int i = size - 1; i >= 0; i--) {
      if (o == elementData[i]) {
        return i;
      }
    }
    return -1;
  }

  public int[] toArray() {
    return Arrays.copyOf(elementData, size);
  }

  public int get(int index) {
    rangeCheck(index);
    return elementData[index];
  }

  public int set(int index, int element) {
    rangeCheck(index);

    int oldValue = elementData[index];
    elementData[index] = element;
    return oldValue;
  }

  public boolean add(int e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
  }

  public void add(int index, int element) {
    rangeCheckForAdd(index);

    ensureCapacityInternal(size + 1);  // Increments modCount!!
    System.arraycopy(elementData, index, elementData, index + 1, size - index);
    elementData[index] = element;
    size++;
  }

  public int remove(int index) {
    rangeCheck(index);
    int oldValue = elementData[index];
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(elementData, index + 1, elementData, index,
          numMoved);
    }
    size--;
    return oldValue;
  }

  private void rangeCheck(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
  }

  private void rangeCheckForAdd(int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
  }

  private String outOfBoundsMsg(int index) {
    return "Index: " + index + ", Size: " + size;
  }

}
