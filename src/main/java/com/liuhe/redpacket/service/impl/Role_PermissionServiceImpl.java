package com.liuhe.redpacket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhe.redpacket.domain.Role;
import com.liuhe.redpacket.domain.Role_Permission;
import com.liuhe.redpacket.mapper.Role_PermissionMapper;
import com.liuhe.redpacket.service.IRole_PermissionService;

@Service
public class Role_PermissionServiceImpl implements IRole_PermissionService {

	@Autowired
	Role_PermissionMapper role_PermissionMapper;

	@Override
	public List<Role> getAll(Role_Permission rp) {
		return role_PermissionMapper.getAll(rp);
	}

	@Override
	public List<Role> get(Long id) {
		return role_PermissionMapper.get(id);
	}

	@Override
	public void delete(Role_Permission rp) {
		role_PermissionMapper.delete(rp);
	}

	@Override
	public void save(Role_Permission rp) {
		role_PermissionMapper.save(rp);
	}

	@Override
	public void update(Role_Permission rp) {
		role_PermissionMapper.update(rp);
	}

}
