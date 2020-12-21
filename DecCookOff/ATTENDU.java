package DecCookOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATTENDU {
    public static void main(String[] args) throws java.lang.Exception{
        FastScanner fs=new FastScanner();
        int t = Integer.parseInt(fs.next());
        StringBuilder sb = new StringBuilder();
        while(t -- > 0) {
            int n = Integer.parseInt(fs.next());
            int countAbsent = 0;
            String s = fs.next();
            for (int i = 0; i < n; i++) {
                int x = s.charAt(i) - '0';
                if (x == 0)
                    countAbsent ++;
            }
            double per = (((120 - n) + (n - countAbsent)) * 100 / 120);
            if (per >= 75) {
                sb.append("YES");
            }
            else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
