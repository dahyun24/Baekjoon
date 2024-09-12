#include <string>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int count_def = 0;
int count_0 = 0;

int delete0(string s){
    for (int i=0;i<s.length();i++){
        if (s[i]=='0') count_0++;
    }
    s.erase(remove(s.begin(), s.end(), '0'), s.end());  // 모든 '0' 제거
    count_def++; // 이 함수가 시행된 횟수 count
    return s.length(); // 1만 남은 길이 return
}

vector<int> solution(string s) {
    vector<int> answer;
    while(s.length()>1){
        int s_size = delete0(s); // 0 삭제 후 문자열의 길이 반환
        stack<int> st;
        while (true){
            if (s_size/2 ==0) {
                st.push(1); 
                break;
            }
            else{
                st.push(s_size%2);
                s_size = s_size/2;
            } 
        }
        s = "";
        while (!st.empty()){
            s = s + to_string(st.top()); 
            st.pop();
        }
    }
    
    answer.push_back(count_def);
    answer.push_back(count_0);
    return answer;
}