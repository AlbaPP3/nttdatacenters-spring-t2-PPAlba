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
@Service("inPeninsula")
public class DistributionServicePeninsulaImpl implements DistributionServiceI{

		private static Logger log = LoggerFactory.getLogger(DistributionServicePeninsulaImpl.class);
		
		@Autowired
		OrderRepository orderRepo;

		@Autowired
		ProductRepository productRepo;

		//Método para crear e insertar un pedido//
		@Override
		public void createOrder(Order o) {
			orderRepo.save(o);

		}
		//Método para insertar un producto dentro de un pedido//
		//y calcular su precio con impuesto si va a la peninsula//
		@Override
		public void insertProductToAnOrder(Order o, Product p) {
			if (o.isPeninsula()) {
				log.info("El pedido se realiza desde fuera de la peninsula");

			} else {

				double tax = (p.getBasePrice() * 21) / 100;

				p.setPVPprice(p.getBasePrice() + tax);

				p.setId_Order(o);
				
				productRepo.save(p);

				orderRepo.save(o);

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
