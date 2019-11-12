package decorators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author Jerry Salonen
 */
public class Write implements WriteInterface {

    public String processFile(File file, String contents) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write(contents);

            bw.close();

            return "Wrote: " + contents + " - to file.";
        } catch (Exception e) {
            return "File could not be created.";
        }

    }
}
