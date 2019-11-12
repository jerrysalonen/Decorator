package decorators;

import java.io.File;

/**
 * @author Jerry Salonen
 */
public abstract class ReadDecorator implements ReadInterface {
    protected Read decodeRead;

    public ReadDecorator(Read decodeRead) {
        this.decodeRead = decodeRead;
    }

    public String processFile(File file) {
        return decodeRead.processFile(file);
    }
}
