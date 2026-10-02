package chatbot.cv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CvReader {

    public static void main(String[]args) throws IOException{
          if (args.length == 0) {
            System.out.println("Usage: CVReader <pdf-path>");
            return;
        }
        File file = new File(args[0]);
          if(!file.exists()){
                System.out.println("There is no files that i can check!");
                return;
            }
        
        try (PDDocument document = Loader.loadPDF(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            System.out.println(text);

            List <String> knownHeaders = List.of("PROFILE", "PROFESSIONAL EXPERIENCE", "EDUCATION", "SKILLS", "LANGUAGES", "CERTIFICATES", "PROJECTS", "AWARDS");

            Map<String,StringBuilder> sections = new HashMap<>();
            ArrayList <String> missingHeaders = new ArrayList<> ();
            ArrayList <String> weakSections = new ArrayList<>();
            String currentSection = null;

            for(String line : text.split("\n")){
                String trimmed = line.trim();
                if(knownHeaders.contains(trimmed)){
                    currentSection =trimmed;
                    sections.put(currentSection, new StringBuilder());
                } else if (currentSection != null){
                    sections.get(currentSection).append(line).append("\n");
                }
            }

            for(String header : knownHeaders){
                if(!sections.containsKey(header)){
                    missingHeaders.add(header);
                }
            }
            System.out.println("The missing parts in your CV: "+ missingHeaders);

            for(String key:sections.keySet()){
                if(sections.get(key).length()<50){
                    weakSections.add(key);
                }
            }
            System.out.println("These sections are too short: " + weakSections);
        }

    }
    
}
