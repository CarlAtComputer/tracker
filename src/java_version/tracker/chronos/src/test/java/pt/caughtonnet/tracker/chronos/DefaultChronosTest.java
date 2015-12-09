/**
 * 
 */
package pt.caughtonnet.tracker.chronos;

import org.junit.Test;

/**
 *	The default chronos test
 * @author CaughtOnNet
 */
public class DefaultChronosTest {

	@Test
	public void testChronos() {
		DefaultChronos chronos = new DefaultChronos();
		chronos.start();
	}
	
	public static void main(String[] args) {
		DefaultChronos chronos = new DefaultChronos();
		chronos.start();
		
	}
}
