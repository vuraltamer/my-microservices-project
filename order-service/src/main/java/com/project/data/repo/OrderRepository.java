package com.project.data.repo;

import com.project.data.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, String>
{

}
