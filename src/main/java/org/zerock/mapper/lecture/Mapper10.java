package org.zerock.mapper.lecture;

import java.util.ArrayList;
import java.util.List;

import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean13;
import org.zerock.domain.lecture.JavaBean15;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;
import org.zerock.domain.lecture.Javabean18;

public interface Mapper10 {

	int removeCustomer();

	int removeEmployee();

	int removeCustomerById(int id);

	int addCustomer();

	int addSupplier();

	int addSupplier2();

	int insertCustomer(Javabean18 customer);

	int insertCustomers(ArrayList<Javabean18> customers);
}
