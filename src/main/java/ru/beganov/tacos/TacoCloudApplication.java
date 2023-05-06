package ru.beganov.tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.beganov.tacos.db.IngredientRepository;
import ru.beganov.tacos.db.TacoRepository;
import ru.beganov.tacos.db.UserRepository;
import ru.beganov.tacos.entity.Ingredient;
import ru.beganov.tacos.entity.Taco;

import java.util.Arrays;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
//	@Profile("dev")
	public CommandLineRunner dataLoader(
			IngredientRepository ingredientRepository, UserRepository userRepository,
			PasswordEncoder encoder, TacoRepository tacoRepository) {
		return args -> {
			Ingredient flourTortilla = new Ingredient(
					"FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
			Ingredient cornTortilla = new Ingredient(
					"COTO", "Corn Tortilla", Ingredient.Type.WRAP);
			Ingredient groundBeef = new Ingredient(
					"GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
			Ingredient carnitas = new Ingredient(
					"CARN", "Carnitas", Ingredient.Type.PROTEIN);
			Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
			Ingredient lettuce = new Ingredient(
					"LETC", "Lettuce", Ingredient.Type.VEGGIES);
			Ingredient cheddar = new Ingredient(
					"CHED", "Cheddar", Ingredient.Type.CHEESE);
			Ingredient jack = new Ingredient(
					"JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
			Ingredient salsa = new Ingredient(
					"SLSA", "Salsa", Ingredient.Type.SAUCE);
			Ingredient sourCream = new Ingredient(
					"SRCR", "Sour Cream", Ingredient.Type.SAUCE);
			ingredientRepository.save(flourTortilla);
			ingredientRepository.save(cornTortilla);
			ingredientRepository.save(groundBeef);
			ingredientRepository.save(carnitas);
			ingredientRepository.save(tomatoes);
			ingredientRepository.save(lettuce);
			ingredientRepository.save(cheddar);
			ingredientRepository.save(jack);
			ingredientRepository.save(salsa);
			ingredientRepository.save(sourCream);

			Taco taco1 = new Taco();
			taco1.setName("Carnivore");
			taco1.setIngredients(Arrays.asList(
					flourTortilla, groundBeef, carnitas,
					sourCream, salsa, cheddar));
			tacoRepository.save(taco1);
			Taco taco2 = new Taco();
			taco2.setName("Bovine Bounty");
			taco2.setIngredients(Arrays.asList(
					cornTortilla, groundBeef, cheddar,
					jack, sourCream));
			tacoRepository.save(taco2);
			Taco taco3 = new Taco();
			taco3.setName("Veg-Out");
			taco3.setIngredients(Arrays.asList(
					flourTortilla, cornTortilla, tomatoes,
					lettuce, salsa));
			tacoRepository.save(taco3);

		};
	}

}
