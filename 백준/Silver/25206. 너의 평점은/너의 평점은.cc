#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    map<string, double> gradeMap;
    gradeMap["A+"] = 4.5;
    gradeMap["A0"] = 4.0;
    gradeMap["B+"] = 3.5;
    gradeMap["B0"] = 3.0;
    gradeMap["C+"] = 2.5;
    gradeMap["C0"] = 2.0;
    gradeMap["D+"] = 1.5;
    gradeMap["D0"] = 1.0;
    gradeMap["F"] = 0.0;

    string subject;
    double score;
    string grade;
    double* arr = new double[20];

    double sum_score = 0.0;
    for (int i = 0; i < 20; i++) {
        double sum = 0.0; // 학점 * 등급
        cin >> subject >> score >> grade;
        if (grade != "P") {
            sum += gradeMap[grade] * score;
            sum_score += score;
            arr[i] = sum;
        }
        else 
            arr[i] = 0.0;
    }
    double result = 0.0;
    for (int i = 0; i < 20; i++) {
        result += arr[i];
    }
    cout << result / sum_score;

    return 0;
}