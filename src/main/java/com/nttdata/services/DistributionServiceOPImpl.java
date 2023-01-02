package com.nttdata.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;
import com.nttdata.repository.OrderRepository;
import com.nttdata.repository.ProductRepository;

/**
 * 
 * @author Alba
 *
 */
@Service("outPeninsula")
public class DistributionServiceOPImpl implements DistributionServiceI{
	
	private static Logger log = LoggerFactory.getLogger(DistributionServiceOPImpl.class);
	
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ProductRepository productRepo;

	//Método para crear e insertar un pedido//
	@Override
	public void createOrder(Order o) {
		orderRepo.save(o);
	}
	//Método que inserta un producto en un pedido y calcula//
	//su precio con impuestos si va fuera de la peninsula//
	@Override
	public void insertProductToAnOrder(Order o, Product p) {

		if (o.isPeninsula()) {
			double tax = (p.getBasePrice() * 4) / 100;

			p.setPVPprice(p.getBasePrice() + tax);

			p.setId_Order(o);
			
			productRepo.save(p);

			orderRepo.save(o);

		} else {
			log.info("El pedido se realiza desde dentro de la peninsula");
		}

	}
	//Método para buscar un pedido por su id//
	@Override
	public Optional<Order> checkDataOrder(Long id) {
		return orderRepo.findById(id);

	}
	//Método para eliminar un pedido por su id//
	@Override
	public void breakDownOrder(Long id) {
		orderRepo.deleteById(id);
	}
}
