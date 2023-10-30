
import java.util.Random;

public class Guess{
    private int guessNumberRange;
    public Guess(int range){
        guessNumberRange = range;
    } 
    public Guess(){
        guessNumberRange = 100;
    }
    public int createNumber(){
        Random random = new Random();
        return random.nextInt(guessNumberRange);
    }
    public int checkNumber(int num,int hiddenNum){
        if(num<hiddenNum){
            return 1;
        }if(num>hiddenNum){
            return -1;
        }
        return 0;
    }
   
}