package coffeeShopManagementSystem;

public class EGovernmentLogger implements ILogger{

	@Override
	public void log(Consumer consumer) {
		System.out.println("Kullanıcı bilgileri e-devlet sisteminde doğrulandı");
		
	}

}
