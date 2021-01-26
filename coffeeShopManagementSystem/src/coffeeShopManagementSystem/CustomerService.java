package coffeeShopManagementSystem;

public class CustomerService implements ICustomerService{

	private ICustomerDao customerDao;
	
	public CustomerService(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void add(Customer customer) {
		customerDao.add(customer);
		
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

}
