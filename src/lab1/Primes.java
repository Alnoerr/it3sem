package lab1;

public class Primes {
    public static void main(String[] args) {
        for (int x = 2; x < 101; x++) {
            if (isPrime(x)) {
                System.out.println(x);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
