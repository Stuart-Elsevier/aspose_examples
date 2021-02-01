package com.mycompany.app;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;


public class convert_to_HTML {
        public static void main( String[] args) throws Exception
        {
            
            String dataDir = Utils.getDataDir(App.class);

            // Load the document from disk.
            Document doc = new Document(dataDir + "Revised manuscript with no changes marked.docx");

            // Save the document into HTML.
            doc.save(dataDir + "Document_out.html", SaveFormat.HTML);
    
    
    
    
            System.out.println("New Word document created successfully.");
       
    
        }
}


