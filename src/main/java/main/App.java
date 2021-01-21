package main;

import java.util.List;

import desserts.DrinkDAO;
import desserts.DrinkDAOImpl;
import desserts.DrinkDTO;

public class App {

	public static void main(String[] args) {
		
		DrinkDAO drinkDAO = new DrinkDAOImpl();

		drinkDAO.create(new DrinkDTO("Orange Juice", true));
		drinkDAO.create(new DrinkDTO("Apple Juice", true));
		drinkDAO.create(new DrinkDTO("Coke", false));
		drinkDAO.create(new DrinkDTO("Iced Tea", true));
		drinkDAO.create(new DrinkDTO("Mojito", true));
		drinkDAO.create(new DrinkDTO("Pepsi", false));
		drinkDAO.create(new DrinkDTO("Pineapple Juice", true));
		drinkDAO.create(new DrinkDTO("Tomato Juice", true));
		drinkDAO.create(new DrinkDTO("Sprite", false));
		drinkDAO.create(new DrinkDTO("RedBull", false));
	     
	     
		      
		 
        //DrinkDTO drink = 
        //drinkDAO.remove(1L);
        //drinkDAO.remove(2L);
        //drinkDAO.remove(3L);

        //drink.setName("not orange juice");
        //drinkDAO.update(drink);

        List<DrinkDTO> drinks = drinkDAO.getAll();
        drinks.forEach((d) -> System.out.println(d.toString()));
	}
}
