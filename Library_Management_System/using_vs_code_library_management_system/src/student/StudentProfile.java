package student;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class StudentProfile extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, pp;
    public JButton[] bp;
    public JPanel borderp, p1, p2, p3, p4, p5, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, dob;
    public JLabel weltext, cl[], cl1[];
    public JTextField[] te, te1;
    public JPasswordField pass1;
    JButton logout, exit, back, update;
    public JComboBox<String> sdod, sdom, sdoy;
    JScrollPane ms;
    Connection con = null;
    String user = "";
    String name = "";

    public StudentProfile(String s, Connection con, String name, String user) {
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
        get_Student_Details();
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

        bp = new JButton[2];
        bp[0] = new JButton("Profile Details");
        bp[1] = new JButton("Update Profile");

        pp = new JPanel[2];
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
        weltext = new JLabel(name + " Profile Details & Update Profile", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel();
        q2 = new JPanel();
        q3 = new JPanel();
        q4 = new JPanel();
        q5 = new JPanel();
        q6 = new JPanel();
        q7 = new JPanel();
        q8 = new JPanel();
        q9 = new JPanel();
        q10 = new JPanel();
        q11 = new JPanel();
        q12 = new JPanel();
        q13 = new JPanel();
        q14 = new JPanel();
        dob = new JPanel();

        q3.setPreferredSize(new Dimension(200, 10));
        q5.setPreferredSize(new Dimension(200, 10));
        q9.setPreferredSize(new Dimension(200, 10));
        q7.setPreferredSize(new Dimension(10, 50));
        q11.setPreferredSize(new Dimension(200, 10));
        q13.setPreferredSize(new Dimension(200, 10));

        cl = new JLabel[11];
        cl[0] = new JLabel("Roll Number", JLabel.CENTER);
        cl[1] = new JLabel("Name", JLabel.CENTER);
        cl[2] = new JLabel("Gender", JLabel.CENTER);
        cl[3] = new JLabel("Date of birth", JLabel.CENTER);
        cl[4] = new JLabel("Father Name", JLabel.CENTER);
        cl[5] = new JLabel("E-mail ID", JLabel.CENTER);
        cl[6] = new JLabel("Phone Number", JLabel.CENTER);
        cl[7] = new JLabel("Course", JLabel.CENTER);
        cl[8] = new JLabel("Branch", JLabel.CENTER);
        cl[9] = new JLabel("Year", JLabel.CENTER);
        cl[10] = new JLabel("Semester", JLabel.CENTER);

        te = new JTextField[11];
        for (int i = 0; i < te.length; i++) {
            te[i] = new JTextField();
        }

        cl1 = new JLabel[9];
        cl1[0] = new JLabel("Roll Number", JLabel.CENTER);
        cl1[1] = new JLabel("Name", JLabel.CENTER);
        cl1[2] = new JLabel("Password", JLabel.CENTER);
        cl1[3] = new JLabel("Date of birth", JLabel.CENTER);
        cl1[4] = new JLabel("Father Name", JLabel.CENTER);
        cl1[5] = new JLabel("E-mail ID", JLabel.CENTER);
        cl1[6] = new JLabel("Phone Number", JLabel.CENTER);
        cl1[7] = new JLabel("Security Question", JLabel.CENTER);
        cl1[8] = new JLabel("Answer", JLabel.CENTER);
        te1 = new JTextField[7];
        for (int i = 0; i < te1.length; i++) {
            te1[i] = new JTextField();
        }
        pass1 = new JPasswordField();
        pass1.setEchoChar('*');
        update = new JButton("Update Profile");
        update.setPreferredSize(new Dimension(200, 50));
        te1[0].setEditable(false);
        te1[1].setEditable(false);
        te1[5].setEditable(false);

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

        pp[0].setLayout(new GridLayout(1, 2, 40, 20));
        pp[1].setLayout(new BorderLayout(0, 20));

        q1.setLayout(new BorderLayout(20, 0));
        q2.setLayout(new BorderLayout(20, 0));
        q3.setLayout(new GridLayout(6, 1, 0, 20));
        q4.setLayout(new GridLayout(6, 1, 0, 20));
        q5.setLayout(new GridLayout(5, 1, 0, 40));
        q6.setLayout(new GridLayout(5, 1, 0, 40));
        q7.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q8.setLayout(new GridLayout(1, 2, 40, 0));
        q9.setLayout(new BorderLayout(20, 0));
        q10.setLayout(new BorderLayout(20, 0));
        q11.setLayout(new GridLayout(5, 1, 0, 30));
        q12.setLayout(new GridLayout(5, 1, 0, 30));
        q13.setLayout(new GridLayout(4, 1, 0, 50));
        q14.setLayout(new GridLayout(4, 1, 0, 50));
        dob.setLayout(new GridLayout(1, 3, 10, 0));
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

        pp[0].add(q1);
        pp[0].add(q2);

        q1.add(q3, BorderLayout.WEST);
        q1.add(q4, BorderLayout.CENTER);

        q2.add(q5, BorderLayout.WEST);
        q2.add(q6, BorderLayout.CENTER);

        for (int i = 0; i < 6; i++) {
            q3.add(cl[i]);
            q4.add(te[i]);
        }
        for (int i = 6; i < 11; i++) {
            q5.add(cl[i]);
            q6.add(te[i]);
        }

        pp[1].add(q7, BorderLayout.SOUTH);
        pp[1].add(q8, BorderLayout.CENTER);

        q7.add(update);

        q8.add(q9);
        q8.add(q10);

        q9.add(q11, BorderLayout.WEST);
        q9.add(q12, BorderLayout.CENTER);

        q10.add(q13, BorderLayout.WEST);
        q10.add(q14, BorderLayout.CENTER);

        for (int i = 0; i < 5; i++) {
            q11.add(cl1[i]);
        }
        q12.add(te1[0]);
        q12.add(te1[1]);
        q12.add(pass1);
        q12.add(dob);
        q12.add(te1[2]);
        for (int i = 5; i < cl1.length; i++) {
            q13.add(cl1[i]);
        }
        q14.add(te1[3]);
        q14.add(te1[4]);
        q14.add(te1[5]);
        q14.add(te1[6]);

        dob.add(sdod);
        dob.add(sdom);
        dob.add(sdoy);

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
        pp[0].setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, color));
        pp[1].setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, color));

        for (int i = 2; i < te1.length; i++) {
            te1[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        }
        pass1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
    }

    // set_color
    public void set_color() {
        getContentPane().setBackground(new Color(19, 15, 64));
        Color color = new Color(41, 128, 185);
        p[0].setBackground(new Color(19, 15, 64));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(Color.WHITE);
        p[6].setBackground(color);

        bp[0].setBackground(new Color(142, 68, 173));
        for (int i = 1; i < bp.length; i++) {
            bp[i].setBackground(new Color(48, 51, 107));
        }

        for (int i = 0; i < bp.length; i++) {
            bp[i].setForeground(Color.WHITE);
            pp[i].setBackground(new Color(41, 128, 185));
        }
        // pp[0].setBackground(Color.RED);
        // pp[1].setBackground(Color.BLACK);

        q1.setBackground(color);
        q2.setBackground(color);
        q3.setBackground(color);
        q4.setBackground(color);
        q5.setBackground(color);
        q6.setBackground(color);
        q7.setBackground(color);
        q8.setBackground(color);
        q9.setBackground(color);
        q10.setBackground(color);
        q11.setBackground(color);
        q12.setBackground(color);
        q13.setBackground(color);
        q14.setBackground(color);
        dob.setBackground(color);

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

        Color color1 = new Color(19, 15, 64);
        Color wt = Color.WHITE;
        for (int i = 0; i < te.length; i++) {
            te[i].setBackground(color1);
            te[i].setForeground(wt);
            te[i].setHorizontalAlignment(JTextField.CENTER);
            te[i].setEditable(false);
        }
        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }
        pass1.setBackground(color1);
        sdod.setBackground(color1);
        sdom.setBackground(color1);
        sdoy.setBackground(color1);
        sdod.setForeground(wt);
        pass1.setForeground(wt);
        sdom.setForeground(wt);
        sdoy.setForeground(wt);
        pass1.setHorizontalAlignment(JPasswordField.CENTER);
        pass1.setCaretColor(wt);

        for (int i = 0; i < te1.length; i++) {
            te1[i].setBackground(color1);
            te1[i].setForeground(wt);
            te1[i].setHorizontalAlignment(JTextField.CENTER);
            te1[i].setCaretColor(wt);
        }
        for (int i = 0; i < cl1.length; i++) {
            cl1[i].setOpaque(true);
            cl1[i].setBackground(Color.YELLOW);
            cl1[i].setForeground(Color.BLACK);
        }
        update.setBackground(Color.YELLOW);
        update.setForeground(new Color(19, 15, 64));
    }

    public void get_Student_Details() {
        if (con != null && EstablishConection.getEstblishConnection() != null) {
            try {
                String q = "SELECT name,gender,dob,father_name,email_id,phone_no,course,branch,year,semester FROM student WHERE roll_no=?";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    te[0].setText(user);
                    te[1].setText(rs.getString(1));
                    te[2].setText(rs.getString(2));
                    te[3].setText(rs.getString(3));
                    te[4].setText(rs.getString(4));
                    te[5].setText(rs.getString(5));
                    te[6].setText(rs.getString(6));
                    te[7].setText(rs.getString(7));
                    te[8].setText(rs.getString(8));
                    te[9].setText(rs.getString(9));
                    te[10].setText(rs.getString(10));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
                get_Student_Details();
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
                if (con != null && EstablishConection.getEstblishConnection() != null) {
                    try {
                        String q = "SELECT name,password,dob,father_name,email_id,phone_no,security_question FROM student WHERE roll_no=?";
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, user);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            te1[0].setText(user);
                            te1[1].setText(rs.getString(1));
                            pass1.setText(rs.getString(2));
                            String dobs = rs.getString(3);
                            te1[2].setText(rs.getString(4));
                            te1[3].setText(rs.getString(5));
                            te1[4].setText(rs.getString(6));
                            te1[5].setText(rs.getString(7));
                            String[] doba = dobs.split("/");
                            sdod.setSelectedItem(doba[0]);
                            sdom.setSelectedItem(doba[1]);
                            sdoy.setSelectedItem(doba[2]);
                        }
                        pass1.requestFocus();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
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
        update.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        update.setFocusable(false);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        for (int i = 0; i < cl.length; i++) {
            cl[i].setFont(font);
        }
        for (int i = 0; i < te.length; i++) {
            te[i].setFont(font);
        }
        for (int i = 0; i < cl1.length; i++) {
            cl1[i].setFont(font);
        }
        for (int i = 0; i < te1.length; i++) {
            te1[i].setFont(font);
        }
        pass1.setFont(font);
        update.setFont(font);

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        sdod.setRenderer(listRenderer);
        sdom.setRenderer(listRenderer);
        sdoy.setRenderer(listRenderer);

        Font font3 = new Font("Tahoma", Font.BOLD, 14);
        sdod.setFont(font3);
        sdom.setFont(font3);
        sdoy.setFont(font3);
    }

    public void create_ActionListener() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con != null && EstablishConection.getEstblishConnection() != null) {
                    try {
                        Student_logout_Info.save_Logout_Info(con, name, user);
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
        update.addActionListener(new Add_Action());
        update.addMouseListener(new Add_Action());
    }

    class Add_Action implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (con != null && EstablishConection.getEstblishConnection() != null) {
                if (e.getSource() == logout) {
                    try {
                        Student_logout_Info.save_Logout_Info(con, name, user);
                        con.close();
                        dispose();
                        new Main("Library Management System").setVisible(true);
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                    }
                } else if (e.getSource() == back) {
                    dispose();
                    new StudentControl("Student Control", con, name, user).setVisible(true);
                } else if (e.getSource() == update) {
                    String dod = String.valueOf(sdod.getSelectedItem()).trim();
                    String dom = String.valueOf(sdom.getSelectedItem()).trim();
                    String doy = String.valueOf(sdoy.getSelectedItem()).trim();
                    String pass = String.valueOf(pass1.getPassword()).trim();
                    String fname1 = te1[2].getText().trim();
                    String email = te1[3].getText().trim();
                    String phone = te1[4].getText().trim();
                    String securityq = String.valueOf(te1[5].getText()).trim();
                    String sans = te1[6].getText().trim();
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
                    if (pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Password", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (pass.length() < 6 || phone.length() > 15) {
                        JOptionPane.showMessageDialog(null,
                                " Sorry, Password must be between 6 and 15 characters long.", "WARNING",
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
                    } else if (sans.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Security Answer", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT name FROM student WHERE roll_no=? && security_question=? && answer=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user);
                            ps.setString(2, securityq);
                            ps.setString(3, sans);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String dateob = dod + "/" + dom + "/" + doy;

                                q = "UPDATE student SET password=?,dob=?,father_name=?,email_id=?,phone_no=? WHERE roll_no=?";
                                ps = con.prepareStatement(q);
                                ps.setString(1, pass);
                                ps.setString(2, dateob);
                                ps.setString(3, fname1);
                                ps.setString(4, email);
                                ps.setString(5, phone);
                                ps.setString(6, user);
                                ps.executeUpdate();

                                JOptionPane.showMessageDialog(null, te1[1].getText() + " Profile Update Successful",
                                        "Information", JOptionPane.INFORMATION_MESSAGE);
                                te1[6].setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Security answer doesn't match", "Error",
                                        JOptionPane.ERROR_MESSAGE);
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
            } else if (e.getSource() == update) {
                update.setBackground(Color.WHITE);
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
            } else if (e.getSource() == update) {
                update.setBackground(Color.YELLOW);
            }
        }
    }
}