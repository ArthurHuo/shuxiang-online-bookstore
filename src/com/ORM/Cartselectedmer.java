package com.ORM;

/**
 * Cartselectedmer ���ﳵѡ��
 */

public class Cartselectedmer implements java.io.Serializable {

	// Fields

	private Integer id;

	private Integer cart;

	private Integer merchandise;

	private Integer number;

	private Double price;

	private Double money;

	// Constructors

	/** default constructor */
	public Cartselectedmer() {
	}

	/** full constructor */
	public Cartselectedmer(Integer cart, Integer merchandise, Integer number,
			Double price, Double money) {
		this.cart = cart;
		this.merchandise = merchandise;
		this.number = number;
		this.price = price;
		this.money = money;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCart() {
		return this.cart;
	}

	public void setCart(Integer cart) {
		this.cart = cart;
	}

	public Integer getMerchandise() {
		return this.merchandise;
	}

	public void setMerchandise(Integer merchandise) {
		this.merchandise = merchandise;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}