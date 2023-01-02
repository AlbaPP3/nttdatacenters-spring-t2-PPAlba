package com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.persistence.Order;

/**
 * 
 * @author Alba
 *
 */

public interface OrderRepository extends JpaRepository<Order, Long> {

}
