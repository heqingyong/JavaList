/** 
 * @projectName:List 
 * @fileName:BirectionalLinkedListTest.java 
 * @packageName:club.younge.test 
 * @date:2016年8月25日上午1:10:52 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.test;

import club.younge.list.BirectionalLinkedList;
import club.younge.list.Node;

/** 
 * @className:BirectionalLinkedListTest 
 * @function: 双向链表测试类  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年8月25日 上午1:10:52
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class BirectionalLinkedListTest {
	
	public static void main(String[] args) {
		final int MAX = 6;
		BirectionalLinkedList<Integer> list = new BirectionalLinkedList<Integer>();
		System.out.println( "Form insert:");
		Node<Integer> node;
		for (int i = 0; i < MAX; i++) {
			node = new Node<Integer>(i);
			System.out.print(node + "--->");
			list.insertAfterHead(node);
		}
		System.out.println("\nTraverse from head:");
		list.traverseFromHead();
		System.out.println("Traverse from tail:");
		list.traverseFromTail();
		Node<Integer> node1 = new Node<Integer>(33);
		list.insertAfter(node1, 0);
		System.out.println("\nTraverse from head(insert 33 after 0):");
		list.traverseFromHead();
		System.out.println("Traverse from tail(insert 33 after 0):");
		list.traverseFromTail();
		
		Node<Integer> node2 = new Node<Integer>(66);
		list.insertBefore(node2, 5);
		System.out.println("\nTraverse from head(insert 66 before 5):");
		list.traverseFromHead();
		System.out.println("Traverse from tail(insert 66 before 5):");
		list.traverseFromTail();
	}
}

