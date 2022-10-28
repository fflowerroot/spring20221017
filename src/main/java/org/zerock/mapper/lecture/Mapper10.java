package org.zerock.mapper.lecture;

import java.util.ArrayList;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;


public interface Mapper10 {

	int removeCustomer();

	int removeEmployee();

	int removeCustomerById(int id);

	int addCustomer();

	int addSupplier();

	int addSupplier2();

	int insertCustomer(JavaBean18 customer);

	int insertCustomers(ArrayList<JavaBean18> customers); // 어떻게함?

	int insertCustomerAndGetKey(JavaBean18 customer);

	int insertSupplierAndGetKey(JavaBean19 supplier);
}

// cf) 리디렉트어트리뷰트는 세션이 끝나면 사라짐