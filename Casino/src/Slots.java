import java.util.Random;
public class Slots {
    String firstLine[];
    String secondLine[];
    String thirdLine[];

    public Slots(){
        setFirstLine();
        setSecondLine();
        setThirdLine();

    }


    public void setFirstLine() {
        String[] firstLine = new String[3];
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            int b = rand.nextInt(0,5);
            switch(b){
                case 2:
                    firstLine[i] = "@";
                    break;
                case 3:
                    firstLine[i] = "#";
                    break;
                case 4:
                    firstLine[i] = "€";
                    break;
                case 5:
                    firstLine[i] = "ß";
                    break;
                default:
                    firstLine[i] = "$";
                    break;
            }
        }
        this.firstLine = firstLine;
    }
    public void setSecondLine() {
        String[] secondLine = new String[3];
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            int b = rand.nextInt(0,5);
            switch(b){
                case 2:
                    secondLine[i] = "@";
                    break;
                case 3:
                    secondLine[i] = "#";
                    break;
                case 4:
                    secondLine[i] = "€";
                    break;
                case 5:
                    secondLine[i] = "ß";
                    break;
                default:
                    secondLine[i] = "$";
                    break;
            }
        }
        this.secondLine = secondLine;
    }
    public void setThirdLine() {
        String[] thirdLine = new String[3];
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            int b = rand.nextInt(0,5);
            switch(b){
                case 2:
                    thirdLine[i] = "@";
                    break;
                case 3:
                    thirdLine[i] = "#";
                    break;
                case 4:
                    thirdLine[i] = "€";
                    break;
                case 5:
                    thirdLine[i] = "ß";
                    break;
                default:
                    thirdLine[i] = "$";
                    break;
            }
        }
        this.thirdLine = thirdLine;
    }
    public void printSlots(){
        System.out.println("---------");
        System.out.println("- " + firstLine[0] + " " +firstLine[1] + " " + firstLine[2] + " -");
        System.out.println("- " + secondLine[0] + " " + secondLine[1] + " " + secondLine[2]+ " -");
        System.out.println("- " + thirdLine[0] + " " + thirdLine[1] + " " + thirdLine[2]+ " -");
        System.out.println("---------");
    }
    public void checkWins(Account user){
        if(firstLine[0].equals(firstLine[1]) && firstLine[0].equals(firstLine[2])){
            System.out.println("First line hit!!!");
            int winnerFirst = checkSign(firstLine[0]);
            System.out.println("You have won " + winnerFirst);
            user.inputMoney(winnerFirst);
        }
        if(secondLine[0].equals(secondLine[1]) && secondLine[0].equals(secondLine[2])){
            System.out.println("Second line hit!!!");
            int winnerSecond = checkSign(secondLine[0]);
            System.out.println("You have won " + winnerSecond);
            user.inputMoney(winnerSecond);
        }
        if(thirdLine[0].equals(thirdLine[1]) && thirdLine[0].equals(thirdLine[2])){
            System.out.println("Third line hit!!!");
            int winnerThird = checkSign(thirdLine[0]);
            System.out.println("You have won " + winnerThird);
            user.inputMoney(winnerThird);
        }
        if(firstLine[0].equals(secondLine[1]) && firstLine[0].equals(thirdLine[2])){
            System.out.println("Down diagonal line hit!!!");
            int winnerFourth = checkSign(thirdLine[2]);
            System.out.println("You have won " + winnerFourth);
            user.inputMoney(winnerFourth);
        }
        if(thirdLine[0].equals(secondLine[1]) && thirdLine[0].equals(firstLine[2])){
            System.out.println("Up diagonal line hit!!!");
            int winnerFifth = checkSign(thirdLine[0]);
            System.out.println("You have won " + winnerFifth);
            user.inputMoney(winnerFifth);
        }
        if(firstLine[0].equals(secondLine[0]) && thirdLine[0].equals(firstLine[0])){
            System.out.println("First row line hit!!!");
            int winnerSixth = checkSign(thirdLine[0]);
            System.out.println("You have won " + winnerSixth);
            user.inputMoney(winnerSixth);
        }
        if(firstLine[1].equals(secondLine[1]) && thirdLine[1].equals(firstLine[1])){
            System.out.println("Second row line hit!!!");
            int winnerSeventh = checkSign(thirdLine[1]);
            System.out.println("You have won " + winnerSeventh);
            user.inputMoney(winnerSeventh);
        }
        if(firstLine[2].equals(secondLine[2]) && thirdLine[2].equals(firstLine[2])){
            System.out.println("Third row line hit!!!");
            int winnerEight = checkSign(thirdLine[2]);
            System.out.println("You have won " + winnerEight);
            user.inputMoney(winnerEight);
        }
    }
    public int checkSign(String sign){
        switch(sign){
            case "@":
                return 500;
            case "#":
                return 1000;
            case "€":
                return 1500;
            case "ß":
                return 2000;
            case "$":
                return 2500;
            default:
                return 0;
        }

    }
}
