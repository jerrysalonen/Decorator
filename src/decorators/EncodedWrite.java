package decorators;

import java.io.File;
import java.util.Base64;

/**
 * @author Jerry Salonen
 */
public class EncodedWrite extends WriteDecorator {
    public EncodedWrite(Write encodeWrite) {
        super(encodeWrite);
    }

    @Override
    public String processFile(File file, String contents) {
        String unEncoded = contents;
        String encodedString = Base64.getEncoder().encodeToString(unEncoded.getBytes());
        return super.processFile(file, encodedString);
    }
}
