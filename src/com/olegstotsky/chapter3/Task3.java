package com.olegstotsky.chapter3;

import java.util.Stack;
import java.util.ArrayList;

public class Task3 {
  public static class SetOfStacks<T> {
    private final ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();
    private final int threshold;

    public SetOfStacks(int threshold) {
      this.threshold = threshold;
      stacks.add(new Stack<T>());
    }

    public void push(T elem) {
      stacks.get(stacks.size()-1).add(elem);
      if (stacks.get(stacks.size()-1).size() >= threshold) {
        this.stacks.add(new Stack<T>());
      }
    }

    public T pop() {
      while (!(stacks.size() == 0) && stacks.get(stacks.size() - 1).empty()) {
        stacks.remove(stacks.size()-1);
      }
      T result = stacks.get(stacks.size()-1).pop();
      if (stacks.get(stacks.size()-1).empty() && stacks.size() > 1) {
        stacks.remove(stacks.size()-1);
      }
      
      return result;
    }

   public T popAt(int index) {
      if (index < 0 || index >= stacks.size()) {
        throw new IndexOutOfBoundsException();
      }
      T elem = stacks.get(index).pop();
      return elem;
   }
  }


  public static void main(String[] args) {
    SetOfStacks<Integer> S = new SetOfStacks<>(2);
    S.push(3);
    S.push(4);
    S.push(5);
    S.push(6);
    S.push(7);
    S.popAt(1);
    S.popAt(1);
    System.out.println(S.pop());
    System.out.println(S.pop());
    System.out.println(S.pop());
  }
}