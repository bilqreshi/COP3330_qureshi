public class Decrypter {

    public static String getval(String vals){
        int val = 0;
        val = Integer.parseInt(vals);
        val = decrypt(val);
        vals = String.valueOf(val);
        return vals;
    }

    public static int decrypt(int val) {
        int a, b, c, d;

        a = val / 1000;
        b = val / 100 % 10;
        c = val / 10 % 10;
        d = val % 10;

        a = ((a + 3) % 10)*10;
        b = (b + 3) % 10;
        c = ((c + 3) % 10)*1000;
        d = ((d + 3) % 10)*100;

        return (c + d + a + b);
    }
}
