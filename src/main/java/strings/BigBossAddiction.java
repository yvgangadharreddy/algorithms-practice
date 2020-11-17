package strings;

import java.util.*;

public class BigBossAddiction {
    public static void main(String[] args) {
        List<Integer> listOfN = new ArrayList<>();
        List<Integer> listOfM = new ArrayList<>();
        Integer noOfCoins;
        Scanner sc1 = new Scanner(System.in);
        Integer T  = sc1.nextInt();
        for (Integer i = 0; i < T; i++) {
            Scanner sc2 = new Scanner(System.in);
            Integer N = sc2.nextInt();
            Integer M = sc2.nextInt();
            listOfN.add(N);
            listOfM.add(M);
        }

        for (int i = 0; i < T; i++) {
            noOfCoins = 0;
            for (int j = 1; j <= listOfN.get(i); j++) {
                noOfCoins++;
                if (listOfN.get(i) % j == 0 && listOfM.get(i) % j == 0) {
                    noOfCoins = 0;
                }
                if (j == listOfN.get(i)) {
                    noOfCoins += listOfM.get(i);
                    System.out.println(noOfCoins);
                }
            }
        }
    }
}
