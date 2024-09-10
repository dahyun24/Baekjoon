#include <string>
using namespace std;

string solution(string s) {
    string answer = "";
    string word;
    
    for (int i =0; i<s.length();i++){
        s[i] = tolower(s[i]);
    }
    
    for (int i =0; i<s.length();i++){
        if (s[i]==' ') s[i+1] = toupper(s[i+1]);
    }
    s[0] = toupper(s[0]);

    return s;
}