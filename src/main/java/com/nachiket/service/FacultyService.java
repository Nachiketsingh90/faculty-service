package com.nachiket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nachiket.client.SkillsClient;
import com.nachiket.dto.FacultyDTO;
import com.nachiket.model.Faculty;
//import com.nachiket.vo.ResponseVO;
import com.nachiket.vo.Skills;

import lombok.extern.java.Log;

@Log
@Service
public class FacultyService {

	@Autowired
	private FacultyDTO facultyDTO;
	
	private String URL="";
	
	@Autowired
	private SkillsClient skillsClient;
	
	public Faculty registerFaculty(Faculty faculty)
	{
		log.info("Ging to register Faculty in FacultyService->>registerfaculty");
		if (faculty!=null)
		{
			skillsClient.addSkillsList(faculty.getSkillList());
			facultyDTO.save(faculty);
		}
		
		log.info("Faculty is registered now");
		return faculty;
	}
	
	public Faculty updateFaculty(Faculty faculty)
	{
		log.info("Ging to update Faculty in FacultyService->>updatefaculty");
		facultyDTO.save(faculty);
		log.info("Faculty is updated now");
		return faculty;
	}
	public String  deleteFaculty(int id)
	{
		log.info("Ging to delete Faculty in FacultyService->>deleteFaculty");
		String msg;
		if(facultyDTO.findById(id).isPresent())
		{
			facultyDTO.deleteById(id);
			msg="Faculty deleted with ID: "+id;
			log.info("Faculty is deleted now");
		}
		else
			msg="Faculty not found with ID: "+id;
		
		return msg;
		
	}
	public Faculty findFaculty(int id)
	{
		log.info("Ging to find Faculty in FacultyService->>findFaculty");
		Optional<Faculty> facultyOp=facultyDTO.findById(id);
		if(facultyOp.isPresent())
			return facultyOp.get();
		else
			
		return null;
		
	}

	public List<Faculty> findAllFaculty() {
		// TODO Auto-generated method stub
		return facultyDTO.findAll();
	}
	
	public Faculty returnObject(int facultyID)
	{
		//ResponseVO obj=new ResponseVO();
		Faculty faculty=facultyDTO.findById(facultyID).get();
		
		List<Integer> intList = null;
		for(Skills skillslist:faculty.getSkillList())
		{
			intList.add(skillslist.getSkillId());
		}
			
		List<Skills> skillList= skillsClient.findAllSkillsByID(intList);
		
		//obj.setFacult(faculty);
		faculty.setSkillList(skillList);
		
		return faculty;
	}
}
