package monostate;

public class Demo {

	public static void main(String[] args) {

		ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer("Luisa Purificação", 18);

		ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();

		System.out.println(ceo2);

	}

}
