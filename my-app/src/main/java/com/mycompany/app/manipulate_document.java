package com.mycompany.app;

import com.aspose.words.Document;
import com.aspose.words.Node;
import com.aspose.words.NodeType;
import com.aspose.words.CompositeNode;


public class manipulate_document {

    public static void recurseAllNodes(Document doc) throws Exception {
        // Open a document
        // ORIGINAL - Replaced WITH THE BELOW - Document doc = new Document(dataDir + "Node.RecurseAllNodes.doc");
        //Document doc = new Document(dataDir + "Revised manuscript with no changes marked.docx");
        // Invoke the recursive function that will walk the tree.
        traverseAllNodes(doc);
    }

    public static void traverseAllNodes(CompositeNode parentNode) throws Exception {
        // This is the most efficient way to loop through immediate children of a node.
        for (Node childNode = parentNode.getFirstChild(); childNode != null; childNode = childNode.getNextSibling()) {
            // Do some useful work.
            System.out.println(Node.nodeTypeToString(childNode.getNodeType()));
        
            // Recurse into the node if it is a composite node.
            if (childNode.isComposite())
                traverseAllNodes((CompositeNode) childNode);
            }
        }
    
    public static void main(String[] args) throws Exception {

        // Set the licence
        com.aspose.words.License license = new com.aspose.words.License();
        license.setLicense("Aspose.Words.Java.lic");

        // Reads the document at location: aspose_examples/src/main/resources/com/mycompany/app/manipulate_doc/
        String dataDir = Utils.getDataDir(manipulate_document.class);
        Document doc = new Document(dataDir + "Revised manuscript with no changes marked.docx");

        recurseAllNodes(doc);


    }
    
}