package monostate;

public class ChiefExecutiveOfficer {

	private static String name;
	private static int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ChiefExecutiveOfficer.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		ChiefExecutiveOfficer.age = age;
	}

	public ChiefExecutiveOfficer() {
	}

	public ChiefExecutiveOfficer(String name, int age) {
		ChiefExecutiveOfficer.name = name;
		ChiefExecutiveOfficer.age = age;
	}

	@Override
	public String toString() {
		return "ChiefExecutiveOfficer [name=" + name + ", age=" + age + "]";
	}

}
