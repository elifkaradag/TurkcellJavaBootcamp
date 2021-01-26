package coffeeShopManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class HibernateNeroConsumerDao implements IConsumerDao{

	public void register(Consumer consumer) {
		System.out.println("M��teri sisteme kaydoldu.");
	}
	public void updateRegistration(Consumer consumer) {
		System.out.println("M�steri kayd� g�ncellendi.");
	}
	public void deleteRegistration(Consumer consumer) {
		System.out.println("M�steri kayd� silindi");
	}

}
