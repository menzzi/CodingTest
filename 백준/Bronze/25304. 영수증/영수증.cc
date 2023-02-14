#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<string>
#include<map>
#include<vector>

using namespace std;


int main() {
	int sum, N;
	cin >> sum;
	cin >> N;
	int result = 0;
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		result += a * b;
	}
	if (result == sum) {
		cout << "Yes";
	}
	else {
		cout << "No";
	}
}
