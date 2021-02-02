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
import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;






public class manipulate_document {
    /*

    private void remove_toc(Document document) {

        
        
        // First remove complete gallery objects
        NodeCollection<StructuredDocumentTag> sdtCollection = document.getChildNodes(NodeType.STRUCTURED_DOCUMENT_TAG,
            true);

        sdtCollection.forEach((StructuredDocumentTag tag) -> {
            if (tag.getSdtType() == SdtType.DOC_PART_OBJ || tag.getSdtType() == SdtType.BUILDING_BLOCK_GALLERY) {
                if (tag.getBuildingBlockGallery().equals("Table of Contents")) {
                    try {
                        tag.remove();
                    } catch (Exception e) {
                        LOGGER.error("Error in remove_toc", e);
                    }
                }
            }
        });
        

        // Now remove toc outside galleries
        NodeCollection<FieldStart> shapeCollection = document.getChildNodes(NodeType.FIELD_START, true);

        shapeCollection.forEach((FieldStart field_start) -> {
            if (field_start.getFieldType() == FieldType.FIELD_TOC) {
                try {
                    field_start.getField().remove();
                } catch (Exception e) {
                    LOGGER.error("Error in remove_toc", e);
                }
            }
        });

    }


*/

    //private static Document remove_toc(Document document) {
    public static void remove_toc(Document document) {
        // First remove complete gallery objects
        NodeCollection<StructuredDocumentTag> sdtCollection = document.getChildNodes(NodeType.STRUCTURED_DOCUMENT_TAG,
            true);

        sdtCollection.forEach((StructuredDocumentTag tag) -> {
            if (tag.getSdtType() == SdtType.DOC_PART_OBJ || tag.getSdtType() == SdtType.BUILDING_BLOCK_GALLERY) {
                if (tag.getBuildingBlockGallery().equals("Table of Contents")) {
                    try {
                        tag.remove();
                    } catch (Exception e) {
                        System.out.println("Error in remove_toc");
                    }
                }
            }
        });


        // Now remove toc outside galleries
        NodeCollection<FieldStart> shapeCollection = document.getChildNodes(NodeType.FIELD_START, true);

        shapeCollection.forEach((FieldStart field_start) -> {
            if (field_start.getFieldType() == FieldType.FIELD_TOC) {
                try {
                    field_start.getField().remove();
                } catch (Exception e) {
                    System.out.println("Error in remove_toc");
                }
            }
        });
        //return document;
    }
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
    
        

        //int type = doc.getNodeType();

    
        /*
        The following code example shows how to enumerate immediate child nodes
        of a CompositeNode using the enumerator provided by the ChildNodes collection:
        */
        
        Paragraph paragraph = (Paragraph) doc.getChild(NodeType.PARAGRAPH, 0, true);

        NodeCollection children = paragraph.getChildNodes();
        for (Node child : (Iterable<Node>) children) {
            
        // Paragraph may contain children of various types such as runs, shapes and so on.
        if (child.getNodeType() == NodeType.RUN) {

        // Say we found the node that we want, do something useful.
            Run run = (Run) child;
            System.out.println(run.getText());
            }
        if (child.getNodeType() == NodeType.HEADER_FOOTER) {
            child.remove();
        }
    }

        //String dataDir2 = Utils.getSharedDataDir(manipulate_doc.class);
        
        //recurseAllNodes(dataDir);
        //traverseAllNodes(dataDir2);

        // recurseAllNodes(doc);

        remove_toc(doc);
        NodeCollection comments = doc.getChildNodes(NodeType.GLOSSARY_DOCUMENT, true);
        comments.clear();
        //DocumentBuilder builder = new DocumentBuilder(doc);
        doc.save(dataDir + "Name the document.docx");



    }
    
}