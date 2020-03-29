import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LifeGame extends JFrame implements MouseMotionListener{
	private final World world;                                 
	static JMenu location=new JMenu();
	public LifeGame(int rows,int columns)
	{
		world=new World(rows, columns);
		world.setBackground(Color.LIGHT_GRAY);
		new Thread(world).start();
		add(world);
	}
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		frame.addMouseMotionListener(frame);
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		
		JMenu options =new JMenu("选项");
		menu.add(options);

		JMenuItem start=options.add("开始");
		start.addActionListener(frame.new StartActionListener());
		JMenuItem stop=options.add("清除");
		stop.addActionListener(frame.new StopActionListener());
		JMenuItem pause=options.add("停止");
		pause.addActionListener(frame.new PauseActionListener());
		JMenuItem doityourself=options.add("放置细胞");
		doityourself.addActionListener(frame.new DIYActionListener());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		frame.setTitle("生命游戏");
		frame.setVisible(true);
		frame.setResizable(false);
	}
	class StartActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setBackground(Color.gray);
			world.diy=false;
			world.clean=false;
			world.setShape();
		}
	}
	class StopActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setBackground(Color.LIGHT_GRAY);
			world.diy=false;
			world.clean=false;
			world.setStop();
		}
	}
	class PauseActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setBackground(Color.LIGHT_GRAY);
			world.diy=false;
			world.clean=false;
			world.setPause();
		}
	}
	class DIYActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setPause();
			world.diy=true;
			world.clean=false;
			world.setBackground(Color.orange);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if(world.diy){
		int x=e.getX();
		int y=e.getY();
		World.pauseshape[(y-50)/20][x/20]=1;
		world.setDiy();
		}
	}
	public void mouseMoved(MouseEvent e) {
		if(world.clean){
		int x=e.getX();
		int y=e.getY();
		World.pauseshape[(y-50)/20][x/20]=0;
		world.setDiy();
		}
	}
}

