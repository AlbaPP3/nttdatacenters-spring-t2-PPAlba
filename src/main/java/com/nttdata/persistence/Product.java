package com.nttdata.persistence;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Alba
 *
 */
@Entity
@Table(name = "NTTDATA_PRODUCT")
public class Product extends AbstractEntity implements Serializable{
	
	//Implementación Versión Serializable//
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS//
	private Long Id_Product;
	private String name;
	private Order Id_Order;
	private Double basePrice;
	private Double PVPprice;
	
	//GETTERS Y SETTERS DE LOS ATRIBUTOS//
	/**
	 * Devuelve el id del producto
	 * 
	 * @return
	 */
	//Mapeo de producto//
	@Column(name= "ID_PRODUCT")
	@Id
	@GeneratedValue(generator= "NTTDATA_SECUENCE")
	public Long getId_Product() {
		return Id_Product;
	}
	
	/**
	 * Asigna el id del producto
	 * 
	 * @param id_Product
	 */
	public void setId_Product(Long id_Product) {
		Id_Product = id_Product;
	}
	
	/**
	 * Devuelve el nombre del prodcuto
	 * 
	 * @return
	 */
	//Mapeo del nombre del producto//
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	/**
	 * Asigna el nombre del producto
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Devuelve el pedido asociado al producto
	 * 
	 * @return
	 */
	//Mapeo del pedido asociado al producto//
	@ManyToOne
	@JoinColumn(name = "ID_ORDER", nullable = true)
	public Order getId_Order() {
		return Id_Order;
	}
	
	/**
	 * Asigna el pedido al producto
	 * 
	 * @param id_Order
	 */
	public void setId_Order(Order id_Order) {
		Id_Order = id_Order;
	}
	
	/**
	 * Devulve el precio sin impuestos
	 * 
	 * @return
	 */
	//Mapeo del precio sin impuestos//
	@Column(name = "PRICE_BASE")
	public Double getBasePrice() {
		return basePrice;
	}
	
	/**
	 * Asigna el precio sin impuestos
	 * 
	 * @param basePrice
	 */
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	
	}
	/**
	 * Devuelve el precio con impuestos
	 * 
	 * @return
	 */
	//Mapeo del precio con impuestos//
	@Column(name = "PVP_PRICE", nullable = true)
	public Double getPVPprice() {
		return PVPprice;
	}
	
	/**
	 * Asigna el precio con impuestos
	 * 
	 * @param pVPprice
	 */
	public void setPVPprice(Double pVPprice) {
		PVPprice = pVPprice;
	}
	
	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return
	 */
	@Transient
	public Class<?> getClase() {
		return Order.class;
	}
}
