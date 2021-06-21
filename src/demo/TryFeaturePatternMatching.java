package demo;

public class TryFeaturePatternMatching {

	public static void main(String[] args) {
		
		tryTraditionalInstanceOf();
		
		tryInstanceOfWithPatternMatching();
		
		tryInstanceOfWithPatternMatchingInline();
		
		tryPatternMatchingOnInstanceOf();
		
		tryInstanceOfWithPatternMatchingNoShadowing();
		
		tryInstanceOfWithPatternMatchingScope();
		
	}
	
	private static void tryTraditionalInstanceOf() {
		
		Object obj = "foo";
		
		if (obj instanceof String) {
		    String str = (String) obj;
		    System.out.println(str.toUpperCase()); // Use str
		} else {
			System.out.println("Unknown Type");
		}

	}
	
	private static void tryInstanceOfWithPatternMatching() {
		
		Object obj = "foo";
		
		if (obj instanceof String str) {
			//str = "bar"; // Compile Error : str is final
			System.out.println(str.toUpperCase()); // Use str
		} else {
			System.out.println("Unknown Type");
		}

	}
	
	// str is final
	private static void tryInstanceOfWithPatternMatchingInline() {
		
		Object obj = "foo";
		
		if (obj instanceof String str && str.startsWith("foo")) {
			System.out.println(str.toUpperCase()); // Use str
		} else {
			System.out.println("Unknown Type");
		}

	}
	
	// str is final
	private static void tryInstanceOfWithPatternMatchingNoShadowing() {
		System.out.println("TryInstanceOfWithPatternMatchingNoShadowing");
		
		String str = "local";
		Object obj = "foo";
		
		//if (obj instanceof String str) { // Compile Error: Duplicate local variable str
		if (obj instanceof String str2) {
			System.out.println(str2.toUpperCase()); // Use str
		} else {
			System.out.println("Unknown Type");
		}

	}
	
	private static void tryInstanceOfWithPatternMatchingScope() {
		System.out.println("TryInstanceOfWithPatternMatchingNoShadowing");
		
	
		Object obj = "foo";
		
		if (obj instanceof String str && str.startsWith("foo")) {  // str in scope
			System.out.println(str.toUpperCase()); // str in scope
		} else if (obj instanceof Number nbr && nbr.longValue() < 12) { // nbr in scope
			System.out.println(nbr.doubleValue()); // nbr in scope
		} else {
			System.out.println("Unknown Type");
		}

	}
	
	private static void tryPatternMatchingOnInstanceOf() {
		
		Animal animal = new Lion();
		
		if (animal instanceof Parrot parrot) {
			parrot.chirp();
		} else if (animal instanceof Goldfish goldfish) {
			goldfish.swim();
		} else if (animal instanceof Lion lion) {
			lion.roar();
		} else {
			System.out.println(animal);
		}

	}
	
	
}

