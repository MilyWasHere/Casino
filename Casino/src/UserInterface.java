import java.util.Scanner;
import java.util.ArrayList;
public class UserInterface {

    private Scanner scan;
    private Account user;
    public UserInterface(Scanner scanner, Account u){
        this.scan = scanner;
        this.user = u;

    }
    public void start(){
        while(true){
            menu();
            String choice = scan.nextLine();
            switch(choice){
                case "1"://Blackjack game
                    blackjack();
                    break;
                case "2"://Slots game
                    slots();
                    break;
                case "3"://Account manager
                    accountManager();
                    break;
                case "4"://Exit program
                    System.exit(0);

            }


        }
    }
    public void menu(){
        System.out.println("#################################");
        System.out.println("#          1 - Blackjack        #");
        System.out.println("#          2 - Slots            #");
        System.out.println("#          3 - Account          #");
        System.out.println("#          4 - Exit             #");
        System.out.println("#################################");
    }
    public void slots(){
        if(user.getName().equals("")){
            System.out.println("Please make an account.");
            System.out.println("Press enter to return to start");
            String n = scan.nextLine();
            start();
        }
        if(!user.checkMoney(50)){
            System.out.println("#################################");
            System.out.println("       HAHA YOU ARE BROKE!!");
            System.out.println("#################################");
            start();
        }
        System.out.println("50 money to play");
        System.out.println("Continue? y - n");
        String choice = scan.nextLine();
        switch (choice){
            case "y":
                break;
            default:
                start();
                break;
        }
        Slots b = new Slots();
        b.printSlots();
        b.checkWins(user);
        System.out.println("Press enter to continue...");
        scan.nextLine();
        start();
    }
    public void blackjack(){
        if(user.getName().equals("")){
            System.out.println("Please make an account.");
            System.out.println("Press enter to return to start");
            String n = scan.nextLine();
            start();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("#################################");
        System.out.println("    How much do you wonna bet?   ");
        System.out.println("#################################");
        double moneyBet = scan.nextDouble();
        if(!user.checkMoney(moneyBet)){
            System.out.println("#################################");
            System.out.println("       HAHA YOU ARE BROKE!!");
            System.out.println("#################################");
            start();
        }
        Deck ofCards = new Deck();
        ofCards.shuffle();
        int dealer = 0;
        int player = 0;
        System.out.println("#################################");
        Card first = ofCards.draw();
        System.out.println("The dealer has drawn " + first.data());
        dealer += first.getValue();
        first = ofCards.draw();
        System.out.println("The dealer has drawn " + first.data());
        dealer += first.getValue();
        System.out.println("The dealer has a total of " + dealer);
        first = ofCards.draw();
        System.out.println("You have drawn " + first.data());
        player += first.getValue();

        while(dealer <= 21 && player < 21){
            menuAlt(dealer, player);
            System.out.println("Do you wish to draw more? y - n");
            String choice = scan.nextLine();
            if(choice.equals("y")){
                first = ofCards.draw();
                System.out.println("You have drawn " + first.data());
                player += first.getValue();
            }else if(choice.equals("n")){
                break;
            }else{
                System.out.println("Unknown input!");
            }
        }
        while(player > dealer && player <= 21){
            first = ofCards.draw();
            menuAlt(dealer, player);
            System.out.println("The dealer has drawn " + first.data());
            dealer += first.getValue();
            if(dealer >= 21){
                break;
            }
        }
        menuAlt(dealer, player);
        //this part i should fix later, the code here is shit, idk why im adding the player <= 21
        //when i coulda just added the first one be (if player > 21, i feel like shit today
        if(player > 21){
            System.out.println("You have lost!");
            user.removeMoney(moneyBet);
        }else if(dealer > 21){
            System.out.println("You have won!");
            user.inputMoney(moneyBet);
        }else if(player > dealer){
            System.out.println("You have won!");
            user.inputMoney(moneyBet);
        }else if(player == dealer){
            System.out.println("It's a draw!");
        }else{
            System.out.println("You have lost!");
            user.removeMoney(moneyBet);
        }
        System.out.println("#################################");
        System.out.println("      Wonna play again? y - n    ");
        System.out.println("#################################");
        String newChoice = scan.nextLine();
        while(true){
            if(newChoice.equals("y") || newChoice.equals("n")){
                break;
            }
            System.out.println("Unknown input");
            newChoice = scan.nextLine();
        }
        if(newChoice.equals("y")){
            blackjack();
        }else{
            start();
        }



    }
    public void menuAlt(int d, int p){
        System.out.println("#################################");
        System.out.println("        Dealer - " + d);
        System.out.println("           You - " + p);
        System.out.println("#################################");

    }
    public void accountManager(){
        if(user.getId() == 0){
            user.setUsername();
            user.setPassword();
            user.setid();
        }
        System.out.println("#################################");
        System.out.println("#                               #");
        System.out.println("#         1 - Deposit Money     #");
        System.out.println("#         2 - Check Balance     #");
        System.out.println("#         3 - Return            #");
        System.out.println("#################################");
        String choice = scan.nextLine();
        switch(choice){
            case "1":
                userMoneyDeposit();
            case "2":
                checkUserMoney();
            case "3":
                start();
            default:
                accountManager();
        }
    }
    public void userMoneyDeposit(){
        System.out.println("#################################");
        System.out.println("#                               #");
        System.out.println("#       Input the desired       #");
        System.out.println("#             amount.           #");
        System.out.println("#                               #");
        System.out.println("#################################");
        int amount = Integer.valueOf(scan.nextLine());
        user.inputMoney(amount);
        System.out.println("You have added "+ amount + " to the account.");
        System.out.println("Spend with care.");
        start();

    }
    public void checkUserMoney(){
        System.out.println("#################################");
        System.out.println("");
        System.out.println("Account name - " + user.getName() );
        System.out.println("Balance - " + user.getMoney());
        System.out.println(" Press enter to return to start");
        System.out.println("#################################");
        String n = scan.nextLine();
        start();
    }

}
