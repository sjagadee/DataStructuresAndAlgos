package stacks_queues;


import java.util.LinkedList;

/**
 * Created by srinivas on 2/7/17.
 *
 * animal queue, which animal comes in should go out first
 *
 * can also take cat out or dog out
 */
public class AnimalQueue {

    LinkedList<Animal> cats = new LinkedList<>();
    LinkedList<Animal> dogs = new LinkedList<>();
    int order = 0;

    public void enQueue(Animal a) {
        a.setOrder(order);
        order++;

        if(a instanceof Dog) {
            dogs.addLast(a);
        } else if(a instanceof Cat) {
            cats.addLast(a);
        }
    }

    public Animal deQueueAny() {
        if(dogs.size() == 0) {
            return deQueueCat();
        } else if(cats.size() == 0) {
            return deQueueDog();
        }

        Dog dog = (Dog) dogs.peek();
        Cat cat = (Cat) cats.peek();
        if(dog.isOlderThan(cat)) {
            return deQueueDog();
        } else {
            return deQueueCat();
        }
    }

    private Dog deQueueDog() {
        return (Dog) dogs.poll();
    }

    private Cat deQueueCat() {
        return (Cat) cats.poll();
    }
}

class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
}

abstract class Animal {

    public int order;
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a) {
        return this.getOrder() > a.getOrder();
    }
}
