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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vmware.projects.service.PeopleService;
import com.vmware.projects.vo.LeaveDetailsUser;
import com.vmware.projects.vo.User;
import com.vmware.projects.vo.UserDetailsByLeaves;

@RestController
public class PeopleServiceController {


	@Autowired
	PeopleService userServiceImpl;

	@RequestMapping(value = "/management/user", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {

		return userServiceImpl.getAllUsers();
	}
	
	@RequestMapping(value = "/management/user/{peopleId}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserDetails(@PathVariable Long peopleId) {

		return userServiceImpl.getUserDetails(peopleId);
	}
	
	@RequestMapping(value = "/management/user/leaves/people/{peopleId}", method = RequestMethod.GET)
	@ResponseBody
	public LeaveDetailsUser getUserLeavesDetails(@PathVariable Long peopleId) {

		return userServiceImpl.getUserLeavesDetails(peopleId);
	}
	
	@RequestMapping(value = "/management/user/people/leaves/{leaveId}", method = RequestMethod.GET)
	@ResponseBody
	public UserDetailsByLeaves getLeavesUserDetails(@PathVariable Long leaveId) {

		return userServiceImpl.getLeavesDetailsbyLeaveTypes(leaveId);
	}

}
