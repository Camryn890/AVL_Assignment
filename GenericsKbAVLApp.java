import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class GenericsKbAVLApp {

    public AVLTree<Origin> tree = new AVLTree<>();
    public void MakeTree(String file)
    {
        try {
            File filename = new File(file);
            Scanner files = new Scanner(filename);
            while (files.hasNextLine()) {
                
                files.useDelimiter("\t");
                String term = files.next();

                String sentence = files.next();

                files.useDelimiter("\n");
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

    public void searchItem(String file)
    {
        int counts = 0;
        try {
            File files = new File(file);
            Scanner filename = new Scanner(files);
            while(filename.hasNextLine())
            {
                counts++;
                if(filename.hasNext()){
                    String item = filename.next();
                    Origin search = new Origin(item,null,0);
                    BinaryTreeNode<Origin> found = tree.find(search);
                    if(found != null)
                    {
                        System.out.println(found.getData().getTerm() +": " + found.getData().getSentence() + "(" + found.getData().getScore()+")");
                    }
                    else{System.out.println("Item not found : " + item);}
                }
                if(counts==100){break;}
            }
            filename.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Please try again.");
            System.exit(0);
        }
    }
    public void counters(){System.out.println("insert: " + AVLTree.counter +1); System.out.println("find: "+ AVLTree.count+1);}
}
