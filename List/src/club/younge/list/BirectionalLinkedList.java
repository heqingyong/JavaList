/** 
 * @projectName:List 
 * @fileName:BirectionalLinkedList.java 
 * @packageName:club.younge.list 
 * @date:2016年8月25日上午12:22:51 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */

package club.younge.list;

/**
 * @className:BirectionalLinkedList
 * @function: 双向链表操作类
 * @reason: 
 * @date: 2016年8月25日 上午12:22:51
 * @author Younge
 * @version
 * @since JDK 1.8
 * @see
 */
public class BirectionalLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;

	public BirectionalLinkedList() {
		head = new Node<T>();
		tail = new Node<T>();
	}

	public void insertAfterHead(Node<T> data) {
		if (head.getNext() == null) {// 头节点后还没有节点，说明链表为空，也可以通过尾节点的前一个节点是否为空作出判断
			head.setNext(data);
			data.setPrev(head);
			tail.setPrev(data);
			data.setNext(tail);
		} else {
			data.setNext(head.getNext()); // 改变该节点的后一个节点为头节点的下一个节点---该节点下一个节点
			head.getNext().setPrev(data); // 改变头节点的下一个节点的前一个节点为该节点---下一个节点的前一个节点
			// 打通该节点后的两个指向
			head.setNext(data); // 最后将头节点的下一个节点指向该节点
			// （若一开始指向该节点，则无法获取头节点的原始下一节点，觉得思路不清晰，可以分离出头节点的原始下一节点到一临时节点）
			data.setPrev(head); // 头节点没值
		}
	}

	public void insertBeforeTail(Node<T> data) {
		if (isEmpty()) {
			tail.setPrev(data);
			head.setNext(data);
		} else {
			data.setPrev(tail.getPrev());
			tail.getPrev().setNext(data);
			tail.setPrev(data);
			data.setNext(tail); // 尾节点没值
		}
	}

	// 添加某个节点到指定的数值的节点后面
	public void insertAfter(Node<T> data, T key) {
		if (isEmpty()) {
			System.out.println("The biretional linked list is empty!");
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				if (temp.getNext().getData().equals(key)) {
					/*if (temp.getNext().getNext() == null) {
						temp.getNext().setNext(tail);
					}*/
					data.setNext(temp.getNext().getNext()); // 该节点的下一个节点
					temp.getNext().getNext().setPrev(data); // 下一个节点的前一个节点
					temp.getNext().setNext(data);
					data.setPrev(temp.getNext());
					break;
				}
				temp = temp.getNext();
			}
			
		}
	}

	// 添加某个节点到指定的数值的节点前面
	public void insertBefore(Node<T> data, T key) {
		if (isEmpty()) {
			System.out.println("The biretional linked list is empty!");
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				if (temp.getNext().getData().equals(key)) {
					data.setNext(temp.getNext());
					temp.getNext().setPrev(data);
					temp.setNext(data); // temp.getNext().getPrev().setNext(data);
										// //前一个节点的下一个节点
					data.setPrev(temp); // data.setPrev(temp.getNext().getPrev());
										// //该节点的前一个节点
					break;
				}
				temp = temp.getNext();
			}
		}
	}

	public void traverseFromHead() {
		if (isEmpty()) {
			System.out.println("The biretional linked list is empty!");
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				if (temp.getNext() == tail) {
					break;
				}
				System.out.print(temp.getNext() + "--->");
				temp = temp.getNext();
			}
			System.out.println();

		}
	}

	public void traverseFromTail() {
		if (isEmpty()) {
			System.out.println("The biretional linked list is empty!");
		} else {
			Node<T> temp = tail;
			while (temp.getPrev() != null) {
				if (temp.getPrev() == head) {
					break;
				}
				System.out.print(temp.getPrev() + "--->");
				temp = temp.getPrev();
			}
			System.out.println();

		}
	}

	public boolean isEmpty() {
		if (head.getNext() == null || tail.getPrev() == null) {
			return true;
		}
		return false;
	}
}
