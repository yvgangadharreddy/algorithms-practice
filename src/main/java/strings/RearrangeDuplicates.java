package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Key {
    char ch;
    int freq;

    public Key(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class KeyComparator implements Comparator<Key> {

    public int compare(Key k1, Key k2) {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}

public class RearrangeDuplicates {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bf.readLine());
        while(testCases-- > 0) {
            String str = bf.readLine();
            char[] charArray = str.toCharArray();
            reArrange(charArray, charArray.length);
        }
    }

    private static void reArrange(char[] arr, int n) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charMap.putIfAbsent(arr[i], 0);
            charMap.put(arr[i], charMap.get(arr[i])+1);
        }

        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        charMap.forEach((k,v) -> pq.add(new Key(k, v)));

        StringBuilder str = new StringBuilder();

        Key prev = new Key('#', -1);

        while(!pq.isEmpty()) {
            Key k = pq.peek();
            pq.poll();
            str.append(k.ch);
            if (prev.freq > 0)
                pq.add(prev);
            k.freq--;
            prev = k;
        }

        if (n != str.length()) {
            System.out.println("Not possible");
        } else {
            System.out.println(str);
        }
    }
}

