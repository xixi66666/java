package frame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gif_LibrarianFrame extends JFrame implements Runnable {

	/**
	 * Java�����л�������ͨ��������ʱ�ж����serialVersionUID����֤�汾һ���Ե�
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public Gif_LibrarianFrame() {
		setUndecorated(true);
		setResizable(false);
		setSize(520, 402);
		JLabel gif_Label = new JLabel(new ImageIcon("image/FINAL FANTASY.gif"));
//		JLabel gif_Label = new JLabel(new ImageIcon("image/GoodLibrarian.gif"));
		getContentPane().add(gif_Label, BorderLayout.CENTER);
	}


	public void run() {
		Gif_LibrarianFrame frame = new Gif_LibrarianFrame();
		frame.setVisible(true);
		try {
			Thread.sleep(4200);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} // ˯4200 (��4.2��)
		frame.setVisible(false);// ������.
		// �����Ǿ�����Ӧ�رյ�,������ڼ䲻�õ��ش���,�������Ҳ�е�.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		Login_LibrarianFrame login_LibrarianFrame = new Login_LibrarianFrame();
		login_LibrarianFrame.setVisible(true);

	}

}