package com.SpringLearn.SpringProgAnnotationBasedAutowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringLearn.beans.Address;
import com.SpringLearn.beans.Student;

@Configuration
public class SpringConfigFile {
	@Bean
	public Address adr() {
		Address ad = new Address();
		ad.setHouseNo(5);
		ad.setCity("Lucknow");
		ad.setPincode(226016);

		return ad;
	}

	@Bean
	public Student stu() {
		Student st = new Student();
		st.setfName("Arush Gupta");
		st.setRollNo(101);
//		st.setAddress(adr()); manually DI
		return st;
	}

}
