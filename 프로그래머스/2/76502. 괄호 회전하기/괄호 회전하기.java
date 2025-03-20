import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i=0;i<s.length();i++){
            String b = sb.substring(0,1);
            sb.delete(0,1);
            sb.append(b);
            if (checkP(sb.toString())) answer++;
        }
        return answer;
    }
    
    public boolean checkP(String sb){
        Stack<Character> st = new Stack<>();
        for (int i =0;i<sb.length();i++){
            char c = sb.charAt(i);
            if (st.isEmpty()) {
                st.push(c);
            }
            else if (c == '[' || c=='{' || c=='('){
                st.push(c);
            } else if (c == ']'){
                if (st.peek() == '[') {st.pop();}
                else {st.push(c);}
            } else if (c == '}'){
                if (st.peek() == '{') {st.pop();}
                else {st.push(c);}
            } else if (c == ')'){
                if (st.peek() == '(') {st.pop();}
                else {st.push(c);}                
            }
        }
        return st.isEmpty();
    }
}