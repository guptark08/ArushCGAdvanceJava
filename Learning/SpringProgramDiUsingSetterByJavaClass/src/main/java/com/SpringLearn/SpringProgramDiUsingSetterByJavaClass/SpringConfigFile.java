package com.SpringLearn.SpringProgramDiUsingSetterByJavaClass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringLearn.beans.Address;
import com.SpringLearn.beans.Student;

@Configuration
public class SpringConfigFile {
	@Bean
	public Address add() {
		Address ad = new Address();
		ad.setHouseNo(5);
		ad.setCity("Lucknow");
		ad.setPincode(210204);
		return ad;
	}

	@Bean
	public Student stu() {
		Student st = new Student();
		st.setfName("Arush Gupta");
		st.setRollNo(101);
		st.setAddress(add());
		return st;
	}
}
