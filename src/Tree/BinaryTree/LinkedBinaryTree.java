package Tree.BinaryTree;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import java.util.Iterator;
import java.util.List;
import material.Position;

/**
 *
 * @author mayte
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {

    private class BTNode<T> implements Position<T> {

        private BTNode<T> parentNode;
        private T element;
        private BTNode<T> leftchildNode;
        private BTNode<T> rigthchildNode;

        public BTNode(BTNode<T> ParentNode, T element, BTNode<T> leftchildNode, BTNode<T> rigthchildNode) {
            this.parentNode = ParentNode;
            this.element = element;
            this.leftchildNode = leftchildNode;
            this.rigthchildNode = rigthchildNode;
        }

        @Override
        public T getElement() {
            return this.element;
        }

        public BTNode<T> getParentNode() {
            return parentNode;
        }

        public void setParentNode(BTNode<T> ParentNode) {
            this.parentNode = ParentNode;
        }

        public BTNode<T> getLeftchildNode() {
            return leftchildNode;
        }

        public void setLeftchildNode(BTNode<T> leftchildNode) {
            this.leftchildNode = leftchildNode;
        }

        public BTNode<T> getRigthchildNode() {
            return rigthchildNode;
        }

        public void setRigthchildNode(BTNode<T> rigthchildNode) {
            this.rigthchildNode = rigthchildNode;
        }

        public void setElement(T element) {
            this.element = element;
        }

    }

    private BTNode<E> root;

    public LinkedBinaryTree() {
        this.root = null;
    }

    private BTNode<E> checkPosition(Position<E> v) {
        if ((v == null) || !(v instanceof BTNode)) {
            throw new RuntimeException("El position no es valido");
        }
        return (BTNode<E>) v;
    }

    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> parentNode = checkPosition(v);
        return parentNode.getLeftchildNode();
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTNode<E> parentNode = checkPosition(v);
        return parentNode.getRigthchildNode();
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTNode<E> parentNode = checkPosition(v);
        return parentNode.getLeftchildNode() == null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTNode<E> parentNode = checkPosition(v);
        return parentNode.getRigthchildNode() == null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        return hasLeft(p) && hasRight(p);

    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        return node.getParentNode() == null;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTNode<E> parentnNode = checkPosition(p);
        E temp = parentnNode.getElement();
        parentnNode.setElement(e);
        return temp;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        if (right(parent(p)) == p) {
            return left(parent(p));
        }
        return right(parent(p));
    }

    @Override
    public Position<E> addRoot(E e) {
        if (!isEmpty()) {
            throw new RuntimeException("Ya existe una raiz");
        }
        BTNode<E> rootNode = new BTNode<>(null, e, null, null);
        this.root = rootNode;
        return rootNode;
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        BTNode<E> parentnNode = checkPosition(p);
        BTNode<E> newleftChild = null;
        if (!hasLeft(parentnNode)) {
            newleftChild = new BTNode<>(parentnNode, e, null, null);
        } else {
            BTNode<E> leftChild = parentnNode.getLeftchildNode();
            newleftChild = new BTNode<>(parentnNode, e, leftChild, null);
            leftChild.setParentNode(newleftChild);
        }
        return newleftChild;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTNode<E> parentnNode = checkPosition(p);
        BTNode<E> newrigthChild = null;
        if (!hasRight(parentnNode)) {
            newrigthChild = new BTNode<>(parentnNode, e, null, null);
        } else {
            BTNode<E> rigthChild = parentnNode.getRigthchildNode();
            newrigthChild = new BTNode<>(parentnNode, e, rigthChild, null);
            rigthChild.setParentNode(newrigthChild);
        }
        return newrigthChild;
    }

    @Override
    public E remove(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        if (!(hasLeft(p) && hasRight(p))) {
          
        }
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTNode<E> node1 = checkPosition(p1);
        BTNode<E> node2 = checkPosition(p1);
        E aux = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux);
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        return node.getParentNode();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        List<Position<E>> list = null;
        if (hasLeft(v)) {
            list.add(node.getLeftchildNode());
        }
        if (hasRight(v)) {
            list.add(node.getRigthchildNode());
        }

        return list;

    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachLeft(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachRight(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedBinaryTree<String> subTree(Position<String> h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
