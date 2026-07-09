package chatbot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import opennlp.tools.tokenize.SimpleTokenizer;

public class Chatbot {
    HashMap <String,String> shortCuts = new HashMap<> ();
    ArrayList<String> elements = new ArrayList<>();
    ArrayList<String> positiveWords = new ArrayList<>();
    ArrayList<String> negativeWords = new ArrayList<>();

    Random random = new Random();
    SimpleTokenizer sTokenizer = new SimpleTokenizer();

public Chatbot(){
    elements.add("Sorry, I couldn't understand!");
    elements.add("Could you explain that differently?");
    elements.add("Hmm, interesting...");
    elements.add("I'm not sure what you mean.");
    

    positiveWords.add("happy");
    positiveWords.add("good");
    positiveWords.add("awesome");
    positiveWords.add("great");

    negativeWords.add("sad");
    negativeWords.add("angry");
    negativeWords.add("bad");
    negativeWords.add("terrible");

    shortCuts.put("hello", "Hey there! Nice to see you.How can i help you?");
    shortCuts.put("how are you?", "I'm a chatbot, but let's say I'm doing great today!");
    
}
    public String getResponse(String input){
        int randomIndex = random.nextInt(elements.size());
        String input2 = input.toLowerCase();
        input2 = input2.trim();
        String[] split = sTokenizer.tokenize(input2);

        if(shortCuts.containsKey(input2)){
            return shortCuts.get(input2);
        }
        
        for(String i : split){
            if(negativeWords.contains(i)){
                return("I'm sorry that you're in a bad mood right now!");
            }else if(positiveWords.contains(i)){
                return("I'm happy to hear that you're good :)");
            }else if(negativeWords.contains(i) && positiveWords.contains(i)){
                return("I couldn't understand what you're trying to mean :(");
            }
        } 
        return (elements.get(randomIndex)); 
  }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public ArrayList<String> getElements() {
        return elements;
    }
}
