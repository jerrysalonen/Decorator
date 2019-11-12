package decorators;

import java.io.File;

/**
 * @author Jerry Salonen
 */
public abstract class WriteDecorator implements WriteInterface {
    protected Write encodeWrite;

    public WriteDecorator(Write encodeWrite) {
        this.encodeWrite = encodeWrite;
    }

    public String processFile(File file, String contents) {
        return encodeWrite.processFile(file, contents);
    }
}