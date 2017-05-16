package com.vmware.projects.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vmware.projects.model.Role;
import com.vmware.projects.service.impl.RoleServiceImpl;

@Controller
public class RoleController {


	@Autowired
	RoleServiceImpl roleServiceImpl;

	 
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	@ResponseBody
	public String saveRole(@RequestBody List<Role> roles) {

		return roleServiceImpl.saveRole(roles);
	}

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getAllRoles() {

		return roleServiceImpl.getAllRoles();
	}

	@RequestMapping(value = "/role/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public Role getRole(@PathVariable Long roleId) {

		return roleServiceImpl.getRoleById(roleId);
	}

	


}
