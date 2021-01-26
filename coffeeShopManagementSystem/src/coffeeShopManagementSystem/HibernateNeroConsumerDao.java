package coffeeShopManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class HibernateNeroConsumerDao implements IConsumerDao{

	public void register(Consumer consumer) {
		System.out.println("Müþteri sisteme kaydoldu.");
	}
	public void updateRegistration(Consumer consumer) {
		System.out.println("Müsteri kaydý güncellendi.");
	}
	public void deleteRegistration(Consumer consumer) {
		System.out.println("Müsteri kaydý silindi");
	}

}
