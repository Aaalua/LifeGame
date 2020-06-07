import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class WorldTest {
	private static World world;
	private static boolean x = false;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		world = new World(6,6);
	}

	@Test
	public void testRun() {
		for(int i=0;i<6.;i++)
		{
			for(int j=0;j<6;j++)
			{
				world.evolve(i,j);
			}
		}
	}

	@Test
	public void testSetZero() {
		world.setZero();
	}
	
	@Test
	public void testUpdateNumber()
	{
		String s = "dad";
		world.record.setText(s);
	}

}
