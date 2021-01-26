package coffeeShopManagementSystem;

public class HibernateCampaignDao implements ICampaignDao{

	@Override
	public void add(Campaign campaign) {
		//Hibernate kodlarý var.
		System.out.println("Kampanya eklendi");
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Kampanya güncellendi");
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println("Kampanya silindi");
		
	}

}
