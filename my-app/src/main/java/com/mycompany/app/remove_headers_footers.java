package com.mycompany.app;

import com.aspose.words.Document;
import com.aspose.words.Section;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.HeaderFooter;
import com.aspose.words.HeaderFooterType;

public class remove_headers_footers {
    public static void main(String[] args) throws Exception {

        

        com.aspose.words.License license = new com.aspose.words.License();
        license.setLicense("Aspose.Words.Java.lic");

        // Reads the document at location: aspose_examples/src/main/resources/com/mycompany/app/manipulate_doc/
        String dataDir = Utils.getDataDir(manipulate_document.class);
        Document doc = new Document(dataDir + "HeadFoot.docx");
        DocumentBuilder builder = new DocumentBuilder(doc);

        for (Section section : doc.getSections()) {
            // Up to three different footers are possible in a section (for first, even and odd pages).
            // We check and delete all of them.
            HeaderFooter footer;

            footer = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.HEADER_FIRST);
            if (footer != null)
                footer.remove();

            // Primary footer is the footer used for odd pages.
            footer = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.HEADER_PRIMARY);
            if (footer != null)
                footer.remove();

            footer = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.HEADER_EVEN);
            if (footer != null)
                footer.remove();
        }
        doc.save(dataDir + "HeadFoot.docx");
    }     

}