package com.nttdata.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;



/**
 * 
 * @author Alba
 *
 */
@Entity
@Table(name = "NTTDATA_ORDER")
public class Order extends AbstractEntity implements Serializable{
	
	//Implementación Versión Serializable//
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS//
	private Long Id_Order;
	private List<Product> products;
	private String address;
	private boolean peninsula;
	
	//GETTERS Y SETTERS DE LOS ATRIBUTOS//
	
	/**
	 * Devuelve el id del pedido
	 * 
	 * @return
	 */
	//Mapeo Id_Order//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	public Long getId_Order() {
		return Id_Order;
	}
	
	/**
	 * Asigna el id del pedido
	 * 
	 * @param Id_Order
	 */
	public void setId_Order(Long Id_Order) {
		this.Id_Order= Id_Order;
	}
	
	/**
	 * Devuelve la lista de productos asociados a un pedido
	 * 
	 * @return
	 */
	//Mapeo de la lista de productos que contiene un pedido//
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	public List<Product> getProducts() {
		return products;
	}
	
	/**
	 * Asigna los productos
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/**
	 * Devuleve la dirección del pedido
	 * 
	 * @return
	 */
	//Mapeo de la dirección//
	@Column(name= "ADDRESS")
	public String getAddress() {
		return address;
	}
	
	/**
	 * Asigna una dirección
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Devuelve si el pedido esta dentro o fuera d ela peninsula
	 * 
	 * @return
	 */
	//Mapeo de si está dentro o fuera de la peninsula//
	@Column(name = "PENINSULA")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isPeninsula() {
		return peninsula;
	}
	
	/**
	 * Asigna si está fuera o no de la peninsula
	 * 
	 * @param peninsula
	 */
	public void setPeninsula(boolean peninsula) {
		this.peninsula = peninsula;
	}
	@Override
	public String toString() {
		return "Order [Id_Order=" + Id_Order + ", Address=" + address + ", Peninsula="
				+ peninsula + "]";
	}
	/**
	 * Devuelve el nombre la clase
	 * 
	 * @return
	 */
	@Transient
	public Class<?> getClase() {
		return Order.class;
	}
}
