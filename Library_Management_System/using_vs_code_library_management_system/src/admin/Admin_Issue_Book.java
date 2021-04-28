package admin;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class Admin_Issue_Book extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p;
    public JPanel borderp, p1, p2, p3, p4, q1, q2, dob;
    public JLabel htext;
    public JLabel[] cl;
    public JTextField book_id, student_roll_no, issue_date;
    public JComboBox<String> rbdod, rbdom, rbdoy;
    JButton logout, exit, back, issueb;
    JScrollPane ms;
    Connection con = null;
    String user = "";
    String name = "";
    String currentDay, currentMonth, currentYear;

    public Admin_Issue_Book(String s, Connection con, String name, String user) {
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
        create_ActionListener();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Calendar cal = new GregorianCalendar();
                        currentDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                        currentMonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
                        currentYear = String.valueOf(cal.get(Calendar.YEAR));

                        String d1 = "", m1 = "";
                        if (Integer.parseInt(currentDay) < 10) {
                            d1 = "0" + currentDay;
                        } else {
                            d1 = currentDay;
                        }
                        if (Integer.parseInt(currentMonth) < 10) {
                            m1 = "0" + currentMonth;
                        } else {
                            m1 = currentMonth;
                        }
                        issue_date.setText(d1 + "/" + m1 + "/" + currentYear);

                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR);
                    }
                }
            }
        });
        t1.start();
    }

    // create_component
    public void create_component() {
        borderp = new JPanel();
        ms = new JScrollPane(borderp);
        p = new JPanel[7];

        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }
        p[0].setPreferredSize(new Dimension(10, 66));
        p[1].setPreferredSize(new Dimension(10, 0));
        p[2].setPreferredSize(new Dimension(0, 10));
        p[3].setPreferredSize(new Dimension(0, 0));
        p[5].setPreferredSize(new Dimension(10, 60));

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        p3.setPreferredSize(new Dimension(155, 10));
        p4.setPreferredSize(new Dimension(130, 10));

        back = new JButton("Back", new ImageIcon(getClass().getResource("/photo/back1.png")));
        htext = new JLabel("Issue Book", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel();
        q2 = new JPanel();

        q2.setPreferredSize(new Dimension(10, 70));

        dob = new JPanel();

        cl = new JLabel[4];
        cl[0] = new JLabel("Book ID", JLabel.CENTER);
        cl[1] = new JLabel("Student Roll Number", JLabel.CENTER);
        cl[2] = new JLabel("Issue Book Date", JLabel.CENTER);
        cl[3] = new JLabel("Return Book Date", JLabel.CENTER);

        book_id = new JTextField();
        student_roll_no = new JTextField();

        issue_date = new JTextField();

        rbdod = new JComboBox<>(new String[] { "Select Day" });
        rbdom = new JComboBox<>(new String[] { "Select Month" });
        rbdoy = new JComboBox<>(new String[] { "Select Year" });

        issueb = new JButton("Issue Book");
        issueb.setPreferredSize(new Dimension(160, 70));

        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                rbdod.addItem("0" + String.valueOf(i));
            } else {
                rbdod.addItem(String.valueOf(i));
            }
        }
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                rbdom.addItem("0" + String.valueOf(i));
            } else {
                rbdom.addItem(String.valueOf(i));
            }
        }

        Calendar cal;
        cal = new GregorianCalendar();

        int cday = cal.get(Calendar.DAY_OF_MONTH);
        int cmonth = cal.get(Calendar.MONTH) + 1;
        int cyear = cal.get(Calendar.YEAR);

        for (int i = cyear; i <= cyear + 1; i++) {
            rbdoy.addItem(String.valueOf(i));
        }
        if (cday < 10) {
            rbdod.setSelectedItem("0" + cday);
        } else {
            rbdod.setSelectedItem(cday + "");
        }

        if (cmonth < 10) {
            rbdom.setSelectedItem("0" + cmonth);
        } else {
            rbdom.setSelectedItem(cmonth + "");
        }
        rbdoy.setSelectedItem(cyear + "");

        issue_date.setEditable(false);
    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new BorderLayout(0, 45));

        p1.setLayout(new BorderLayout(0, 0));
        p2.setLayout(new GridLayout(1, 1));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q1.setLayout(new GridLayout(4, 2, 20, 45));
        q2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
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

        p1.add(p2, BorderLayout.WEST);
        p1.add(p3, BorderLayout.EAST);
        p1.add(p4, BorderLayout.CENTER);
        p2.add(back);
        p3.add(logout);
        p4.add(exit);

        p[4].add(p[5], BorderLayout.NORTH);
        p[4].add(p[6], BorderLayout.CENTER);

        p[5].add(htext);

        p[6].add(q1, BorderLayout.CENTER);
        p[6].add(q2, BorderLayout.SOUTH);

        q1.add(cl[0]);
        q1.add(book_id);
        q1.add(cl[1]);
        q1.add(student_roll_no);
        q1.add(cl[2]);
        q1.add(issue_date);
        q1.add(cl[3]);
        q1.add(dob);
        q2.add(issueb);

        dob.add(rbdod);
        dob.add(rbdom);
        dob.add(rbdoy);
    }

    // set_Border
    public void set_Border() {
        borderp.setBorder(BorderFactory.createLineBorder(new Color(19, 15, 64), 10));
        p[4].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        p[0].setBorder(BorderFactory.createLineBorder(new Color(162, 155, 254), 4));
        Color co1 = new Color(211, 84, 0);
        p2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, co1));
        p3.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, co1));
        p4.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, co1));
        Color color = new Color(41, 128, 185);
        p[6].setBorder(BorderFactory.createMatteBorder(60, 200, 60, 200, color));
        book_id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        student_roll_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        issue_date.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
    }

    // set_color
    public void set_color() {
        getContentPane().setBackground(new Color(19, 15, 64));

        Color color = new Color(41, 128, 185);
        p[0].setBackground(new Color(19, 15, 64));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(new Color(45, 52, 54));
        p[6].setBackground(color);

        htext.setForeground(Color.WHITE);
        Color co1 = new Color(211, 84, 0);
        p1.setBackground(Color.BLACK);
        p2.setBackground(co1);
        p4.setBackground(co1);
        logout.setBackground(new Color(34, 47, 62));
        exit.setBackground(new Color(34, 47, 62));
        back.setBackground(new Color(34, 47, 62));
        logout.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        q1.setBackground(color);
        q2.setBackground(color);
        dob.setBackground(color);

        Color color1 = new Color(19, 15, 64);
        book_id.setBackground(color1);
        student_roll_no.setBackground(color1);
        issue_date.setBackground(color1);
        issue_date.setOpaque(true);
        rbdod.setBackground(color1);
        rbdom.setBackground(color1);
        rbdoy.setBackground(color1);

        Color wh = Color.WHITE;
        book_id.setForeground(wh);
        student_roll_no.setForeground(wh);
        issue_date.setForeground(wh);
        rbdod.setForeground(wh);
        rbdom.setForeground(wh);
        rbdoy.setForeground(wh);

        book_id.setCaretColor(wh);
        student_roll_no.setCaretColor(wh);
        issue_date.setCaretColor(wh);

        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }
        issueb.setBackground(Color.YELLOW);
        issueb.setForeground(new Color(19, 15, 64));

        book_id.requestFocus();
    }

    // set_font_and_Cursor
    public void set_font_and_Cursor() {
        Font af = new Font("Tahoma", Font.BOLD, 16);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        htext.setFont(af);
        logout.setFont(af);
        exit.setFont(af);
        back.setFont(af);

        logout.setCursor(cursor);
        exit.setCursor(cursor);
        back.setCursor(cursor);
        issueb.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        issueb.setFocusable(false);

        book_id.setHorizontalAlignment(JTextField.CENTER);
        student_roll_no.setHorizontalAlignment(JTextField.CENTER);
        issue_date.setHorizontalAlignment(JTextField.CENTER);

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        rbdod.setRenderer(listRenderer);
        rbdom.setRenderer(listRenderer);
        rbdoy.setRenderer(listRenderer);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        issueb.setFont(font);

        Font font1 = new Font("Tahoma", Font.BOLD, 20);
        for (int i = 0; i < cl.length; i++) {
            cl[i].setFont(font1);
        }
        book_id.setFont(font1);
        student_roll_no.setFont(font1);
        issue_date.setFont(font1);
        Font font2 = new Font("Tahoma", Font.BOLD, 16);
        rbdod.setFont(font2);
        rbdom.setFont(font2);
        rbdoy.setFont(font2);
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
        issueb.addActionListener(new Add_Action());
        issueb.addMouseListener(new Add_Action());
    }

    public int check_day(int m, int y) {
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            return 31;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        } else {
            if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) {
                return 29;
            } else {
                return 28;
            }
        }
    }

    class Add_Action implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (con != null && EstablishConection.getEstblishConnection() != null) {
                if (e.getSource() == logout) {
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
                } else if (e.getSource() == issueb) {
                    String bid = book_id.getText().trim();
                    String sroll_no = student_roll_no.getText().trim();
                    String issuedate = issue_date.getText().trim();
                    String dod = String.valueOf(rbdod.getSelectedItem()).trim();
                    String dom = String.valueOf(rbdom.getSelectedItem()).trim();
                    String doy = String.valueOf(rbdoy.getSelectedItem()).trim();
                    String no_avaible_book = "", no_issue_book = "", std_total_issue_book = "";
                    boolean leapyear = false, invalid = false, bookidvalid = false, studentrollvalid = false;

                    if (dod.equals("Select Day") == false && dom.equals("Select Month") == false
                            && doy.equals("Select Year") == false) {
                        // return date
                        int da = Integer.parseInt(dod);
                        int mo = Integer.parseInt(dom);
                        int ye = Integer.parseInt(doy);

                        int da1 = check_day(mo, ye);

                        // current date(issue date)
                        int da2 = Integer.parseInt(currentDay);
                        int mo2 = Integer.parseInt(currentMonth);
                        int ye2 = Integer.parseInt(currentYear);
                        int d3, m3, y3;

                        if (da <= da1) { // check Return date of the book will be more than or equal to Issue date of
                                         // the Book
                            if (da < da2) {
                                mo = mo - 1;
                                da += check_day(mo, ye);
                            }
                            if (mo < mo2) {
                                mo = mo + 12;
                                ye = ye - 1;
                            }
                            d3 = da - da2;
                            m3 = mo - mo2;
                            y3 = ye - ye2;
                            if (y3 >= 0 && m3 >= 0 && d3 >= 0) {
                                invalid = false;
                            } else {
                                invalid = true;
                            }
                        } else {
                            leapyear = true;
                        }
                    }
                    if (bid.isEmpty() == false) {
                        try {
                            String q = "SELECT avaible_book,no_of_issue_book FROM book WHERE book_id=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                no_avaible_book = rs.getString(1);
                                no_issue_book = rs.getString(2);
                            } else {
                                bookidvalid = true;
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                        }
                    }
                    if (sroll_no.isEmpty() == false) {
                        try {
                            String q = "SELECT total_issue_book FROM student WHERE roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, sroll_no);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                std_total_issue_book = rs.getString(1);
                            } else {
                                studentrollvalid = true;
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                        }
                    }
                    if (bid.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (sroll_no.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Student Roll Number", "WARNING",
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
                    } else if (invalid) {
                        JOptionPane.showMessageDialog(null,
                                "Return date of the book will be more than or equal to Issue date of the Book",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (bookidvalid) {
                        JOptionPane.showMessageDialog(null, "That Book id is not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (studentrollvalid) {
                        JOptionPane.showMessageDialog(null, "That Student Roll Number is not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(no_avaible_book) <= 0) {
                        JOptionPane.showMessageDialog(null, "That Book is not avaible", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(std_total_issue_book) >= 6) {
                        JOptionPane.showMessageDialog(null, "Maximum books have been issued by this student", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT issue_book_date FROM issue_book WHERE book_id=? && student_roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid);
                            ps.setString(2, sroll_no);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                JOptionPane.showMessageDialog(null, "this book has been alredy issued for this Student",
                                        "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else {
                                // get book details
                                q = "SELECT book_name,book_author,book_edition,book_publication FROM book WHERE book_id=?";
                                ps = con.prepareStatement(q);
                                ps.setString(1, bid);
                                rs = ps.executeQuery();
                                String bname1 = "", bauthorn1 = "", bedition1 = "", bpubn1 = "", sname = "",
                                        course1 = "", branch1 = "", year1 = "", semester1 = "";
                                if (rs.next()) {
                                    bname1 = rs.getString(1);
                                    bauthorn1 = rs.getString(2);
                                    bedition1 = rs.getString(3);
                                    bpubn1 = rs.getString(4);
                                }
                                // get Student details
                                q = "SELECT name,course,branch,year,semester FROM student WHERE roll_no=?";
                                ps = con.prepareStatement(q);
                                ps.setString(1, sroll_no);
                                rs = ps.executeQuery();
                                if (rs.next()) {
                                    sname = rs.getString(1);
                                    course1 = rs.getString(2);
                                    branch1 = rs.getString(3);
                                    year1 = rs.getString(4);
                                    semester1 = rs.getString(5);
                                }

                                String return_date = dod + "/" + dom + "/" + doy;

                                // insert issue_book information from issue_book table in database
                                q = "INSERT INTO issue_book(book_id,book_name,book_author,book_edition,book_publication,student_roll_no,std_name,course,branch,year,semester,issue_book_date,return_book_date,username_of_admin_issue_book,username_of_librarian_issue_book) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                ps = con.prepareStatement(q);
                                ps.setString(1, bid);
                                ps.setString(2, bname1);
                                ps.setString(3, bauthorn1);
                                ps.setString(4, bedition1);
                                ps.setString(5, bpubn1);
                                ps.setString(6, sroll_no);
                                ps.setString(7, sname);
                                ps.setString(8, course1);
                                ps.setString(9, branch1);
                                ps.setString(10, year1);
                                ps.setString(11, semester1);
                                ps.setString(12, issuedate);
                                ps.setString(13, return_date);
                                ps.setString(14, user);
                                ps.setString(15, "null");
                                ps.executeUpdate();

                                // update avaible_book,no_of_issue_book information from book table in database
                                no_avaible_book = String.valueOf((Integer.parseInt(no_avaible_book) - 1));
                                no_issue_book = String.valueOf((Integer.parseInt(no_issue_book) + 1));
                                q = "UPDATE book SET avaible_book=?,no_of_issue_book=? WHERE book_id=?";
                                ps = con.prepareStatement(q);
                                ps.setString(1, no_avaible_book);
                                ps.setString(2, no_issue_book);
                                ps.setString(3, bid);
                                ps.executeUpdate();

                                // update total_issue_book information from student table in database
                                std_total_issue_book = String.valueOf((Integer.parseInt(std_total_issue_book) + 1));
                                q = "UPDATE student SET total_issue_book=? WHERE roll_no=?";
                                ps = con.prepareStatement(q);
                                ps.setString(1, std_total_issue_book);
                                ps.setString(2, sroll_no);
                                ps.executeUpdate();

                                JOptionPane.showMessageDialog(null, "this Book issue Successful for this student",
                                        "Information", JOptionPane.INFORMATION_MESSAGE);

                                // clear
                                book_id.setText("");
                                student_roll_no.setText("");
                                Calendar cal;
                                cal = new GregorianCalendar();

                                int cday = cal.get(Calendar.DAY_OF_MONTH);
                                int cmonth = cal.get(Calendar.MONTH) + 1;
                                int cyear = cal.get(Calendar.YEAR);

                                for (int i = cyear; i <= cyear + 1; i++) {
                                    rbdoy.addItem(String.valueOf(i));
                                }
                                if (cday < 10) {
                                    rbdod.setSelectedItem("0" + cday);
                                } else {
                                    rbdod.setSelectedItem(cday + "");
                                }

                                if (cmonth < 10) {
                                    rbdom.setSelectedItem("0" + cmonth);
                                } else {
                                    rbdom.setSelectedItem(cmonth + "");
                                }
                                rbdoy.setSelectedItem(cyear + "");
                                book_id.requestFocus();

                            }
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            e1.printStackTrace();
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
            } else if (e.getSource() == issueb) {
                issueb.setBackground(Color.WHITE);
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
            } else if (e.getSource() == issueb) {
                issueb.setBackground(Color.YELLOW);
            }
        }
    }
}
