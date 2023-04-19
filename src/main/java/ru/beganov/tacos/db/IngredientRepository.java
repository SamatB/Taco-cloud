package ru.beganov.tacos.db;

import org.springframework.data.repository.CrudRepository;
import ru.beganov.tacos.entity.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
