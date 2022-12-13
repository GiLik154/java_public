package secretmap;

import java.util.Random;
import java.util.Scanner;

public class SecretMap {
    public static void main(String[] args) {
        int n = 0;
        int x = 0;
        int y = 0;
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("1~16사이 숫자로 입력하십시오.");
        n = input.nextInt();
        int arr1[] = new int[n];  
        int arr2[] = new int[n];
        String arr3[] = new String[n];
        String arr4[] = new String[n];

        if (1 <= n && n <= 16) {
            for (int i = 0; i < n; i++) {
                y = (int) Math.pow(2, n) - 1;
                arr1[i] = random.nextInt(y)+1;
                arr2[i] = random.nextInt(y)+1;
            }
        } else {
            System.out.println("1~16사이 숫자로 다시 입력하십시오.");
        }
    for (int i = 0; i < n; i++) {
        arr3[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        arr4[i] = arr3[i].replace("1", "#");
        arr4[i] = arr4[i].replace("0", " ");
        System.out.println("[\"" + arr4[i] + "\"]");
    }
    
    }
}
