#include <iostream>
#include <string>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num;
    cin >> num;
    int* arr = new int[num];
    for (int i = 0; i < num; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < num; i++) {
        for (int j = 0; j < num-1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp;
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    for (int i = 0; i < num; i++) {
        cout << arr[i] << "\n";
    }

    delete arr;
    return 0;
}