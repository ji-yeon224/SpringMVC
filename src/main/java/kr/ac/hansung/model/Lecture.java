package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lecture {
	
	
	
	private int id;
	private int year;
	private int semester;
	
	@NotEmpty(message="과목명 란을 비울 수 없습니다.")
	private String title;
	
	@Length(min=2, max=2, message="교과 구분은 2글자로 입력하세요(예: 전선, 전지...)")
	private String type;
	
	@NotEmpty(message="교수명 란을 비울 수 없습니다.")
	private String professor;
	
	private int credit;
}
