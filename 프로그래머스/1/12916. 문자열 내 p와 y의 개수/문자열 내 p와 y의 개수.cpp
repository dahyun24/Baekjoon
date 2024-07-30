#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;

    int count_p = 0;
    int count_q = 0;
    for (char c : s){
        c = tolower(c);
        if (c == 'p') count_p++;
        else if (c == 'y') count_q++;
    }
    if (count_p == count_q) answer = true;
    else answer = false;

    return answer;
}