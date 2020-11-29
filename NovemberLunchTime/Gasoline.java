package NovemberLunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gasoline {
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
            ArrayList<Pair> list = new ArrayList<Pair>();
            int arr[] = new  int[n];
            for (int i = 0; i < n; i++) {
                list.add(new Pair());
                list.get(i).fuel = reader.nextLong();
            }
            for (int i = 0; i < n; i++) {
                list.get(i).coin = reader.nextLong();
            }
            Collections.sort(list, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return (int) (o1.coin - o2.coin);
                }
            });
            long cost = 0;
            for (Pair car: list) {
                if (car.fuel >= n) {
                    long dist = Math.max(car.fuel, n);
                    cost += dist * car.coin;
                    n  = 0;
                }
                else {
                    cost += car.fuel * car.coin;
                    n -= car.fuel;
                }
                if (n == 0)
                    break;
            }
            sb.append(cost + "\n");
        }
        System.out.println(sb);
    }

    private static class Pair {
        long fuel = 0;
        long coin = 0;
    }
}
