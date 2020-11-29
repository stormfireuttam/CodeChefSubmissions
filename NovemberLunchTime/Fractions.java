// We iterate from 1 to n-1 and find all possible a
// Along with this we maintain two list x(all possible divisors of a) and y(all possible divisors of a+1)
// Increment the value and add the value of current y if
//          a + x'y' <= n
package NovemberLunchTime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fractions {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    private static final int MAX = (int) 1e6 + 5;
    static boolean isPrime[] = new boolean[MAX];
    static ArrayList<Integer> primeFactors = new ArrayList<>();
    public static void sieve(int m) {
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i < m; i ++) {
            if (isPrime[i]) {
                for (int j = i * i; j < m; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < m; i++) {
            if (isPrime[i]) primeFactors.add(i);
        }
    }
    public static void main(String[] args)throws java.lang.Exception {
        FastReader reader = new FastReader();
        sieve(MAX);
//        System.out.println(primeFactors.size());
        int n = reader.nextInt();

    }

}
