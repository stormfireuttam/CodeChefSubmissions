package NovemberLunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasolineBeginner {
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

    public static void main(String[] args)throws java.lang.Exception {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = reader.nextInt();
            int arr[] = new  int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            int remaining = arr[0], count = 0;
            boolean nextRound = false;
            while (remaining > 0) {
                if (nextRound)
                {
                    count ++;
                    remaining --;
                }
                for (int i = 1; i < n && remaining > 0; i++) {
                    remaining--;
                    remaining += arr[i];
                    arr[i] = 0;
                    count ++;
                    if (remaining <= 0) break;
                }
                nextRound = true;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
