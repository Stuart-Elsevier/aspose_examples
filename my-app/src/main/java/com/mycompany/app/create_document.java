package com.mycompany.app;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;

public class create_document 
{
    public static void main( String[] args) throws Exception
    {
        com.aspose.words.License license = new com.aspose.words.License();
        license.setLicense("Aspose.Words.Java.lic");
        String dataDir = Utils.getDataDir(App.class);
        // Open the document.
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        builder.writeln("Enter Text for the new document");
        
        // Save document at: aspose_examples/src/main/resources/com/mycompany/app/manipulate_document/
        doc.save(dataDir + "Name the document.docx");




        System.out.println("New Word document created successfully.");
   

    }
}
