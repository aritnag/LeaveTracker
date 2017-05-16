package com.leaveservice.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.leaveservice.model.Leave;
import com.leaveservice.model.PeopleLeaveRequestAction;
import com.leaveservice.model.PeopleLeaves;
import com.leaveservice.repository.LeaveRepository;
import com.leaveservice.repository.PeopleLeaveRepository;
import com.leaveservice.repository.PeopleLeaveRequestActionRepository;
import com.leaveservice.vo.DetailsByLeaveVO;
import com.leaveservice.vo.LeaveDetailsVO;
import com.leaveservice.vo.LeaveVO;
import com.leaveservice.vo.People;
import com.leaveservice.vo.PeopleLeaveRequestActionVO;
import com.leaveservice.vo.PeopleLeaveVO;


@Service
public class LeaveService {

	@Autowired
	LeaveRepository leaveRepository;
	
	@Autowired
	PeopleLeaveRepository peopleLeaveRepository;
	
	@Autowired
	PeopleLeaveRequestActionRepository peopleLeaveRequestActionRepository;
	
		@Autowired       
	  protected RestTemplate restTemplate; 

	  public   String USER_SERVICE_URL;
	  public  String ROLE_SERVICE_URL ;
	  public   String HIERARCHY_SERVICE_URL;
	
	  public LeaveService(RestTemplate restTemplate, String uSER_SERVICE_URL, String rOLE_SERVICE_URL,
				String hIERARCHY_SERVICE_URL) {
			this.restTemplate = restTemplate;
			this.USER_SERVICE_URL = uSER_SERVICE_URL;
			this.ROLE_SERVICE_URL = rOLE_SERVICE_URL;
			this.HIERARCHY_SERVICE_URL = hIERARCHY_SERVICE_URL;
		}


	public String saveLeave(List<Leave> leaves) {

		String response = "";

		try {

			leaveRepository.save(leaves);
            
			response = "Saved Successfully";

		} catch (Exception e) {
			response = "Failed to save category. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	
	public LeaveVO getLeaveById(Long leaveId) {

		LeaveVO leaveVO = new LeaveVO();
		
		try {

			Leave leave = leaveRepository.findOne(leaveId);
			leaveVO.setLeaveId(leave.getLeaveId());
			leaveVO.setLeaveType(leave.getType());
			leaveVO.setIsActive(leave.getIsActive());
				

		} catch (Exception e) {

			e.printStackTrace();
		}

		return leaveVO;
	}
	
	public PeopleLeaveVO getPeopleLeaveById(Long peopleLeaveId) {

		PeopleLeaveVO peopleLeaveVO=new PeopleLeaveVO();
		try {

			PeopleLeaves peopleLeaves = peopleLeaveRepository.findOne(peopleLeaveId);
			peopleLeaveVO.setDuration(peopleLeaves.getDuration());
			peopleLeaveVO.setLeaveEndDate(peopleLeaves.getLeaveEndDate());
			peopleLeaveVO.setLeaveId(peopleLeaves.getLeaveId());
			peopleLeaveVO.setLeaveStartDate(peopleLeaves.getLeaveStartDate());
			peopleLeaveVO.setPeopleId(peopleLeaves.getPeopleId());
			peopleLeaveVO.setPeopleLeaveId(peopleLeaves.getPeopleLeaveId());
			peopleLeaveVO.setStatus(peopleLeaves.getStatus());
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return peopleLeaveVO;
	}



	public List<LeaveVO> getAllLeaves() {

		List<Leave> leaves = leaveRepository.findAll();

		List<LeaveVO> leavePOJOList = new ArrayList<LeaveVO>();

		
		for(Leave leave : leaves)
		{
			LeaveVO leaveVO=new LeaveVO();
			leaveVO.setLeaveId(leave.getLeaveId());
			leaveVO.setLeaveType(leave.getType());
			leaveVO.setIsActive(leave.getIsActive());
			leavePOJOList.add(leaveVO);
		}

		return leavePOJOList;
	}

	private People getPeopleDetails(String url,Long peopleId){
		People people= restTemplate.getForObject(USER_SERVICE_URL + url, People.class, peopleId);
		  return people;
	}
	public List<LeaveDetailsVO> getAllLeavesbyPersonId(Long personId) {
		
		List<LeaveDetailsVO> leaveDetailsVOs=new ArrayList<LeaveDetailsVO>();
		List<PeopleLeaves> peopleLeaveVOs=peopleLeaveRepository.findAll();
		for(PeopleLeaves leaves:peopleLeaveVOs){
			if(personId==leaves.getPeopleId()){
				LeaveDetailsVO detailsVO=new LeaveDetailsVO();
				LeaveVO leaveVO=getLeaveById(leaves.getLeaveId());
				
				detailsVO.setLeave(leaveVO);
				PeopleLeaveRequestActionVO peopleLeaveVO=new PeopleLeaveRequestActionVO();
				peopleLeaveVO.setDuration(leaves.getDuration());
				peopleLeaveVO.setLeaveEndDate(leaves.getLeaveEndDate());
				peopleLeaveVO.setLeaveId(leaves.getLeaveId());
				peopleLeaveVO.setLeaveStartDate(leaves.getLeaveStartDate());
				peopleLeaveVO.setPeopleId(leaves.getPeopleId());
				peopleLeaveVO.setPeopleLeaveId(leaves.getPeopleLeaveId());
				peopleLeaveVO.setStatus(leaves.getStatus());
				List<PeopleLeaveRequestAction> actions=peopleLeaveRequestActionRepository.findAll();
				for(PeopleLeaveRequestAction leaveRequestAction:actions){
					if(leaveRequestAction.getPeopleLeaveId()==leaves.getPeopleLeaveId()){
						peopleLeaveVO.setActionTaken(leaveRequestAction.getActionTaken());
						peopleLeaveVO.setActionTakenBy(getPeopleDetails("/user/people/{peopleId}",leaveRequestAction.getActionTakenBy()));
					}
				}
				detailsVO.setPeopleLeave(peopleLeaveVO);
				leaveDetailsVOs.add(detailsVO);
			}
		}
		return leaveDetailsVOs;
		
	}


	public DetailsByLeaveVO getAllPersonsbyLeaveId(Long leaveId) {
		DetailsByLeaveVO leaveDetailsVOs=new DetailsByLeaveVO();
		List<PeopleLeaves> peopleLeaveVOs=peopleLeaveRepository.findAll();
		Leave leave=leaveRepository.findOne(leaveId);
		LeaveVO leaveVO=new LeaveVO();
		leaveVO.setLeaveId(leave.getLeaveId());
		leaveVO.setLeaveType(leave.getType());
		leaveVO.setIsActive(leave.getIsActive());
		leaveDetailsVOs.setLeave(leaveVO);
		List<PeopleLeaveRequestActionVO> leaveRequestActionVOs=new ArrayList<PeopleLeaveRequestActionVO>();
		for(PeopleLeaves leaves:peopleLeaveVOs){
			if(leaveId==leaves.getLeaveId()){
				PeopleLeaveRequestActionVO peopleLeaveVO=new PeopleLeaveRequestActionVO();
				peopleLeaveVO.setDuration(leaves.getDuration());
				peopleLeaveVO.setLeaveEndDate(leaves.getLeaveEndDate());
				peopleLeaveVO.setLeaveId(leaves.getLeaveId());
				peopleLeaveVO.setLeaveStartDate(leaves.getLeaveStartDate());
				peopleLeaveVO.setPeopleId(leaves.getPeopleId());
				peopleLeaveVO.setPeopleLeaveId(leaves.getPeopleLeaveId());
				peopleLeaveVO.setStatus(leaves.getStatus());
				List<PeopleLeaveRequestAction> actions=peopleLeaveRequestActionRepository.findAll();
				for(PeopleLeaveRequestAction leaveRequestAction:actions){
					if(leaveRequestAction.getPeopleLeaveId()==leaves.getPeopleLeaveId()){
						peopleLeaveVO.setActionTaken(leaveRequestAction.getActionTaken());
						peopleLeaveVO.setActionTakenBy(getPeopleDetails("/user/people/{peopleId}",leaveRequestAction.getActionTakenBy()));
					}
				}
				leaveRequestActionVOs.add(peopleLeaveVO);
			}
		}
		leaveDetailsVOs.setPeopleLeave(leaveRequestActionVOs);
		return leaveDetailsVOs;
	}


	public String savePeopleLeave(List<PeopleLeaveRequestActionVO> peopleLeaves) {
		

		String response = "";
		boolean flag=false;
		try {
			if(peopleLeaves!=null && !peopleLeaves.isEmpty()){
			for(PeopleLeaveRequestActionVO actionVO:peopleLeaves){
				PeopleLeaves leaves=new PeopleLeaves();
				leaves.setDuration(actionVO.getDuration());
				leaves.setLeaveEndDate(actionVO.getLeaveEndDate());
				leaves.setLeaveId(actionVO.getLeaveId());
				leaves.setLeaveStartDate(actionVO.getLeaveStartDate());
				leaves.setPeopleId(actionVO.getPeopleId());
				leaves.setStatus(actionVO.getStatus());
				PeopleLeaves pl=peopleLeaveRepository.save(leaves);
				PeopleLeaveRequestAction leaveRequestAction=new PeopleLeaveRequestAction();
				leaveRequestAction.setActionTaken(actionVO.getActionTaken());
				leaveRequestAction.setActionTakenBy(actionVO.getActionTakenBy().getPeopleId());
				leaveRequestAction.setPeopleId(actionVO.getPeopleId());
				leaveRequestAction.setPeopleLeaveId(pl.getPeopleLeaveId());
				PeopleLeaveRequestAction persist=peopleLeaveRequestActionRepository.save(leaveRequestAction);
				if(persist.getPeopleLeaveRequestAction()>0)
					flag=true;
			}
			}
			
            if(flag)
			response = "Saved Successfully";

		} catch (Exception e) {
			response = "Failed to save category. Please try again";
			e.printStackTrace();
		}

		return response;
	
	}
}
