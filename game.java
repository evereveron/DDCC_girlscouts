import java.util.Scanner;
import java.util.Random;

public class game {

	static String name;
	static String[] inventory;
	static String choice;
	static int health;

	static Scanner scanner;
	static Random random;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		random = new Random();
		System.out.println("What is your character's name?");
		name = scanner.nextLine();
		health = 100;
		System.out.println("\n");
		printPic();
		System.out.println("Hi " + name + ". You are a small puppy who has gotten lost =( Try to find your way home!\n");

		System.out.println("--------------------\n");

		System.out.println("You see two paths in front of you. One leads into a sunny meadow, the other leads into a misty forest. Do you go to the forest or the meadow?\n");
		choice = scanner.nextLine();

		choice = checkChoice(choice, "forest", "meadow");

		if(choice.equalsIgnoreCase("forest")) {
			System.out.println("The trees loom high above you. There is birdsong in the air. You feel like you should feel scared of the forest, but it is too beautiful to be afraid. You begin to feel hopeful at getting home, even excited about this adventure.\n");
		}
		else if(choice.equalsIgnoreCase("meadow")) {
			System.out.println("The tall grass sways around you. Cheerful chirping fills the air. You feel like you should feel exposed in the meadow, but it is too peaceful to be afraid. You begin to feel hopeful at getting home, even excited about this adventure.\n");
		}

		System.out.println("The calm is suddenly broken by low growling. A fox springs out at you!");
		System.out.println("'You're trespassing on my territory!', it snaps at you.\n");

		System.out.println("Do you bite his ear or try to talk it out?");
		choice = scanner.nextLine();

		choice = checkChoice(choice, "bite", "talk");

		if(choice.equalsIgnoreCase("bite")) {
			System.out.println("You lunge for his ear and chomp down.");
			System.out.println("'Ouch!' Fox yelps.\n");
		}
		else if(choice.equalsIgnoreCase("talk")) {
			System.out.println("'I'm just trying to find my way home.' you say in a reasonable tone.");
			System.out.println("'Too bad! I'm not a reasonable fox!' Fox yells, and attacks you.\n");
		}

		fight("Fox", 10);

		System.out.println("'Wow, you're strong!' Fox says with admiration. 'Let me help you find your way home.'\n");
		System.out.println("Together, the two of you travel. Fox teaches you to catch fish and stalk rabbits for food. You play together in the soft grass and watch for shooting stars at night.\n");
		System.out.println("With your new friend's help, you are easily able to navigate through the wilderness. Eventually he brings you to the edge of town. 'This is where I leave you,' Fox says. 'Now that you know your way around, come visit me sometimes!'\n");

		System.out.println("Do you cry or do you sadly say goodbye?");
		choice = scanner.nextLine();

		choice = checkChoice(choice, "cry", "goodbye");
		if(choice.equalsIgnoreCase("cry")) {
			System.out.println("'Don't cry "+ name + ",' Fox says kindly. 'You know we'll be friends forever. Sometimes we can't always stay with the people we care about though. Remember what I said about visiting!' \n");
		}
		else if(choice.equalsIgnoreCase("goodbye")) {
			System.out.println("'Good bye " + name + ", Fox says solemnly. 'You know we'll be friends forever. Don't forget to visit!'\n");
		}

		System.out.println("With that, he bounds away.\n");
		System.out.println("Though sad your friend left, you eagerly run back to your house, back to your family.\n");
		System.out.println("You win!");
	}

	/*
		helper method to determine if your choices are valid.
		pass in the user's choice and the two valid options.
	*/
	private static String checkChoice(String choice, String option1, String option2) {
		while(!choice.equalsIgnoreCase(option1) && !choice.equalsIgnoreCase(option2)) {
			System.out.println("Please choose "+ option1 + " or " + option2 + "!\n");
			choice = scanner.nextLine();
		}
		return choice;
	}

	private static void printPic() {

	System.out.println("                __");
    System.out.println("              ,\" e`--o");
    System.out.println(" ((          (  | __,'");
    System.out.println("  \\\\~-------' \\_;/");
	System.out.println("  (             /");
    System.out.println("  /) .______.  )");
    System.out.println(" (( (      (( (");
    System.out.println("  ``-'      ``-'\n");
	}

	private static void fight(String enemy, int enemyHealth) {

		System.out.println(enemy + " wants to fight!\n");

		while(enemyHealth > 0) {
			int enemyAttack = random.nextInt(5);
			health -= enemyAttack;
			System.out.println(enemy + " does " + enemyAttack + " damage!");
			System.out.println("You are at " + health + " health.\n");

			System.out.println("Do you bite or scratch?");
			choice = scanner.nextLine();

			choice = checkChoice(choice, "bite", "scratch");

			if(choice.equalsIgnoreCase("bite")) {
				System.out.println("You bite " + enemy);
				int damage = random.nextInt(8);
				enemyHealth -= damage;
				System.out.println("You do " + damage + " damage!");
				System.out.println(enemy + "'s health is at " + enemyHealth+ ". \n");
			}
			else if(choice.equalsIgnoreCase("scratch")) {
				System.out.println("You scratch " + enemy);
				int damage = random.nextInt(5);
				enemyHealth -= damage;
				System.out.println("You do " + damage + " damage!");
				System.out.println(enemy + "'s health is at " + enemyHealth + ". \n");
			}

			
			if(health <=0 ) {
				System.out.println("You are too injured to fight, so you run away. You may be lost forever =(\n");
				System.out.println("-------------------------\n");
				System.out.println("You lose!");
				System.exit(0);
			}
		}

		System.out.println("You win!\n");
	}

}
