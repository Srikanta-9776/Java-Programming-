import dao.CustomerDAO;
import model.Customer;
import java.util.Scanner;

public class Rest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAO();

        while (true) {
            System.out.println("\n=== Garage Billing System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Customer c = new Customer(name, phone, email);
                    customerDAO.addCustomer(c);
                    break;

                case 2:
                    for (Customer cust : customerDAO.getAllCustomers()) {
                        System.out.println(cust.getId() + " - " + cust.getName() + " (" + cust.getPhone() + ")");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
