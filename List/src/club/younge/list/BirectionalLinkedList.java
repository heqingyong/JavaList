/** 
 * @projectName:List 
 * @fileName:BirectionalLinkedList.java 
 * @packageName:club.younge.list 
 * @date:2016��8��25������12:22:51 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */

package club.younge.list;

/**
 * @className:BirectionalLinkedList
 * @function: ˫�����������
 * @reason: 
 * @date: 2016��8��25�� ����12:22:51
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
		if (head.getNext() == null) {// ͷ�ڵ��û�нڵ㣬˵������Ϊ�գ�Ҳ����ͨ��β�ڵ��ǰһ���ڵ��Ƿ�Ϊ�������ж�
			head.setNext(data);
			data.setPrev(head);
			tail.setPrev(data);
			data.setNext(tail);
		} else {
			data.setNext(head.getNext()); // �ı�ýڵ�ĺ�һ���ڵ�Ϊͷ�ڵ����һ���ڵ�---�ýڵ���һ���ڵ�
			head.getNext().setPrev(data); // �ı�ͷ�ڵ����һ���ڵ��ǰһ���ڵ�Ϊ�ýڵ�---��һ���ڵ��ǰһ���ڵ�
			// ��ͨ�ýڵ�������ָ��
			head.setNext(data); // ���ͷ�ڵ����һ���ڵ�ָ��ýڵ�
			// ����һ��ʼָ��ýڵ㣬���޷���ȡͷ�ڵ��ԭʼ��һ�ڵ㣬����˼·�����������Է����ͷ�ڵ��ԭʼ��һ�ڵ㵽һ��ʱ�ڵ㣩
			data.setPrev(head); // ͷ�ڵ�ûֵ
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
			data.setNext(tail); // β�ڵ�ûֵ
		}
	}

	// ���ĳ���ڵ㵽ָ������ֵ�Ľڵ����
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
					data.setNext(temp.getNext().getNext()); // �ýڵ����һ���ڵ�
					temp.getNext().getNext().setPrev(data); // ��һ���ڵ��ǰһ���ڵ�
					temp.getNext().setNext(data);
					data.setPrev(temp.getNext());
					break;
				}
				temp = temp.getNext();
			}
			
		}
	}

	// ���ĳ���ڵ㵽ָ������ֵ�Ľڵ�ǰ��
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
										// //ǰһ���ڵ����һ���ڵ�
					data.setPrev(temp); // data.setPrev(temp.getNext().getPrev());
										// //�ýڵ��ǰһ���ڵ�
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
