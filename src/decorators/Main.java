package decorators;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select = -1;
        String directory;
        String path;

        ReadInterface read = new Read();
        WriteInterface write = new Write();

        // With decorators
        ReadInterface readDecoded = new DecodedRead(new Read());
        WriteInterface writeEncoded = new EncodedWrite(new Write());

        File file = null;

        do {
            System.out.println("1: Read\n2: Write\n3: Read encoded\n4: Write encoded\n0: Close");

            try {
                select = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
            if (select > 0) {
                try {
                    System.out.println("Directory (e.g. C:\\Users\\myuser). Leave blank to use your user directory.");
                    directory = sc.nextLine();

                    if (directory.length() < 1) {
                        directory = System.getProperty("user.home");
                    }

                    System.out.println("Input file name.");
                    String fileName = sc.nextLine();

                    path = directory + "\\" + fileName;

                    file = new File(path);
                } catch (Exception e) {
                    System.out.println("Problem reading the file (directory or file doesn't exist)");
                    select = -1;
                }
            }

            switch(select) {
                case 1:
                    System.out.println(read.processFile(file));
                    break;
                case 2:
                    System.out.println("Write your content here:");
                    String contents = sc.nextLine();
                    System.out.println(write.processFile(file, contents));
                    break;
                case 3:
                    System.out.println(readDecoded.processFile(file));
                    break;
                case 4:
                    System.out.println("Write your content here:");
                    String contentsToDecode = sc.nextLine();
                    System.out.println(writeEncoded.processFile(file, contentsToDecode));
                    break;
            }

        } while (select != 0);
    }
}
