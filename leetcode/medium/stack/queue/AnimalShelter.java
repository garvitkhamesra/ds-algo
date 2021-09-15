package medium.stack.queue;

import java.util.LinkedList;

abstract class Animal {
    int order;
    String name;

    Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super( name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

public class AnimalShelter {
     LinkedList<Dog> dogs = new LinkedList();
     LinkedList<Cat> cats = new LinkedList();

     public void enqueue(Animal animal) {
         animal.order += 1;
         if (animal instanceof Dog) {
             dogs.addLast((Dog) animal);
         } else {
             cats.addLast((Cat) animal);
         }
     }

     public Animal dequeueAny() {
         if (dogs.size() == 0) return dequeueCat();
         else if (cats.size() == 0) return dequeueDog();

         if (dogs.peek().order > cats.peek().order) return dequeueCat();
         else return dequeueDog();
     }

    public Animal dequeueDog() {
        return dogs.pop();
    }

    public Animal dequeueCat() {
        return cats.pop();
    }

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog("d"));
        animalShelter.enqueue(new Dog("o"));
        animalShelter.enqueue(new Cat("c"));
        animalShelter.enqueue(new Cat("a"));
        animalShelter.enqueue(new Dog("g"));
        animalShelter.enqueue(new Cat("t"));
        System.out.println(animalShelter.dequeueAny().name);
        System.out.println(animalShelter.dequeueDog().name);
        System.out.println(animalShelter.dequeueCat().name);
    }
}
