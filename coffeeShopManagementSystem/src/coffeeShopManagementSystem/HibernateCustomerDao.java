package coffeeShopManagementSystem;

public class HibernateCustomerDao implements ICustomerDao{

	@Override
	public void add(Customer customer) {
		//Hibernate kodlar� yer alacak
		System.out.println("Customer veritaban�na eklendi.");
		
	}

	@Override
	public void update(Customer customer) {
		System.out.println("Customer veritaban�nda g�ncellendi.");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println("Customer veritaban�ndan silindi.");
		
	}

}
