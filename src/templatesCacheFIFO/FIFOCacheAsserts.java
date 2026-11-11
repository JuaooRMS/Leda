package templatesCacheFIFO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FIFOCacheAsserts {
	
	private FIFOEvictionStrategy fifocache;
	
	@BeforeEach
    void setUp() {
        fifocache = new FIFOEvictionStrategy(3);
    }
	@Test
	void testCacheVazio() {
		assertNull(fifocache.getNextEviction());
		assertEquals(0, fifocache.size());
	}
	
	@Test
	void testSaidaMiss() {
		assertEquals("miss", fifocache.get("a"));
		assertEquals(1, fifocache.size());
		assertNull(fifocache.getNextEviction());
	}
	
	@Test
	void testSaidaHit() {
		assertEquals("miss", fifocache.get("a"));
		assertEquals("hit", fifocache.get("a"));
		assertEquals(1, fifocache.size());
		assertNull(fifocache.getNextEviction());
	}
	
	@Test
	void testFilaCheia() {
		assertEquals("miss", fifocache.get("a"));
		assertNull(fifocache.getNextEviction());
		assertEquals("miss", fifocache.get("b"));
		assertNull(fifocache.getNextEviction());
		assertEquals("miss", fifocache.get("c"));
		assertEquals("hit", fifocache.get("a"));
		assertEquals("hit", fifocache.get("b"));
		assertEquals("hit", fifocache.get("c"));
		assertEquals(3, fifocache.size());
		assertEquals("a", fifocache.getNextEviction());
	}
	
	@Test
	void testAddFilaCheia() {
		assertEquals("miss", fifocache.get("a"));
		assertEquals("miss", fifocache.get("b"));
		assertEquals("miss", fifocache.get("c"));
		assertEquals(3, fifocache.size());
		assertEquals("a", fifocache.getNextEviction());
		assertEquals("miss", fifocache.get("d"));
		assertEquals("b", fifocache.getNextEviction());
		assertEquals("miss", fifocache.get("a"));
		assertEquals("c", fifocache.getNextEviction());
		assertEquals("miss", fifocache.get("b"));
		assertEquals("d", fifocache.getNextEviction());
		assertEquals("miss", fifocache.get("c"));
		assertEquals("a", fifocache.getNextEviction());
	}
}
