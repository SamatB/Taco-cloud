package ru.beganov.tacos.db;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import ru.beganov.tacos.entity.Taco;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {

    List<Taco> findAll(PageRequest pageRequest);
}
