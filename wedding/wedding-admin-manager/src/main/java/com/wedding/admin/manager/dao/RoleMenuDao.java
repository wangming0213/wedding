package com.wedding.admin.manager.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedding.admin.manager.mapper.RoleMenuExMapper;
import com.wedding.admin.manager.mapper.RoleMenuMapper;
import com.wedding.admin.manager.pojo.RoleMenu;
import com.wedding.admin.manager.pojo.RoleMenuExample;
import com.wedding.admin.manger.dto.RoleMenuMappingDto;
import com.wedding.common.constants.DataStatus;
import com.wedding.common.mybatis.MyBatisBaseDao;

@Repository
public class RoleMenuDao extends MyBatisBaseDao<RoleMenu>{

	@Autowired
	@Getter
	private RoleMenuMapper mapper;
	
	@Autowired
	private RoleMenuExMapper roleMenuExMapper;
	
	public List<RoleMenuMappingDto> getRoleMenuByRoleId(String roleId){
		return roleMenuExMapper.getRoleMenuByRoleId(roleId);
	}

	public int logicDeleteRoleMenuByRoleId(String roleId){
		RoleMenu menu = new RoleMenu();
		menu.setRoleId(roleId);
		menu.setStat(DataStatus.DISABLED);
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		return mapper.updateByExampleSelective(menu, example);
	}

	public int logicDeleteByMenuId(String menuId) {
		RoleMenu menu = new RoleMenu();
		menu.setId(menuId);
		menu.setStat(DataStatus.DISABLED);
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andMenuIdEqualTo(menuId);
		return mapper.updateByExampleSelective(menu, example);
	}
}
