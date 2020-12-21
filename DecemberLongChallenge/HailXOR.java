package DecemberLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class HailXOR {
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
    static long MAX = (long) (1e5 + 5);
    static long arr[] = new long[Math.toIntExact(MAX)];
    static long p;
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t -- > 0) {
            long n = reader.nextLong();
            long x = reader.nextLong();
            for (int i = 1; i <= n; i++) {
                arr[i] = reader.nextLong();
            }
            int i;
            for (i = 1; i < n && x > 0; i+= 1) {
                if (i == n - 1) {
                    p = arr[i] / 2;
                    p = (long) Math.pow(2, p);
                    if (x % 2 != 0)
                    {
                        arr[i] = arr[i] ^ p;
                        arr[i + 1] = arr[i + 1] ^ p;
                    }
                    x = 0;
                    break;
                }
                p = Math.min(arr[i], arr[i + 1]) / 2;
                while (arr[i] != 0 && x > 0) {
                    p = (long) Math.pow(2, p);
                    arr[i] = p ^ arr[i];
                    arr[i + 1] = p ^ arr[i + 1];
                    x --;
                    p = arr[i] / 2;
                }
            }
            for (i = 1; i <= n; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
