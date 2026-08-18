package chatbot.cv;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CvReader {

    public static void main(String[]args) throws IOException{
        File file = new File("C:/Users/Yağmur/OneDrive/Desktop/Yeni klasör (2)/Yağmur_Erocağı_CV.pdf");

        try (PDDocument document = Loader.loadPDF(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            System.out.println(text);

            List <String> knownHeaders = List.of("PROFILE", "PROFESSIONAL EXPERIENCE", "EDUCATION", "SKILLS", "LANGUAGES", "CERTIFICATES", "PROJECTS");

            Map<String,StringBuilder> sections = new HashMap<>();
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


        }

    }
    
}
