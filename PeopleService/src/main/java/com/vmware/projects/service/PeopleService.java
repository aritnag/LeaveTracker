package com.vmware.projects.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmware.projects.vo.DetailsByLeaveVO;
import com.vmware.projects.vo.LeaveDetailsUser;
import com.vmware.projects.vo.LeaveDetailsVO;
import com.vmware.projects.vo.People;
import com.vmware.projects.vo.PeopleLeaveDetailsVO;
import com.vmware.projects.vo.PeopleLeaveRequestActionVO;
import com.vmware.projects.vo.PeopleRoleHierarchy;
import com.vmware.projects.vo.Role;
import com.vmware.projects.vo.User;
import com.vmware.projects.vo.UserDetailsByLeaves;


@Service
public class PeopleService {
	
	  @Autowired       
	  protected RestTemplate restTemplate; 

	  public   String USER_SERVICE_URL;
	  public  String ROLE_SERVICE_URL ;
	  public   String HIERARCHY_SERVICE_URL;
	  public   String PROJECT_SERVICE_URL;
	  public  String LEAVE_SERVICE_URL ;
	  
	  
  
	 

	public PeopleService(RestTemplate restTemplate, String uSER_SERVICE_URL, String rOLE_SERVICE_URL,
			String hIERARCHY_SERVICE_URL, String pROJECT_SERVICE_URL, String lEAVE_SERVICE_URL) {
		this.restTemplate = restTemplate;
		USER_SERVICE_URL = uSER_SERVICE_URL;
		ROLE_SERVICE_URL = rOLE_SERVICE_URL;
		HIERARCHY_SERVICE_URL = hIERARCHY_SERVICE_URL;
		PROJECT_SERVICE_URL = pROJECT_SERVICE_URL;
		LEAVE_SERVICE_URL = lEAVE_SERVICE_URL;
	}
	public List<User> getAllUsers() {
		 People[] people = restTemplate.getForObject(USER_SERVICE_URL+"/user/people", People[].class);
		 //List<People> peopleList=Arrays.asList(people);
		  List<User> returnList=new ArrayList<User>();
		  for(People p:Arrays.asList(people)){
			  User u=new User();
			  u.setEmail(p.getEmail());
			  u.setFirstName(p.getFirstName());
			  u.setLastName(p.getLastName());
			  u.setPeopleId(p.getPeopleId());
			  PeopleRoleHierarchy roleHierarchy=getHierarchyDetails("/peopleRoleRel/peopleRole/peopleId/{peopleId}",p.getPeopleId());
			  if(roleHierarchy!=null){
				  u.setRoles(getRoleDetails("/role/role/{roleId}",roleHierarchy.getRoleId()));
				//Reporter
				  if(roleHierarchy.getPeopleIdReportedTo()!=null){
				  People reportManager=getPeopleDetails("/user/people/{peopleId}",roleHierarchy.getPeopleIdReportedTo());
				  u.setReporting(reportManager);
				  
				  }
			  }
			  u.setReportees(getReportees(p.getPeopleId()));
			  
			  returnList.add(u);
		  }
		  return returnList;
    }
	private List<People> getReportees(Long peopleId) {
		List<People> peopleList=new ArrayList<People>();
		PeopleRoleHierarchy[] peopleRoleHierarchy = restTemplate.getForObject(HIERARCHY_SERVICE_URL+"/peopleRoleRel/peopleReportee/{peopleId}", PeopleRoleHierarchy[].class,peopleId);
		List<PeopleRoleHierarchy> peopleRoleHierarchies=Arrays.asList(peopleRoleHierarchy);
		for(PeopleRoleHierarchy hierarchy:peopleRoleHierarchies){
			People reportee=getPeopleDetails("/user/people/{peopleId}",hierarchy.getPeopleId());
			peopleList.add(reportee);
		}
		return peopleList;
	}
	private PeopleRoleHierarchy getHierarchyDetails(String url,Long peopleId){
		  PeopleRoleHierarchy roleHierarchy= restTemplate.getForObject(HIERARCHY_SERVICE_URL + url, PeopleRoleHierarchy.class,peopleId);
		  return roleHierarchy;
	}
	private Role getRoleDetails(String url,Long roleId){
		  Role role= restTemplate.getForObject(ROLE_SERVICE_URL + url, Role.class, roleId);
		  return role;
	}
	
	private People getPeopleDetails(String url,Long peopleId){
		People people= restTemplate.getForObject(USER_SERVICE_URL + url, People.class, peopleId);
		  return people;
	}
	
	private LeaveDetailsVO getLeaveDetails(String url,Long leaveId){
		LeaveDetailsVO leaveDetailsVO= restTemplate.getForObject(USER_SERVICE_URL + url, LeaveDetailsVO.class, leaveId);
		  return leaveDetailsVO;
	}
	public User getUserDetails(Long peopleId) {
		User u=null;
		People people=getPeopleDetails("/user/people/{peopleId}",peopleId);
		if(people!=null){
				u = new User();
			  u.setEmail(people.getEmail());
			  u.setFirstName(people.getFirstName());
			  u.setLastName(people.getLastName());
			  u.setPeopleId(people.getPeopleId());
			  PeopleRoleHierarchy roleHierarchy=getHierarchyDetails("/peopleRoleRel/peopleRole/peopleId/{peopleId}",people.getPeopleId());
			  if(roleHierarchy!=null){
				  u.setRoles(getRoleDetails("/role/role/{roleId}",roleHierarchy.getRoleId()));
				//Reporter
				  if(roleHierarchy.getPeopleIdReportedTo()!=null){
				  People reportManager=getPeopleDetails("/user/people/{peopleId}",roleHierarchy.getPeopleIdReportedTo());
				  u.setReporting(reportManager);
				  //u.setReportees(getReportees(people.getPeopleId()));
				  }
			  }
			  u.setReportees(getReportees(people.getPeopleId()));
		}
		return u;
	}
	public User getUserProjectDetails(Long peopleId) {
		// TODO Auto-generated method stub
		return null;
	}
	public LeaveDetailsUser getUserLeavesDetails(Long peopleId) {
		LeaveDetailsVO[] leaveDetailsVOs = restTemplate.getForObject(LEAVE_SERVICE_URL+"/leave/leaves/person/{peopleId}", LeaveDetailsVO[].class,peopleId);
		List<LeaveDetailsVO> list=Arrays.asList(leaveDetailsVOs);
		LeaveDetailsUser leaveDetailsUsers=new LeaveDetailsUser();
		User user=getUserDetails(peopleId);
		leaveDetailsUsers.setUser(user);	
		leaveDetailsUsers.setLeaveDetails(list);
		return leaveDetailsUsers;
	}
	
	public UserDetailsByLeaves getLeavesDetailsbyLeaveTypes(Long leaveId) {
		UserDetailsByLeaves detailsByLeaves=new UserDetailsByLeaves();
		DetailsByLeaveVO leaveDetailsVOs = restTemplate.getForObject(LEAVE_SERVICE_URL+"/leave/leaves/leave/{leaveId}", DetailsByLeaveVO.class,leaveId);
		detailsByLeaves.setLeaveDetails(leaveDetailsVOs.getLeave());
		List<PeopleLeaveDetailsVO> users=new ArrayList<PeopleLeaveDetailsVO>();
		for(PeopleLeaveRequestActionVO actionVO:leaveDetailsVOs.getPeopleLeave()){
			User u=getUserDetails(actionVO.getPeopleId());
			PeopleLeaveDetailsVO detailsVO=new PeopleLeaveDetailsVO();
			detailsVO.setActionTaken(actionVO.getActionTaken());
			detailsVO.setActionTakenByUser(actionVO.getActionTakenBy());
			detailsVO.setDuration(actionVO.getDuration());
			detailsVO.setLeaveEndDate(actionVO.getLeaveEndDate());
			detailsVO.setLeaveStartDate(actionVO.getLeaveStartDate());
			detailsVO.setStatus(actionVO.getStatus());
			detailsVO.setUser(u);
			users.add(detailsVO);		
		}
		detailsByLeaves.setPeopleLeaveDetails(users);
		return detailsByLeaves;
		
	}
}

