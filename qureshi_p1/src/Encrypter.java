public class Encrypter {

    public static String getval(String vals){
        int val = 0;
        val = Integer.parseInt(vals);
        val = encrypt(val);
        vals = Integer.toString(val);
        return vals;
    }

    public static int encrypt(int val) {
        int a, b, c, d;

        a = val / 1000;
        b = val / 100 % 10;
        c = val / 10 % 10;
        d = val % 10;

        a = ((a + 7) % 10)*10;
        b = (b + 7) % 10;
        c = ((c + 7) % 10)*1000;
        d = ((d + 7) % 10)*100;

        return (c + d + a + b);
    }
}
