package admin;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Main.EstablishConection;
import Main.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Admin_Manage_Student extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, pp, q1, h, q2, q3;
    public JButton[] bp;
    public JLabel[] cl, cl2;
    public JPanel borderp, p1, p2, p3, p4, p5, cp1, bp1, gen, r1, searchp, searchp1, searchp2, deletep, dob, dob2, v1,
            v2;
    public JTextField sroll, sname, fname, semail, sphone, ssans, searcht, sroll2, sname2, fname2, semail2, sphone2;
    public JComboBox<String> security, course, branch, year, semester, sdod, sdom, sdoy, sdod2, sdom2, sdoy2, course2,
            branch2, year2, semester2;
    public JPasswordField pass1;
    ButtonGroup bgroup;
    JRadioButton m, f;
    public JLabel weltext, searchl;
    JButton logout, exit, back, crst, searchb, deleteb, update, searchb2, clear;
    JTable table1, table2;
    DefaultTableModel model1, model2;
    JScrollPane js, js1,ms;
    Connection con = null;
    String user = "";
    String name = "";

    public Admin_Manage_Student(String s, Connection con, String name, String user) {
        super(s);
        // setSize(1080,780);
        setMinimumSize(new Dimension(1320, 790));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this.con = con;
        this.name = name;
        this.user = user;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setResizable(false);
        create_component();
        set_Layout();
        add_component();
        set_color();
        set_Border();
        set_font_and_Cursor();
        albActionListener();
        create_ActionListener();
    }

    // create_component
    public void create_component() {
        borderp = new JPanel();
        ms = new JScrollPane(borderp);
        p = new JPanel[7];

        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }
        p[0].setPreferredSize(new Dimension(10, 124));
        p[1].setPreferredSize(new Dimension(10, 0));
        p[2].setPreferredSize(new Dimension(0, 10));
        p[3].setPreferredSize(new Dimension(0, 0));
        p[5].setPreferredSize(new Dimension(10, 40));

        bp = new JButton[4];
        bp[0] = new JButton("Add New Student");
        bp[1] = new JButton("View Students List");
        bp[2] = new JButton("Edit Student Details");
        bp[3] = new JButton("Delete Student Details");

        pp = new JPanel[4];
        for (int i = 0; i < pp.length; i++) {
            pp[i] = new JPanel();
            bp[i].setFocusable(false);
        }

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p3.setPreferredSize(new Dimension(155, 10));
        p4.setPreferredSize(new Dimension(155, 10));

        back = new JButton("Back", new ImageIcon(getClass().getResource("/photo/back1.png")));
        weltext = new JLabel("Manage Student", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel[6];
        for (int i = 0; i < q1.length; i++) {
            q1[i] = new JPanel();
        }
        q1[0].setPreferredSize(new Dimension(20, 10));
        q1[1].setPreferredSize(new Dimension(20, 10));
        q1[2].setPreferredSize(new Dimension(20, 10));
        q1[3].setPreferredSize(new Dimension(20, 10));
        q1[4].setPreferredSize(new Dimension(20, 10));
        q1[5].setPreferredSize(new Dimension(20, 10));
        // q1[6].setPreferredSize(new Dimension(230,10));
        // q1[7].setPreferredSize(new Dimension(230,10));
        // q1[8].setPreferredSize(new Dimension(230,10));

        cp1 = new JPanel();
        bp1 = new JPanel();
        bp1.setPreferredSize(new Dimension(10, 90));
        r1 = new JPanel();
        crst = new JButton("Add Student");
        crst.setPreferredSize(new Dimension(200, 48));

        h = new JPanel[6];
        for (int i = 0; i < h.length; i++) {
            h[i] = new JPanel();
        }
        h[2].setPreferredSize(new Dimension(240, 10));
        h[4].setPreferredSize(new Dimension(240, 10));

        dob = new JPanel();

        cl = new JLabel[14];
        cl[0] = new JLabel("Roll Number", JLabel.CENTER);
        cl[1] = new JLabel("Name", JLabel.CENTER);
        cl[2] = new JLabel("Password", JLabel.CENTER);
        cl[3] = new JLabel("Gender", JLabel.CENTER);
        cl[4] = new JLabel("Date of birth", JLabel.CENTER);
        cl[5] = new JLabel("Father Name", JLabel.CENTER);
        cl[6] = new JLabel("E-mail ID", JLabel.CENTER);
        cl[7] = new JLabel("Phone Number", JLabel.CENTER);
        cl[8] = new JLabel("Course", JLabel.CENTER);
        cl[9] = new JLabel("Branch", JLabel.CENTER);
        cl[10] = new JLabel("Year", JLabel.CENTER);
        cl[11] = new JLabel("Semester", JLabel.CENTER);
        cl[12] = new JLabel("Security Question", JLabel.CENTER);
        cl[13] = new JLabel("Answer", JLabel.CENTER);

        sroll = new JTextField();
        sname = new JTextField();
        pass1 = new JPasswordField();
        fname = new JTextField();
        semail = new JTextField();
        sphone = new JTextField();
        ssans = new JTextField();

        pass1.setEchoChar('*');

        bgroup = new ButtonGroup();
        m = new JRadioButton("Male");
        f = new JRadioButton("Female");
        bgroup.add(m);
        bgroup.add(f);

        gen = new JPanel();

        // btech=new String[]{};
        // bca=new String[]{};
        course = new JComboBox<>(
                new String[] { "Select the Course", "B.Tech", "BCA", "BBA", "B.Sc", "M.Tech", "MCA", "MBA", "M.Sc" });
        branch = new JComboBox<>(new String[] { "Select the Branch", "CSE", "IT", "ECE", "EE", "EEE", "Civil",
                "Mechanical", "Automobile", "other" });
        year = new JComboBox<>(new String[] { "Select the Year", "1st", "2nd", "3rd", "4th" });
        semester = new JComboBox<>(
                new String[] { "Select the Semester", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" });
        security = new JComboBox<>(new String[] { "Select Security Question", "Your Nick Name?", "Your Lucky Number?",
                "Your Childhood Name?", "Your Place of birth?" });
        sdod = new JComboBox<>(new String[] { "Select Day" });
        sdom = new JComboBox<>(new String[] { "Select Month" });
        sdoy = new JComboBox<>(new String[] { "Select Year" });
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                sdod.addItem("0" + String.valueOf(i));
            } else {
                sdod.addItem(String.valueOf(i));
            }
        }
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                sdom.addItem("0" + String.valueOf(i));
            } else {
                sdom.addItem(String.valueOf(i));
            }
        }
        Calendar cal = new GregorianCalendar();
        int newyear = cal.get(Calendar.YEAR);
        int oldyear = newyear - 100;
        for (int i = newyear; oldyear <= i; i--) {
            sdoy.addItem(String.valueOf(i));
        }

        String[] col = { "Roll No.", "Name", "Gender", "DOB", "Father Name", "Email ID", "Phone No.", "Course",
                "Branch", "Year", "Semester", "Total Issue Book", "Total Return Book" };
        // table1
        model1 = new DefaultTableModel(col, 0);
        table1 = new JTable(model1);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(30);
        // cell alignment
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        js = new JScrollPane(table1);
        // table2
        model2 = new DefaultTableModel(col, 0);
        table2 = new JTable(model2);
        table2.getTableHeader().setReorderingAllowed(false);
        // table2.setColumnHeight(30);
        table2.setRowHeight(30);
        // cell alignment
        renderer = (DefaultTableCellRenderer) table2.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        js1 = new JScrollPane(table2);

        searchp = new JPanel();
        searchp1 = new JPanel();
        searchp2 = new JPanel();
        deletep = new JPanel();

        q2 = new JPanel[3];
        for (int i = 0; i < q2.length; i++) {
            q2[i] = new JPanel();
        }

        searchl = new JLabel("Roll Number", JLabel.CENTER);
        searcht = new JTextField();
        searchb = new JButton("Search");
        deleteb = new JButton("Delete Student Details");

        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(120);
        columnModel.getColumn(11).setPreferredWidth(100);
        columnModel.getColumn(12).setPreferredWidth(100);

        columnModel = table2.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(120);
        columnModel.getColumn(11).setPreferredWidth(100);
        columnModel.getColumn(12).setPreferredWidth(100);

        table1.setGridColor(Color.WHITE);
        table2.setGridColor(Color.WHITE);

        // update student
        q3 = new JPanel[11];
        for (int i = 0; i < q3.length; i++) {
            q3[i] = new JPanel();
        }
        q3[1].setPreferredSize(new Dimension(10, 50));
        q3[3].setPreferredSize(new Dimension(10, 50));
        q3[4].setPreferredSize(new Dimension(10, 50));
        q3[7].setPreferredSize(new Dimension(220, 10));
        q3[9].setPreferredSize(new Dimension(220, 10));
        dob2 = new JPanel();
        v1 = new JPanel();
        v2 = new JPanel();

        cl2 = new JLabel[10];
        cl2[0] = new JLabel("Roll Number", JLabel.CENTER);
        cl2[1] = new JLabel("Name", JLabel.CENTER);
        cl2[2] = new JLabel("Date of birth", JLabel.CENTER);
        cl2[3] = new JLabel("Father Name", JLabel.CENTER);
        cl2[4] = new JLabel("E-mail ID", JLabel.CENTER);
        cl2[5] = new JLabel("Phone Number", JLabel.CENTER);
        cl2[6] = new JLabel("Course", JLabel.CENTER);
        cl2[7] = new JLabel("Branch", JLabel.CENTER);
        cl2[8] = new JLabel("Year", JLabel.CENTER);
        cl2[9] = new JLabel("Semester", JLabel.CENTER);

        sroll2 = new JTextField();
        sname2 = new JTextField();
        fname2 = new JTextField();
        semail2 = new JTextField();
        sphone2 = new JTextField();

        course2 = new JComboBox<>(
                new String[] { "Select the Course", "B.Tech", "BCA", "BBA", "B.Sc", "M.Tech", "MCA", "MBA", "M.Sc" });
        branch2 = new JComboBox<>(new String[] { "Select the Branch", "CSE", "IT", "ECE", "EE", "EEE", "Civil",
                "Mechanical", "Automobile", "other" });
        year2 = new JComboBox<>(new String[] { "Select the Year", "1st", "2nd", "3rd", "4th" });
        semester2 = new JComboBox<>(
                new String[] { "Select the Semester", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" });
        sdod2 = new JComboBox<>(new String[] { "Select Day" });
        sdom2 = new JComboBox<>(new String[] { "Select Month" });
        sdoy2 = new JComboBox<>(new String[] { "Select Year" });
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                sdod2.addItem("0" + String.valueOf(i));
            } else {
                sdod2.addItem(String.valueOf(i));
            }
        }
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                sdom2.addItem("0" + String.valueOf(i));
            } else {
                sdom2.addItem(String.valueOf(i));
            }
        }
        newyear = cal.get(Calendar.YEAR);
        oldyear = newyear - 100;
        for (int i = newyear; oldyear <= i; i--) {
            sdoy2.addItem(String.valueOf(i));
        }
        searchb2 = new JButton("Search");
        update = new JButton("Update Student Details");
        clear = new JButton("Clear");
        searchb2.setPreferredSize(new Dimension(200, 50));
        clear.setPreferredSize(new Dimension(200, 50));
        update.setPreferredSize(new Dimension(300, 50));

        set_Hide(false);

    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(2, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new GridLayout(1, 1));

        p1.setLayout(new BorderLayout(0, 0));
        p2.setLayout(new GridLayout(1, 1));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new GridLayout(1, 1));
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        for (int i = 0; i < pp.length; i++) {
            pp[i].setLayout(new BorderLayout(0, 20));
        }
        cp1.setLayout(new GridLayout(1, 2, 20, 0));
        bp1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        gen.setLayout(new GridLayout(1, 2));
        h[0].setLayout(new BorderLayout(10, 0));
        h[1].setLayout(new BorderLayout(10, 0));
        h[2].setLayout(new GridLayout(7, 1, 10, 20));
        h[3].setLayout(new GridLayout(7, 1, 10, 20));
        h[4].setLayout(new GridLayout(7, 1, 10, 20));
        h[5].setLayout(new GridLayout(7, 1, 10, 20));
        dob.setLayout(new GridLayout(1, 3, 10, 0));

        q1[2].setLayout(new GridLayout(1, 1));
        q1[5].setLayout(new BorderLayout(0, 0));
        searchp.setLayout(new GridLayout(2, 1));
        searchp1.setLayout(new BorderLayout(0, 0));
        searchp2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        deletep.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q2[2].setLayout(new GridLayout(1, 2, 20, 0));
        q3[0].setLayout(new BorderLayout(0, 10));
        q3[1].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q3[2].setLayout(new GridLayout(1, 2, 40, 0));
        q3[3].setLayout(new GridLayout(1, 4, 20, 0));
        q3[4].setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        q3[5].setLayout(new BorderLayout(20, 0));
        q3[6].setLayout(new BorderLayout(20, 0));
        q3[7].setLayout(new GridLayout(5, 1, 20, 20));
        q3[8].setLayout(new GridLayout(5, 1, 20, 20));
        q3[9].setLayout(new GridLayout(4, 1, 20, 40));
        q3[10].setLayout(new GridLayout(4, 1, 20, 40));
        dob2.setLayout(new GridLayout(1, 3, 10, 0));
    }

    // add_component
    public void add_component() {
        add(ms);
        borderp.add(p[0], BorderLayout.NORTH);
        borderp.add(p[1], BorderLayout.SOUTH);
        borderp.add(p[2], BorderLayout.EAST);
        borderp.add(p[3], BorderLayout.WEST);
        borderp.add(p[4], BorderLayout.CENTER);

        p[0].add(p1);
        p[0].add(p2);
        p1.add(p3, BorderLayout.WEST);
        p1.add(p4, BorderLayout.EAST);
        p1.add(p5, BorderLayout.CENTER);
        p2.add(weltext);
        p3.add(back);
        p4.add(logout);
        p5.add(exit);

        p[4].add(p[5], BorderLayout.NORTH);
        p[4].add(p[6], BorderLayout.CENTER);

        for (int i = 0; i < pp.length; i++) {
            p[5].add(bp[i]);
        }
        hide();
        p[6].add(pp[0]);
        pp[0].setVisible(true);

        int j = 0;
        for (int i = 1; i < pp.length; i++) {
            if (i != 2) {
                pp[i].add(q1[j], BorderLayout.WEST);
                j++;
                pp[i].add(q1[j], BorderLayout.EAST);
                j++;
                pp[i].add(q1[j], BorderLayout.CENTER);
                j++;
            }
        }

        Color color = new Color(41, 128, 185);
        for (int i = 0; i < q1.length; i++) {
            q1[i].setBackground(color);
        }

        // q1[0].setBackground(Color.RED);
        // q1[1].setBackground(Color.cyan);
        // q1[2].setBackground(Color.BLACK);//2
        // q1[3].setBackground(Color.YELLOW);
        // q1[4].setBackground(Color.GRAY);
        q3[9].setBackground(Color.GREEN);// 5

        pp[0].add(cp1, BorderLayout.CENTER);
        pp[0].add(bp1, BorderLayout.SOUTH);

        bp1.add(r1);
        r1.add(crst);

        cp1.add(h[0]);
        cp1.add(h[1]);

        h[0].add(h[2], BorderLayout.WEST);
        h[0].add(h[3], BorderLayout.CENTER);

        h[1].add(h[4], BorderLayout.WEST);
        h[1].add(h[5], BorderLayout.CENTER);

        h[2].add(cl[0]);
        h[2].add(cl[1]);
        h[2].add(cl[2]);
        h[2].add(cl[3]);
        h[2].add(cl[4]);
        h[2].add(cl[5]);
        h[2].add(cl[6]);
        h[3].add(sroll);
        h[3].add(sname);
        h[3].add(pass1);
        h[3].add(gen);
        h[3].add(dob);
        h[3].add(fname);
        h[3].add(semail);
        h[4].add(cl[7]);
        h[4].add(cl[8]);
        h[4].add(cl[9]);
        h[4].add(cl[10]);
        h[4].add(cl[11]);
        h[4].add(cl[12]);
        h[4].add(cl[13]);
        h[5].add(sphone);
        h[5].add(course);
        h[5].add(branch);
        h[5].add(year);
        h[5].add(semester);
        h[5].add(security);
        h[5].add(ssans);

        dob.add(sdod);
        dob.add(sdom);
        dob.add(sdoy);

        gen.add(m);
        gen.add(f);

        q1[2].add(js);

        q1[5].add(searchp, BorderLayout.NORTH);
        q1[5].add(deletep, BorderLayout.SOUTH);
        q1[5].add(js1, BorderLayout.CENTER);
        searchp.add(searchp1);
        searchp.add(searchp2);

        searchp1.add(q2[0], BorderLayout.WEST);
        searchp1.add(q2[1], BorderLayout.EAST);
        searchp1.add(q2[2], BorderLayout.CENTER);

        q2[0].setPreferredSize(new Dimension(200, 70));
        q2[1].setPreferredSize(new Dimension(200, 70));

        searchb.setPreferredSize(new Dimension(140, 50));
        deleteb.setPreferredSize(new Dimension(320, 50));

        q2[2].add(searchl);
        q2[2].add(searcht);
        searchp2.add(searchb);
        deletep.add(deleteb);

        pp[2].add(q3[0], BorderLayout.NORTH);
        pp[2].add(q3[1], BorderLayout.SOUTH);
        pp[2].add(q3[2], BorderLayout.CENTER);

        q3[1].add(update);

        q3[0].add(q3[3], BorderLayout.NORTH);
        q3[0].add(q3[4], BorderLayout.SOUTH);
        q3[3].add(v1);
        q3[3].add(cl2[0]);
        q3[3].add(sroll2);
        q3[3].add(v2);
        q3[4].add(searchb2);
        q3[4].add(clear);
        q3[2].setBackground(Color.BLACK);
        q3[7].setBackground(Color.ORANGE);

        q3[2].add(q3[5]);
        q3[2].add(q3[6]);

        q3[5].add(q3[7], BorderLayout.WEST);
        q3[5].add(q3[8], BorderLayout.CENTER);

        q3[6].add(q3[9], BorderLayout.WEST);
        q3[6].add(q3[10], BorderLayout.CENTER);

        q3[7].add(cl2[1]);
        q3[7].add(cl2[2]);
        q3[7].add(cl2[3]);
        q3[7].add(cl2[4]);
        q3[7].add(cl2[5]);
        q3[8].add(sname2);
        q3[8].add(dob2);
        q3[8].add(fname2);
        q3[8].add(semail2);
        q3[8].add(sphone2);
        q3[9].add(cl2[6]);
        q3[9].add(cl2[7]);
        q3[9].add(cl2[8]);
        q3[9].add(cl2[9]);
        q3[10].add(course2);
        q3[10].add(branch2);
        q3[10].add(year2);
        q3[10].add(semester2);

        dob2.add(sdod2);
        dob2.add(sdom2);
        dob2.add(sdoy2);
    }

    // set_Border
    public void set_Border() {
        borderp.setBorder(BorderFactory.createLineBorder(new Color(19, 15, 64), 10));
        p[4].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        p[0].setBorder(BorderFactory.createLineBorder(new Color(162, 155, 254), 4));
        Color co1 = new Color(211, 84, 0);
        p3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, co1));
        p4.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, co1));
        p5.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, co1));

        Color color = new Color(41, 128, 185);
        cp1.setBorder(BorderFactory.createMatteBorder(20, 20, 5, 20, color));
        bp1.setBorder(BorderFactory.createMatteBorder(12, 0, 20, 0, color));

        pp[2].setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, color));

        sroll.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        sname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        pass1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        fname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        semail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        sphone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        ssans.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));

        sroll2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        sname2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        fname2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        semail2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        sphone2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));

        q1[2].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));
        q1[5].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));

        q2[0].setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        q2[1].setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        q2[2].setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        searchp2.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        deletep.setBorder(BorderFactory.createMatteBorder(20, 0, 0, 0, color));

        searcht.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
    }

    public void set_Hide(boolean ve) {
        for (int i = 1; i < cl2.length; i++) {
            cl2[i].setVisible(ve);
        }
        sname2.setVisible(ve);
        dob2.setVisible(ve);
        fname2.setVisible(ve);
        semail2.setVisible(ve);
        sphone2.setVisible(ve);
        course2.setVisible(ve);
        branch2.setVisible(ve);
        year2.setVisible(ve);
        semester2.setVisible(ve);
        update.setVisible(ve);
    }

    // set_color
    public void set_color() {
        getContentPane().setBackground(new Color(19, 15, 64));

        p[0].setBackground(new Color(19, 15, 64));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(Color.WHITE);
        p[6].setBackground(Color.PINK);

        bp[0].setBackground(new Color(142, 68, 173));
        for (int i = 1; i < bp.length; i++) {
            bp[i].setBackground(new Color(48, 51, 107));
        }

        Color color = new Color(41, 128, 185);
        for (int i = 0; i < bp.length; i++) {
            bp[i].setForeground(Color.WHITE);
            pp[i].setBackground(color);
        }
        for (int i = 0; i < h.length; i++) {
            h[i].setBackground(color);
        }

        dob.setBackground(color);
        // pp[0].setBackground(Color.RED);
        // pp[1].setBackground(Color.BLACK);
        // pp[2].setBackground(Color.DARK_GRAY);

        weltext.setForeground(Color.WHITE);
        Color co1 = new Color(211, 84, 0);
        p1.setBackground(co1);
        p2.setBackground(new Color(45, 52, 54));
        p3.setBackground(co1);
        p5.setBackground(co1);
        logout.setBackground(new Color(34, 47, 62));
        exit.setBackground(new Color(34, 47, 62));
        back.setBackground(new Color(34, 47, 62));
        logout.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        bp1.setBackground(color);
        cp1.setBackground(color);

        Color color1 = new Color(19, 15, 64);
        sroll.setBackground(color1);
        sname.setBackground(color1);
        pass1.setBackground(color1);
        fname.setBackground(color1);
        semail.setBackground(color1);
        sphone.setBackground(color1);
        course.setBackground(color1);
        branch.setBackground(color1);
        year.setBackground(color1);
        semester.setBackground(color1);
        security.setBackground(color1);
        ssans.setBackground(color1);
        m.setBackground(color1);
        f.setBackground(color1);
        searcht.setBackground(color1);
        sdod.setBackground(color1);
        sdom.setBackground(color1);
        sdoy.setBackground(color1);

        sroll2.setBackground(color1);
        sname2.setBackground(color1);
        fname2.setBackground(color1);
        semail2.setBackground(color1);
        sphone2.setBackground(color1);
        course2.setBackground(color1);
        branch2.setBackground(color1);
        year2.setBackground(color1);
        semester2.setBackground(color1);
        sdod2.setBackground(color1);
        sdom2.setBackground(color1);
        sdoy2.setBackground(color1);

        Color wh = Color.WHITE;
        sroll.setForeground(wh);
        sname.setForeground(wh);
        pass1.setForeground(wh);
        fname.setForeground(wh);
        semail.setForeground(wh);
        sphone.setForeground(wh);
        course.setForeground(wh);
        branch.setForeground(wh);
        year.setForeground(wh);
        semester.setForeground(wh);
        security.setForeground(wh);
        ssans.setForeground(wh);
        m.setForeground(wh);
        f.setForeground(wh);
        searcht.setForeground(wh);
        sdod.setForeground(wh);
        sdom.setForeground(wh);
        sdoy.setForeground(wh);

        sroll2.setForeground(wh);
        sname2.setForeground(wh);
        fname2.setForeground(wh);
        semail2.setForeground(wh);
        sphone2.setForeground(wh);
        course2.setForeground(wh);
        branch2.setForeground(wh);
        year2.setForeground(wh);
        semester2.setForeground(wh);
        sdod2.setForeground(wh);
        sdom2.setForeground(wh);
        sdoy2.setForeground(wh);

        sroll.setCaretColor(wh);
        sname.setCaretColor(wh);
        pass1.setCaretColor(wh);
        fname.setCaretColor(wh);
        semail.setCaretColor(wh);
        sphone.setCaretColor(wh);
        ssans.setCaretColor(wh);
        searcht.setCaretColor(wh);

        sroll2.setCaretColor(wh);
        sname2.setCaretColor(wh);
        fname2.setCaretColor(wh);
        semail2.setCaretColor(wh);
        sphone2.setCaretColor(wh);

        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }
        for (int i = 0; i < cl2.length; i++) {
            cl2[i].setOpaque(true);
            cl2[i].setBackground(Color.YELLOW);
            cl2[i].setForeground(Color.BLACK);
        }

        crst.setBackground(Color.YELLOW);
        r1.setBackground(new Color(30, 39, 46));
        crst.setForeground(Color.BLACK);

        searchb.setBackground(Color.YELLOW);
        searchb.setForeground(new Color(19, 15, 64));

        searchb2.setBackground(Color.YELLOW);
        searchb2.setForeground(new Color(19, 15, 64));
        clear.setBackground(Color.YELLOW);
        clear.setForeground(new Color(19, 15, 64));

        update.setBackground(Color.YELLOW);
        update.setForeground(new Color(19, 15, 64));

        deleteb.setBackground(Color.YELLOW);
        deleteb.setForeground(new Color(19, 15, 64));

        searchl.setOpaque(true);
        searchl.setBackground(Color.YELLOW);

        table1.setBackground(color1);
        table1.setForeground(Color.WHITE);
        table2.setBackground(color1);
        table2.setForeground(Color.WHITE);
        table1.getTableHeader().setBackground(new Color(45, 52, 54));
        table1.getTableHeader().setForeground(Color.WHITE);
        table2.getTableHeader().setBackground(new Color(45, 52, 54));
        table2.getTableHeader().setForeground(Color.WHITE);

        js.getViewport().setBackground(color);
        js.setBorder(BorderFactory.createEmptyBorder());
        js1.getViewport().setBackground(color1);
        js1.setBorder(BorderFactory.createEmptyBorder());

        Color color2 = new Color(41, 128, 185);
        for (int i = 0; i < q2.length; i++) {
            q2[i].setBackground(color2);
        }
        searchp2.setBackground(color2);
        deletep.setBackground(color2);

        sroll.requestFocus();

        for (int i = 0; i < q3.length; i++) {
            q3[i].setBackground(color);
        }
        v1.setBackground(color);
        v2.setBackground(color);
        dob2.setBackground(color);
    }

    public void hide() {
        for (int i = 0; i < pp.length; i++) {
            pp[i].setVisible(false);
            p[6].remove(pp[i]);
        }
    }

    public void albActionListener() {
        bp[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(pp[0]);
                pp[0].setVisible(true);
                bp[0].setBackground(new Color(142, 68, 173));
                bp[1].setBackground(new Color(48, 51, 107));
                bp[2].setBackground(new Color(48, 51, 107));
                bp[3].setBackground(new Color(48, 51, 107));
                sroll.setText("");
                sname.setText("");
                pass1.setText("");
                if (m.isSelected()) {
                    m.setSelected(false);
                } else if (f.isSelected()) {
                    f.setSelected(false);
                }
                sdod.setSelectedIndex(0);
                sdom.setSelectedIndex(0);
                sdoy.setSelectedIndex(0);
                fname.setText("");
                semail.setText("");
                sphone.setText("");
                course.setSelectedIndex(0);
                branch.setSelectedIndex(0);
                year.setSelectedIndex(0);
                semester.setSelectedIndex(0);
                security.setSelectedIndex(0);
                ssans.setText("");
                sroll.requestFocus();
            }
        });
        bp[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(pp[1]);
                pp[1].setVisible(true);
                bp[0].setBackground(new Color(48, 51, 107));
                bp[1].setBackground(new Color(142, 68, 173));
                bp[2].setBackground(new Color(48, 51, 107));
                bp[3].setBackground(new Color(48, 51, 107));
                if (con != null && EstablishConection.getEstblishConnection() != null) {
                    if (model1.getRowCount() != 0) {
                        int no = model1.getRowCount();
                        for (int i = 1; i <= no; i++) {
                            model1.removeRow(0);
                        }
                    }
                    try {
                        String q = "SELECT roll_no,name,gender,dob,father_name,email_id,phone_no,course,branch,year,semester,total_issue_book,total_return_book	 FROM student";

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(q);

                        String[] row = new String[13];
                        while (rs.next()) {
                            row[0] = rs.getString(1);
                            row[1] = rs.getString(2);
                            row[2] = rs.getString(3);
                            row[3] = rs.getString(4);
                            row[4] = rs.getString(5);
                            row[5] = rs.getString(6);
                            row[6] = rs.getString(7);
                            row[7] = rs.getString(8);
                            row[8] = rs.getString(9);
                            row[9] = rs.getString(10);
                            row[10] = rs.getString(11);
                            row[11] = rs.getString(12);
                            row[12] = rs.getString(13);
                            model1.addRow(row);
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        bp[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(pp[2]);
                pp[2].setVisible(true);
                bp[0].setBackground(new Color(48, 51, 107));
                bp[1].setBackground(new Color(48, 51, 107));
                bp[2].setBackground(new Color(142, 68, 173));
                bp[3].setBackground(new Color(48, 51, 107));
                sroll2.requestFocus();

            }
        });

        bp[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(pp[3]);
                pp[3].setVisible(true);
                bp[0].setBackground(new Color(48, 51, 107));
                bp[1].setBackground(new Color(48, 51, 107));
                bp[2].setBackground(new Color(48, 51, 107));
                bp[3].setBackground(new Color(142, 68, 173));
                searcht.setText("");
                searcht.requestFocus();
                if (model2.getRowCount() != 0) {
                    model2.removeRow(0);
                }
            }
        });
    }

    // set_font_and_Cursor
    public void set_font_and_Cursor() {
        Font af = new Font("Tahoma", Font.BOLD, 16);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        for (int i = 0; i < pp.length; i++) {
            bp[i].setFont(af);
            bp[i].setCursor(cursor);
        }
        weltext.setFont(af);
        logout.setFont(af);
        exit.setFont(af);
        back.setFont(af);

        logout.setCursor(cursor);
        exit.setCursor(cursor);
        back.setCursor(cursor);
        crst.setCursor(cursor);
        searchb.setCursor(cursor);
        deleteb.setCursor(cursor);
        searchb2.setCursor(cursor);
        update.setCursor(cursor);
        clear.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        m.setFocusable(false);
        f.setFocusable(false);
        crst.setFocusable(false);
        searchb.setFocusable(false);
        deleteb.setFocusable(false);
        searchb2.setFocusable(false);
        update.setFocusable(false);
        clear.setFocusable(false);

        m.setHorizontalAlignment(JRadioButton.CENTER);
        f.setHorizontalAlignment(JRadioButton.CENTER);
        sroll.setHorizontalAlignment(JTextField.CENTER);
        sname.setHorizontalAlignment(JTextField.CENTER);
        pass1.setHorizontalAlignment(JPasswordField.CENTER);
        fname.setHorizontalAlignment(JTextField.CENTER);
        semail.setHorizontalAlignment(JTextField.CENTER);
        sphone.setHorizontalAlignment(JTextField.CENTER);
        ssans.setHorizontalAlignment(JTextField.CENTER);
        searcht.setHorizontalAlignment(JTextField.CENTER);
        sroll2.setHorizontalAlignment(JTextField.CENTER);
        sname2.setHorizontalAlignment(JTextField.CENTER);
        fname2.setHorizontalAlignment(JTextField.CENTER);
        semail2.setHorizontalAlignment(JTextField.CENTER);
        sphone2.setHorizontalAlignment(JTextField.CENTER);

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        course.setRenderer(listRenderer);
        branch.setRenderer(listRenderer);
        year.setRenderer(listRenderer);
        semester.setRenderer(listRenderer);
        security.setRenderer(listRenderer);
        sdod.setRenderer(listRenderer);
        sdom.setRenderer(listRenderer);
        sdoy.setRenderer(listRenderer);
        course2.setRenderer(listRenderer);
        branch2.setRenderer(listRenderer);
        year2.setRenderer(listRenderer);
        semester2.setRenderer(listRenderer);
        sdod2.setRenderer(listRenderer);
        sdom2.setRenderer(listRenderer);
        sdoy2.setRenderer(listRenderer);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        crst.setFont(font);

        Font font1 = new Font("Tahoma", Font.BOLD, 18);
        for (int i = 0; i < cl.length; i++) {
            cl[i].setFont(font1);
        }
        for (int i = 0; i < cl2.length; i++) {
            cl2[i].setFont(font1);
        }

        sroll.setFont(font1);
        sname.setFont(font1);
        pass1.setFont(font1);
        fname.setFont(font1);
        semail.setFont(font1);
        sphone.setFont(font1);
        course.setFont(font1);
        branch.setFont(font1);
        year.setFont(font1);
        semester.setFont(font1);
        security.setFont(font1);
        ssans.setFont(font1);
        m.setFont(font1);
        f.setFont(font1);

        sroll2.setFont(font1);
        sname2.setFont(font1);
        fname2.setFont(font1);
        semail2.setFont(font1);
        sphone2.setFont(font1);
        course2.setFont(font1);
        branch2.setFont(font1);
        year2.setFont(font1);
        semester2.setFont(font1);

        searchl.setFont(font);
        searcht.setFont(font);
        searchb.setFont(font);
        deleteb.setFont(font);
        searchb2.setFont(font);
        update.setFont(font);
        clear.setFont(font);

        Font font2 = new Font("Tahoma", Font.BOLD, 12);
        table1.setFont(font2);
        table2.setFont(font2);
        table1.getTableHeader().setFont(font2);
        table2.getTableHeader().setFont(font2);

        Font font3 = new Font("Tahoma", Font.BOLD, 12);
        sdod.setFont(font3);
        sdom.setFont(font3);
        sdoy.setFont(font3);
        sdod2.setFont(font3);
        sdom2.setFont(font3);
        sdoy2.setFont(font3);

    }

    public void create_ActionListener() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con != null && EstablishConection.getEstblishConnection() != null) {
                    try {
                        Admin_logout_Info.save_Logout_Info(con, name, user);
                        con.close();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                    }
                }
                System.exit(0);
            }
        });
        back.addActionListener(new Add_Action());
        back.addMouseListener(new Add_Action());
        logout.addActionListener(new Add_Action());
        logout.addMouseListener(new Add_Action());
        exit.addMouseListener(new Add_Action());
        crst.addMouseListener(new Add_Action());
        crst.addActionListener(new Add_Action());
        searchb.addActionListener(new Add_Action());
        searchb.addMouseListener(new Add_Action());
        deleteb.addActionListener(new Add_Action());
        deleteb.addMouseListener(new Add_Action());
        searchb2.addActionListener(new Add_Action());
        searchb2.addMouseListener(new Add_Action());
        update.addActionListener(new Add_Action());
        update.addMouseListener(new Add_Action());
        clear.addActionListener(new Add_Action());
        clear.addMouseListener(new Add_Action());
    }

    class Add_Action implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (con != null) {
                if (e.getSource() == logout && EstablishConection.getEstblishConnection() != null) {
                    try {
                        Admin_logout_Info.save_Logout_Info(con, name, user);
                        con.close();
                        dispose();
                        new Main("Library Management System").setVisible(true);
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                    }
                } else if (e.getSource() == back) {
                    dispose();
                    new AdminControl("Admin Control", con, name, user).setVisible(true);
                } else if (e.getSource() == crst) {
                    String roll = sroll.getText().trim();
                    String name = sname.getText().trim();
                    String pass = String.valueOf(pass1.getPassword()).trim();
                    String gender = "";
                    if (m.isSelected()) {
                        gender = "Male";
                    } else if (f.isSelected()) {
                        gender = "Female";
                    }
                    String dod = String.valueOf(sdod.getSelectedItem()).trim();
                    String dom = String.valueOf(sdom.getSelectedItem()).trim();
                    String doy = String.valueOf(sdoy.getSelectedItem()).trim();
                    String fname1 = fname.getText().trim();
                    String email = semail.getText().trim();
                    String phone = sphone.getText().trim();
                    String course1 = String.valueOf(course.getSelectedItem()).trim();
                    String branch1 = String.valueOf(branch.getSelectedItem()).trim();
                    String year1 = String.valueOf(year.getSelectedItem()).trim();
                    String semester1 = String.valueOf(semester.getSelectedItem()).trim();
                    String securityq = String.valueOf(security.getSelectedItem()).trim();
                    String sans = ssans.getText().trim();
                    boolean ph = false, em = false, ro = false, leapyear = false;
                    if (roll.isEmpty() == false) {
                        try {
                            Long.parseLong(roll);
                        } catch (NumberFormatException e1) {
                            ro = true;
                        }
                    }
                    if (phone.isEmpty() == false) {
                        try {
                            Long.parseLong(phone);
                        } catch (NumberFormatException e1) {
                            ph = true;
                        }
                    }
                    if (email.isEmpty() == false) {
                        if (email.endsWith("@gmail.com")) {
                        } else if (email.endsWith("@yahoo.com")) {
                        } else if (email.endsWith("@hotmail.com")) {
                        } else {
                            em = true;
                        }
                    }
                    if (dod.equals("Select Day") == false && dom.equals("Select Month") == false
                            && doy.equals("Select Year") == false) {
                        int da = Integer.parseInt(dod);
                        int mo = Integer.parseInt(dom);
                        int ye = Integer.parseInt(doy);
                        int da1 = 31;

                        if (mo == 1 || mo == 3 || mo == 5 || mo == 7 || mo == 8 || mo == 10 || mo == 12) {
                            da1 = 31;
                        } else if (mo == 4 || mo == 6 || mo == 9 || mo == 11) {
                            da1 = 30;
                        } else {
                            if ((ye % 400 == 0) || ((ye % 4 == 0) && (ye % 100 != 0))) {
                                da1 = 29;
                            } else {
                                da1 = 28;
                            }
                        }
                        if (da <= da1) {
                            leapyear = false;
                        } else {
                            leapyear = true;
                        }
                    }
                    if (roll.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Roll Number", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (ro) {
                        JOptionPane.showMessageDialog(null, "Roll Number must be numbers only(Not Decimal Number)",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Name", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (name.length() < 4 || name.length() > 30) {
                        JOptionPane.showMessageDialog(null, "Sorry, name must be between 4 and 30 characters long.",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Password", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (pass.length() < 6 || phone.length() > 15) {
                        JOptionPane.showMessageDialog(null,
                                " Sorry, Password must be between 6 and 15 characters long.", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (gender.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Select the Gender", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (dod.equals("Select Day")) {
                        JOptionPane.showMessageDialog(null, "Select Day", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (dom.equals("Select Month")) {
                        JOptionPane.showMessageDialog(null, "Select Month", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (doy.equals("Select Year")) {
                        JOptionPane.showMessageDialog(null, "Select Year", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (leapyear) {
                        JOptionPane.showMessageDialog(null, "Select Valid Date of birth", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (fname1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Father name", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (fname1.length() < 4 || name.length() > 30) {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, Father name must be between 4 and 30 characters long.", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the E-mail ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (email.startsWith("@gmail.com") || email.startsWith("@yahoo.com")
                            || email.startsWith("@hotmail.com") || email.startsWith("@")) {
                        JOptionPane.showMessageDialog(null, "Email ID not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (em) {
                        JOptionPane.showMessageDialog(null,
                                "Email ID end with @gmail.com or @yahoo.com or @hotmail.com", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Phone Number", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (ph) {
                        JOptionPane.showMessageDialog(null, "Phone number must be numbers only", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.startsWith("0") || phone.startsWith("1") || phone.startsWith("2")
                            || phone.startsWith("3") || phone.startsWith("4") || phone.startsWith("5")) {
                        JOptionPane.showMessageDialog(null, "phone Number not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.length() <= 9 || phone.length() > 10) {
                        JOptionPane.showMessageDialog(null, "phone number must be 10 digits", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (course1.equals("Select the Course")) {
                        JOptionPane.showMessageDialog(null, "Select the Course", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (branch1.equals("Select the Branch")) {
                        JOptionPane.showMessageDialog(null, "Select the Branch", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (year1.equals("Select the Year")) {
                        JOptionPane.showMessageDialog(null, "Select the Year", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (semester1.equals("Select the Semester")) {
                        JOptionPane.showMessageDialog(null, "Select the Semester", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (securityq.equals("Select Security Question")) {
                        JOptionPane.showMessageDialog(null, "Select Security Question", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (sans.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Security Answer", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        String q = "SELECT roll_no FROM student WHERE roll_no=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, roll);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                JOptionPane.showMessageDialog(null, "That Roll Number Student is taken. Try another.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                String dateob = dod + "/" + dom + "/" + doy;

                                q = "INSERT INTO student(roll_no,name,password,gender,dob,father_name,email_id,phone_no,course,branch,year,semester,security_question,answer,username_of_admin_add_student,username_of_librarian_add_student) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                ps = con.prepareStatement(q);
                                ps.setString(1, roll);
                                ps.setString(2, name);
                                ps.setString(3, pass);
                                ps.setString(4, gender);
                                ps.setString(5, dateob);
                                ps.setString(6, fname1);
                                ps.setString(7, email);
                                ps.setString(8, phone);
                                ps.setString(9, course1);
                                ps.setString(10, branch1);
                                ps.setString(11, year1);
                                ps.setString(12, semester1);
                                ps.setString(13, securityq);
                                ps.setString(14, sans);
                                ps.setString(15, user);
                                ps.setString(16, "null");

                                ps.executeUpdate();

                                sroll.setText("");
                                sname.setText("");
                                pass1.setText("");
                                if (m.isSelected()) {
                                    m.setSelected(false);
                                } else if (f.isSelected()) {
                                    f.setSelected(false);
                                }
                                sdod.setSelectedIndex(0);
                                sdom.setSelectedIndex(0);
                                sdoy.setSelectedIndex(0);
                                fname.setText("");
                                semail.setText("");
                                sphone.setText("");
                                course.setSelectedIndex(0);
                                branch.setSelectedIndex(0);
                                year.setSelectedIndex(0);
                                semester.setSelectedIndex(0);
                                security.setSelectedIndex(0);
                                ssans.setText("");
                                sroll.requestFocus();
                                JOptionPane.showMessageDialog(null, "Student add Successful", "Information",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                } else if (e.getSource() == searchb2) {
                    String roll = sroll2.getText().trim();
                    if (roll.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Roll No", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT name,dob,father_name,email_id,phone_no,course,branch,year,semester FROM student WHERE roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, roll);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                sroll2.setEditable(false);
                                set_Hide(true);
                                sname2.setText(rs.getString(1));
                                String[] doarr = rs.getString(2).split("/");
                                sdod2.setSelectedItem(doarr[0]);
                                sdom2.setSelectedItem(doarr[1]);
                                sdoy2.setSelectedItem(doarr[2]);
                                fname2.setText(rs.getString(3));
                                semail2.setText(rs.getString(4));
                                sphone2.setText(rs.getString(5));
                                course2.setSelectedItem(rs.getString(6));
                                branch2.setSelectedItem(rs.getString(7));
                                year2.setSelectedItem(rs.getString(8));
                                semester2.setSelectedItem(rs.getString(9));
                            } else {
                                JOptionPane.showMessageDialog(null, "This Roll Number Student is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == clear) {
                    sroll2.setEditable(true);
                    sroll2.setText("");
                    sname2.setText("");
                    sdod2.setSelectedIndex(0);
                    sdom2.setSelectedIndex(0);
                    sdoy2.setSelectedIndex(0);
                    fname2.setText("");
                    semail2.setText("");
                    sphone2.setText("");
                    course2.setSelectedIndex(0);
                    branch2.setSelectedIndex(0);
                    year2.setSelectedIndex(0);
                    semester2.setSelectedIndex(0);
                    set_Hide(false);
                    sroll2.requestFocus();
                } else if (e.getSource() == update) {
                    String roll = sroll2.getText().trim();
                    String name = sname2.getText().trim();
                    String dod = String.valueOf(sdod2.getSelectedItem()).trim();
                    String dom = String.valueOf(sdom2.getSelectedItem()).trim();
                    String doy = String.valueOf(sdoy2.getSelectedItem()).trim();
                    String fname1 = fname2.getText().trim();
                    String email = semail2.getText().trim();
                    String phone = sphone2.getText().trim();
                    String course1 = String.valueOf(course2.getSelectedItem()).trim();
                    String branch1 = String.valueOf(branch2.getSelectedItem()).trim();
                    String year1 = String.valueOf(year2.getSelectedItem()).trim();
                    String semester1 = String.valueOf(semester2.getSelectedItem()).trim();
                    boolean ph = false, em = false, leapyear = false;
                    if (phone.isEmpty() == false) {
                        try {
                            Long.parseLong(phone);
                        } catch (NumberFormatException e1) {
                            ph = true;
                        }
                    }
                    if (email.isEmpty() == false) {
                        if (email.endsWith("@gmail.com")) {
                        } else if (email.endsWith("@yahoo.com")) {
                        } else if (email.endsWith("@hotmail.com")) {
                        } else {
                            em = true;
                        }
                    }
                    if (dod.equals("Select Day") == false && dom.equals("Select Month") == false
                            && doy.equals("Select Year") == false) {
                        int da = Integer.parseInt(dod);
                        int mo = Integer.parseInt(dom);
                        int ye = Integer.parseInt(doy);
                        int da1 = 31;

                        if (mo == 1 || mo == 3 || mo == 5 || mo == 7 || mo == 8 || mo == 10 || mo == 12) {
                            da1 = 31;
                        } else if (mo == 4 || mo == 6 || mo == 9 || mo == 11) {
                            da1 = 30;
                        } else {
                            if ((ye % 400 == 0) || ((ye % 4 == 0) && (ye % 100 != 0))) {
                                da1 = 29;
                            } else {
                                da1 = 28;
                            }
                        }
                        if (da <= da1) {
                            leapyear = false;
                        } else {
                            leapyear = true;
                        }
                    }
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Name", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (name.length() < 4 || name.length() > 30) {
                        JOptionPane.showMessageDialog(null, "Sorry, name must be between 4 and 30 characters long.",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (dod.equals("Select Day")) {
                        JOptionPane.showMessageDialog(null, "Select Day", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (dom.equals("Select Month")) {
                        JOptionPane.showMessageDialog(null, "Select Month", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (doy.equals("Select Year")) {
                        JOptionPane.showMessageDialog(null, "Select Year", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (leapyear) {
                        JOptionPane.showMessageDialog(null, "Select Valid Date of birth", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (fname1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Father name", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (fname1.length() < 4 || name.length() > 30) {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, Father name must be between 4 and 30 characters long.", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the E-mail ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (email.startsWith("@gmail.com") || email.startsWith("@yahoo.com")
                            || email.startsWith("@hotmail.com") || email.startsWith("@")) {
                        JOptionPane.showMessageDialog(null, "Email ID not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (em) {
                        JOptionPane.showMessageDialog(null,
                                "Email ID end with @gmail.com or @yahoo.com or @hotmail.com", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Phone Number", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (ph) {
                        JOptionPane.showMessageDialog(null, "Phone number must be numbers only", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.startsWith("0") || phone.startsWith("1") || phone.startsWith("2")
                            || phone.startsWith("3") || phone.startsWith("4") || phone.startsWith("5")) {
                        JOptionPane.showMessageDialog(null, "phone Number not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.length() <= 9 || phone.length() > 10) {
                        JOptionPane.showMessageDialog(null, "phone number must be 10 digits", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (course1.equals("Select the Course")) {
                        JOptionPane.showMessageDialog(null, "Select the Course", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (branch1.equals("Select the Branch")) {
                        JOptionPane.showMessageDialog(null, "Select the Branch", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (year1.equals("Select the Year")) {
                        JOptionPane.showMessageDialog(null, "Select the Year", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (semester1.equals("Select the Semester")) {
                        JOptionPane.showMessageDialog(null, "Select the Semester", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String dateob = dod + "/" + dom + "/" + doy;

                            String q = "UPDATE student SET name=?,dob=?,father_name=?,email_id=?,phone_no=?,course=?,branch=?,year=?,semester=? WHERE roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, name);
                            ps.setString(2, dateob);
                            ps.setString(3, fname1);
                            ps.setString(4, email);
                            ps.setString(5, phone);
                            ps.setString(6, course1);
                            ps.setString(7, branch1);
                            ps.setString(8, year1);
                            ps.setString(9, semester1);
                            ps.setString(10, roll);
                            ps.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Student details Update Successful", "Information",
                                    JOptionPane.INFORMATION_MESSAGE);

                            sroll2.setEditable(true);
                            sroll2.setText("");
                            sname2.setText("");
                            sdod2.setSelectedIndex(0);
                            sdom2.setSelectedIndex(0);
                            sdoy2.setSelectedIndex(0);
                            fname2.setText("");
                            semail2.setText("");
                            sphone2.setText("");
                            course2.setSelectedIndex(0);
                            branch2.setSelectedIndex(0);
                            year2.setSelectedIndex(0);
                            semester2.setSelectedIndex(0);
                            set_Hide(false);
                            sroll2.requestFocus();
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == searchb) {
                    String roll = searcht.getText().trim();
                    if (roll.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Roll No", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {

                        if (model2.getRowCount() != 0) {
                            model2.removeRow(0);
                        }
                        try {
                            String q = "SELECT roll_no,name,gender,dob,father_name,email_id,phone_no,course,branch,year,semester,total_issue_book,total_return_book FROM student WHERE roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, roll);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String[] row = new String[13];
                                row[0] = rs.getString(1);
                                row[1] = rs.getString(2);
                                row[2] = rs.getString(3);
                                row[3] = rs.getString(4);
                                row[4] = rs.getString(5);
                                row[5] = rs.getString(6);
                                row[6] = rs.getString(7);
                                row[7] = rs.getString(8);
                                row[8] = rs.getString(9);
                                row[9] = rs.getString(10);
                                row[10] = rs.getString(11);
                                row[11] = rs.getString(12);
                                row[12] = rs.getString(13);
                                model2.addRow(row);
                            } else {
                                JOptionPane.showMessageDialog(null, "This Roll Number Student is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == deleteb) {
                    String roll = searcht.getText().trim();
                    if (roll.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username then Search", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        // if (model2.getRowCount() != 0) {
                        // model2.removeRow(0);
                        // }
                        try {
                            String q = "SELECT roll_no,total_issue_book FROM student WHERE roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, roll);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                int std_total_issue_book = Integer.parseInt(rs.getString(2));
                                if (std_total_issue_book == 0) {
                                    q = "DELETE FROM student WHERE roll_no=?";
                                    PreparedStatement ps1 = con.prepareStatement(q);
                                    ps1.setString(1, roll);
                                    ps1.executeUpdate();

                                    searcht.setText("");
                                    if (model2.getRowCount() != 0) {
                                        model2.removeRow(0);
                                    }
                                    JOptionPane.showMessageDialog(null, "Student Deleted Successful", "Information",
                                            JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Some Books of this student hava issued so, this student record cannot be deleted",
                                            "WARNING", JOptionPane.WARNING_MESSAGE);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "This Roll Number Student is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == logout) {
                logout.setBackground(Color.ORANGE);
                logout.setForeground(new Color(34, 47, 62));
            } else if (e.getSource() == exit) {
                exit.setBackground(Color.ORANGE);
                exit.setForeground(new Color(34, 47, 62));
            } else if (e.getSource() == back) {
                back.setBackground(Color.ORANGE);
                back.setForeground(new Color(34, 47, 62));
            } else if (e.getSource() == crst) {
                crst.setBackground(new Color(30, 39, 46));
                r1.setBackground(Color.YELLOW);
                crst.setForeground(Color.WHITE);
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.WHITE);
            } else if (e.getSource() == deleteb) {
                deleteb.setBackground(Color.WHITE);
            } else if (e.getSource() == searchb2) {
                searchb2.setBackground(Color.WHITE);
            } else if (e.getSource() == update) {
                update.setBackground(Color.WHITE);
            } else if (e.getSource() == clear) {
                clear.setBackground(Color.WHITE);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == logout) {
                logout.setBackground(new Color(34, 47, 62));
                logout.setForeground(Color.WHITE);
            } else if (e.getSource() == exit) {
                exit.setBackground(new Color(34, 47, 62));
                exit.setForeground(Color.WHITE);
            } else if (e.getSource() == back) {
                back.setBackground(new Color(34, 47, 62));
                back.setForeground(Color.WHITE);
            } else if (e.getSource() == crst) {
                crst.setBackground(Color.YELLOW);
                r1.setBackground(new Color(30, 39, 46));
                crst.setForeground(Color.BLACK);
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.YELLOW);
            } else if (e.getSource() == deleteb) {
                deleteb.setBackground(Color.YELLOW);
            } else if (e.getSource() == searchb2) {
                searchb2.setBackground(Color.YELLOW);
            } else if (e.getSource() == update) {
                update.setBackground(Color.YELLOW);
            } else if (e.getSource() == clear) {
                clear.setBackground(Color.YELLOW);
            }
        }
    }
}
