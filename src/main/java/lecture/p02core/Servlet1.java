package lecture.p02core;

import lombok.Data;

@Data
public class Servlet1 {
	private ProductDao productDao;
	public void doGet() {
		productDao.getProductName();
	}
}
