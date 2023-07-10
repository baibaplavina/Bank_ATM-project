import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TransactionController {

    private float balance;
    private final String fileName = "C:\\Users\\BaibaP\\IdeaProjects\\java_35_36_02\\BankAccountProject\\src\\main\\java\\bankRepository.csv";

    public void transactionController() {
        String[] choices = {"Deposit money", "Withdraw money", "Display balance", "Exit"};
        int userTransactionChoice = JOptionPane.showOptionDialog(null, "Select Transaction", "Transaction panel", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, choices, null);
        System.out.println(userTransactionChoice);


        switch (userTransactionChoice) {
            case 0:
                //Deposit money
                depositMoney();
                break;
            case 1:
                //"Withdraw money"
                withdrawMoney();
                break;
            case 2:
                // "Display balance"
                displayBalance();
                break;
            case 3:
                //Exit
                JOptionPane.showMessageDialog(null, "Thank you for using our services! Good bye!");
                System.exit(0);
                break;
            default:
                // getInfo("Please make your choice by pressing buttons");

                break;
        }
        transactionController();

    }

    private void displayBalance() {
        JOptionPane.showMessageDialog(null, "Your current balance is: " + balance);
    }

    private void withdrawMoney() {
           float userWithDraw = Float.parseFloat(JOptionPane.showInputDialog("Please input withdraw amount", null));
            balance -= userWithDraw;
            String csvData = String.format("%f", (float) balance);
              try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true));
                writer.write(csvData);
                writer.close();
                System.out.println("Data written to " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error writing to file: " + fileName);
            } catch (NumberFormatException e) {
                System.out.println("Invalid deposit amount");
            }

    }

    private void depositMoney() {
        float userDeposit = Float.parseFloat(JOptionPane.showInputDialog("Please input deposit amount", null));
        balance += userDeposit;
        String csvData = String.format("%f", (float) balance);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true));
            writer.write(csvData);
            writer.close();
            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to file: " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Invalid deposit amount");
        }

    }
}
