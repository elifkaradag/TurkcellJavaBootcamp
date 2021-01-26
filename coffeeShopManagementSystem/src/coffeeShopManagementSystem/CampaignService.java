package coffeeShopManagementSystem;

public class CampaignService implements ICampaignService{

	private ICampaignDao campaignDao;
	
	public CampaignService(ICampaignDao campaignDao) {
		this.campaignDao = campaignDao;
	}

	@Override
	public void add(Campaign campaign) {
		campaignDao.add(campaign);
		
	}

	@Override
	public void update(Campaign campaign) {
		campaignDao.update(campaign);
		
	}

	@Override
	public void delete(Campaign campaign) {
		campaignDao.delete(campaign);
		
	}

}
