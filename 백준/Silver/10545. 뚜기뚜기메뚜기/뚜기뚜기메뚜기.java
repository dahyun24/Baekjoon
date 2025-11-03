import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class KeyInfo {
        int key;
        int count;

        KeyInfo(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    public static Map<Character, KeyInfo> buildKeypadMap() {
        Map<Character, KeyInfo> map = new HashMap<>();

        String[] letters = {
                "",      // 0
                "",      // 1
                "abc",   // 2
                "def",   // 3
                "ghi",   // 4
                "jkl",   // 5
                "mno",   // 6
                "pqrs",  // 7
                "tuv",   // 8
                "wxyz"   // 9
        };

        for (int i = 2; i <= 9; i++) {
            String group = letters[i];
            for (int j = 0; j < group.length(); j++) {
                char c = group.charAt(j);
                map.put(c, new KeyInfo(i, j + 1));
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[10];
        for (int i = 1; i <= 9; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Character, KeyInfo> map = buildKeypadMap();

        int[] reverse = new int[10];
        for (int i = 1; i <= 9; i++) {
            reverse[arr[i]] = i;
        }

        String word = br.readLine();

        int lastKey = -1; // 직전 실제 입력 키
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            KeyInfo info = map.get(c);

            int originalKey = info.key;
            int realKey = reverse[originalKey];

            if (realKey == lastKey) {
                bw.write('#');
            }

            for (int k = 0; k < info.count; k++) {
                bw.write(Integer.toString(realKey));
            }
            
            lastKey = realKey;
        }
        bw.flush();
        bw.close();
    }
}
