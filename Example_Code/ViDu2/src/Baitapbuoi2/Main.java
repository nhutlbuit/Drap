package Baitapbuoi2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		for(int i=0;i<10;i++)
		{
			animals.add(new Duck(i*10,i,i,i,i));
			animals.add(new Sheep(i*10,i,i,i,i));
		}
		Farm farm = new Farm(animals);
		System.out.println("Tong so animal: "+farm.TotalAnimals());
		System.out.println("Tong so Vit: "+farm.TotalDucks());
		System.out.println("Tong so Cuu: "+farm.TotalSheeps());
		System.out.println("Tong so dong vat bi om: "+farm.TotalSick());
		farm.WriteInfAnimals();
		farm.ReadInfAnimals();
	}

}
