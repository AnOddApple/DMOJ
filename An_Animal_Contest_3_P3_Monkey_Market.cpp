#include <bits/stdc++.h>
//https://dmoj.ca/problem/aac3p3
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> prices(n);
    for(int i = 0; i < n; i++){
        cin >> prices[i];
    }
    sort(prices.begin(), prices.end());
    vector<vector<int>> pairs(n/2, vector<int>(2));
    if(n%2 == 0){
        for(int i = 0; i < n/2; i++){
            pairs[i][0] = prices[i];
            pairs[i][1] = prices[n-i-1];
        }
        for(int i = n/2-1; i >= 0; i--){
            cout << pairs[i][0] << " ";
            if(i != 0) cout << pairs[i][1] << " ";
            else cout << pairs[i][1];
        }
        cout << endl;
        bool isB = true;
        for(int i = 0; i < n; i++){
            if(isB) {
                cout << "B";
                isB = false;
            }
            else {
                cout << "S";
                isB = true;
            }
        }
    }
    else if(n%2 == 1){
        for(int i = 0; i < n/2; i++){
            pairs[i][0] = prices[i];
            pairs[i][1] = prices[n-i-1];
        }
        for(int i = n/2-1; i >= 0; i--){
            cout << pairs[i][0] << " ";
            cout << pairs[i][1] << " ";
        }
        cout << prices[n/2];
        bool isB = true;
        cout << endl;
        for(int i = 0; i < n-1; i++){
            if(isB) {
                cout << "B";
                isB = false;
            }
            else {
                cout << "S";
                isB = true;
            }
        }
        cout << "E";   
    }
}