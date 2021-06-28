package com.nachiket.vo;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Skills {

	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public int getExp_in_skill() {
		return exp_in_skill;
	}
	public void setExp_in_skill(int exp_in_skill) {
		this.exp_in_skill = exp_in_skill;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int skillId;
	private String skillName;
	private String skillLevel;
	private int exp_in_skill;
}
