#include <iostream>
#include <string>
#include <algorithm> // reverse 함수를 위해서

using namespace std;

int dial_char_to_num(char a);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string dial;
    cin >> dial;
    
    int sum = 0;
    for (char a : dial) {
        sum += dial_char_to_num(a);
    }
    cout << sum;

	return 0;
}

int dial_char_to_num(char a) {
    int result;
    switch (a)
    {
    case 'A':
    case 'B':
    case 'C':
        result = 3;
        break;
    case 'D':
    case 'E':
    case 'F':
        result = 4;
        break;
    case 'G':
    case 'H':
    case 'I':
        result = 5;
        break;
    case 'J':
    case 'K':
    case 'L':
        result = 6;
        break;
    case 'M':
    case 'N':
    case 'O':
        result = 7;
        break;
    case 'P':
    case 'Q':
    case 'R':
    case 'S':
        result = 8;
        break;
    case 'T':
    case 'U':
    case 'V':
        result = 9;
        break;
    case 'W':
    case 'X':
    case 'Y':
    case 'Z':
        result = 10;
        break;
    }
    return result;
}