package org.zerock.mapper.lecture;

import java.util.List;

import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean13;
import org.zerock.domain.lecture.JavaBean15;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;

public interface Mapper09 {
	String getCustomerNameById(int id);
	String getEmployeeFirstNameById(int i22dsd2); 
	List<String> getCustomerNameByCityAndCountry(String country, String city);
//	List<String> getCustomerNameByCityAndCountry(String city, String country);
//	String getCustomerNameByCityAndCountry2(String string, String string2);
//	String getSupplierNameByCityAndCountry(String country, String city);
	List<String> getSupplierNameByCityAndCountry(String country111, String 매퍼java파일의파라미터이름과맞추면됨);
	String getContactName(JavaBean04 p);
	String getSupplierContactName(JavaBean04 b);
	List<String> getProductName(JavaBean16 b16, JavaBean17 b17);
}
