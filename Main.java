public class Main {

    public static void main(String[] args) {

        UserController userController = new UserController();
        userController.start();

        TransactionController transactionController = new TransactionController();
        transactionController.transactionController();
    }
}
