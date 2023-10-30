package javasource;
import java.util.Scanner;
public class Main{
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
      
        System.out.println("--".repeat(30));
        System.out.println("\t\tNumber Guessing Game");
        System.out.println("\t\t\t\t   - wizard.x");
        System.out.println("--".repeat(30));
        System.out.println("Game Rules :- \n1) Every single game you get 8 chances.\n2)Find correctly the hidden number you got 30 points.\n3)Else you losse your all chances score decreases 15 points.\n4)Three dificullty modes are here \n5) Easy mode --> ranges from 0 to 100\n6)Meadium mode --> ranges from 0 to 200\n7)Hard mode --> ranges from 0 to 400");        
        System.out.println("--".repeat(30));
        
        System.out.print("Hi User! Please Enter your name : ");
        String name = scan.nextLine();
        User user = User.loginUser(name);
        System.out.println("Hello, "+user.getUserName()+"! Welcome to number guessing game.");
        System.out.println("--".repeat(30));
        System.out.println(user);
        System.out.println("--".repeat(30));
        boolean flag = true;
        while(flag){
            System.out.print("Select the difficullty mode [Easy, Medium, Hard] : ");
            char opt = scan.nextLine().charAt(0);
            play(opt,user);
            System.out.print("Play again [y / n] : ");
            char again = scan.nextLine().charAt(0);
            if(Character.toUpperCase(again) == 'Y'){
                flag = true;
            }else{
                flag = false;
            }
        }
        System.out.println("--".repeat(30));
        System.out.println(user);
        System.out.println("--".repeat(30));
        System.out.println("\t\t\t\t- wizard");

    }
    public static void play(char opt,User user){
        int range;
        switch (Character.toUpperCase(opt)) {
            case 'M' :
                range = 200;
                break;
            case 'H' :
                range = 400;
                break;
            default:
                range = 100;
                break;
        }
        Guess guess = new Guess(range);
        int hiddenNumber = guess.createNumber();
        int chance = 8;
        
        while(chance > 0){
            System.out.print("Enter your Guess number : ");
            int guessNum = scan.nextInt();
            if(guess.checkNumber(hiddenNumber, guessNum) > 0){
                System.out.println("Guess the number is smaller than the number!");
                chance-=1;
                System.out.println("remaining chances : "+chance);
            }else if(guess.checkNumber(hiddenNumber, guessNum) < 0){
                System.out.println("Guess the number is bigger than than the number!");
                chance-=1;
                System.out.println("remaining chances : "+chance);
            }else{
                System.out.println("Good jop! You found the answer!\nThe hidden number is "+guessNum); 
                user.modifyScore(30);   
                break;
            }
            if(chance == 0){
                System.out.println("Try again! The hiiden number is "+hiddenNumber);
                user.modifyScore(-15);
            }
        }
        System.out.println(user.getUserName() + " your score is "+user.getScore());
        scan.nextLine();
    }
}