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


public class expand_references {
    

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


        // Prints the document structure for falt finding and understanding what types are what
        recurseAllNodes(dataDir);



        /*
        Paragraph paragraph = (Paragraph) doc.getChild(NodeType.PARAGRAPH, 0, true);

        NodeCollection children = paragraph.getChildNodes();
        for (Node child : (Iterable<Node>) children) {
            System.out.println(child);
            System.out.println(child.getNodeType());

            */
            
    }
}




// To Do
// 1. Currently able to see if childNode is Run, do something.
    // Should be able to see if childNode is reference
    // Find out what nodetype reference is
// 2. 