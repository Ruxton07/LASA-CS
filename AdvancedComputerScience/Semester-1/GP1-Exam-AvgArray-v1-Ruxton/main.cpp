#include <sstream>
#include <iostream>
using namespace std;

float average(float arr[], int e)
{
  float total = 0;
  for (int i = 0; i < e; i++) {
    total += arr[i];
  }
  total /= e;
  return total;
}

int main()
{
    // Create variables
  int n = 0;
    // Create array named 'num' of type float of size 100 elements.
    float num[100];
    cout << "Enter the numbers of data: ";
    cin >> n;
    cout << endl;

    while (n > 100 || n <= 0)
    {
        cout << "Error! number should in range of (1 to 100)." << endl;
        cout << "Enter the number again: ";
        cin >> n;
    }
  
    cout << "Enter list of numbers separated by a space: " << endl;
    for(int i = 0; i < n; ++i)
    {
        cin >> num[i];
    }
    float av = average(num, n);
    cout << "Average = " << av;

    return 0;
}