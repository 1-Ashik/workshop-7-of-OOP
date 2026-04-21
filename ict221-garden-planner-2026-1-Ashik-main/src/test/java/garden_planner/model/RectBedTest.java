package garden_planner.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * ============================================================
 * Change made by Claude Code (Workshop 7, Section 5)
 * ------------------------------------------------------------
 * Added a full JUnit 5 test suite for the RectBed class.
 * The original file only contained a single testGetArea test.
 *
 * What was added:
 *  - DELTA constant for floating-point comparisons
 *  - testDefaultValues   : verifies default left/top/width/height
 *  - testSetLeft         : verifies setLeft / getLeft
 *  - testSetTop          : verifies setTop / getTop
 *  - testSetWidth        : verifies setWidth / getWidth
 *  - testSetHeight       : verifies setHeight / getHeight
 *  - testGetArea         : extended with multiple cases
 *  - testGetPerimeter    : verifies perimeter calculation
 *  - testToStringDefault : verifies default toString output
 *  - testToStringAfterSetters : verifies toString after changes
 * ============================================================
 */

/**
 * JUnit 5 tests for the RectBed class.
 */
public class RectBedTest {

    // Change made by Claude Code: tolerance for double comparisons
    private static final double DELTA = 1e-9;

    // Change made by Claude Code: new test for default RectBed values
    @Test
    void testDefaultValues() {
        RectBed rBed = new RectBed();
        assertEquals(0.0, rBed.getLeft(), DELTA);
        assertEquals(0.0, rBed.getTop(), DELTA);
        assertEquals(1.0, rBed.getWidth(), DELTA);
        assertEquals(1.0, rBed.getHeight(), DELTA);
    }

    // Change made by Claude Code: new test for setLeft setter
    @Test
    void testSetLeft() {
        RectBed rBed = new RectBed();
        rBed.setLeft(2.5);
        assertEquals(2.5, rBed.getLeft(), DELTA);
    }

    // Change made by Claude Code: new test for setTop setter
    @Test
    void testSetTop() {
        RectBed rBed = new RectBed();
        rBed.setTop(3.75);
        assertEquals(3.75, rBed.getTop(), DELTA);
    }

    // Change made by Claude Code: new test for setWidth setter
    @Test
    void testSetWidth() {
        RectBed rBed = new RectBed();
        rBed.setWidth(4.0);
        assertEquals(4.0, rBed.getWidth(), DELTA);
    }

    // Change made by Claude Code: new test for setHeight setter
    @Test
    void testSetHeight() {
        RectBed rBed = new RectBed();
        rBed.setHeight(5.0);
        assertEquals(5.0, rBed.getHeight(), DELTA);
    }

    // Change made by Claude Code: extended testGetArea with extra cases
    @Test
    void testGetArea() {
        RectBed rBed = new RectBed();
        // default 1x1 -> 1
        assertEquals(1.0, rBed.getArea(), DELTA);

        rBed.setWidth(2.0);
        rBed.setHeight(3.0);
        assertEquals(6.0, rBed.getArea(), DELTA);

        rBed.setWidth(2.5);
        rBed.setHeight(4.0);
        assertEquals(10.0, rBed.getArea(), DELTA);
    }

    // Change made by Claude Code: new test for getPerimeter
    @Test
    void testGetPerimeter() {
        RectBed rBed = new RectBed();
        // default 1x1 -> 4
        assertEquals(4.0, rBed.getPerimeter(), DELTA);

        rBed.setWidth(2.0);
        rBed.setHeight(3.0);
        assertEquals(10.0, rBed.getPerimeter(), DELTA);

        rBed.setWidth(5.5);
        rBed.setHeight(2.5);
        assertEquals(16.0, rBed.getPerimeter(), DELTA);
    }

    // Change made by Claude Code: new test for default toString format
    @Test
    void testToStringDefault() {
        RectBed rBed = new RectBed();
        assertEquals("Rectangle 0.00 0.00 1.00 1.00", rBed.toString());
    }

    // Change made by Claude Code: new test for toString after setters
    @Test
    void testToStringAfterSetters() {
        RectBed rBed = new RectBed();
        rBed.setLeft(1.0);
        rBed.setTop(2.0);
        rBed.setWidth(3.0);
        rBed.setHeight(4.0);
        assertEquals("Rectangle 1.00 2.00 3.00 4.00", rBed.toString());
    }
}
