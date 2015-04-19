package pl.mwaleria.warrior.game;

import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.Animation;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:Walerianczyk.Marcin@gmail.com">Marcin Walerianczyk</a>
 */
public class EntityTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCheckCollision() throws Exception {
        Entity e1 = new Entity(null, 100, 100, 100, 100) {
            @Override
            public Animation getAnimation() {
                return null;
            }
        };
        Entity e2 = new Entity(null, 100, 199, 100, 100) {
            @Override
            public Animation getAnimation() {
                return null;
            }
        };
        assertEquals(CollisionDirection.DOWN, e1.checkCollision(e2));
        assertEquals(CollisionDirection.UP, e2.checkCollision(e1));

        e2 = new Entity(null, 199, 100, 100, 100) {
            @Override
            public Animation getAnimation() {
                return null;
            }
        };
        assertEquals(CollisionDirection.RIGHT, e1.checkCollision(e2));
        assertEquals(CollisionDirection.LEFT, e2.checkCollision(e1));


    }

    @Test
    public void testHasCommonPoints() throws Exception {
        Entity e1 = new Entity(null, 0, 0, 0, 0) {
            @Override
            public Animation getAnimation() {
                return null;
            }
        };

        assertTrue(e1.hasCommonPoints(100, 100, 200, 100));
        assertFalse(e1.hasCommonPoints(100, 100, 201, 100));
        assertTrue(e1.hasCommonPoints(100, 100, 150, 10));
        assertTrue(e1.hasCommonPoints(150, 10, 100, 100));

    }
}