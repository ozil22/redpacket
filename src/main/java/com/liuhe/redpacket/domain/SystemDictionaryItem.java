package com.liuhe.redpacket.domain;

import java.io.Serializable;

/**
 * 数据字典明细
 * @author ozil
 */
public class SystemDictionaryItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -434047515610115344L;
	private Long id;
	private Integer sn;//数据字典明细序号
	private String value;//数据字典明细值
	private String intro;//字典目录明细简介
	
	//字典目录     多对一
	private SystemDictionary parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public SystemDictionary getParent() {
		return parent;
	}

	public void setParent(SystemDictionary parent) {
		this.parent = parent;
	}
	
	
}

