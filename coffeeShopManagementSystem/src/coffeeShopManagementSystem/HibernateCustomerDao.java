package coffeeShopManagementSystem;

public class HibernateCustomerDao implements ICustomerDao{

	@Override
	public void add(Customer customer) {
		//Hibernate kodları yer alacak
		System.out.println("Customer veritabanına eklendi.");
		
	}

	@Override
	public void update(Customer customer) {
		System.out.println("Customer veritabanında güncellendi.");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println("Customer veritabanından silindi.");
		
	}

}
