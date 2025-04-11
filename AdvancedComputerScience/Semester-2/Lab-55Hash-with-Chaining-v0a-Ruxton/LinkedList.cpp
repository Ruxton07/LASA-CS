//*****************************************************************
//  LinkedList.cpp
//  HashTable

//
//  This header file contains the Linked List class declaration.
//  Hash Table array elements consist of Linked List objects.
//*****************************************************************

#include "LinkedList.h"

// Constructs the empty linked list object.
// Creates the head node and sets length to zero.
LinkedList::LinkedList()
{
    head = NULL;
    length = 0;
}

// Inserts an item at the end of the list.
void LinkedList::insert( Element * newElement )
{
  //cout << "Insert function ran" << endl;
  if (head == NULL) {
    //cout << "If ran" << endl;
    head = newElement;
  } else {
    //cout << "Else ran" << endl;
    Element *current = head;
    //cout << "yay head isnt null" << endl;
    while (current->next != nullptr) {
      current = current->next;
    }
    current->next = newElement;
  }
  length++;
  //cout << "COMPLETED" << endl;
}

// Removes an item from the list by item key.
// Returns true if the operation is successful.
bool LinkedList::remove( string Key )
{
  //cout << "Remove function ran" << endl;
  Element *current = head;
  for (int i = 0; i < length; i++) {
    if (current->key == Key) {
      //cout << "In if loop" << endl;
      Element *thisIter = head;
      //cout << "wth" << endl;
      if (i > 0) {
        for (int j = 0; j < i; j++) {
          //cout << "In inner for loop" << endl;
          thisIter = thisIter->next;
        }
        thisIter->next = current->next;
        delete current;
      } else {
        head = nullptr;
      }
      //cout << "after inner for loop" << endl;
      //cout << "current key is: " << current->key << endl;
      //cout << "thisIter key is: " << thisIter->key << endl;
      length--;
      return true;
      //cout << "okay linkages r changed" << endl;
      //cout << "At end of if loop" << endl;
    }
    current = current->next;
  }
  //cout << "for loop done" << endl;
  return false;
  //cout << "Remove completed" << endl;
  
}

// Searches for an item by its key.
// Returns a reference to first match.
// Returns a NULL pointer if no match is found.
Element * LinkedList::get( string Key )
{
  Element *current = head;
  for (int i = 0; i < length; i++) {
    if (current->key == Key) {
      return current;
    }
    current = current->next;
  }
  return nullptr;
}

// Displays list contents to the console window.
void LinkedList::printList()
{
    if (length == 0)
    {
        cout << "\n{ }\n";
        return;
    }
    Element * p = head;
    Element * q = head;
    cout << "\n{ ";
    while (q)
    {
        p = q;
        //if (p != head)
        if (p != nullptr)
        {
            cout << p -> key;
            if (p -> next) cout << ", ";
            else cout << " ";
        }
        q = p -> next;
    }
    cout << "}\n";
}

// Returns the length of the list.
int LinkedList::getLength()
{
    return length;
}

// De-allocates list memory when the program terminates.
LinkedList::~LinkedList()
{
  // * * * * * * * * * * *
  // Your code goes here
  // * * * * * * * * * * *
}

//*****************************************************************
// End of File
//*****************************************************************