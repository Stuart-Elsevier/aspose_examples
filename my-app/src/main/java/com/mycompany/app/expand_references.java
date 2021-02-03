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
import com.aspose.words.BookmarkStart;
import com.aspose.words.BookmarkEnd;
import com.aspose.words.BookmarkCollection;
import com.aspose.words.Bookmark;
import java.text.MessageFormat;
import com.aspose.words.VisitorAction;
import com.aspose.words.DocumentVisitor;
import java.util.Iterator;



public class expand_references {
    
    /// <summary>
    /// Use an iterator and a visitor to print info of every bookmark in the collection.
    /// </summary>
    private static void printAllBookmarkInfo(BookmarkCollection bookmarks) throws Exception {
        BookmarkInfoPrinter bookmarkVisitor = new BookmarkInfoPrinter();

        // Get each bookmark in the collection to accept a visitor that will print its contents.
        Iterator<Bookmark> enumerator = bookmarks.iterator();

        while (enumerator.hasNext()) {
            Bookmark currentBookmark = enumerator.next();

            if (currentBookmark != null) {
                currentBookmark.getBookmarkStart().accept(bookmarkVisitor);
                currentBookmark.getBookmarkEnd().accept(bookmarkVisitor);

                System.out.println(currentBookmark.getBookmarkStart().getText());
            }
        }
    }

    /// <summary>
    /// Prints contents of every visited bookmark to the console.
    /// </summary>
    public static class BookmarkInfoPrinter extends DocumentVisitor {
        public int visitBookmarkStart(BookmarkStart bookmarkStart) throws Exception {
            System.out.println(MessageFormat.format("BookmarkStart name: \"{0}\", Content: \"{1}\"", bookmarkStart.getName(),
                    bookmarkStart.getBookmark().getText()));
            return VisitorAction.CONTINUE;
        }

        public int visitBookmarkEnd(BookmarkEnd bookmarkEnd) {
            System.out.println(MessageFormat.format("BookmarkEnd name: \"{0}\"", bookmarkEnd.getName()));
            return VisitorAction.CONTINUE;
        }
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


        // Prints the document structure for falt finding and understanding what types are what
        recurseAllNodes(dataDir);
        BookmarkCollection bookmarks = doc.getRange().getBookmarks();
        printAllBookmarkInfo(bookmarks);


            
    }
}




// To Do
// 1. Currently able to see if childNode is Run, do something.
    // Should be able to see if childNode is reference
    // Find out what nodetype reference is
        // Is this the Nodetype: ADDIN EN.REFLIST 
// 2. Are references stored in Bookmarks
    // get already created bookmarks and see if they have different names or values


/* To do:
- App file should contain main method!!! This may stop individual files being run? Is this a good thing?
- Remove TOC
- Can I traverse the whole document?
    - switching child elements?
*/


/*
Paragraph paragraph = (Paragraph) doc.getChild(NodeType.PARAGRAPH, 0, true);

NodeCollection children = paragraph.getChildNodes();
for (Node child : (Iterable<Node>) children) {
    System.out.println(child);
    System.out.println(child.getNodeType());

    */