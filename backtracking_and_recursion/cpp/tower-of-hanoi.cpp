#include <bits/stdc++.h>

using namespace std;

void towerOfHanoi(int numOfDisk, char src, char des, char mid)
{
	if (numOfDisk == 1) {
		cout << "Move " << src << " to " << des << endl;
		return;
	}
	towerOfHanoi(numOfDisk-1, src, mid, des);
	towerOfHanoi(1, src, des, mid);
	towerOfHanoi(numOfDisk-1, mid, des, src);
}

int main() {
	int n = 3;
	towerOfHanoi(n, 'A', 'C', 'B');
}