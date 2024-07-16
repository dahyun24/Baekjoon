// 슬라이딩 윈도우
// 두개의 포인터로 범위를 지정한 다음, 범위를 유지한 채로 이동하며 문제 해결

#include <iostream>
#include <string>
#include <vector>
using namespace std;

int checkArr[4];
int myArr[4];
int checkSecret = 0; //몇 개의 문자에 대한 개수를 충족했는지 판단하는 변수, 즉 4가 되면 모두 충족
void Add(char c);
void Remove(char c);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int S, P; // S 전체, P 부분
    cin >> S >> P;
    
    string A;
    cin >> A;

    int result = 0; // 만들 수 있는 비밀번호 종류
    
    for (int i = 0; i < 4; i++) {
        cin >> checkArr[i];
        if (checkArr[i] == 0) checkSecret++; //만족할 필요가 없는 문자에 대해서 ++
    }

    // 초기 P 만큼 문자열 처리 (범위 window 만큼)
    for (int i = 0; i < P; i++){
        Add(A[i]);
    }
    if (checkSecret == 4) { // 첫번째 window에서 조건 만족
        result++;
    }

    // 슬라이딩 윈도우 처리 부분
    for (int i = P; i < S; i++) {
        int j = i - P;
        Add(A[i]);
        Remove(A[j]);
        if (checkSecret == 4) {
            result++;
        }
    }
    cout << result;

    return 0;
}

void Add(char c) {
    if (c == 'A'){
        myArr[0]++;
        if (myArr[0] == checkArr[0]) checkSecret++;
    }
    else if (c == 'C') {
        myArr[1]++;
        if (myArr[1] == checkArr[1]) checkSecret++;
    }
    else if (c == 'G') {
        myArr[2]++;
        if (myArr[2] == checkArr[2]) checkSecret++;
    }
    else if (c == 'T') {
        myArr[3]++;
        if (myArr[3] == checkArr[3]) checkSecret++;
    }
}

void Remove(char c) {
    if (c == 'A') {
        if (myArr[0] == checkArr[0]) checkSecret--;
        myArr[0]--;
    }
    else if (c == 'C') {
        if (myArr[1] == checkArr[1]) checkSecret--;
        myArr[1]--;
    }
    else if (c == 'G') {
        if (myArr[2] == checkArr[2]) checkSecret--;
        myArr[2]--;
    }
    else if (c == 'T') {
        if (myArr[3] == checkArr[3]) checkSecret--;
        myArr[3]--;
    }
}