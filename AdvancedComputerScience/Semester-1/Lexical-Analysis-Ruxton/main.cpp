#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

// returns count of non-overlapping occurrences of 'sub' in 'str'
int countSubstring(const string& str, const string& sub)
{
	if (sub.length() == 0) return 0;
	int count = 0;
	for (int offset = str.find(sub); offset != string::npos; 
		offset = str.find(sub, offset + sub.length()))
	{
		++count;
	}
	return count;
}

int wordCounts(const string& doc) {
  int words = 1;
  for (int i = 0; i < doc.length()-1; i++) {
    if (doc[i] == ' ' && isalpha(doc[i+1]) && !(isdigit(doc[i+1]))) {
      words++;
    }
  }
  return words;
}

int uniqueWords(const string& doc) {
  string currentWord = "";
  int total = -1; //accounts for intial offset
  vector<string> arr;
  for (int i = 0; i < doc.length(); i++) {
    if (doc.substr(i, 1) != " ") {
      currentWord += doc.substr(i, 1);
    } else {
      bool in = false;
      for (auto j = arr.begin(); j != arr.end(); ++j) {
        if (*j == currentWord) {
          in = true;
        }
      }
      if (doc.substr(i+1, 1) != " " && !in) {
        arr.push_back(currentWord);
        currentWord = "";
        total++;
      } else if (in) { currentWord = ""; }
    }
  }
  return total;
}

int sentenceCount(const string& doc) {
  int total = 0;
  for (int i = 0; i < doc.length(); i++) {
    if (doc.substr(i, 1) == ".") {
      total++;
    }
  }
  return total;
}

string lexicalDensity(const string& doc) {
  return to_string((int)((((float)uniqueWords(doc)/wordCounts(doc))*100)+0.5f)) + "%";
}

int main()
{

   string source = ("I was born in Lousiana down on the ol bayou raised on shrimps and catfish mamas good gumbo.  I got the ramblin fever.  Said goodbye to ma and pa.   Crossed that ol red river and this is what I saw. I saw miles and miles of Texas 1000 stars up in the sky.  I saw miles and miles of Texas gonna live here till I die.");


	cout << "substring count: " << countSubstring(source, "is")        << '\n';
  cout << "word count: " << wordCounts(source) << '\n';
  cout << "Unique word count: " << uniqueWords(source) << '\n';
  cout << "Lexical density: " << lexicalDensity(source) << '\n';

	return 0;
}