package org.zerock.mapper.lecture;

import java.util.List;

import org.zerock.domain.lecture.JavaBean13;
import org.zerock.domain.lecture.JavaBean15;

public interface Mapper08 {
  JavaBean13 getCategory();

JavaBean15 getSupplier();
List<String> getProductName();
List<String> getProductName2();
List<String> getEmployeeName();
}
