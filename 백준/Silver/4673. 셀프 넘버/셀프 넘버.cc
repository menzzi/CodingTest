#include<stdio.h>

int sum(int n) {
	int sum = n;
	while (n > 0) {
		sum += n % 10;
		n = n / 10;
	}
	return sum;
}
int arr[10001];

int main() {
	int check;
	for (int i = 1; i < 10001; i++) {
		check = sum(i);
		if (check < 10001) {
			arr[check] = 1;
		}
	}
	for(int i = 1; i < 10001; i++) {
		if (arr[i] != 1) {
			printf("%d\n", i);
		}
	}
}