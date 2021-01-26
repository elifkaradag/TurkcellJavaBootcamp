package coffeeShopManagementSystem;

public abstract class ConsumerService{
	
	public abstract void register(Consumer consumer);
	public abstract void updateRegistration(Consumer consumer);
	public abstract void deleteRegistration(Consumer consumer);

	public void buyCoffee(Consumer consumer) {
		System.out.println("M��teri bir kahve sat�n ald�");
	}

}
