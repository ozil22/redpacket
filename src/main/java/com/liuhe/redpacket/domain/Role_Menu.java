package com.liuhe.redpacket.domain;

import java.awt.Menu;
import java.io.Serializable;

/**
 * 角色和菜单的中间表,主要的作用就是做级操作除的时候需要
 * 就是一个中间表的domain
 * @author tian
 *
 */
public class Role_Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6928821150260181331L;
	private Role role;
	private Menu menu;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
