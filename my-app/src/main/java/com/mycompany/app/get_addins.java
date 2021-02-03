package com.mycompany.app;

import com.aspose.words.Document;
import com.aspose.words.Paragraph;
import com.aspose.words.Section;
import com.aspose.words.DocumentBuilder;
import java.io.File;
import java.nio.file.Path;

import com.aspose.words.Node;
import com.aspose.words.NodeCollection;
import com.aspose.words.Run;
import com.aspose.words.NodeType;
import com.aspose.words.CompositeNode;
import com.aspose.words.StructuredDocumentTag;
import com.aspose.words.SdtType;
import com.aspose.words.FieldType;
import com.aspose.words.FieldStart;
import com.aspose.words.FieldCollection;

import com.aspose.words.BookmarkStart;
import com.aspose.words.BookmarkEnd;
import com.aspose.words.BookmarkCollection;
import com.aspose.words.Bookmark;
import java.text.MessageFormat;
import com.aspose.words.VisitorAction;
import com.aspose.words.DocumentVisitor;
import java.util.Iterator;
import com.aspose.words.FieldAddIn;
import com.aspose.words.Field;
import com.aspose.words.FieldSeparator;
import com.aspose.words.FieldEnd;




public class get_addins {

    public static void fieldCollection(Document doc) throws Exception {
    
        // This collection stores all of a document's fields.
        FieldCollection fields = doc.getRange().getFields();
    
        // Iterate over the field collection, and print contents and type
        // of every field using a custom visitor implementation.
        //FieldVisitor fieldVisitor = new FieldVisitor();
    
        Iterator<Field> fieldEnumerator = fields.iterator();
    
        while (fieldEnumerator.hasNext()) {
            if (fieldEnumerator.next() != null) {
                Field currentField = fieldEnumerator.next();
    
                currentField.getStart();
                System.out.println(currentField.getStart());
                //System.out.println(currentField.getFieldCode());
                if (currentField.getSeparator() != null) {
                    System.out.println(currentField.getSeparator());
                    System.out.println(currentField.getType()); // FieldType 81 is ADDIN
                    if (currentField.getType() == 81){ // addin
                        System.out.println(currentField.getType());
                        System.out.println(currentField.getResult());
                        System.out.println(currentField.getFieldCode());
                    }
                }
                //System.out.println(currentField.getResult());
                currentField.getEnd();
            } else {
                System.out.println("There are no fields in the document.");
            }
        }
        //System.out.println(currentField.getDisplayResult());

        //System.out.println(fieldVisitor.getText());
    }



    public static void recurseAllNodes(String dataDir) throws Exception {
        // Open a document
        Document doc = new Document(dataDir + "Revised manuscript with no changes marked.docx");
        // Invoke the recursive function that will walk the tree.
        traverseAllNodes(doc);
    }
    
    /**
     * A simple function that will walk through all children of a specified node
     * recursively and print the type of each node to the screen.
     */
    public static void traverseAllNodes(CompositeNode parentNode) throws Exception {
        // This is the most efficient way to loop through immediate children of a node.
        for (Node childNode = parentNode.getFirstChild(); childNode != null; childNode = childNode.getNextSibling()) {
            // Do some useful work.
            System.out.println(Node.nodeTypeToString(childNode.getNodeType()));
            if (childNode.getNodeType() == NodeType.RUN) {

                Run run = (Run) childNode;
                System.out.println(run.getText());
                if (childNode.getNextSibling() != null){
                Node siblingNode = run.getNextSibling();
                    System.out.println("THIS IS A SIBLING");
                    System.out.println(siblingNode);
                    siblingNode.getNodeType();
                    System.out.println("ENDDDD");
                    // get Type - what is add in type
              }
          }
            if (childNode.getNodeType() == NodeType.BOOKMARK_START) {

            }

            
            // Recurse into the node if it is a composite node.
            if (childNode.isComposite())
                traverseAllNodes((CompositeNode) childNode);
        }
    }



    public static void main(String[] args) throws Exception {


        com.aspose.words.License license = new com.aspose.words.License();
        license.setLicense("Aspose.Words.Java.lic");

        // Reads the document at location: aspose_examples/src/main/resources/com/mycompany/app/manipulate_doc/
        String dataDir = Utils.getDataDir(manipulate_document.class);
        Document doc = new Document(dataDir + "Revised manuscript with no changes marked.docx");

        //recurseAllNodes(dataDir);
        BookmarkCollection bookmarks = doc.getRange().getBookmarks();
        fieldCollection(doc);


        // Prints the document structure for falt finding and understanding what types are what
        //BookmarkCollection bookmarks = doc.getRange().getBookmarks();
        

        //Document doc = new Document(getMyDir() + "Field sample - ADDIN.docx");

        // Aspose.Words does not support inserting ADDIN fields, but we can still load and read them.
        //FieldAddIn field = (FieldAddIn) doc.getRange().getFields().get(0);
        //field.getFieldCode();
        
        //Assert.assertEquals(" ADDIN \"My value\" ", field.getFieldCode());


            
    }
    
}

/*
TO DO
-1 Print the citation contents to HTML document
-2 The current Field iteration doesnt get all the citations, incorporate getSibling code to see if siblings are missing?
-3 Combine getSibling code and getfield code into one method?? is this possible?
*/


/*
// REMOVE???
// This is the most efficient way to loop through immediate children of a node.
for (Node childNodeSecond = parentNode.getFirstChild(); childNodeSecond != null; childNodeSecond = childNodeSecond.getNextSibling()) {
    // Do some useful work.
    System.out.println(Node.nodeTypeToString(childNodeSecond.getNodeType()));
    if childNodeSecond.getNodeType() == NodeType.
    // Recurse into the node if it is a composite node.
    if (childNodeSecond.isComposite())
        traverseAllNodes((CompositeNode) childNodeSecond);
    }
    
*/
