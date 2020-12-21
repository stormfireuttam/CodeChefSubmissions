package DecemberLongChallenge;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class StringOperations {
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader f) {
            br = new BufferedReader(f);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(next());
            }
            return arr;
        }

    }
    static HashSet<String> hSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t -- > 0) {
            String s = sc.next();
            hSet.clear();
            int count1[] = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    count1[i] = (s.charAt(i) == '1') ? 1 : 0;
                }
                else {
                    count1[i] = (s.charAt(i) == '1') ? count1[i - 1] + 1 : count1[i - 1];
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String str = s.substring(i, j);

                    if (i != 0 && isEquivalent(str, count1[j - 1] - count1[i - 1])) {
                        if (hSet.contains(str) || hSet.contains(reverse(str))) {
                            continue;
                        }
                        else
                            hSet.add(str);
                    }
                    else if ( i == 0 && isEquivalent(str, count1[j - 1])) {
                        if (hSet.contains(str) || hSet.contains(reverse(str))) {
                            continue;
                        }
                        else
                            hSet.add(str);

                    }
                    else {
                        if (!hSet.contains(str)){
                            hSet.add(str);
                        }
                    }
                }
            }
            pw.println(hSet.size());
        }
        pw.close();
    }
    private static boolean isEquivalent(String str, int numberOfOnes) {
        if (numberOfOnes % 2 != 0)
            return false;
        return true;
    }
    private static String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i --) {
            res.append(s.charAt(i));
        }
        return String.valueOf(res);
    }
}
