import net.jini.space.*;
import java.awt.*;
import javax.swing.*;

public class Getter extends JFrame {
	private static int FIVE_SECOMDS = 1000 * 5;  //1000 miliseconds, multiplied by 5

	private JavaSpace space;
    private JTextField outString;
    private JTextField authorString;

    public Getter() {
		space = SpaceUtils.getSpace();
		if (space == null){
			System.err.println("Failed to find the javaspace");
			System.exit(1);
		}

		initComponents ();
		this.setSize(300,150);
	}

	private void initComponents() {
		setTitle("JavaSpaces Getter");
		addWindowListener (new java.awt.event.WindowAdapter () {
			public void windowClosing (java.awt.event.WindowEvent evt) {
				exitForm (evt);
			}
		}   );

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

        JPanel jPanel1 = new JPanel();
		jPanel1.setLayout (new FlowLayout ());

        JPanel jPanel2 = new JPanel();
		jPanel2.setLayout (new FlowLayout ());

        JPanel jPanel3 = new JPanel();
		jPanel2.setLayout (new FlowLayout ());

		// North
        JLabel textLabel = new JLabel();
		textLabel.setText ("Value retrieved ");
		jPanel1.add(textLabel);

		outString = new JTextField(12);
		outString.setText("");
		outString.setEditable(false);
		jPanel1.add(outString);

		cp.add (jPanel1, "North");

		// Center
        JLabel authorLabel = new JLabel();
		authorLabel.setText ("Author ");
		jPanel2.add(authorLabel);

		authorString = new JTextField(12);
		authorString.setText("");
		authorString.setEditable(false);
		jPanel2.add(authorString);

		cp.add (jPanel2, "Center");

		//  Southerner (Ew!)
        JButton getButton = new JButton();
		getButton.setText(" Get ");
		getButton.addActionListener (new java.awt.event.ActionListener () {
			public void actionPerformed (java.awt.event.ActionEvent evt) {
				getSobj (evt);
			}
		}   );

		jPanel3.add(getButton);
		cp.add (jPanel3, "South");
	}

	private void exitForm(java.awt.event.WindowEvent evt) {
		System.exit (0);
	}

	private void getSobj (java.awt.event.ActionEvent evt) {
		Sobj template = new Sobj();
		try {
			Sobj got = (Sobj)space.take(template, null, FIVE_SECOMDS);
			if (got == null)
				outString.setText("No object found");
			else
				outString.setText(got.contents);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new Getter().setVisible(true);
	}
}
