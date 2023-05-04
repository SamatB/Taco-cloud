package ru.beganov.tacos.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.beganov.tacos.entity.TacoOrder;
import ru.beganov.tacos.entity.User;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    TacoOrder save(TacoOrder tacoOrder);

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    List<TacoOrder> findByUserOOrderByPlaceAtDesc(User user, Pageable pageable);

//    @Query("FROM TacoOrder o where o.deliveryCity= )
//    List<TacoOrder> readOrdersDeliveredInSeattle(String seattle);

}
