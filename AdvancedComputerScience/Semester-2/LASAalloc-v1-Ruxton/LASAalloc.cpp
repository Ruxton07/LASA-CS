/* * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 		LASAalloc.h
 * 		LASAalloc class declaration.
 *
 * 		Do not change this file other than to add local varaibles and
 * Functions. Make any changes only in the provided block.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include "LASAalloc.h"
#include <iostream>
#include <stdlib.h>

// Defines for LASAalloc buffer simulation.
// Keep it simple, no changes to program break
#define INITIAL_MALLOC_SIZE 100000
#define MAX_MALLOC_SIZE 100000

using namespace std;

// typedef unsigned char BYTE_t;

LASAalloc::LASAalloc() {
  brk(INITIAL_MALLOC_SIZE);

  // Point to where first node will be located.
  block *firstBlock = (block *)bufferBase;
  freeList = firstBlock;

  // Configure first node on freeList
  firstBlock->size = (int)(bufferSize);
  firstBlock->prev_block = nullptr;
  firstBlock->next_block = nullptr;
  firstBlock->this_block_data =
      (void *)((long long int)bufferBase + (long long int)sizeof(block));
  firstBlock->freeFlag = true;

  // Show initial statistics
  cout << "buffer Allocation: " << bufferBase << " - " << brk(0) << endl;
  cout << "freeList: " << freeList << " - " << brk(0) << endl;
  cout << "Block header size " << sizeof(block) << endl;
  cout << "integer size " << sizeof(int) << endl;

  display_node(freeList);
}

LASAalloc::~LASAalloc() { free(bufferBase); }

void LASAalloc::display_node(struct block *p) {
  cout << "Prev: " << p->prev_block;
  cout << "\tNext: " << p->next_block;
  cout << "\tFree: " << p->freeFlag;
  cout << "\tSize: " << p->size;
  cout << "\tThis: " << p->this_block_data << endl;
  cout << endl;
}

void LASAalloc::display() {
  struct block *p;
  if (freeList == NULL) {
    // cout<<"List is empty\n";
    return;
  }
  p = freeList;
  // cout<<"List is :\n";
  while (p != NULL) {
    display_node(p);
    p = p->next_block;
  }
  cout << "\n";
}

void *LASAalloc::lalloc(int size) {
  block *tempBlock = (block *)findFit(size);
  if ((size + sizeof(block)) <= tempBlock->size) {
    tempBlock = (block *)(split(tempBlock, size));
  }
  tempBlock->this_block_data = tempBlock + sizeof(block);
  return tempBlock->this_block_data;
  // block *freeBlock = freeList;
  // // cout << "allocation subtraction: " << size+sizeof(block) << endl;
  // // cout << (freeBlock->next_block != nullptr) << endl;
  // while (freeBlock->next_block != nullptr &&
  //        freeBlock->size < size + sizeof(block)) {
  //   // cout << "3" << endl;
  //   freeBlock = freeBlock->next_block;
  // }
  // // cout << "4" << endl;
  // if (freeBlock->size >= size + sizeof(block)) { // Don't need to hijack
  //   block *splitBlock = new block();
  //   splitBlock = (block *)((long long int)freeBlock->this_block_data + size);
  //   // cout << "okay splitBlock is lowkey " << splitBlock << " and it was set
  //   to " << (void* )((long long int)freeBlock->this_block_data + size) <<
  //   endl; if (freeBlock->prev_block != nullptr) {
  //     freeBlock->prev_block->next_block = splitBlock;
  //     splitBlock->prev_block = freeBlock->prev_block;
  //   } else {
  //     freeList = splitBlock;
  //     splitBlock->prev_block = nullptr;
  //   }
  //   splitBlock->this_block_data =
  //       (block *)((long long int)splitBlock + sizeof(block));
  //   splitBlock->size = freeBlock->size - size - sizeof(block);
  //   // cout << "4.5" << endl;
  //   freeBlock->size = size;
  //   // cout << "splitBlock->size: " << splitBlock->size << endl;
  //   freeBlock->freeFlag = false;
  //   splitBlock->freeFlag = true;
  //   ///////////////freeBlock->prev_block =
  //   return freeBlock->this_block_data;
  // } else { // Need to hijack
  //   cout << "IM HIJACKING BTW" << endl;
  //   freeBlock->freeFlag = false;
  //   if (freeBlock == freeList) {
  //     freeList = freeBlock->next_block;
  //   }
  //   return freeBlock->this_block_data;
  // }
}

void *LASAalloc::findFit(int size) {
  size += (size % 8);
  block *freeBlock = freeList;
  while (freeBlock->next_block != nullptr) {
    if (freeBlock->freeFlag && freeBlock->size >= size) {
      return freeBlock;
    }
    freeBlock = freeBlock->next_block;
  }
  if (freeBlock == nullptr &&
      !(freeBlock->freeFlag && freeBlock->size >= size)) {
    return nullptr;
  } else {
    return freeBlock;
  }
}

void *LASAalloc::split(block *freeBlock, int size) {
  freeBlock->freeFlag = false;
  if (freeBlock->size > (size + sizeof(block))) {
    block *splitBlock = new block();
    block *nextBlock = freeBlock->next_block;
    splitBlock->next_block = nextBlock;
    if (nextBlock != nullptr)
      nextBlock->prev_block = splitBlock;
    splitBlock->prev_block = freeBlock;
    splitBlock->freeFlag = true;
    splitBlock->size = freeBlock->size - size - sizeof(block);
    freeBlock->next_block = splitBlock;
  }
  freeBlock->size = size;
  return freeBlock;
}

void LASAalloc::lfree(void *userBlock) {
  block *tempBlock = freeList;
  while (tempBlock != nullptr && tempBlock->next_block != nullptr) { // Identifying the block
    bool exitLoop = false;
    if (tempBlock->this_block_data == userBlock) {
      tempBlock->freeFlag = true;
      exitLoop = true;
    }
    if (exitLoop)
      break;
    tempBlock = tempBlock->next_block;
  }
  while (tempBlock != nullptr && tempBlock->next_block != nullptr) { // Coalescing loop
    if (tempBlock->freeFlag && tempBlock->next_block->freeFlag) {
      tempBlock->size += tempBlock->next_block->size + sizeof(block);
      // block *nextBlock = tempBlock->next_block;
      tempBlock->next_block = tempBlock->next_block->next_block;
      if (tempBlock->next_block != 0) {
        tempBlock->next_block->prev_block = tempBlock;
      }
    }
    tempBlock = tempBlock->next_block;
    if (tempBlock == nullptr)
      break;
  }
  if (tempBlock != nullptr && tempBlock->next_block != nullptr) {
    while (tempBlock != nullptr && tempBlock->next_block != nullptr) { // Coalescing loop repeated pass for double
                                    // coalescence
      if (tempBlock == nullptr || tempBlock->next_block == nullptr)
        break;
      if (tempBlock->freeFlag && tempBlock->next_block->freeFlag) {
        tempBlock->size += tempBlock->next_block->size + sizeof(block);
        // block *nextBlock = tempBlock->next_block;
        tempBlock->next_block = tempBlock->next_block->next_block;
        if (tempBlock->next_block != nullptr) {
          tempBlock->next_block->prev_block = tempBlock;
        }
      }
      tempBlock = tempBlock->next_block;
      if (tempBlock == nullptr || tempBlock->next_block == nullptr)
        break;
    }
  }
  // // cout << "9.7" << endl;
  // block *accessibleUserBlock =
  //     ((block *)((long long int)userBlock - sizeof(block)));
  // // cout << "9.8" << endl;
  // block *nextBlock = (block*)((long long int)accessibleUserBlock +
  // accessibleUserBlock->size);
  // // cout << "10" << endl;
  // block *prevBlock = accessibleUserBlock->prev_block;
  // // cout << "10.1" << endl;
  // bool nextBlockState = (nextBlock != nullptr && (((long long int)
  // accessibleUserBlock + sizeof(block) + accessibleUserBlock->size)==((long
  // long int)nextBlock))) ? nextBlock->freeFlag : false; bool prevBlockState =
  // (prevBlock != nullptr && (((long long int) prevBlock + sizeof(block) +
  // prevBlock->size)==((long long int)accessibleUserBlock))) ?
  // prevBlock->freeFlag : false;
  // // cout << "nextBlock: " << nextBlock << endl;
  // // cout << "nextBlockState: " << nextBlockState << endl;
  // if (nextBlockState) {
  //   // cout << "10.2" << endl;
  //   accessibleUserBlock->next_block = nextBlock->next_block ?
  //   nextBlock->next_block : nullptr;
  //   // cout << "10.3" << endl;
  //   if (nextBlock->next_block != nullptr) {
  //     nextBlock->next_block->prev_block = accessibleUserBlock;
  //   }
  //   // cout << "10.4" << endl;
  //   accessibleUserBlock->size += nextBlock->size + sizeof(block);
  //   // cout << "10.5" << endl;
  //   accessibleUserBlock->freeFlag = true;
  // }
  // // cout << "11" << endl;
  // if (prevBlockState) {
  //   // accessibleUserBlock = prevBlock;
  //   // nextBlock = accessibleUserBlock->next_block;
  //   // prevBlock = accessibleUserBlock->prev_block;
  //   // accessibleUserBlock->next_block = nextBlock->next_block ?
  //   nextBlock->next_block : nullptr;
  //   // if (nextBlock->next_block != nullptr) {
  //   //   nextBlock->next_block->prev_block = accessibleUserBlock;
  //   // }
  //   // accessibleUserBlock->size += nextBlock->size + sizeof(block);
  //   // accessibleUserBlock->freeFlag = true;
  //   // // accessibleUserBlock->prev_block = prevBlock->prev_block;
  //   // // prevBlock->prev_block->next_block = accessibleUserBlock;
  //   // // accessibleUserBlock->size += prevBlock->size+sizeof(block);
  // }
  // if (((long long int)accessibleUserBlock) < ((long long int) freeList)) {
  //   accessibleUserBlock->next_block = freeList;
  //   accessibleUserBlock->next_block->prev_block = accessibleUserBlock;
  //   freeList = accessibleUserBlock;
  // } else {
  //   block *p = freeList;
  //   while (p->next_block != nullptr && ((long long int)p->next_block) <
  //   ((long long int)accessibleUserBlock)) {
  //     p = p->next_block;
  //   }
  //   accessibleUserBlock->next_block = p->next_block;
  //   p->next_block->prev_block = accessibleUserBlock;
  //   p->next_block = accessibleUserBlock;
  //   accessibleUserBlock->prev_block = p;
  // }
  // return nullptr;
}

/*
 *   >>>>>>  DO NOT CHANGE THIS SECTION  <<<<<<<
 *
 * brk()
 * Function to simulate the libc brk() function to allocate memory for a buffer
 *
 */

void *LASAalloc::brk(int size) {

  if (size != 0) {
    if (bufferBase == 0) {
      bufferBase = malloc(size);
      bufferSize = size;
    } else {
      cout << "buffer already locked/n";
      return 0;
    }
  }
  return bufferSize + (block *)bufferBase;
}