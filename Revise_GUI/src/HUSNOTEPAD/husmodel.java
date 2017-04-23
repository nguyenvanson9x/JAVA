package HUSNOTEPAD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class husmodel {
	private static final int FILE_OPEN = 1;
	private static final int FILE_SAVE = 2;
	private husview view;

	public husmodel(husview view) {
		this.view = view;
	}
	
	public void operateFile(String title, int type) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(title);
		int choose = -1;
		switch (type) {
		case FILE_OPEN:
			choose = chooser.showOpenDialog(null);
			
			break;
		case FILE_SAVE:
			choose = chooser.showSaveDialog(null);
			
			break; 
	
		}
		if (choose == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			switch (type) {
			case FILE_OPEN:
				//JOptionPane.showMessageDialog(null, "Read a file");
				open(file);
				view.setTitle(file.getName());
				break;
			case FILE_SAVE:
				int result = JOptionPane.showConfirmDialog(null, "Do u want to save this file");
				if (result == JOptionPane.YES_OPTION) {
					saveFile(file);
					view.setTitle(file.getName());
				}
				
				break; 
		
			}
		}
	}
	
	public void open(File file) {
		view.setTextArea("");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while ((line = br.readLine())!= null) {
				view.getTextArea().append(line+"\n");
				//view.setTextArea(line+"\n");
			
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void saveFile(File file) {
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String data = view.getTextArea().getText();
			bw.write(data);
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
