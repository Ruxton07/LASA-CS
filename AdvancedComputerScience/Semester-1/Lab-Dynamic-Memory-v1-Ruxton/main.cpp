#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <string>
#include <vector>
#include <stdio.h>
#include <new>

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
  		if ((arr[i]->Total) >= (arr[j]->Total))
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
  int salesArrayCount = 0;
  SALESREC **s = new SALESREC*[40];
  string line;
  
  file.open("SalesDataDyn.csv", ifstream::in);
  int j = 0;
  getline(file, line);
  cout << "Record: " << line << endl;
  while (file.good() && file.is_open()) {
    SALESREC *saleRecItem = new SALESREC();
    getline(file, saleRecItem->date, ',');
    getline(file, saleRecItem->region, ',');
    getline(file, saleRecItem->rep, ',');
    getline(file, saleRecItem->item, ',');
    getline(file, saleRecItem->units, ',');
    getline(file, saleRecItem->unitCost, '\n');
    saleRecItem->Total = saleRecItem->calcTotal();
    s[j] = saleRecItem;
    j++;
  }
  salesArrayCount = j;
  file.close();
  bubbleSortPops(s, 31);
  for (int i = 0; i < salesArrayCount; i++) {
    if ((s[i]->Total) != 0)
      cout << "Record: " << s[i]->date << "," << s[i]->region << ","
         << s[i]->rep << "," << s[i]->item << ", " << s[i]->units << ", "
         << s[i]->unitCost << ", " << s[i]->Total << endl;
  }
  delete[] s;
}