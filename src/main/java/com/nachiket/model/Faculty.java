package com.nachiket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.nachiket.vo.Skills;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Faculty {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int facultyID;
	private String facultyName;
	//private List<String> skillList;
	private int experience;
	
	@OneToMany(targetEntity = Skills.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="faculty_skill",referencedColumnName = "facultyID")
	private List<Skills> skillList;
}
