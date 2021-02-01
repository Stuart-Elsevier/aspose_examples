package com.mycompany.app;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

/*
For simple conversion to HTML, MHTML, or EPUB, one of the Save method overloads is used. 
You can save the document to a file or stream and explicitly set the output document save format or define it from the file name extension.

The following example shows how to convert DOCX to HTML with specifying a save format:
*/



public class convert_to_HTML {
        public static void main( String[] args) throws Exception
        {
            
            // current class dir
            String dataDir = Utils.getDataDir(App.class);

            // Load the document from disk.
            Document doc = new Document(dataDir + "Revised manuscript with no changes marked.docx");

            // Save the document into HTML.
            doc.save(dataDir + "Document_out.html", SaveFormat.HTML);
    
    
    
    
            System.out.println("New Word document created successfully.");
       
    
        }
}


