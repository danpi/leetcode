package interview_ch5;

public class N1_Primes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
