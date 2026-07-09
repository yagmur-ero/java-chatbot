package chatbot;
import java.util.Scanner;


public class main {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Chatbot bot = new Chatbot();

        while(true){
        System.out.println("You: ");
        String input = sc.nextLine();

        if(input.equalsIgnoreCase("Exit" )|| 
        input.equalsIgnoreCase("Quit") || 
        input.equalsIgnoreCase("Bye") || 
        input.equalsIgnoreCase("Goodbye")){
        System.out.println("The program is ending...");
        break;
        }else{
        String answer = bot.getResponse(input);
        System.out.println("Bot: " + answer);
        }
}
 sc.close();
}
}