#include <iostream>
using namespace std;

int main() {
  int num;
  int arr[101];
  int find_num;

  cin >> num;

  for(int i = 0; i < num; i++)
    cin >> arr[i];
  cin >> find_num;

  int res = 0; 
  for(int i = 0; i < num; i++) {
    if(arr[i] == find_num) 
      res++;
  }
  cout << res;
}