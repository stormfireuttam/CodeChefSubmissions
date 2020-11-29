package NovemberCookOff;


import java.util.Scanner;

public class FlipBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String a, b;
        int ans;
        while(t-- > 0) {
            ans = 0;
            a = sc.nextLine();
            b = sc.nextLine();
            for (int i = 0; i < a.length(); i+=2) {
                if(a.charAt(i)!= b.charAt(i)) {
                    while (i < a.length() && a.charAt(i) != b.charAt(i)) {
                        i += 2;
                    }
                    ans ++;
                }
            }
            for (int i = 1; i < a.length(); i+=2) {
                if(a.charAt(i)!= b.charAt(i)) {
                    while (i < a.length() && a.charAt(i) != b.charAt(i)) {
                        i += 2;
                    }
                    ans ++;
                }
            }
            System.out.println(ans);
        }
    }

}
