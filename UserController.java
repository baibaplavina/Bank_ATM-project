
import javax.swing.*;
import java.io.*;
import java.util.UUID;

public class UserController {

    public UserController() {
    }

    private User user;
    String fileName = "C:\\Users\\BaibaP\\IdeaProjects\\java_35_36_02\\BankAccountProject\\src\\main\\java\\bankRepository.csv";

    public void start() {
        String[] choice = {"LOGIN", "Create new user", "Exit"};
        int userChoice = JOptionPane.showOptionDialog(null, "Select action", "BANK ATM project", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, choice, null);

        if (userChoice == 0) {
            //Make login() and userCheck()
         JOptionPane.showMessageDialog(null, "section under construction", "BANK ATM project", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
        } else if (userChoice == 1) {
            createNewUser();
        } else {
            System.exit(0);
        }
    }

      private void createNewUser() {
        String name = getInfo("What is your name? ");
        System.out.println("Hi" + ", " + name);

        String userName = getInfo("Please type username: ");
        String password = getInfo("Please type password:  ");

        String gender = getInfo("What is your gender (male/female? ");
        while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            gender = getInfo("Please enter your gender (male/female? ");
        }

        UUID accountNo = UUID.randomUUID();
        System.out.println("Your account created successfully. Your account No is: " + accountNo);

        float balance = 0.0f;
        user = new User(name, userName, password, gender, accountNo, balance);

        // Format the data into a CSV string
        String csvData = user.toCSVString();

        //Write the CSV string to a file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true));
            writer.newLine();
            writer.write(csvData);
            writer.close();
            System.out.println("Data written to " + this.fileName);
        } catch (Exception e) {
            e.printStackTrace();
               System.out.println("Error writing to file : bankRepository.csv");
            }
    }

           public String getInfo (String message){
            return JOptionPane.showInputDialog(message);
        }

    }
