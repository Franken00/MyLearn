package com.SongJian.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.SongJian.Util.FileUtil;
import com.SongJian.Util.Linked;
import com.SongJian.Util.StringUtil;

public class AddRelation {
	JFrame f = new JFrame("�½���ϵ");
	JButton sure = new JButton("ȷ��");
	JButton reset = new JButton("����");
	JButton returnto = new JButton("����");
	JLabel is = new JLabel("��");
	JLabel de = new JLabel("��");
	Font font =new Font("΢���ź�", Font.PLAIN, 20);//��������	
	Font font1 =new Font("����", Font.PLAIN, 18);//��������
	
	String[] chars = new String[] {"��ʦ" ,"ѧ��","���","�ܵ�","�ְ�","үү","����","����","ͬѧ","�ֵ�"};	
	JComboBox<String> userchoicer = new JComboBox<>(chars);
	
	JTextField textname1 = new JTextField();
	JTextField textname2 = new JTextField();
	//JTextField textrelation = new JTextField();
	
	JPanel contentPanel = new JPanel();
	re r = new re();
	Reset re = new Reset();
	Write w = new Write();
	private File file = new File("FilesSave\\relation.txt");
	public void init()
	{
		contentPanel.setLayout(null);
		is.setFont(font1);
		de.setFont(font1);
		sure.setFont(font1);
		reset.setFont(font1);
		returnto.setFont(font1);
		//textrelation.setFont(font1);
		textname2.setFont(font1);
		textname1.setFont(font1);
		userchoicer.setFont(font);
		
		sure.addActionListener(w);
		
		sure.setBounds(30, 200, 100, 35);
		reset.setBounds(150, 200, 100, 35);
		returnto.setBounds(290, 200, 100, 35);
		//textrelation.setBounds(30, 30, 100, 35);
		textname2.setBounds(260, 30, 100, 35);
		userchoicer.setBounds(520, 30, 100, 35);
		textname1.setBounds(30, 30, 100, 35);
		is.setBounds(150, 30, 100, 35);
		de.setBounds(380, 30, 100, 35);
		
		returnto.addActionListener(r);
		reset.addActionListener(re);
		
		is.add(userchoicer);
		de.add(userchoicer);
		contentPanel.add(userchoicer);
		contentPanel.add(sure);
		contentPanel.add(returnto);
		contentPanel.add(reset);
		contentPanel.add(textname2);
		contentPanel.add(textname1);
		contentPanel.add(is);
		contentPanel.add(de);
		f.add(contentPanel);
		f.setBounds(600,220,700,500);
		f.setVisible(true);
	}
	class re implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
		}	
	}
	
	class Reset implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			textname1.setText("");
			textname2.setText("");
		}			
	}
	class Write implements ActionListener
	{
		String s0,s1,s2,s3;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			s0 = (String) userchoicer.getSelectedItem();
			s1 = textname1.getText();
			s2 = textname2.getText();
			if(StringUtil.isEmpty(s1) || StringUtil.isEmpty(s2))
			{
				JOptionPane.showMessageDialog(null,"����������Ϊ��");
			}
			else if(s1.equals(s2))
			{
				JOptionPane.showMessageDialog(null,"���ֲ�����ͬ");
			}
			else {
				s3 = s1 + "��" + s2 + "��" + s0 + "\r\n" ;
				try {
					new FileUtil().Write(file, s3);
					JOptionPane.showMessageDialog(null,"��ӳɹ���");
					f.dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		   }
		}			
	}
}
