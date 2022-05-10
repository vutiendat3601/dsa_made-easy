#include <bits/stdc++.h>

using namespace std;

int bins[20];

void printResult(int n) {
	for (int i =1;i<=n;i++) {
		cout << bins[i];
	}
	cout << endl;
}

void genBin(int iTh, int n) {
	for (int i=0;i<=1;i++) {
		bins[iTh]=i;
		if (iTh == n) {
			printResult(n);
		}else {
			genBin(iTh+1, n);
		}
	}
}

int main() {
	int n = 3;
	genBin(1, n);
}