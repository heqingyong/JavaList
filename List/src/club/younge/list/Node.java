/** 
 * @projectName:List 
 * @fileName:Node.java 
 * @packageName:club.younge.list 
 * @date:2016年8月25日上午12:17:17 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.list;  
/** 
 * @className:Node 
 * @function: 双向链表节点实体类  
 * @reason:    
 * @date:     2016年8月25日 上午12:17:17
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	public Node() {
		
	}
	public Node(T data) {
		this.data = data;
	}
	//实现equals和hashCode, 两个最好一同改写
	public boolean equals(Node<T> node) {
		if (data.equals(node.getData())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return data.hashCode();
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public Node<T> getPrev() {
		return prev;
	}
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
}

