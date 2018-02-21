package com.company;
/* Created by InteliJ Idea

 *User: Nicholas Gaultney
 *Date: 2/14/2018
 *intime: 3:43 PM
 *Contact: nmgaultney@gmail.com
 */

public class BinarySearchTree {      // Build this with an Integer data type for now, later figure out how to make this dynamic
    private Node root;
    private Boolean parentNode;
    private int sum;

    public void insert(int value){
        Node node = new Node(value);
        if (root == null){
            root = node;
        } else {
            insert(root, node);
        }
    }

    private void insert(Node latestRoot, Node newValue){
        if (newValue.value < latestRoot.value){
            if (latestRoot.left != null){
                insert(latestRoot.left, newValue);
            } else {
                latestRoot.left = newValue;
            }
        } else if (newValue.value >= latestRoot.value) {                            // This means that newValue greater OR EQUAL is put to the right
            if (latestRoot.right != null){
                insert(latestRoot.right, newValue);
            } else {
                latestRoot.right = newValue;
            }
        }
    }

    public void increment(int value){
        increment(value, root);
    }

    private void increment(int value, Node latestRoot){
        if (latestRoot != null){
            latestRoot.value += value;
            increment(value, latestRoot.left);
            increment(value, latestRoot.right);
        }
    }

    public void replaceWithSum(int value) {
        sum = 0;
        replaceWithSum(value, root);

        if (sum != 0){
            insert(sum);
        }
    }

    private void replaceWithSum(int value, Node latestRoot){
        if (latestRoot == null){
            return;
        }
        if (value == latestRoot.value){
            sum += (latestRoot.left == null) ? 0 : latestRoot.left.value;
            sum += (latestRoot.right == null) ? 0 : latestRoot.right.value;

            parentNode = true;
        } else if (value > latestRoot.value){
            replaceWithSum(value, latestRoot.right);
            if (parentNode){ latestRoot.right = null; parentNode = false; }
        } else {
            replaceWithSum(value, latestRoot.left);
            if (parentNode){ latestRoot.left = null; parentNode = false; }

        }
        return;
    }

    public void copy(BinarySearchTree bst){
        bst.insert(root.value);
        copy(bst, root);
    }

    private void copy(BinarySearchTree bst, Node latestRoot){
        if(latestRoot == null){return;}
        if (latestRoot.left != null) {
            bst.insert(latestRoot.left.value);
        }
        if (latestRoot.right != null) {
            bst.insert(latestRoot.right.value);
        }
        copy(bst, latestRoot.left);
        copy(bst, latestRoot.right);

    }

    public void inOrderPrint(){
        inOrderPrint(root);
    }

    private void inOrderPrint(Node latestRoot){
        if (latestRoot != null){
            inOrderPrint(latestRoot.left);
            print(latestRoot);
            inOrderPrint(latestRoot.right);
        }
    }

    private void postOrderPrint(Node currentNode){

        if (currentNode.left != null){
            postOrderPrint(currentNode.left);
        }

        if (currentNode.right != null){
            postOrderPrint(currentNode.right);
        }

        print(currentNode);
    }

    private void print(Node number){
        System.out.println(number.value);
    }
}