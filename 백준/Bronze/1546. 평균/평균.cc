#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;
    int* arr = new int[N];
 
    long sum = 0;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        sum = sum + arr[i];
    }
    long max = 0;
    for (int i = 0; i < N; i++) {
        if (arr[i] > max) max = arr[i];
    }
    double mean = (sum * 100.0)/ max / N;
    cout << mean;

	return 0;
}