package arithmetic;

import java.util.Scanner;

public class ArithmeticMain {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Arithmetic ar = new Arithmetic();
        while (scan.hasNextLine()) {
            String[] starr = new String[] {scan.nextLine(), scan.nextLine()};
            System.out.println(ar.handleLines(starr));
        }
        scan.close();
    }
}