#include <bits/stdc++.h>

using namespace std;

int isArrayInSortedOrder(int nums[], int n) {
	if (n == 1) {
		return 1;
	}
	return nums[n-1]<=nums[n-2] ? 0 : isArrayInSortedOrder(nums, n-1);
}

int main() {
	int nums[] = {1,2,3,4,5,6};
	cout << isArrayInSortedOrder(nums, 6) << endl;
}