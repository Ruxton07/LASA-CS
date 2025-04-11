#include <iostream>

#define MIN_DEGREE 3

struct node{
  int n;
  bool leaf;
  int k[2*MIN_DEGREE - 1];
  node* c[2*MIN_DEGREE];
  
};


node* ALLOCATE_NODE()
{
    node* aNode = new node();
    aNode->leaf = false;
    aNode->n = 0;
    for (int i=0; i < 2*MIN_DEGREE; i++) {
      aNode->c[i] = NULL;
    }
    return aNode;
}

void B_TREE_SPLIT_CHILD (node* x,int i, node* y)
{

  //
  //    >>>>   YOUR CODE GOES HERE    <<<<
  //

  node* z = ALLOCATE_NODE();
  z->leaf = y->leaf;
  z->n = MIN_DEGREE - 1;
  for (int j = 0; j < MIN_DEGREE - 1; j++) {
    z->k[j] = y->k[j + MIN_DEGREE];
  }
  if (y->leaf == false)
    for (int j = 0; j < MIN_DEGREE; j++)
      z->c[j] = y->c[j+ MIN_DEGREE];
  y->n = MIN_DEGREE-1;
  for (int j= x->n; j > i+1;j--)
    x->c[j+1] = x->c[j];
  x->c[i+1] = z;
  for (int j = x->n-1; j >= i; j--)
    x->k[j+1] = x->k[j];
  x->k[i]= y->k[MIN_DEGREE-1];
  x->n++;
}

void displayNode(node* aNode) 
{
  std::cout << "leaf: " << aNode->leaf << std::endl;
  std::cout << "keys" ;
  for (int i=0; i < aNode->n; i++) {
    std::cout << ", " << aNode->k[i];
  }
  std::cout << std::endl;
  if (aNode->leaf) {
    std::cout << "Pointers : ";
    for (int i=0; i < aNode->n+1; i++) {
      if (aNode->c[i] == NULL) {
        std::cout << "[" << i << "] = NULL, ";
      }
      else {
        std::cout << "[" << i << "] = CHILD, ";
        // std::cout << "[" << i << "] = " << aNode->c[i] << ", ";
      }
    }
    std::cout << std::endl;
  }
}

int main() {
  node* node1 = ALLOCATE_NODE();
  node* node2 = ALLOCATE_NODE();
  int index = 0;
  int inCount = 0;
  std::cout << "Hello B-TREE assignment!\n";
  std::cout << "How many keys for node 1?\n";
  std::cin >> inCount;
  node1->leaf = true;
  node1->n = inCount;
  for (int i=0; i < inCount; i++) {
    std::cout << "Enter key " << i << " ";
    std::cin >> node1->k[i];
  }

  std::cout << "How many keys for node 2?\n";
  std::cin >> inCount;
  node2->leaf = false;
  node2->n = inCount;
  for (int i=0; i < inCount; i++) {
    std::cout << "Enter key " << i << " ";
    std::cin >> node2->k[i];
  }
  std::cout << std::endl;
  for (int i=0; i < 2*MIN_DEGREE; i++) {
    node2->c[i] = NULL;
  }
  index = 0;
  for (index=0; index < node1->n; index++) {
    if (node1->k[index] > node2->k[0]) {
      node1->c[index] = node2;
      break;
    }
  }
  // if index == count then node2 keys are greater than all in node1
  if (index == node1->n)
  {
    node1->c[index] = node2;
  }

  B_TREE_SPLIT_CHILD (node1,index,node2);

  std::cout << "Contents of node 1 :" << std::endl;
  displayNode(node1);
  
  for (int i=0; i < node1->n+1; i++) {
      if (node1->c[i]){
        std::cout << "Contents of child " << i << " : " << std::endl;
        displayNode(node1->c[i]);
      }
    }

}

