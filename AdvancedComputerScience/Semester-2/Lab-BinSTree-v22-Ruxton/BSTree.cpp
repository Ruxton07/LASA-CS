/*
 * Binary Search Tree class
 * Do not alter the display() function, this will break the Repl.it
 * tests
 */

#include "BSTree.h"
#include <cstdlib>
#include <iostream>

using namespace std;

/*
 * Find Element in the Tree
 * find a node by item_key and provide an updated parent node
 *   pointer and location node pointer
 */

void BST::find(int item_key, node **prnt, node **loc) {
  node *ptr, *ptrsave;
  if (root == NULL) {
    *loc = NULL;
    *prnt = NULL;
    return;
  }
  if (item_key == root->key_value) {
    *loc = root;
    *prnt = NULL;
    return;
  }
  if (item_key < root->key_value)
    ptr = root->p_left;
  else
    ptr = root->p_right;
  ptrsave = root;
  while (ptr != NULL) {
    if (item_key == ptr->key_value) {
      *loc = ptr;
      *prnt = ptrsave;
      return;
    }
    ptrsave = ptr;
    if (item_key < ptr->key_value)
      ptr = ptr->p_left;
    else
      ptr = ptr->p_right;
  }
  *loc = NULL;
  *prnt = ptrsave;
}

/*
 * Inserting Element into the Tree
 */
void BST::insert(node *tree, node *newnode) {
  // if (we are at root)
  if (tree == NULL) {
    // Just create a single node for root to point to,
    //    with all the data in it.
    root = newnode;
    return;
  }
  // if (there is already a node with our key value)
  if (tree->key_value == newnode->key_value) {
    // Just return
    return;
  }
  // if (the new node is less than the current node)
  if (newnode->key_value < tree->key_value) {
    // if (see if something is already a child on the left)
    if (tree->p_left != NULL) {
      // if so, the recurse insert at this subtree
      insert(tree->p_left, newnode);
    } else {
      // otherwise the new node goes here as a leaf (ie no children)
      tree->p_left = newnode;
      return;
    }
  } else // it must be to the right
  {
    // if (is there already a child on right?)
    if (tree->p_right != NULL) {
      // if so, the recurse insert at this subtree
      insert(tree->p_right, newnode);
    } else {
      // otherwise the new node goes here as a leaf (ie no children)
      tree->p_right = newnode;
      return;
    }
  }
}

/* Finding min value in a tree */
node *BST::findMin(node *tree) {
  node *walker = tree;
  while (walker->p_left != NULL) {
      walker = walker->p_left;
  }
  return walker;
}

node *BST::findMax(node *tree) {
  node *walker = tree;
  while (walker->p_right != NULL) {
      walker = walker->p_right;
  }
  return walker;
}


node* BST::findSuccessor(int item) {
  node* loc = new node();
  node* prnt = new node();
  find(item, &prnt, &loc);

  if (loc->p_right != NULL) {
    return findMin(loc->p_right);
    } else {
    node* a = loc;
    node* b = a->parent_node;
    while (a == b->p_right && b != NULL) {
      a=b;
      b=b->parent_node;
    }
    return b;
  }
}

node* BST::findPredecessor(int item) {
  node* loc = new node();
  node* prnt = new node();
  find(item, &prnt, &loc);

  if (loc->p_left != NULL) {
    return findMin(loc->p_left);
    } else {
    node* a = loc;
    node* b = a->parent_node;
    while (a == b->p_left && b != NULL) {
      a=b;
      b=b->parent_node;
    }
    return b;
  }
}
  /*
   * Delete Element from the tree
   */
  void BST::remove(int item) {
    node *parent = new node();
    node *location = new node();
    if (root == NULL) {
      cout << "Tree empty" << endl;
      return;
    }
    find(item, &parent, &location);
    // cout << "1" << endl;
    if (location == NULL) {
      // cout << "2" << endl;
      cout << "Item not present in tree" << endl;
      return;
    }
    // cout << "3" << endl;
    // if (there is no child on left or right)
    if (location->p_left == NULL && location->p_right == NULL) {
      // cout << "4" << endl;
      case_0(parent, location);
      free(location);
    }
    // if (there is one child on left only)
    else if (location->p_left != NULL && location->p_right == NULL) {
      // cout << "5" << endl;
      case_1(parent, location);
      free(location);
    }
    // if (there is one child on right only)
    else if (location->p_left == NULL && location->p_right != NULL) {
      // cout << "6" << endl;
      case_1(parent, location);
      free(location);
    }
    // if (there are children on left and right)
    else {
      // cout << "7" << endl;
      case_2(parent, location);
    }
  }

  // /*
  //  * Case 0
  //  * the node is simply removed no other updates necessary.
  //  */
  void BST::case_0(node * prnt, node * loc) {
    if (prnt != NULL) {
      if (loc == prnt->p_left) {
        prnt->p_left = NULL;
      } else if (loc == prnt->p_right) {
        prnt->p_right = NULL;
      }
    }
  }

  // /*
  //  * Case 1
  //  * We have only one child so promote the child and replace the target
  //  * node
  //  */
  void BST::case_1(node * prnt, node * loc) {
    if (loc->parent_node == NULL) {
      if (loc->p_left != NULL) {
        root = loc->p_left;
      } else if (loc->p_right != NULL) {
        root = loc->p_right;
      }
    } else {
      if (loc->p_right == NULL) {
        if (!(loc->key_value < loc->parent_node->key_value)) {
          loc->parent_node->p_right = loc->p_left;
        } else {
          loc->parent_node->p_left = loc->p_left;
        }
      } else if (loc->p_left == NULL) {
        if (!(loc->key_value < loc->parent_node->key_value)) {
          loc->parent_node->p_right = loc->p_right;
        } else {
          loc->parent_node->p_left = loc->p_right;
        }
      }
    }
  }

  // /*
  //  * Case case_2
  //  * We have to find and promote a successor or predecessor
  //  */
  void BST::case_2(node * prnt, node * loc) {
    if (loc->parent_node == NULL) {
      node* successor = findSuccessor(loc->key_value);
      int key = successor->key_value;
      remove(key);
      root->key_value = key;
    } else {
      node* successor = findSuccessor(loc->key_value);
      int key = successor->key_value;
      remove(key);
      root->key_value = key;
    }
  }

  /*
   * Display Tree Structure
   */
  void BST::display(node * ptr, int level) {
    int i;
    if (ptr != NULL) {
      display(ptr->p_right, level + 1);
      cout << endl;
      if (ptr == root)
        cout << "Root->:  ";
      else {
        for (i = 0; i < level; i++)
          cout << "       ";
      }
      cout << ptr->key_value;
      display(ptr->p_left, level + 1);
    }
  }
