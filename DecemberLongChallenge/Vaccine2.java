package DecemberLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vaccine2 {
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
    public static void main(String[] args) throws java.lang.Exception {
        FastReader read = new FastReader();
        int t = read.nextInt();
        while (t -- > 0) {
            int n = read.nextInt(), d = read.nextInt();
            int arr[] = new int[n];
            int countRisk = 0, countNonRisk = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = read.nextInt();
                if (arr[i] <= 9 || arr[i] >= 80) {
                    countRisk ++;
                }
                else
                    countNonRisk ++;
            }
            int days = 0;
            if (countRisk % d == 0)
                days += countRisk / d;
            else
                days += countRisk / d + 1;
            if (countNonRisk % d == 0)
                days += countNonRisk / d;
            else
                days += countNonRisk / d + 1;
            System.out.println(days);
        }
    }
}
