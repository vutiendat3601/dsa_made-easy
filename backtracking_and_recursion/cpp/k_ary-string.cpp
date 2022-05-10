#include <bits/stdc++.h>

using namespace std;

int str[20];

void printResult(int k) {
	for (int i =1;i<=k;i++) {
		cout << str[i];
	}
	cout << endl;
}

void genStr(int iTh, int n, int k) {
	for (int i = str[iTh-1]+1;i <= n - k + iTh;i++) {
		str[iTh] = i;
		if (iTh == k) {
			printResult(k);
		} else {
			genStr(iTh+1, n, k);
		}
	}
}

int main() {
	int n =5;
	genStr(1, 5, 3);
}