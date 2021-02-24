package java_chobo2.ch12;


public class Ex12_3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitbox = new FruitBox<Fruit>();
		FruitBox<Apple> applebox = new FruitBox<Apple>();
		FruitBox<Grape> grapebox = new FruitBox<Grape>();
//		FruitBox<Grape> grapebox = new FruitBox<Apple>();		
//		FruitBox<Toy> toybox = new FruitBox<Toy>();
		
		fruitbox.add(new Fruit());
		fruitbox.add(new Apple());
		fruitbox.add(new Grape());
		applebox.add(new Apple());
//		applebox.add(new Grape());
		grapebox.add(new Grape());
		
		System.out.println("fruitbox - " + fruitbox);
		System.out.println("applebox - " + applebox);
		System.out.println("grapebox - " + grapebox);

	}

}
