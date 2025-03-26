import java.util.*;
class Solution {
    public String solution(String[] participants, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String name : completion){
            if (hashMap.containsKey(name)){
                int count = hashMap.get(name);
                count++;
                hashMap.put(name, count);
            } else {
                hashMap.put(name,1);
            }
        }
        for (String participant : participants) {
            if (hashMap.containsKey(participant)) {
                int num = hashMap.get(participant);
                if (num == 0){
                    answer = participant;
                } else {
                    num--;
                    hashMap.put(participant, num);
                }
            } else {
                answer = participant;
            }
        }
        return answer;
    }
}