package com.ORM;

/**
 * Memberlevel ��Ա�ȼ�
 */

public class Memberlevel implements java.io.Serializable {

	// Fields

	private Integer id;

	private String levelName;

	private Integer favourable;

	// Constructors

	/** default constructor */
	public Memberlevel() {
	}

	/** full constructor */
	public Memberlevel(String levelName, Integer favourable) {
		this.levelName = levelName;
		this.favourable = favourable;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getFavourable() {
		return this.favourable;
	}

	public void setFavourable(Integer favourable) {
		this.favourable = favourable;
	}

}