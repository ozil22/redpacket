package com.liuhe.redpacket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhe.redpacket.domain.Permission;
import com.liuhe.redpacket.domain.Role;
import com.liuhe.redpacket.domain.Role_Menu;
import com.liuhe.redpacket.domain.Role_Permission;
import com.liuhe.redpacket.mapper.RoleMapper;
import com.liuhe.redpacket.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> getAll() {

		return roleMapper.getAll();
	}

	@Override
	public Role get(Long id) {
		return roleMapper.get(id);
	}

	@Override
	public Role finMenus(Long id) {
		return roleMapper.finMenus(id);
	}

	@Override
	public void saveRelativity(Role_Menu rm) {
		roleMapper.saveRelativity(rm);
	}

	@Override
	public void deleteRelativity(Role_Menu rm) {
		roleMapper.deleteRelativity(rm);
	}

	/*
	 * 删除一个角色的时候,需要删除它的外键关联 (non-Javadoc)
	 * 
	 * @see com.liuhe.redpacket.service.IRoleService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// Role role = new Role();
		// role.setId(id);
		// Role_Menu rm = new Role_Menu();
		// rm.setRole(role);
		// deleteRelativity(rm);
		// 首先删除中间表关系
		// Role_Permission rm = new Role_Permission(id, null);
		roleMapper.deleteRelativityForPermission(id);
		roleMapper.delete(id);
	}

	@Override
	public void save(Role role) {
		// 首先是保存权限对象,获得返回的该对象的id值
		roleMapper.save(role);
		// 通过这个关系创建中间表(类)的集合
		// 如果用户传入的角色没有权限的话.就不用下面的操作了
		if (role.getPermissions().size() != 0) {
			List<Role_Permission> rps = new ArrayList<Role_Permission>();
			List<Permission> permissions = role.getPermissions();
			for (Permission permission : permissions) {
				Role_Permission rp = new Role_Permission(role.getId(),
						permission.getId());
				rps.add(rp);
			}
			roleMapper.saveRelativityForPermission(rps);
		}
	}

	@Override
	public void update(Role role) {
		// 首先需要删除当前角色的关联关系的中间表
		roleMapper.deleteRelativityForPermission(role.getId());
		// 保存新的角色的关联关系
		roleMapper.update(role);
		// 保存该角色的对象字段
		// 如果用户传入的角色没有权限的话.就不用下面的操作了
		if (role.getPermissions().size() != 0) {
			List<Role_Permission> rps = new ArrayList<Role_Permission>();
			List<Permission> permissions = role.getPermissions();
			for (Permission permission : permissions) {
				Role_Permission rp = new Role_Permission(role.getId(),
						permission.getId());
				rps.add(rp);
			}
			roleMapper.saveRelativityForPermission(rps);
		}
	}

	@Override
	public Role findPermissions(Long id) {
		return roleMapper.findPermissions(id);
	}

	@Override
	public void saveRelativityForPermission(List<Role_Permission> list) {

	}

	@Override
	public void deleteRelativityForPermission(Role_Permission rp) {

	}

}
