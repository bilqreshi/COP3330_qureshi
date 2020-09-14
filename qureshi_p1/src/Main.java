import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int strSize = 0;

        Scanner input = new Scanner(System.in);
        while (strSize != 4) {

            System.out.println("Enter a four digit value");
            String vals = input.next();
            strSize = vals.length();

            if (strSize == 4) {

                System.out.println("Press 'e' to encrypt\nPress 'd' to decrypt");
                Scanner opt = new Scanner(System.in);
                String option = opt.next();

                if (option.equals("e")) {
                    Encrypter.getval(vals);
                }
                else if (option.equals("d")) {
                    Decrypter.getval(vals);
                }
                else {
                    System.out.println("invalid");
                }
            }
        }
    }
}