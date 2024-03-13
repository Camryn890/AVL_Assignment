import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class GenericsKbAVLApp {

    AVLTree<Origin> tree = new AVLTree<Origin>();
    GenericsKbAVLApp(String file)
    {
        tree = new AVLTree<Origin>();
        MakeTree(file);
    }

    private void MakeTree(String file)
    {
        try {
            File filename = new File(file);
            Scanner files = new Scanner(filename);
            while (files.hasNextLine()) {
                files.useDelimiter("/t");
                String term = files.next();
                String sentence = files.next();
                files.useDelimiter("/n");
                float score = files.nextFloat();
                Origin result = new Origin(term, sentence, score);
                tree.insert(result);
                files.nextLine();

            }
        }
        catch(FileNotFoundException e) {System.out.println("Please try again.");}
    }

    public void searchItem(String file)
    {
        try {
            File files = new File(file);
            Scanner filename = new Scanner(files);
            while(filename.hasNextLine())
            {
                String item = filename.next();
                Origin search = new Origin(item,null,0);
                if(tree.find(search) != null)
                {
                    BinaryTreeNode<dataType> found = tree.find(search);
                    System.out.println(found.getData().getTerm() +": " + found.getData().getSentence() + "(" + found.getData().getScore()+")");
                };
            }
        }
        catch(FileNotFoundException e){System.out.println("Please try again.");}
    }
}
