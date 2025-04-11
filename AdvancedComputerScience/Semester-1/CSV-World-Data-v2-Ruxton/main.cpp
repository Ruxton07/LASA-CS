#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct COUNTRY{
  string cName;
  string pop;
  string CC;
  string pos;
};

int dumpLength = 16;
int fileLength = 241;

void bubbleSortPops(COUNTRY* arr[], int n) {
  int i, j;
  bool swapped;
  for (i = 0; i < n - 1; i++) {
    swapped = false;
    for (j = 0; j < n - i - 1; j++) {
      if (arr[j]->pop < arr[j + 1]->pop) {
        COUNTRY* temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        swapped = true;
      }
    }
    if (swapped == false) break;
  }
}

int main() {
  ifstream file;
  COUNTRY datCountries[fileLength];
  COUNTRY devRegionCountries[fileLength];
  COUNTRY * pPopCountries[fileLength];
  COUNTRY * pUSRankDevCountries[fileLength];
  string dump = "";
  
  file.open("WPP2015_MORT_F07_1_LIFE_EXPECTANCY_0_BOTH_SEXES.csv");

  for (int idc = 0; idc < dumpLength; idc++) {
    getline(file, dump);
  }
  string line;
  int j = 0;
  while (file.good() && file.is_open()) {
    getline(file, line);
    for (int i = 0; i < 16; i++) {
      if (i == 0) {
        getline(file, datCountries[j].pos, ',');
      } else if (i == 2) {
        getline(file, datCountries[j].cName, ',');
      } else if (i == 4) {
        getline(file, datCountries[j].CC, ',');
      } else if (i == 15) {
        getline(file, datCountries[j].pop, ',');
      } else { getline(file, dump, ','); }
    }
    j++;
  }

  int devIndex = 0;
  for (int k = 0; k < fileLength; k++) {
    pPopCountries[k] = &datCountries[k];
    if (stoi(datCountries[k].pos) > 133 && stoi(datCountries[k].pos) < 179 && stoi(datCountries[k].CC) < 900) {
      pUSRankDevCountries[devIndex] = &datCountries[k];
      //cout << devRegionCountries[k] << endl;
      devIndex++;
    }
  }
  bubbleSortPops(pPopCountries, fileLength);
  pUSRankDevCountries[devIndex] = pPopCountries[0];
  pUSRankDevCountries[devIndex+1] = pPopCountries[6];
  pUSRankDevCountries[devIndex+2] = pPopCountries[7];
  pUSRankDevCountries[devIndex+3] = pPopCountries[40];
  
  cout << "Countries sorted by longest lived population in 2000-2005:" << endl;
  bubbleSortPops(pUSRankDevCountries, devIndex+4);
  for (int q = 0; q < fileLength; q++) {
    cout << q+1 << ": "<<pPopCountries[q]->cName << ": " << pPopCountries[q]->pop << endl;
  }
  for(int i=0; i<fileLength; i++) {
    if(pPopCountries[i]->pop=="77.13") {
      cout << '\n' << "Place of US in all countries: " << i+1 << endl;
    }
  }

  for (int t = 0; t < devIndex+4; t++) {
    if (pUSRankDevCountries[t]->pop == "77.13") {
      cout << "Position of US in developed regions: " << t+1 << endl;
    }
  }
  file.close();
}

