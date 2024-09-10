#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    int count = 0;
    bool answer = true;
    for (char ch : s) {
        if (ch == '(') {
            count++;
        } else if (ch == ')') {
            count--;
        }
        if (count < 0) {
            return false; 
        }
    }
    if (count != 0) answer = false;
    return answer;
}