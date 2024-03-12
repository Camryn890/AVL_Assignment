import java.util.Scanner;
public class GenericsKbAVLApp {

    GenericsKbAVLApp(String file)
    {
        MakeTree(file);
    }

    private void MakeTree(String file)
    {
        Scanner files = new Scanner(file);
        while(files.hasNextLine()){
            files.useDelimiter("/t");
            String term = files.next();
            String sentence = files.next();
            files.useDelimiter("/n");
            float score = files.nextFloat();
            files.nextLine();

        }

    }
}
