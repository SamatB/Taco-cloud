package ru.beganov.tacos.db;

import ru.beganov.tacos.entity.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
