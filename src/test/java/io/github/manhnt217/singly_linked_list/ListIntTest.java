package io.github.manhnt217.singly_linked_list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author manhnt
 */
public class ListIntTest {

	@Test
	public void testAppend() throws Exception {
		ListInt l = new ListInt();
		l.append(1);
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(5);
		l.append(8);
		assertEquals("[1, 1, 2, 3, 5, 8]", l.toString());
		l.removeTail();
		l.removeTail();
		l.append(125);
		assertEquals("[1, 1, 2, 3, 125]", l.toString());
	}

	@Test
	public void testRemoveTail() throws Exception {
		ListInt l = new ListInt();
		l.append(1);
		l.append(3);
		l.append(9);
		l.append(13);

		assertEquals(13, l.removeTail());
		assertEquals("[1, 3, 9]", l.toString());
		assertEquals(9, l.removeTail());
		assertEquals("[1, 3]", l.toString());
		assertEquals(3, l.removeTail());
		assertEquals("[1]", l.toString());
		assertEquals(1, l.removeTail());
		assertEquals("[]", l.toString());
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveTailException() throws Exception {
		ListInt l = new ListInt();
		l.removeTail();
	}

	@Test
	public void testRemoveGreaterThan() throws Exception {
		ListInt l = new ListInt();
		l.append(1);
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(5);
		l.append(-8);
		l.removeGreaterThan(2);
		assertEquals("[1, 1, 2, -8]", l.toString());
		l.append(18);
		assertEquals("[1, 1, 2, -8, 18]", l.toString());
		l.removeTail();
		l.removeTail();
		assertEquals("[1, 1, 2]", l.toString());
	}
}