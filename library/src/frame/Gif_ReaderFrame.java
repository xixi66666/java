package frame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gif_ReaderFrame extends JFrame implements Runnable {

	/**
	 * Java�����л�������ͨ��������ʱ�ж����serialVersionUID����֤�汾һ���Ե�
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public Gif_ReaderFrame() {
		setUndecorated(true);
		setResizable(false);
		setSize(529, 527);
//		JLabel gif_Label = new JLabel(new ImageIcon("image/Reader.gif"));
		JLabel gif_Label = new JLabel(new ImageIcon("image/goodReader.gif"));
		getContentPane().add(gif_Label, BorderLayout.CENTER);
	}

	public void run() {
		Gif_ReaderFrame frame = new Gif_ReaderFrame();
		frame.setVisible(true);
		try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}// ˯1800 (��1.8��)
		frame.setVisible(false);// ������.
		// �����Ǿ�����Ӧ�رյ�,������ڼ䲻�õ��ش���,�������Ҳ�е�.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		Login_ReaderFrame login_ReaderFrame = new Login_ReaderFrame();
		login_ReaderFrame.setVisible(true);

	}

}