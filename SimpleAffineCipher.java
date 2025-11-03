import java.util.Scanner;

public class SimpleAffineCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 5;
        int b = 8;

        if (gcd(a, 26) != 1) {
            System.out.println("Invalid key 'a'. It must be coprime with 26.");
            return;
        }

        System.out.print("Enter plaintext: ");
        String message = sc.nextLine().toUpperCase();

        String ciphertext = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                int x = c - 'A';
                int e = (a * x + b) % 26;
                ciphertext += (char) (e + 'A');
            } else {
                ciphertext += c;
            }
        }

        System.out.println("Ciphertext: " + ciphertext);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}