#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <string>
#include <vector>

using namespace std;

class SALESREC {
public:
  string date;
  string region;
  string rep;
  string item;
  string units;
  string unitCost;
  float Total;
  float calcTotal() {
    return atof(units.c_str()) * atof(unitCost.c_str()); }
};
void bubbleSortPops(SALESREC *arr[], int n) {
  for (int i=0; i < n; i++) {
		for (int j=i; j < n; j++) {
  		if ((arr[i]->Total) < (arr[j]->Total))
  		{
        SALESREC* temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
  		}
    }
  }
}

int main() {
  ifstream file;
  char cNum[10];
  SALESREC salesArr[40];
  int salesArrayCount = 0;
  SALESREC *s[40];
  string line;

  file.open("SalesDataPt2.csv", ifstream::in);
  int j = 0;
  getline(file, line);
  cout << line << endl;
  while (file.good() && file.is_open()) {
    getline(file, salesArr[j].date, ',');
    getline(file, salesArr[j].region, ',');
    getline(file, salesArr[j].rep, ',');
    getline(file, salesArr[j].item, ',');
    getline(file, salesArr[j].units, ',');
    getline(file, salesArr[j].unitCost, '\n');
    j++;
  }
  salesArrayCount = j;
  file.close();
  // Initialize the sort array pointers
  for (int i = 0; i < salesArrayCount; i++) {
    s[i] = &salesArr[i];
    salesArr[i].Total = salesArr[i].calcTotal();
  }
  bubbleSortPops(s, 31);
  for (int i = 0; i < salesArrayCount; i++) {
    if ((s[i]->Total) != 0)
      cout << s[i]->date << "," << s[i]->region << ","
         << s[i]->rep << "," << s[i]->item << "," << s[i]->units << ","
         << s[i]->unitCost << "," << s[i]->Total << endl;
  }
}