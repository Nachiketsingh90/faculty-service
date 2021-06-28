package com.nachiket.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nachiket.vo.Skills;



@FeignClient(name="SKILL-SERVICE")

public interface SkillsClient {


	@PostMapping("/skills/addSkills")
	public ResponseEntity<String> registerSkills(@RequestBody Skills skills);
	
	@GetMapping("/skills/findAllSkillsByID")
	public List<Skills> findAllSkillsByID(@PathVariable List<Integer> skillID);
	
	@PostMapping("/skills/addSkillsList")
	public void addSkillsList(@RequestBody List<Skills> skillsList);
	
}
