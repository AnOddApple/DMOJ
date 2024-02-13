#include <bits/stdc++.h>

using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> locations(n);
    vector<string> words(n);
    for(int i = 0; i < n; i++){
        cin >> locations[i];
        getline(cin, words[i]);
    }
    for(int i = 0; i < n; i++){
        (words[i]).erase(locations[i], 1);
    }
    for(int i = 0; i < n; i++){
        cout << i+1 << words[i] << endl;
    }
}