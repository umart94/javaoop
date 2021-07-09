package com.umartariq;
//BINARY SEARCH TREE ( with recursion )
public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root = root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            // the tree was empty , so our item becomes the head of the tree
            this.root = newItem;
            return true;
        }

        //otherwise start comparing from head of the tree
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparision = (currentItem.compareTo(newItem));
            if(comparision<0){
                //newItem is greater move right if possible
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    // there's no node to the right, so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparision > 0 ){
                //newItem is less, move left if possible
                if(currentItem.previous()!=null){
                    currentItem = currentItem.previous();
                } else {
                    //there's no node to the left so add at this point
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                //equal so dont add
                System.out.println(newItem.getValue() + " is already present ");
                return false;
            }
        }
        return false;



    }

    @Override
    public boolean removeItem(ListItem item) {

        if(item != null){
            System.out.println("Deleting item "+ item.getValue());

        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while(currentItem != null){
            int comparision = (currentItem.compareTo(item));
            if(comparision<0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparision>0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                //equal: we've found the item so remove it
                performRemoval(currentItem,parentItem);
                return true;
            }
        }

        return false;
    }
    public void performRemoval(ListItem currentItem,ListItem parentItem){
        //remove item from the tree
        if(currentItem.next() == null){
            //no right tree, so make parent point to the left tree ( which maybe null)
            if(parentItem.next()==currentItem){
                //item is right child of its parent
                parentItem.setNext(currentItem.previous());

            } else if(parentItem.previous() == currentItem){
                //item is left child of its parent
                parentItem.setPrevious(currentItem.previous());
            } else {
                //parent must be item, which means we were looking at the root of the tree
                this.root = currentItem.previous();
            }
        }
        else if (currentItem.previous() == null){
            //no left tree so make parent point to the right tree ( which maybe null)
            if(parentItem.next()==currentItem){
                //item is right child of parent
                parentItem.setNext(currentItem.next());

            } else if(parentItem.previous() == currentItem){
                //item is left child of its parent
                parentItem.setPrevious(currentItem.next());

            }else{
                //again we are deleting the root
                this.root = currentItem.next();
            }
        }
        else {
            //neither left nor right are null
            //from right subtree find the smallest value
            ListItem current = currentItem.next();
            ListItem leftMostParent = currentItem;
            while(current.previous() != null){
                leftMostParent = current;
                current = current.previous();

            }
            //put smallest value into our node to be deleted
            currentItem.setValue(current.getValue());
            //now delete the smallest value
            if(leftMostParent == currentItem){
                //there was no leftmostnode so current points to the smallest
                //node that is the one that must now be deleted
                currentItem.setNext(current.next());
            }else {
                //set smallest node parent to point to the smallest nodes right child which maybe null
                leftMostParent.setPrevious(current.next());
            }
        }
    }
    @Override
    public void traverse(ListItem root) {
               //recursive method
                if(root != null){
                    traverse(root.previous());
                    System.out.println(root.getValue());
                    traverse(root.next());
                }



    }

           /* //dont do this due to recursion
            if(root != null){
                System.out.println(root.getValue());
                traverse(root.next());
            }
    */
}
