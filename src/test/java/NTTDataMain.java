

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;
import com.nttdata.services.DistributionServiceI;

/**
 * 
 * @author Alba
 *
 */
public class NTTDataMain implements CommandLineRunner{
	
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);
	
	
	@Autowired
	@Qualifier("inPeninsula")
	private DistributionServiceI deliveryService1;

	@Autowired
	@Qualifier("outPeninsula")
	private DistributionServiceI deliveryService2;
	
    public static void main( String[] args ){
    	SpringApplication.run(NTTDataMain.class, args);
    }
    @Override
    public void run(String...args)throws Exception{
    	
    	log.info("Creación de pedidos");
    	
    	Order order1 = new Order();
    	order1.setAddress("Av. Doctor Fleming, Nº2");
    	order1.setPeninsula(false);
    	
    	Order order2 = new Order();
    	order2.setAddress("C.Pompeu Fabra Nº23 ");
    	order2.setPeninsula(true);
    	
    	Order order3 = new Order();
    	order3.setAddress("Av. Juan de Borbón Nº20 3A");
    	order3.setPeninsula(true);
    	
    	log.info("Inserción de los pedidos creados");
    	
    	deliveryService1.createOrder(order1);
    	deliveryService2.createOrder(order2);
    	deliveryService2.createOrder(order3);
    	
    	log.info("Creación de productos");
    	
    	Product product1 = new Product();
    	product1.setName("Cafetera");
    	product1.setBasePrice(200.00);
    	
    	Product product2 = new Product();
    	product2.setName("Lavadora");
    	product2.setBasePrice(300.00);
    	
    	log.info("Inserción de los productos creados en los diferentes pedidos");
    	
    	deliveryService1.insertProductToAnOrder(order1, product2);
    	deliveryService2.insertProductToAnOrder(order3, product2);
    	deliveryService2.insertProductToAnOrder(order2, product1);
    	
    	}
}
