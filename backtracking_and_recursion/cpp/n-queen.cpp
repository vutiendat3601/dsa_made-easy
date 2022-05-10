#include <bits/stdc++.h>

using namespace std;

int queen_pos[20];
int n;

void printResult() {
	for (int i =0;i<n;i++) {
		cout << queen_pos[i] << " ";
	}
	cout << endl;
}

void solve(int r) {
	if (r == n){
		printResult();
	} else {
		for (int c=0;c<n;c++) {
			int ok = 1;
			for (int j = 0;j<r;j++) {
				if (c == queen_pos[j] || r - j == c - queen_pos[j] ||
				r - j == queen_pos[j] - c) {
					ok = 0;
					break;
				}
			}
			if (ok) {
				queen_pos[r] = c;
				solve(r+1);
			}
		}
	}
}

int main() {
	n = 6;
	solve(0);
}