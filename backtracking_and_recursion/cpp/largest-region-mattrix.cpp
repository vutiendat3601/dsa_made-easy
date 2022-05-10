#include <bits/stdc++.h>

using namespace std;

string d[100];
int n, largestCnt = 0;
int visited[100][100];
int directions[8][8] = 
{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

int isInBound(int x, int y) {
	return x >= 0 && x < d[0].length() && y >= 0 && y < d[0].length();
}

void findLargestRegion(int x, int y, int& cnt){
	visited[x][y]=1;
	cnt++;
	for (int i =0;i<8;i++) {
		int xD = x + directions[i][0];
		int yD = y + directions[i][1];
		if (isInBound(xD, yD) && d[xD][yD] == '1' && !visited[xD][yD]){
			findLargestRegion(xD, yD, cnt);
		}
	}
}

void solve() {
	for (int i = 0; i < n;i++) {
		for (int j = 0;j < d[0].length();j++) {
			if (!visited[i][j]) {
				int cnt = 0;
				findLargestRegion(i, j, cnt);
				largestCnt = largestCnt >= cnt ? largestCnt : cnt;
			}
		}
	}
	cout << largestCnt << endl;
}

int main() {
	freopen("../input/largest-region-mattrix.txt", "r", stdin);
	string s;
	getline(cin, s);
	n = 0;
	while (s != "") {
		d[n++] = s;
		getline(cin, s);
	}
	for (int j = 0;j<n;j++) {
		cout << d[j] << endl;
	}
	solve();
}