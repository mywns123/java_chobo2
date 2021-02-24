package java_chobo2.ch12;

import java.util.ArrayList;

public interface Eatable {}

class Fruit implements Eatable {
public String toString() {return "Fruit";}
}

class Apple extends Fruit{public String toString() {return "Apple";}}
class Grape extends Fruit{public String toString() {return "Grape";}}
class toy {public String toString() {return "toy";}}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {

}

class Box<T> {
	ArrayList<T> list =  new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) { return list.get(i);}
	int size() { return list.size();}
	public String toString() {return list.toString();}
	
}