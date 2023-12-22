import java.io.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome Back!!");
        int count = 0;
        int Choice = 0;
        while (Choice != 6) {
            System.out.println("\n Menu:\n1- Add Workers.\n2- Add Clients\n3- Display All Workers and Clients\n4- Modify\n5- Search By Name\n6- Exit!");
            System.out.print("Enter a choice: ");
            Choice = scanner.nextInt();
            scanner.nextLine();


            switch (Choice) {
                case 1:
                    Address WorkerA = new Address();
                    Worker W = new Worker();
                    System.out.println("Enter Worker's Info: ");

                    System.out.print("Enter Name: ");
                    String Name = scanner.nextLine();
                    W.setName(Name);
                    System.out.print("Enter Gender: ");
                    String Gender = scanner.nextLine();
                    W.setGender(Gender);
                    System.out.print("Enter Age: ");
                    int Age = scanner.nextInt();
                    W.setAge(Age);
                    scanner.nextLine();

                    System.out.println("Enter Worker's Address: ");
                    System.out.print("Enter Country: ");
                    String Country = scanner.nextLine();
                    WorkerA.setCountry(Country);
                    System.out.print("Enter City: ");
                    String City = scanner.nextLine();
                    WorkerA.setCity(City);
                    System.out.print("Enter Street Number: ");
                    int Num = scanner.nextInt();
                    WorkerA.setStreetNum(Num);
                    scanner.nextLine();
                    W.setAddress(WorkerA);


                    System.out.println("Enter More Info on Worker: ");
                    System.out.print("Enter Salary: ");
                    int Salary = scanner.nextInt();
                    W.setSalary(Salary);
                    scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String Position = scanner.nextLine();
                    W.setPosition(Position);
                    System.out.print("Enter Role: ");
                    String Role = scanner.nextLine();
                    W.setRole(Role);

                    try (
                            FileWriter file = new FileWriter("Workers.csv", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(file);
                            PrintWriter output = new PrintWriter(bufferedWriter)) {
                        output.println(W);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    break;

                case 2:

                    Client C = new Client();
                    Address ClientA = new Address();

                    System.out.print("Enter Client's Info");
                    System.out.print("Enter Name: ");
                    String NameC = scanner.nextLine();
                    C.setName(NameC);
                    System.out.print("Enter Gender: ");
                    String genderC = scanner.nextLine();
                    C.setGender(genderC);
                    System.out.print("Enter Age: ");
                    int ageC = scanner.nextInt();
                    C.setAge(ageC);
                    scanner.nextLine();

                    System.out.println("Enter Client's Address: ");
                    System.out.print("Enter Country: ");
                    String CountryC = scanner.nextLine();
                    ClientA.setCountry(CountryC);
                    System.out.print("Enter City: ");
                    String CityC = scanner.nextLine();
                    ClientA.setCity(CityC);
                    System.out.print("Enter Street Number: ");
                    int NumC = scanner.nextInt();
                    ClientA.setStreetNum(NumC);
                    scanner.nextLine();
                    C.setAddress(ClientA);

                    System.out.println("Enter More Info on your Client");

                    System.out.print("Enter Clients' Cart: ");
                    String[] Cart = new String[5];
                    for (int i = 0; i < 5; i++) {
                        Cart[i] = scanner.nextLine();
                    }
                    C.setCart(Cart);
                    System.out.print("Is Client on list(True/False): ");
                    Boolean list = scanner.nextBoolean();
                    C.setLoyalList(list);
                    System.out.println("Enter Clients' Order Number: ");
                    int orderNum = scanner.nextInt();
                    C.setOrderID(orderNum);

                    try (
                            FileWriter file = new FileWriter("Clients.csv", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(file);
                            PrintWriter output = new PrintWriter(bufferedWriter)) {
                        output.println(C);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Displaying All Info Available: ");
                    File fileWorkers = new File("Workers.csv");
                    Scanner readWorkers = new Scanner(fileWorkers);
                    System.out.println("Workers List: ");
                    while (readWorkers.hasNext()) {
                        String Workers = readWorkers.nextLine();
                        System.out.println(Workers);
                    }

                    readWorkers.close();
                    System.out.println();

                    File fileClients = new File("Clients.csv");
                    Scanner readClients = new Scanner(fileClients);
                    System.out.println("Clients List: ");
                    while (readClients.hasNext()) {
                        String Clients = readClients.nextLine();
                        System.out.println(Clients);
                    }
                    readClients.close();
                    break;

                case 4:
                    System.out.print("Do you want to Modify a Workers' Info or Clients' Info?  ");
                    String answer = scanner.nextLine();

                    String[] arrayWorkers = new String[100];
                    String[] arrayClients = new String[100];

                    if (answer.equals("Worker")) {
                        File file = new File("Workers.csv");
                        Scanner input = new Scanner(file);

                        System.out.print("Which Worker do you want to modify (by number): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Please enter what you want to replace: ");
                        String oldString = scanner.nextLine();
                        System.out.print("Please enter new value: ");
                        String newString = scanner.nextLine();

                        while (input.hasNext()) {
                            arrayWorkers[count] = input.nextLine();
                            count++;
                        }
                        for (int i = 1; i <= count; i++) {
                            arrayWorkers[choice] = arrayWorkers[choice].replaceAll(oldString, newString);
                            try (
                                    FileWriter fileworker = new FileWriter("Workers.csv", true);
                                    BufferedWriter bufferedWriter = new BufferedWriter(fileworker);
                                    PrintWriter outputWorkers = new PrintWriter(bufferedWriter)) {
                                outputWorkers.println(arrayWorkers[i]);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        input.close();
                    } else if (answer.equals("Client")) {
                        System.out.print("Which Client do you want to modify (by number): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        File file = new File("Clients.csv");
                        Scanner input = new Scanner(file);

                        System.out.print("Please enter what you want to replace: ");
                        String oldString = scanner.nextLine();
                        System.out.print("Please enter new value: ");
                        String newString = scanner.nextLine();

                        while (input.hasNext()) {
                            arrayClients[count] = input.nextLine();
                            count++;
                        }
                        for (int i = 1; i <= count; i++) {
                            arrayClients[choice] = arrayClients[choice].replaceAll(oldString, newString);
                            try (
                                    FileWriter fileclient = new FileWriter("Clients.csv", true);
                                    BufferedWriter bufferedWriter = new BufferedWriter(fileclient);
                                    PrintWriter outputClients = new PrintWriter(bufferedWriter)) {
                                outputClients.println(arrayClients[i]);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        input.close();
                    }
                case 5:
                    System.out.println("Do you want to search for Worker Info or Client Info?  ");
                    String search = scanner.nextLine();
                    if (search.equals("Worker")) {
                        File file = new File("Workers.csv");
                        Scanner input = new Scanner(file);

                        System.out.print("Which Worker do you want to display the info: ");
                        String name = scanner.nextLine()+ ',';
                        while (input.hasNext()) {
                            String nameInfo = input.next();
                            String remainInfo = input.nextLine();
                            if (name.equals(nameInfo)) {
                                String Info = nameInfo + remainInfo;
                                System.out.println(Info);
                                break;
                            } else System.out.print("Person is not Available");
                        }
                        input.close();
                    } else if (search.equals("Client")) {
                        File file = new File("Clients.csv");
                        Scanner input = new Scanner(file);

                        System.out.print("Which Client do you want to display the info: ");
                        String name = scanner.nextLine()+ ',';
                        while (input.hasNext()) {
                            String nameInfo = input.next();
                            String remainInfo = input.nextLine();
                            if (name.equals(nameInfo)) {
                                String Info = nameInfo + remainInfo;
                                System.out.println(Info);
                                break;
                            } else System.out.print("Person is not Available");
                        }
                        input.close();
                    }
                    break;
                default:
                    continue;
            }
        }
        ChristmasTree christmasTree = new ChristmasTree();
    }
    static class ChristmasTree {
        public ChristmasTree() {
            int height = 6;
            for (int i = 1; i <= height; i++) {
                for (int j = height - i; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= i; k++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            for (int i = 1; i <= height / 2; i++) {
                System.out.print(" ");
                for (int j = height - 3; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = 2; k > 0; k--) {
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.print("Merry Christmas");
        }
    }
}