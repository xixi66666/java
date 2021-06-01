package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Author;
import model.Book;
import model.Publisher;
import sqlTools.AuthorTools;
import sqlTools.BookTools;
import sqlTools.PublisherTools;

public class Book_RegisterFrame extends JFrame {

	/**
	 * Java�����л�������ͨ��������ʱ�ж����serialVersionUID����֤�汾һ���Ե�
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField idBooktextField;
	private JTextField nameBooktextField;
	private JTextField priceField;
	private JTextField typetextField;
	private JTextField authortextField;
	private JTextField publishertextField;
	private JTextField authorWorkplaceField;
	private JTextField publisherAddressField;

	private JLabel idBookLabel;
	private JLabel nameBookLabel;
	private JLabel priceLabel;
	private JLabel typeLabel;
	private JLabel authorLabel;
	private JLabel publisherLabel;
	private JLabel authorWorkplaceLabel;
	private JLabel publisherAddressLabel;

	private JButton insertButton;

	/*	*//**
			 * Launch the application.
			 */
/*	public static void main(String[] args) {
		try {
			Book_RegisterFrame frame = new Book_RegisterFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the frame.
	 */
	public Book_RegisterFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton reader_Registerbutton = new JButton("����ע��");
		reader_Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reader_RegisterFrame reader_RegisterFrame = new Reader_RegisterFrame();
				reader_RegisterFrame.setVisible(true);
				CloseFrame();
			}
		});
		reader_Registerbutton.setBounds(60, 197, 123, 29);
		contentPane.add(reader_Registerbutton);

		JButton book_Registerbutton = new JButton("�鼮���");
		book_Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book_RegisterFrame book_RegisterFrame = new Book_RegisterFrame();
				book_RegisterFrame.setVisible(true);
				CloseFrame();
			}
		});
		book_Registerbutton.setBounds(60, 292, 123, 29);
		contentPane.add(book_Registerbutton);

		JButton all_Readerbutton = new JButton("���߿����");
		all_Readerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_ReaderFrame all_ReaderFrame = new All_ReaderFrame();
				all_ReaderFrame.setVisible(true);
				CloseFrame();
			}
		});
		all_Readerbutton.setBounds(60, 375, 123, 29);
		contentPane.add(all_Readerbutton);

		JButton all_Bookbutton = new JButton("������");
		all_Bookbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_BookFrame all_BookFrame = new All_BookFrame();
				all_BookFrame.setVisible(true);
				CloseFrame();
			}
		});
		all_Bookbutton.setBounds(60, 459, 123, 29);
		contentPane.add(all_Bookbutton);

		JButton checkReader_button = new JButton("���Ĺ���");
		checkReader_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckReaderFrame checkReaderFrame = new CheckReaderFrame();
				checkReaderFrame.setVisible(true);
				CloseFrame();
			}
		});
		checkReader_button.setBounds(60, 545, 123, 29);
		contentPane.add(checkReader_button);

		JButton log_out_Button = new JButton("�ǳ�");
		log_out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				CloseFrame();
			}
		});
		log_out_Button.setBounds(817, 102, 85, 29);
		contentPane.add(log_out_Button);

		idBookLabel = new JLabel("�鼮���");
		idBookLabel.setFont(new Font("����", Font.PLAIN, 30));
		idBookLabel.setBounds(448, 163, 131, 51);
		contentPane.add(idBookLabel);

		nameBookLabel = new JLabel("����");
		nameBookLabel.setFont(new Font("����", Font.PLAIN, 30));
		nameBookLabel.setBounds(469, 229, 81, 51);
		contentPane.add(nameBookLabel);

		priceLabel = new JLabel("�۸�");
		priceLabel.setFont(new Font("����", Font.PLAIN, 30));
		priceLabel.setBounds(469, 292, 81, 51);
		contentPane.add(priceLabel);

		typeLabel = new JLabel("����");
		typeLabel.setFont(new Font("����", Font.PLAIN, 30));
		typeLabel.setBounds(469, 358, 81, 44);
		contentPane.add(typeLabel);

		authorLabel = new JLabel("����");
		authorLabel.setFont(new Font("����", Font.PLAIN, 30));
		authorLabel.setBounds(349, 419, 81, 44);
		contentPane.add(authorLabel);

		publisherLabel = new JLabel("������");
		publisherLabel.setFont(new Font("����", Font.PLAIN, 30));
		publisherLabel.setBounds(330, 499, 96, 44);
		contentPane.add(publisherLabel);

		idBooktextField = new JTextField();
		idBooktextField.setFont(new Font("����", Font.PLAIN, 30));
		idBooktextField.setBounds(594, 168, 131, 41);
		contentPane.add(idBooktextField);
		idBooktextField.setColumns(10);

		nameBooktextField = new JTextField();
		nameBooktextField.setFont(new Font("����", Font.PLAIN, 30));
		nameBooktextField.setBounds(594, 236, 131, 37);
		contentPane.add(nameBooktextField);
		nameBooktextField.setColumns(10);

		priceField = new JTextField();
		priceField.setFont(new Font("����", Font.PLAIN, 30));
		priceField.setBounds(594, 299, 131, 37);
		contentPane.add(priceField);
		priceField.setColumns(10);

		typetextField = new JTextField();
		typetextField.setFont(new Font("����", Font.PLAIN, 30));
		typetextField.setBounds(594, 367, 131, 37);
		contentPane.add(typetextField);
		typetextField.setColumns(10);

		authortextField = new JTextField();
		authortextField.setFont(new Font("����", Font.PLAIN, 30));
		authortextField.setBounds(448, 423, 131, 36);
		contentPane.add(authortextField);
		authortextField.setColumns(10);

		publishertextField = new JTextField();
		publishertextField.setFont(new Font("����", Font.PLAIN, 30));
		publishertextField.setBounds(448, 501, 131, 41);
		contentPane.add(publishertextField);
		publishertextField.setColumns(10);

		insertButton = new JButton(new ImageIcon("image/new.jpg"));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_AddBook();
			}
		});
		insertButton.setBounds(544, 582, 106, 44);
		contentPane.add(insertButton);

		authorWorkplaceLabel = new JLabel("���ߵ�λ");
		authorWorkplaceLabel.setFont(new Font("����", Font.PLAIN, 30));
		authorWorkplaceLabel.setBounds(633, 419, 131, 44);
		contentPane.add(authorWorkplaceLabel);

		publisherAddressLabel = new JLabel("�������ַ");
		publisherAddressLabel.setFont(new Font("����", Font.PLAIN, 30));
		publisherAddressLabel.setBounds(616, 499, 166, 44);
		contentPane.add(publisherAddressLabel);

		authorWorkplaceField = new JTextField();
		authorWorkplaceField.setFont(new Font("����", Font.PLAIN, 30));
		authorWorkplaceField.setBounds(791, 421, 131, 40);
		contentPane.add(authorWorkplaceField);
		authorWorkplaceField.setColumns(10);

		publisherAddressField = new JTextField();
		publisherAddressField.setFont(new Font("����", Font.PLAIN, 30));
		publisherAddressField.setBounds(791, 503, 131, 36);
		contentPane.add(publisherAddressField);
		publisherAddressField.setColumns(10);

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);
	}

	/**
	 * �������ݿ⽨��ʱ��Book��author��publisher�ֶηֱ����Author��Publisher��
	 * ��˴�����дʱ��Ӧ���ȸ���Author��Publisher��
	 * 
	 * @return ���������鼮�Ĳ���
	 * @param Book
	 *            �鼮������ģ��
	 * @param Author
	 *            ���ߵ�����ģ��
	 * @param Publisher
	 *            �����������ģ��
	 * @param BookTools
	 *            ���ݿ�������鼮����ģ�͡�����
	 * @param AuthorTools
	 *            ���ݿ��������������ģ�͡�����
	 * @param PublisherTools
	 *            ���ݿ����������������ģ�͡�����
	 */
	protected void do_insertButton_AddBook() {

		BookTools bookTools = new BookTools();
		Book book = new Book();

		Author author = new Author();
		AuthorTools authorTools = new AuthorTools();

		Publisher publisher = new Publisher();
		PublisherTools publisherTools = new PublisherTools();

		if (idBooktextField.getText() != null && !"".equals(idBooktextField.getText())
				&& nameBooktextField.getText() != null && !"".equals(nameBooktextField.getText())
				&& priceField.getText() != null && !"".equals(priceField.getText()) && typetextField.getText() != null
				&& !"".equals(typetextField.getText()) && authortextField.getText() != null
				&& !"".equals(authortextField.getText()) && publishertextField.getText() != null
				&& !"".equals(publishertextField.getText()) && authorWorkplaceField.getText() != null
				&& !"".equals(authorWorkplaceField.getText()) && publisherAddressField.getText() != null
				&& !"".equals(publisherAddressField.getText())) {
			book.setBookId(idBooktextField.getText());
			book.setBookName(nameBooktextField.getText());
			book.setPrice(Integer.parseInt(priceField.getText()));
			book.setType(typetextField.getText());
			book.setAuthor(authortextField.getText());
			book.setPublisher(publishertextField.getText());
			author.setName(authortextField.getText());
			publisher.setName(publishertextField.getText());
			publisher.setAddress(publisherAddressField.getText());
			publisherTools.AddPublisher(publisher);
			authorTools.AddAuthor(author);
			int i = bookTools.AddBook(book);
			if (i == 1) {
				JOptionPane.showMessageDialog(getContentPane(), "�ɹ�����ͼ����Ϣ��", "", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(getContentPane(), "����ͼ����Ϣʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "��������������", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	public void CloseFrame() {
		super.dispose();
	}
}
