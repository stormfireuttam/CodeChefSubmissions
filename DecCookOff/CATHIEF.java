package DecCookOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CATHIEF {
    public static void main(String[] args) throws java.lang.Exception{
        FastScanner fs=new FastScanner();
        int t = fs.nextInt();
        boolean caught;
        StringBuilder sb  = new StringBuilder();
        outer: while (t -- > 0) {
            long police = fs.nextLong();
            long thief = fs.nextLong();
            long k = fs.nextLong();
            long n = fs.nextLong();
            caught = false;
            if (thief < police) {
                long op = (thief) / k;
                if (thief % k == 0) {
                    thief = 0;
                }
                else {
                    thief = thief % k;
                }
                police -= op * k;

                if (police == thief) {
                    caught = true;
                    sb.append("Yes\n");
                    continue outer;
                }

                while (true) {
                    thief += k;
                    police -= k;
                    if (police == thief) {
                        caught = true;
                        sb.append("Yes\n");
                        continue outer;
                    }
                    if (thief > police) {
                        sb.append("No\n");
                        continue outer;
                    }
                }
            }
            else {
                long op = (n - thief) / k;
                if ((n - thief) % k == 0) {
                    thief = n;
                }
                else {
                    thief = n - (n - thief) % k;
                }
                police = police + op * k;

                if (police == thief) {
                    caught = true;
                    sb.append("Yes\n");
                    continue;
                }

                while (true) {
                    thief -= k;
                    police += k;
                    if (police == thief) {
                        caught = true;
                        sb.append("Yes\n");
                        continue outer;
                    }
                    if (thief < police){
                        sb.append("No\n");
                        continue outer;
                    }
                }
            }
        }
        System.out.print(sb);
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long[] readArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
