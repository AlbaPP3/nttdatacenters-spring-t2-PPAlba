package com.nttdata.services;

import java.util.Optional;

import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;

/**
 * 
 * @author Alba
 *
 */
public interface DistributionServiceI {
	
	/**
	 * Crea un pedido y lo inserta
	 * 
	 * @param o(pedido)
	 */
	public void createOrder(Order o);
	
	/**
	 * 
	 * Inserta un producto al pedido
	 * 
	 * @param o(pedido)
	 * @param p(producto)
	 */
	public void insertProductToAnOrder(Order o, Product p);
	
	
	/**
	 * Devuelve los datos del pedido
	 * 
	 * @param id(id)
	 * @return Optional
	 */
	public Optional<Order> checkDataOrder(Long id);
	
	/**
	 * Elimina un pedido
	 * 
	 * @param id(id)
	 */
	public void breakDownOrder(Long id);
}
