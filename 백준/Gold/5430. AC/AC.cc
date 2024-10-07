#include <iostream>
#include <deque>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int p;
    cin >> p;  // 테스트 케이스 개수

    for (int i = 0; i < p; i++) {
        string T;
        cin >> T;  // 수행할 함수

        int n;
        cin >> n;  // 배열에 들어있는 수의 개수

        string input;
        cin >> input;  // 배열 입력 예: [1,2,3,4]

        deque<int> vec;  // deque를 사용하여 양방향에서 빠르게 원소를 제거
        string num;

        // 입력에서 불필요한 문자 제거 ('[', ']', ',' 등)
        input = input.substr(1, input.size() - 2);  // 앞뒤의 [] 제거

        stringstream ss(input);
        while (getline(ss, num, ',')) {
            if (!num.empty()) vec.push_back(stoi(num));
        }

        bool reverse_flag = false;  // 뒤집힌 상태를 기록하는 플래그
        bool error_flag = false;    // 에러 발생 여부를 기록하는 플래그

        for (char a : T) {
            if (a == 'R') {
                reverse_flag = !reverse_flag;  // 뒤집기 상태 전환
            } 
            else if (a == 'D') {
                if (vec.empty()) {  // 배열이 비었으면 에러
                    cout << "error\n";
                    error_flag = true;
                    break;
                }

                // reverse 상태에 따라 앞에서 제거할지 뒤에서 제거할지 결정
                if (reverse_flag) {
                    vec.pop_back();  // 뒤집힌 상태이면 뒤에서 제거
                } else {
                    vec.pop_front();  // 정상 상태이면 앞에서 제거
                }
            }
        }

        if (!error_flag) {
            // 배열 출력 (뒤집힌 상태에 따라 처리)
            cout << "[";

            if (reverse_flag) {
                // 뒤집힌 상태라면 뒤에서부터 출력
                for (auto it = vec.rbegin(); it != vec.rend(); ++it) {
                    cout << *it;
                    if (it + 1 != vec.rend()) cout << ",";
                }
            } else {
                // 정상 상태라면 앞에서부터 출력
                for (auto it = vec.begin(); it != vec.end(); ++it) {
                    cout << *it;
                    if (it + 1 != vec.end()) cout << ",";
                }
            }

            cout << "]\n";
        }
    }

    return 0;
}
