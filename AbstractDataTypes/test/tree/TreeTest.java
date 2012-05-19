package tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {
	Tree<String, Object> tree;

	@Before
	public void setUp() throws Exception {
		tree = new Tree<String, Object>();
	}

	@Test
	public void testInsertSimple() {
		tree.insert("hallo");
		assertEquals("hallo", tree.getRoot().key);
	}

	@Test
	public void testToStringSimple() {
		tree.insert("a");
		assertEquals("a", tree.toString());
	}

	@Test
	public void testInsertAndToString() {
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");

		assertEquals("a, b, c", tree.toString());
		Tree<String,Object>.Node a = tree.find("a");
		Tree<String,Object>.Node b = tree.find("b");
		Tree<String,Object>.Node c = tree.find("c");
		assertEquals(b,a.parent);
		assertEquals(b,c.parent);
		assertEquals(null,b.parent);
	}

	@Test
	public void testMinimum() {
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");

		assertEquals("a", tree.minimum().key);
	}

	@Test
	public void testInsertAndToStringInteger() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(11);
		it.insert(23);
		it.insert(28);
		it.insert(1);
		assertEquals("1, 5, 11, 12, 20, 23, 28", it.toString());
		assertEquals("((1-5-11)-12-(-20-(-23-28)))", it.toStringTree());
	}

	@Test
	public void testSuccessor() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(11);
		it.insert(23);
		it.insert(28);
		it.insert(1);
		assertEquals("1, 5, 11, 12, 20, 23, 28", it.toString());
		assertEquals("((1-5-11)-12-(-20-(-23-28)))", it.toStringTree());
		assertEquals(Integer.valueOf(11), it.successor(5).key);
		assertEquals(Integer.valueOf(5), it.successor(1).key);
		assertEquals(Integer.valueOf(12), it.successor(11).key);
		assertEquals(Integer.valueOf(20), it.successor(12).key);
		assertEquals(Integer.valueOf(23), it.successor(20).key);
		assertEquals(Integer.valueOf(28), it.successor(23).key);
	}

	@Test
	public void testDeleteLeaf() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.delete(20);
		assertEquals("5, 12", it.toString());
	}

	@Test
	public void testToStringTree1() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)", it.toStringTree());

	}

	@Test
	public void testToStringTree2() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(5);
		it.insert(2);
		it.insert(1);
		it.insert(3);
		it.insert(7);
		it.insert(6);
		it.insert(8);
		assertEquals("((1-2-3)-5-(6-7-8))", it.toStringTree());

	}

	@Test
	public void testDeleteWithRightChild() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		assertEquals("(5-12-(-20-21))", it.toStringTree());
		it.delete(20);
		assertEquals("(5-12-21)", it.toStringTree());
	}

	@Test
	public void testDeleteWithTwoChilds1() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		it.delete(20);
		assertEquals("after deletion", "(5-12-(19-21-))", it.toStringTree());
	}
	@Test
	public void testDeleteWithTwoChilds2() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		it.delete(12);
		assertEquals("after deletion", "(5-19-(-20-21))", it.toStringTree());
	}

	@Test
	public void testDeleteWithTwoChilds3() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(19);
		it.insert(23);
		it.insert(21);
		it.insert(22);
		it.insert(24);
		
		assertEquals("(5-12-(19-20-((-21-22)-23-24)))", it.toStringTree());
		              //(5-12-(19-21-(22-23-24)))
		it.delete(20);
		assertEquals("after deletion", "(5-12-(19-21-(22-23-24)))", it.toStringTree());
	}
	@Test
	public void testTransplant1(){
		Tree<Integer,Object> it = new Tree<Integer,Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)",it.toStringTree());
		Tree<Integer,Object>.Node a = it.find(3);
		Tree<Integer,Object>.Node b = it.find(1);
		it.transplant(a,b);
		assertEquals("(-2-1)",it.toStringTree());
	}
	@Test
	public void testTransplant2(){
		Tree<Integer,Object> it = new Tree<Integer,Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)",it.toStringTree());
		Tree<Integer,Object>.Node a = it.find(2);
		Tree<Integer,Object>.Node b = it.find(1);
		it.transplant(a,b);
		assertEquals("1",it.toStringTree());
	}
	@Test
	public void testReplace(){
		Tree<Integer,Object> it = new Tree<Integer,Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)",it.toStringTree());
		Tree<Integer,Object>.Node a = it.find(2);
		Tree<Integer,Object>.Node b = it.new Node(10,null);
		it.replace(a,b);
		assertEquals("(1-10-3)",it.toStringTree());
	}
	@Test
	public void testReplaceInner(){
	
	Tree<Integer, Object> it = new Tree<Integer, Object>();
	it.insert(12);
	it.insert(5);
	it.insert(20);
	it.insert(21);
	it.insert(19);
	assertEquals("(5-12-(19-20-21))", it.toStringTree());
	Tree<Integer,Object>.Node a = it.find(20);
	Tree<Integer,Object>.Node b = it.new Node(10,null);
	it.replace(a,b);
	assertEquals("(5-12-(19-10-21))",it.toStringTree());
	}
	
	@Test
	public void testTransplant(){
		Tree<Integer,Object> it = new Tree<Integer,Object>();
		it.insert(2);
		it.insert(1);
		it.insert(4);
		it.insert(3);
		it.insert(5);
		assertEquals("(1-2-(3-4-5))",it.toStringTree());
		Tree<Integer,Object>.Node four = it.find(4);
		Tree<Integer,Object>.Node one = it.find(1);
		it.transplant(one, four);
		assertEquals("((3-4-5)-2-)",it.toStringTree());
	}

}
