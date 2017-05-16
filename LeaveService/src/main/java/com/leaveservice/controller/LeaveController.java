package com.leaveservice.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leaveservice.model.Leave;
import com.leaveservice.model.PeopleLeaves;
import com.leaveservice.serviceimpl.LeaveService;
import com.leaveservice.vo.DetailsByLeaveVO;
import com.leaveservice.vo.LeaveDetailsVO;
import com.leaveservice.vo.LeaveVO;
import com.leaveservice.vo.PeopleLeaveRequestActionVO;



@Controller
public class LeaveController {

	@Autowired
	LeaveService leaveServiceImpl;
	
	@RequestMapping(value = "/leaves", method = RequestMethod.POST)
	@ResponseBody
	public String saveLeave(@RequestBody List<Leave> leaves) {

		return leaveServiceImpl.saveLeave(leaves);
	}
	
	@RequestMapping(value = "/leaves/people", method = RequestMethod.POST)
	@ResponseBody
	public String savePeopleLeave(@RequestBody List<PeopleLeaveRequestActionVO> peopleLeaves) {

		return leaveServiceImpl.savePeopleLeave(peopleLeaves);
	}

	@RequestMapping(value = "/leave/{leaveId}", method = RequestMethod.GET)
	@ResponseBody
	public LeaveVO getLeave(@PathVariable Long leaveId) {

		return leaveServiceImpl.getLeaveById(leaveId);
	}

	@RequestMapping(value = "/leaves", method = RequestMethod.GET)
	@ResponseBody
	public List<LeaveVO> getAllLeaves() {

		return leaveServiceImpl.getAllLeaves();
	}
	

	@RequestMapping(value = "/leaves/person/{personId}", method = RequestMethod.GET)
	@ResponseBody
	public List<LeaveDetailsVO> getAllLeavesbyPersonId(@PathVariable Long personId) {

		return leaveServiceImpl.getAllLeavesbyPersonId(personId);
	}
	
	@RequestMapping(value = "/leaves/leave/{leaveId}", method = RequestMethod.GET)
	@ResponseBody
	public DetailsByLeaveVO getAllPersonsbyLeaveId(@PathVariable Long leaveId) {

		return leaveServiceImpl.getAllPersonsbyLeaveId(leaveId);
	}
	
	
}
