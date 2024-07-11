#include <iostream>
#include <string>
#include <sstream>  // 공백 기준 문자열 자를 때 사용
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string sen, word;
    getline(cin, sen); 
    //cin으로 받으면 공백을 처리해버리기에 
    // 공백을 포함한 문자열을 받으려면 getline

    stringstream ss(sen);
    int count = 0;
    while (ss >> word)
        count++;
    cout << count;

	return 0;
}