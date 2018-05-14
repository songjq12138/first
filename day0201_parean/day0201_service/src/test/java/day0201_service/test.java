package day0201_service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {

	public static void main(String[] args) {
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
		System.out.println(bc.encode("1234"));
	}
}
