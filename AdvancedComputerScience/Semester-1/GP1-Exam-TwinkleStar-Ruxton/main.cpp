#include <iostream>
#include <string>

using namespace std;


____ testFunc(________) {

}

int main() {
    string input;

    // Prompt the user for input
    cout << "Enter a string: ";

    // Read a line of text from stdin into the 'input' variable
    getline(cin, input);

    // Call the function to process the input string
    cout << testFunc(input) << endl;
  

    return 0;
}
