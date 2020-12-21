package DecemberLongChallenge;

import PlacementPreparationWeek1.Program1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vaccine1 {
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
        int d1 = read.nextInt(), v1 = read.nextInt();
        int d2 = read.nextInt(), v2 = read.nextInt();
        int p = read.nextInt();
        int sum = 0, startDay = Math.min(d1, d2), nDays = startDay;
        while (sum < p) {
            if (d1 <= startDay) {
                sum += v1;
            }
            if (d2 <= startDay) {
                sum += v2;
            }
            startDay++;
        }
        System.out.println(startDay - 1);
    }
}
