package DecCookOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SDSTRING {
    public static void main(String[] args) throws java.lang.Exception{
        FastScanner fs=new FastScanner();
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t -- > 0) {
            char a[] = fs.next().toCharArray();
            if (a.length % 2 !=  0) {
                sb.append(-1 + "\n");
            }
            else {
                int count0 = 0, count1 = 0;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }
                if (count0 == count1)
                    sb.append("0\n");
                else {
                    if (count0 == 0 || count1 == 0)
                        sb.append(-1 + "\n");
                    else
                    {
                        int res = Math.abs(count0 - count1) / 2;
                        sb.append(res + "\n");
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
