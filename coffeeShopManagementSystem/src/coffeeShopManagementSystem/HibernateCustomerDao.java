package coffeeShopManagementSystem;

public class HibernateCustomerDao implements ICustomerDao{

	@Override
	public void add(Customer customer) {
		//Hibernate kodlarý yer alacak
		System.out.println("Customer veritabanýna eklendi.");
		
	}

	@Override
	public void update(Customer customer) {
		System.out.println("Customer veritabanýnda güncellendi.");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println("Customer veritabanýndan silindi.");
		
	}

}
