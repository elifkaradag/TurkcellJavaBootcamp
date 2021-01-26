package coffeeShopManagementSystem;

public class HibernateCampaignDao implements ICampaignDao{

	@Override
	public void add(Campaign campaign) {
		//Hibernate kodlar� var.
		System.out.println("Kampanya eklendi");
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Kampanya g�ncellendi");
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println("Kampanya silindi");
		
	}

}
