package decorators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Jerry Salonen
 */
public class Read implements ReadInterface {

    public String processFile(File file) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String contents = "";
            String st = "";

            while ((st = br.readLine()) != null) {
                contents += st;
            }

            br.close();

            return contents;

        } catch (Exception e) {
            return "File not found";
        }

    }
}
