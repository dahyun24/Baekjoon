#include <iostream>
#include <string>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int arr[100][100] = {0};
    int num;
    cin >> num;
    while (num>0) {
        int a, b;
        cin >> a >> b;
        for(int i=0;i<10;i++)
        {
            for (int j = 0; j < 10; j++) {
                arr[a + i][b + j] = 1;
            }
        }
        num--;
    }
    int count = 0;
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            if (arr[i][j] == 1)
                count++;
        }
    }
    cout << count;
    return 0;
}