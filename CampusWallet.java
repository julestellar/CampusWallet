import java.util.Scanner;

public class CampusWallet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LOGIN
        System.out.println("Welcome to CampusWallet!");
        System.out.print("Enter MSU-IIT Email: ");
        String email = sc.nextLine();

        boolean validEmail = email.endsWith("@g.msuiit.edu.ph");
        if (!validEmail) {
            System.out.println("Login failed! Only MSU-IIT emails allowed.");
            return;
        }

        System.out.println("Login successful!\n");

        // Savings goals start from zero
        double emergencyFund = 0;
        double textbooks = 0;
        double studyAbroad = 0;

        int mainChoice = 0;

        while (mainChoice != 4) {
            // MAIN DASHBOARD
            System.out.println("\n====== CAMPUSWALLET DASHBOARD ======");
            System.out.println("[1] View Income Opportunities");
            System.out.println("[2] Student Marketplace");
            System.out.println("[3] Budget Helper");
            System.out.println("[4] Exit");
            System.out.print("Choose an option: ");
            mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 1:
                    System.out.println("\nIncome Opportunities:");
                    System.out.println("- Library Assistant – ₱80/hr");
                    System.out.println("- Canteen Helper – ₱70/hr");
                    System.out.println("- Poster Designer – ₱300/project");
                    break;

                case 2:
                    System.out.println("\nStudent Marketplace:");
                    System.out.println("- Used Textbook – ₱150");
                    System.out.println("- Dorm Lamp – ₱90");
                    System.out.println("- Graphing Calculator – ₱500");
                    break;

                case 3:
                    int budgetChoice = 0;
                    while (budgetChoice != 3) {
                        // BUDGET HELPER MENU
                        System.out.println("\n=== Budget Helper ===");
                        System.out.println("[1] Put money");
                        System.out.println("[2] Check Financial Health Score");
                        System.out.println("[3] Back to Dashboard");
                        System.out.print("Choose an option: ");
                        budgetChoice = sc.nextInt();

                        switch (budgetChoice) {
                            case 1:
                                System.out.println("\nWhere do you want to put this money?");
                                System.out.println("[1] Emergency Fund");
                                System.out.println("[2] Textbooks");
                                System.out.println("[3] Study Abroad");
                                System.out.print("Choose (1-3): ");
                                int goal = sc.nextInt();
                                System.out.print("Enter amount: ₱");
                                double amount = sc.nextDouble();

                                switch (goal) {
                                    case 1:
                                        emergencyFund += amount;
                                        System.out.println("₱" + amount + " added to Emergency Fund.");
                                        break;
                                    case 2:
                                        textbooks += amount;
                                        System.out.println("₱" + amount + " added to Textbooks Fund.");
                                        break;
                                    case 3:
                                        studyAbroad += amount;
                                        System.out.println("₱" + amount + " added to Study Abroad Fund.");
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                }
                                break;

                            case 2:
                                // Financial Health Score
                                double totalSavings = emergencyFund + textbooks + studyAbroad;
                                double score = (totalSavings / 1000) * 100;
                                if (score > 100) score = 100;

                                System.out.println("\n--- Financial Health Score ---");
                                System.out.println("Emergency Fund: ₱" + emergencyFund);
                                System.out.println("Textbooks Fund: ₱" + textbooks);
                                System.out.println("Study Abroad Fund: ₱" + studyAbroad);
                                System.out.println("Total Savings: ₱" + totalSavings);
                                System.out.println("Score: " + score + "/100");
                                if (score >= 80)
                                    System.out.println("Status: Excellent! 🌟");
                                else if (score >= 60)
                                    System.out.println("Status: Good 👍");
                                else if (score >= 40)
                                    System.out.println("Status: Fair 🙂");
                                else
                                    System.out.println("Status: Needs Improvement ⚠️");
                                break;

                            case 3:
                                System.out.println("Returning to Dashboard...");
                                break;

                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye! Thank you for using CampusWallet.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
