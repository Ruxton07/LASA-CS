/*
 * C++ Program To Implement BST
 */
#ifndef BSTREE_H
#define BSTREE_H


/*
 * Node Declaration
 */
struct node
{
    int key_value;
    struct node *parent_node;
    struct node *p_left;
    struct node *p_right;
};
 
/*
 * Class Declaration
 */
class BST
{
public:
		node* root;
        void find(int, node **, node **);    
        void insert(node *, node *);
        void remove(int);
        void remove(node *, int);
        void display(node *, int);
        void case_0(node *prnt, node *loc);
        void case_1(node *prnt, node *loc);
        void case_2(node *prnt, node *loc);
        node* findMin(node* tree);
        node* findMax(node* tree);
        node* findSuccessor(int item);
        node* findPredecessor(int item);
        BST()
        {
            root = nullptr;
        }
};


#endif	//BSTREE_H

