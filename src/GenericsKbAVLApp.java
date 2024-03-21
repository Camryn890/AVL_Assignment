import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

/**
 * A class using an AVL tree to manage the data supplied
 */
public class GenericsKbAVLApp {

    /**
     * The AVL tree that stores Origin objects.
     */
    public AVLTree<Origin> tree = new AVLTree<>();

    /**
     * Reads the data of the file and makes an AVL tree
     * @param file The name of the file containing data
     */
    public void MakeTree(String file)
    {
        try {
            Scanner files = new Scanner(new File(file));
            while (files.hasNextLine()) {
                
                files.useDelimiter("\t");
                String term = files.next();

                String sentence = files.next();

                files.useDelimiter("\\n");
                float score = Float.parseFloat(files.next());

                Origin result = new Origin(term, sentence, score);

                tree.insert(result);
                files.nextLine();

            }
            files.close();
        }
        catch(FileNotFoundException e) 
        {
            System.out.println("Please try again.");
            System.exit(0);
        }
    }

    /**
     * Searches if items in specified file is in the AVL tree
     * If an item is found its details are printed out or if the item isn't found it is inserted into the AVL tree
     * @param file The name of the file containing the items that are searched for in the AVL tree
     */
    public void searchItem(String file)
    {
        int counts = 0;
        try {
            File files = new File(file);
            Scanner filename = new Scanner(files);
            while(filename.hasNextLine())
            {
                counts++;
                if(counts==10){break;}
                if(filename.hasNext()){
                    String item = filename.next();
                    Origin search = new Origin(item,null,0);
                    BinaryTreeNode<Origin> found = tree.find(search);
                    if(found != null)
                    {
                        System.out.println(found.getData().getTerm() +": " + found.getData().getSentence() + "(" + found.getData().getScore()+")");
                    }
                    else{System.out.println("Item not found : " + item); tree.insert(search);}
                }
            }
            filename.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Please try again.");
            System.exit(0);
        }
    }

    /**
     * Prints the counts of insertions and finds that are performed in the AVL tree
     * Resets the counters to zero
     */
    public void counters(){System.out.println("insert: " + AVLTree.counter +1); System.out.println("find: "+ AVLTree.count+1); AVLTree.counter = 0; AVLTree.count = 0; }
}
