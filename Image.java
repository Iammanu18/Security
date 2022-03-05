import javax.swing.*;
//import javax.swing.JFrame;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Image {
	
	
	public static void oprate(int key) {
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file=fileChooser.getSelectedFile();
		//file fileInputStream
		try {
			FileInputStream fis=new FileInputStream(file);
			byte []data=new byte[fis.available()];
			fis.read(data);
			int i=0;
			for(byte b:data)
			{
				System.out.println(b);
				data[i]=(byte)(b^key);
				i++;
			}
			
			
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null,"Done");
			
		}catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		System.out.print("   ");
		JFrame f=new JFrame();
		f.setTitle("Image operation");
		f.setSize(400,400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font=new Font("Roboto",Font.BOLD,25);
		//creating button
		JButton button= new JButton();
		button.setText("open Image");
		button.setFont(font);
		
		/*button.addActionListener(e->{
			System.out.println("button clicked");
			//String text=textField.getText();
			int temp=Integer.parseInt(text);
		});*/
		JLabel l1=new JLabel("Key");
		l1.setFont(font);
		//l1.setText("key");


		//creating text field
		JTextField textField=new JTextField(10);
		textField.setFont(font);
		
		button.addActionListener(e->{
			System.out.println("button clicked");
			String text=textField.getText();
			int temp=Integer.parseInt(text);
			oprate(temp);
		});
		
		f.setLayout((new FlowLayout()));
		
		
		f.add(button);
		f.add(textField);
		f.add(l1);
		f.setVisible(true);
	}

}
