#include <fstream>
#include <iostream>
#include <string>
#include <cstring>
#include <sstream>

using namespace std;

class Rec {
public:
  char orderDate[16];
  char region[16];
  char rep[16];
  char item[64];
  int units;
  float price;

  Rec() {}

  float total() { return units * price; }

  friend ostream &operator<<(ostream &os, const Rec &record) {
    os << record.orderDate << ", " << record.rep << ", " << record.item << endl;
    return os;
  }

  bool operator==(const Rec &check) {
    return (strcmp(orderDate, check.orderDate) == 0) && (strcmp(rep, check.rep) == 0) &&
           (strcmp(item, check.item) == 0);
  }

  Rec operator+(Rec &other) {
    other.units += units;
    return other;
  }
};

int main() {
  std::cout << "Hello More Sales Data!  :)\n";

  ifstream file("SalesDataP5.csv");
  if (!file.is_open()) {
    cout << "Error: Unable to open file.\n";
    return 1;
  }

  const int maxRecords = 50; // Maximum number of records
  Rec records[maxRecords];   // Use a standard array for storing records
  int recordCount = 0;       // Counter for the number of records read

  string tempLine;
  while (getline(file, tempLine)) {
    if (recordCount < maxRecords) {
      // Assuming CSV format: orderDate,region,rep,item,unit,price
      Rec &rec = records[recordCount];
      if (sscanf(tempLine.c_str(), "%[^,],%[^,],%[^,],%[^,],%d,%f",
                 &rec.orderDate[0], &rec.region[0], &rec.rep[0], &rec.item[0],
                 &rec.units, &rec.price) == 6) {
        recordCount++;
      }
    } else {
      cout << "Warning: Maximum record limit reached.\n";
      break;
    }
  }

  file.close();

  for (int i = 0; i < recordCount; i++)
    cout << records[i].orderDate << "," << records[i].region << ","
         << records[i].rep << "," << records[i].item << "," << records[i].units
         << "," << records[i].price << "," << records[i].total() << endl;
  cout << '\n' << '\n' << endl;
  for (int v = 0; v < recordCount - 1; v++) {
    if (records[v] == records[v+1]) {
      Rec eRec;
      eRec.units = -1;
      records[v] = eRec;
    }
  }
  for (int w = 0; w < recordCount; w++)
    if (records[w].units != -1)
      cout << records[w];
  return 0;
}
