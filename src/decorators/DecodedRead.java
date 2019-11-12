package decorators;

import java.io.File;
import java.util.Base64;

/**
 * @author Jerry Salonen
 */
public class DecodedRead extends ReadDecorator {
    public DecodedRead(Read decodeRead) {
        super(decodeRead);
    }

    @Override
    public String processFile(File file) {
        String encoded = super.processFile(file);
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        return new String(decodedBytes);
    }
}
