package catcafe;

import java.util.Scanner;

public class ScannerInput {
    Scanner input = new Scanner(System.in);
    String cmd = "";

    void close() {
        input.close();
    }
}
