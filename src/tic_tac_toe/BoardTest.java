package tic_tac_toe;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testMax_score() {
		Board initial = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, -1}});
		Board initial_ = new Board(new int[][]{
			{0, -1, 1},
			{1, 1, -1},
			{0, -1, -1}});
		Board initial0 = new Board(new int[][]{
			{0, 0, -1},
			{1, -1, 1},
			{0, 1, 1}});
		assertEquals(initial.max_score(),10005);
		assertEquals(initial_.max_score(),25);
		assertEquals(initial0.max_score(),33);
		
	}

	@Test
	public void testMin_score() {
		Board initial = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, -1}});
		Board initial_ = new Board(new int[][]{
			{0, -1, 1},
			{1, 1, -1},
			{0, -1, -1}});
		Board initial0 = new Board(new int[][]{
			{0, 0, -1},
			{1, -1, 1},
			{0, 1, 1}});
		assertEquals(initial.min_score(),(33));
		assertEquals(initial_.min_score(),(14));
		assertEquals(initial0.min_score(),(24));
	}

	@Test
	public void testEval() {
		Board initial = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, -1}});
		Board initial_ = new Board(new int[][]{
			{0, -1, 1},
			{1, 1, -1},
			{0, -1, -1}});
		Board initial0 = new Board(new int[][]{
			{0, 0, -1},
			{1, -1, 1},
			{0, 1, 1}});
		assertEquals(initial.eval(),(9972));
		assertEquals(initial_.eval(),(11));
		assertEquals(initial0.eval(),(9));
	}

	@Test
	public void testMax_move_neighbors() {
		Board initial = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, -1}});
		ArrayList<Board>resIA = new ArrayList<Board>();
		Board neigh1 = new Board(new int[][]{
			{1, 1, 0},
			{1, 0, 0},
			{1, -1, -1}});
		Board neigh2 = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, 1, -1}});
		Board neigh3 = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, 1}});
		resIA.add(neigh1);
		resIA.add(neigh2);
		resIA.add(neigh3);
		for(Board b : initial.max_move_neighbors()) {
			assertTrue(resIA.contains(b));
		}
	}

	@Test
	public void testMin_move_neighbors() {
		Board initial = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, -1}});
		ArrayList<Board>resIA = new ArrayList<Board>();
		Board neigh1 = new Board(new int[][]{
			{1, 0, 0},
			{1, 0, 0},
			{1, -1, -1}});
		Board neigh2 = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, 0, -1}});
		Board neigh3 = new Board(new int[][]{
			{1, -1, 0},
			{1, 0, 0},
			{1, -1, 0}});
		resIA.add(neigh1);
		resIA.add(neigh2);
		resIA.add(neigh3);
		for(Board b : initial.min_move_neighbors()) {
			assertTrue(resIA.contains(b));
		}
	}

	@Test
	public void testIsOver() {
		Board initial = new Board(new int[][]{
			{0, -1, 1},
			{0, 1, 1},
			{0, -1, -1}});
		Board initial_ = new Board(new int[][]{
			{0, -1, 1},
			{1, 1, -1},
			{0, -1, -1}});
		Board initial0 = new Board(new int[][]{
			{0, 0, 1},
			{1, 1, 0},
			{0, 1, 1}});
		initial.isOver();
		initial_.isOver();
		assertTrue(initial.isOver());
		assertTrue(!initial_.isOver());
		assertTrue(initial0.isOver());
	}

	@Test
	public void testXwins() {
		Board initial = new Board(new int[][]{
			{0, -1, 1},
			{0, 1, 1},
			{0, -1, -1}});
		Board initial_ = new Board(new int[][]{
			{0, -1, 1},
			{1, 1, 1},
			{0, -1, -1}});
		initial.Owins();
		initial_.Owins();
		assertTrue(!initial.Xwins());
		assertTrue(initial_.Xwins());
	}

	@Test
	public void testOwins() {
		Board initial = new Board(new int[][]{
			{0, -1, 1},
			{0, 1, 1},
			{0, -1, -1}});
		Board initial_ = new Board(new int[][]{
			{0, -1, 1},
			{1, 1, 1},
			{0, -1, -1}});
		initial.Owins();
		initial_.Owins();
		assertTrue(initial.Owins());
		assertTrue(!(initial_.Owins()));
	}

}
