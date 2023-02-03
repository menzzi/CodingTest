#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<string>
#include<map>
	

using namespace std;

int main() {
	int arr[6];
	int answer[6] = { 0, };
	for (int i = 0; i < 6; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < 2; i++) {
		if (arr[i] != 1) {
			answer[i] = 1 - arr[i];
		}
		else {
			answer[i] = 0;
		}
	}
	for (int i = 2; i < 5; i++) {
		if (arr[i] != 2) {
			answer[i] = 2 - arr[i];
		}
		else {
			answer[i] = 0;
		}
	}
	for (int i = 5; i < 6; i++) {
		if (arr[i] != 8) {
			answer[i] = 8 - arr[i];
		}
		else {
			answer[i] = 0;
		}
	}
	for (int i = 0; i < 6; i++) {
		cout << answer[i] << " ";
	}
}
