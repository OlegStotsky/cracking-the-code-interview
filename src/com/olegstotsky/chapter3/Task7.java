package com.olegstotsky.chapter3;

import java.util.LinkedList;
import java.util.Optional;

public class Task7 {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        shelter.enqueue(new Dog("d1"));
        shelter.enqueue(new Dog("d2"));
        shelter.enqueue(new Dog("d3"));
        shelter.enqueue(new Cat("c1"));
        shelter.enqueue(new Cat("c2"));
        shelter.enqueue(new Dog("d4"));
        Optional<Animal> opt = Optional.ofNullable(new Cat(""));
        while (true) {
            opt = shelter.dequeueAny();
            if (!opt.isPresent()) {
                return;
            }
            System.out.println(opt.get().name);
        }
    }

    abstract static class Animal {
        public String name;
    }

    static class Cat extends Animal {
        Cat(String name) {
            this.name = name;
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            this.name = name;
        }
    }

    static class Shelter {
        LinkedList<Entry<Cat>> cats = new LinkedList<>();
        LinkedList<Entry<Dog>> dogs = new LinkedList<>();
        int time = 0;

        void enqueue(Cat cat) {
            this.cats.add(new Entry<Cat>(time, cat));
            time++;
        }

        void enqueue(Dog dog) {
            this.dogs.add(new Entry<Dog>(time, dog));
            time++;
        }

        Optional<Animal> dequeueAny() {
            if (this.cats.isEmpty() && this.dogs.isEmpty()) {
                return Optional.empty();
            }
            if (this.dogs.isEmpty() || !this.cats.isEmpty() && this.cats.getFirst().time < this.dogs.getFirst().time) {
                return Optional.of(this.cats.removeFirst().animal);
            }

            return Optional.of(this.dogs.removeFirst().animal);
        }

        Optional<Cat> dequeueCat() {
            if (this.cats.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(this.cats.removeFirst().animal);
        }

        Optional<Dog> dequeueDog() {
            return Optional.of(this.dogs.removeFirst().animal);
        }

        private static class Entry<T> {
            int time;
            T animal;

            Entry(int time, T animal) {
                this.time = time;
                this.animal = animal;
            }
        }
    }
}
