package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList extends JPanel implements ActionListener, MouseListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	ArrayList<String> tasks = new ArrayList<String>();
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;

	public static void main(String[] args) {
		new ToDoList();
	}

	public ToDoList() {
		JFrame j = new JFrame();
		j.setSize(780, 780);
		j.add(this);
		j.addMouseListener(this);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add = new JButton("Add Task");
		add.setBounds(100, 100, 100, 40);
		add.addActionListener(this);
		view = new JButton("View Tasks");
		view.setBounds(220, 100, 100, 40);
		view.addActionListener(this);
		remove = new JButton("Remove Task");
		remove.setBounds(340, 100, 100, 40);
		remove.addActionListener(this);
		save = new JButton("Save Task");
		save.setBounds(460, 100, 100, 40);
		save.addActionListener(this);
		load = new JButton("Load List");
		load.setBounds(580, 100, 100, 40);
		load.addActionListener(this);
		j.add(add);
		j.add(view);
		j.add(remove);
		j.add(load);
		j.add(save);
		j.setLayout(null);

		j.setVisible(true);
		j.setTitle("To Do List");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		if (clicked == add) {
			String a = JOptionPane.showInputDialog("Enter A Task");
			if (a.equals("")) {
				JOptionPane.showMessageDialog(null, "Do not leave the space blank");
			} else {
				tasks.add(a);
			}
		}
		if (clicked == view) {
			String s = "";
			for (String i : tasks) {
				s += (i + "\n");
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if (clicked == remove) {
			String a = JOptionPane.showInputDialog("Enter the name of the task to remove");
			a = a.trim();
			a = a.toLowerCase();
			int index = -1;
			for (String i : tasks) {
				if (i.toLowerCase().equals(a)) {
					index = tasks.indexOf(i);
				}
			}
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Task Not Found");
			} else {
				tasks.remove(index);
			}
		}
		if (clicked == load) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String s = "";
					String str = br.readLine();
					while (str != null) {
						s += str + "\n";
						str = br.readLine();
					}
					br.close();
					JOptionPane.showMessageDialog(null, s);

				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else {
				try {
					BufferedReader saved = new BufferedReader(
							new FileReader(new File("").getAbsolutePath() + "/src/_03_To_Do_List/saved.txt"));
					String save="";
					String str = saved.readLine();
					String s="";
					BufferedReader br = new BufferedReader(
							new FileReader(new File("").getAbsolutePath() + "/src/_03_To_Do_List/"+str));
					String read = br.readLine();
					while (read!=null) {
						s+=read + "\n";
						read = br.readLine();
					}
					JOptionPane.showMessageDialog(null, s);
					saved.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		if (clicked == save) {
			String s = "";
			for (String i : tasks) {
				s += i + "\n";
			}
			String name = "";
			for (String i : tasks) {
				name += i;
			}
			try {
				FileWriter fw;
				FileWriter saved = new FileWriter(new File("").getAbsolutePath() + "/src/_03_To_Do_List/saved.txt");
				String savedname;
				if (name.length() > 10) {
					fw = new FileWriter(
							new File("").getAbsolutePath() + "/src/_03_To_Do_List/" + name.substring(0, 10) + ".txt");
					savedname = name.substring(0, 10);
				} else {
					fw = new FileWriter(new File("").getAbsolutePath() + "/src/_03_To_Do_List/" + name + ".txt");
					savedname = name;
				}
				saved.write(savedname + ".txt");
				saved.close();
				try {
					fw.write(s);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
