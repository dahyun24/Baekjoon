#include <iostream>
#include <iostream>
#include <string>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<string> croatian = { "c=","c-","dz=","d-","lj","nj","s=","z=" };
    int index;
    string str;
    cin >> str;
    for (int i = 0; i < croatian.size(); i++)
    {
        while (1) {
            index = str.find(croatian[i]);
            if (index == -1)
                break;
            str.replace(index, croatian[i].length(), "#");
        }
    }
    cout << str.length();
}