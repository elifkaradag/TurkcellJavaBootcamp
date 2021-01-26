package coffeeShopManagementSystem;

public class Main {

	public static void main(String[] args) {
		ICustomerService customerService = new CustomerService(new HibernateCustomerDao());
		customerService.add(new Starbucks());
		
		Consumer consumer = new Consumer();
		
		StarbucksConsumerService starbucksConsumerService = new StarbucksConsumerService(new EGovernmentLogger(),new HibernateStarbucksConsumerDao());
		starbucksConsumerService.register(consumer);
		starbucksConsumerService.buyCoffee(consumer,new Campaign());
		
//		System.out.println();
		
//		ICustomerService customerService = new CustomerService(new HibernateCustomerDao());
//		customerService.add(new Nero());
//		
//		NeroConsumerService neroConsumerService = new NeroConsumerService(new HibernateNeroConsumerDao());
//		neroConsumerService.register(consumer);
//		neroConsumerService.buyCoffee(consumer);
		

	}

}
