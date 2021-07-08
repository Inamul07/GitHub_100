import java.lang.Math;
import java.util.*;
public class rockPaperScissors {
    static String result(String[] choice, String usrChoice, String compChoice) {
        String result = "";
        if(usrChoice.equals(choice[0])) {
            if(compChoice.equals(choice[0]))
                result = "Tie";
            else if(compChoice.equals(choice[1]))
                result = "Lose";
            else if(compChoice.equals(choice[2]))
                result = "Win";
        } else if(usrChoice.equals(choice[1])) {
            if(compChoice.equals(choice[1]))
                result = "Tie";
            else if(compChoice.equals(choice[0]))
                result = "Win";
            else if(compChoice.equals(choice[2]))
                result = "Lose";
        } else if(usrChoice.equals(choice[2])) {
            if(compChoice.equals(choice[2]))
                result = "Tie";
            else if(compChoice.equals(choice[1]))
                result = "Win";
            else if(compChoice.equals(choice[0]))
                result = "Lose";
        } else
            result = "Invalid";
        return result;
        
    }

    static void play(String[] choice, int usrScore, int compScore) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ur choice: ");
        String usrChoice = sc.nextLine().toLowerCase();
        int random = (int) Math.floor(Math.random() * 3);
        String compChoice = choice[random];
        System.out.println("Computer choice: " + compChoice);
        String result = result(choice,  usrChoice, compChoice);
        if(result.equals("Win")) {
            System.out.println("You Win!!");
            usrScore += 1;
        } else if(result.equals("Lose")) {
            System.out.println("You Lose ");
            compScore += 1;
        } else if(result.equals("Tie"))
            System.out.println("It is a Tie");
        else
            System.out.println(result);
        System.out.println("Your Score: " + usrScore + "\tComputer Score: " + compScore);
        System.out.print("Do you want to play again (Y/N): ");
        Character ch = sc.next().charAt(0);
        if(ch == 'Y')
            play(choice, usrScore, compScore);
        else {
            if(usrScore > compScore)
                System.out.println("You Won The Match");
            else
                System.out.println("You Lost The Match");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] choice = {"rock", "paper", "scissor"};
        int usrScore = 0, compScore  = 0;
        play(choice, usrScore, compScore);
        sc.close();
    }
}