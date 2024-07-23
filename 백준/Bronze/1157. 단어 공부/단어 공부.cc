#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int arr[100] = {0};
    string A;
    cin >> A;
    for (char a : A) {
        if (isalpha(a)) { // 알파벳 문자인지 확인
            char upper_a = toupper(a); // 대문자로 변환
            int asci_a = upper_a;
            arr[asci_a]++;
        }
    }
    int max_count = 0;
    char max_char = '?';
    bool duplicate = false;

    for (int i = 65; i <= 90; i++) { // 대문자 알파벳 범위 ('A' ~ 'Z')
        if (arr[i] > max_count) {
            max_count = arr[i];
            max_char = i;
            duplicate = false;
        } else if (arr[i] == max_count && max_count > 0) {
            duplicate = true;
        }
    }

    if (duplicate) {
        cout << "?";
    } else {
        cout << max_char;
    }

    return 0;
}
