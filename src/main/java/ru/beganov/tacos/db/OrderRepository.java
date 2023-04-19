package ru.beganov.tacos.db;

import org.springframework.data.repository.CrudRepository;
import ru.beganov.tacos.entity.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    TacoOrder save(TacoOrder tacoOrder);
}
