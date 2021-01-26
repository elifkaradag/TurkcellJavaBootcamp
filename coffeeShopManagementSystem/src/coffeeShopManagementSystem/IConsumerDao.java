package coffeeShopManagementSystem;

import java.util.List;

public interface IConsumerDao {
	void register(Consumer consumer);
	void updateRegistration(Consumer consumer);
	void deleteRegistration(Consumer consumer);
	
	

}
