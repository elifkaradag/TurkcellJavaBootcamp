package coffeeShopManagementSystem;

import java.util.List;

public class StarbucksConsumerService extends ConsumerService{
	
	private ILogger logger;
	private IConsumerDao starbucksConsumerDao;
	
	public StarbucksConsumerService(ILogger logger,IConsumerDao starbucksConsumerDao) {
		this.logger = logger;
		this.starbucksConsumerDao = starbucksConsumerDao;
		
	}
	public void register(Consumer consumer) {
		logger.log(consumer);
		starbucksConsumerDao.register(consumer);
	}
	public void updateRegistration(Consumer consumer) {
		logger.log(consumer);
		starbucksConsumerDao.updateRegistration(consumer);
	}
	public void deleteRegistration(Consumer consumer) {
		logger.log(consumer);
		starbucksConsumerDao.deleteRegistration(consumer);
	}
	public void buyCoffee(Consumer consumer,Campaign campaign) {
		consumer.setPoint(consumer.getPoint()+1);
		starbucksConsumerDao.updateRegistration(consumer);
		System.out.println("Müþteri bir kahve satýn aldý ve bir yýldýz kazandý.");
	}

}
