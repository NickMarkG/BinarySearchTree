package com.company;
/* Created by InteliJ Idea

 *User: Nicholas Gaultney
 *Date: 2/14/2018
 *Time: 3:43 PM
 *Contact: nmgaultney@gmail.com
 */

public class Node {
    public Integer value;
    public Node right;
    public Node left;


    public Node(int value) {
        this.value = value;
    }

    public void delete(){
        delete(this);
    }

    private void delete(Node latestRoot){
       if (latestRoot != null) {
           delete(latestRoot.left);
           delete(latestRoot.right);

           latestRoot = null;
       }
    }

    //TODO: Build more comparison methods for different classes
}
