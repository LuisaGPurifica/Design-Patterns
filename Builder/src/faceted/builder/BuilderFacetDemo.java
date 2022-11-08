package faceted.builder;

public class BuilderFacetDemo {
	public static void main(String[] args) {
		PersonBuilder pb = new PersonBuilder();
		Person person = pb.lives().at("Av. Parada Pinto").in("São Paulo").withPostcode("02611-003").works().at("IBM")
				.asA("Developer").earning(24000).build();
		System.out.println(person);
	}
}
