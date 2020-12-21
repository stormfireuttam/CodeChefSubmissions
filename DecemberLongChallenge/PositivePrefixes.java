package DecemberLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PositivePrefixes {
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
        StringBuilder sb = new StringBuilder();
        while (t -- > 0) {
            int n = read.nextInt();
            int k = read.nextInt();
            int arr[] = new int[n + 1];
            int currPos = 0, sum = 0;
            for (currPos = 1; currPos <= n; currPos++) {
                if (k == 0 || k == n)
                    break;
                if (sum + currPos <= currPos + 1 && k > 0) {
                    arr[currPos] = currPos;
                    sum += currPos;
                    k --;
                    continue;
                }
                if (sum > currPos) {
                    arr[currPos] = -currPos;
                    sum -= currPos;
                    if (sum > 0)
                        k --;
                    continue;
                }
                if (sum + currPos > currPos + 1 && k == 1) {
                    arr[currPos] = -currPos;
                    if (sum - currPos - 1 > 0)
                        break;
                    else
                    {
                        sum -= (currPos + 1);
                        continue;
                    }
                }
                if (sum + currPos > currPos + 1 && k > 1) {
                    arr[currPos] = currPos;
                    if (sum > 0)
                        k --;
                    sum += currPos;
                }
            }
            if (k == n) {
                for (int i = 1; i <= n; i++) {
                    arr[i] = i;
                }
            }
            else if(currPos <= n) {
                for (; currPos <= n; currPos++) {
                    arr[currPos] = -currPos;
                }
            }
            for (int i = 1; i <= n; i++)
                sb.append(arr[i] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}