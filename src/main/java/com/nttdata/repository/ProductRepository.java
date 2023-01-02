package com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Product;

/**
 * 
 * @author Alba
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
