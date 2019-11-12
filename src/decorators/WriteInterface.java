package decorators;

import java.io.File;

/**
 * @author Jerry Salonen
 */
public interface WriteInterface {
    String processFile(File file, String contents);
}
