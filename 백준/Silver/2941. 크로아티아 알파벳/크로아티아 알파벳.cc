#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

int main() {
	string str;
	int sum = 0;
	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == 'c') {
			if (str[i + 1] == '=' || str[i + 1] == '-') {
				sum++;
				i++;
			}
			else sum++;
		}
		else if (str[i] == 'l' || str[i] == 'n') {
			if (str[i + 1] == 'j') {
				sum++;
				i++;
			}
			else sum++;
		}
		else if (str[i] == 's' || str[i] == 'z') {
			if (str[i + 1] == '=') {
				sum++;
				i++;
			}
			else sum++;
		}
		else if (str[i] == 'd') {
			if (str[i + 1] == '-') {
				sum++;
				i++;
			}
			else if (str[i + 1] == 'z' && str[i + 2] == '=') {
				sum++;
				i=i+2;
			}
			else sum++;
		}
		else sum++;
	}
	cout << sum;

}