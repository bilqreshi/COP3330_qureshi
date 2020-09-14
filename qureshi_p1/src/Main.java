import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int strSize = 0;
        String option = "0";

        Scanner input = new Scanner(System.in);
        while (strSize != 4) {

            System.out.println("Enter a four digit value");
            String vals = input.next();
            strSize = vals.length();

            if (strSize == 4) {

                while(!option.equals("e") & !option.equals("d")){

                    System.out.println("Press 'e' to encrypt\nPress 'd' to decrypt");
                    Scanner opt = new Scanner(System.in);
                    option = opt.next();

                    if (option.equals("e")) {
                        System.out.println("encrypted value: " + Encrypter.getval(vals));
                    }
                    if (option.equals("d")) {
                        System.out.println("decrypted value: " + Decrypter.getval(vals));
                    }
                }
            }
        }
    }
}