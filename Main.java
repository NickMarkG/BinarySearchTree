package com.company;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();

        BST.insert(60);
        BST.insert(70);
        BST.insert(32);
        BST.insert(5);
        BST.insert(42);
        BST.insert(80);

        BST.inOrderPrint();
        System.out.println();
        //BST.increment(10);
        //BST.inOrderPrint();

        //BST.replaceWithSum(32);
        //BST.inOrderPrint();

        BinarySearchTree newBST = new BinarySearchTree();
        BST.copy(newBST);
        newBST.inOrderPrint();

    }
}
