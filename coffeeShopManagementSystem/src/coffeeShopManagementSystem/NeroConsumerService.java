package coffeeShopManagementSystem;

public class NeroConsumerService extends ConsumerService{
	
    private IConsumerDao neroConsumerDao;
	
	public NeroConsumerService(IConsumerDao neroConsumerDao) {
		this.neroConsumerDao = neroConsumerDao;
	}
	public void register(Consumer consumer) {
		neroConsumerDao.register(consumer);
	}
	public void updateRegistration(Consumer consumer) {
		neroConsumerDao.updateRegistration(consumer);
	}
	public void deleteRegistration(Consumer consumer) {
		neroConsumerDao.deleteRegistration(consumer);
	}

}
