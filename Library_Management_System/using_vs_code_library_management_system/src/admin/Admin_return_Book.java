package admin;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Admin_return_Book extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, v;
    public JPanel borderp, p1, p2, p3, p4, q1, q2, q3, q4;
    public JLabel htext;
    public JLabel[] cl;
    public JTextField book_id, student_roll_no, issue_date, return_date;
    JButton logout, exit, back, returnb, search, clear;
    Connection con = null;
    JScrollPane ms;
    String user = "";
    String name = "";
    String currentDay, currentMonth, currentYear;

    public Admin_return_Book(String s, Connection con, String name, String user) {
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
        htext = new JLabel("Return Book", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel();
        q2 = new JPanel();
        q3 = new JPanel();
        q4 = new JPanel();

        q2.setPreferredSize(new Dimension(10, 70));

        v = new JPanel[5];
        for (int i = 0; i < v.length; i++) {
            v[i] = new JPanel();
        }

        cl = new JLabel[4];
        cl[0] = new JLabel("Book ID", JLabel.CENTER);
        cl[1] = new JLabel("Student Roll Number", JLabel.CENTER);
        cl[2] = new JLabel("Issue Book Date", JLabel.CENTER);
        cl[3] = new JLabel("Return Book Date", JLabel.CENTER);

        book_id = new JTextField();
        student_roll_no = new JTextField();

        issue_date = new JTextField();
        return_date = new JTextField();

        returnb = new JButton("Return Book");
        returnb.setPreferredSize(new Dimension(180, 70));

        search = new JButton("Search");
        clear = new JButton("Clear");
    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new BorderLayout(0, 30));

        p1.setLayout(new BorderLayout(0, 0));
        p2.setLayout(new GridLayout(1, 1));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q1.setLayout(new GridLayout(5, 2, 20, 30));
        q2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        for (int i = 0; i < v.length; i++) {
            if (i != 2) {
                v[i].setLayout(new GridLayout(1, 2, 20, 0));
            } else {
                v[i].setLayout(new GridLayout(1, 4, 20, 0));
            }
        }
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

        q2.add(returnb);

        for (int i = 0; i < v.length; i++) {
            q1.add(v[i]);
        }
        v[0].add(cl[0]);
        v[0].add(book_id);
        v[1].add(cl[1]);
        v[1].add(student_roll_no);
        v[2].add(q3);
        v[2].add(search);
        v[2].add(clear);
        v[2].add(q4);
        v[3].add(cl[2]);
        v[3].add(issue_date);
        v[4].add(cl[3]);
        v[4].add(return_date);

        hide_component(false);
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
    }

    // hide component
    public void hide_component(boolean va) {
        cl[2].setVisible(va);
        cl[3].setVisible(va);
        issue_date.setVisible(va);
        return_date.setVisible(va);
        returnb.setVisible(va);
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
        q3.setBackground(color);
        q4.setBackground(color);

        for (int i = 0; i < v.length; i++) {
            v[i].setBackground(color);
        }

        Color color1 = new Color(19, 15, 64);
        book_id.setBackground(color1);
        student_roll_no.setBackground(color1);
        issue_date.setBackground(color1);
        return_date.setBackground(color1);

        Color wh = Color.WHITE;
        book_id.setForeground(wh);
        student_roll_no.setForeground(wh);
        issue_date.setForeground(wh);
        return_date.setForeground(wh);

        book_id.setCaretColor(wh);
        student_roll_no.setCaretColor(wh);
        issue_date.setCaretColor(wh);
        return_date.setCaretColor(wh);

        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }
        returnb.setBackground(Color.YELLOW);
        returnb.setForeground(new Color(19, 15, 64));
        search.setBackground(Color.YELLOW);
        search.setForeground(new Color(19, 15, 64));
        clear.setBackground(Color.YELLOW);
        clear.setForeground(new Color(19, 15, 64));

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
        returnb.setCursor(cursor);
        search.setCursor(cursor);
        clear.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        returnb.setFocusable(false);
        search.setFocusable(false);
        clear.setFocusable(false);

        book_id.setHorizontalAlignment(JTextField.CENTER);
        student_roll_no.setHorizontalAlignment(JTextField.CENTER);
        issue_date.setHorizontalAlignment(JTextField.CENTER);
        return_date.setHorizontalAlignment(JTextField.CENTER);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        returnb.setFont(font);
        search.setFont(font);
        clear.setFont(font);

        Font font1 = new Font("Tahoma", Font.BOLD, 20);
        for (int i = 0; i < cl.length; i++) {
            cl[i].setFont(font1);
        }
        book_id.setFont(font1);
        student_roll_no.setFont(font1);
        issue_date.setFont(font1);
        return_date.setFont(font1);
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
        returnb.addActionListener(new Add_Action());
        returnb.addMouseListener(new Add_Action());
        search.addActionListener(new Add_Action());
        search.addMouseListener(new Add_Action());
        clear.addActionListener(new Add_Action());
        clear.addMouseListener(new Add_Action());
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
                } else if (e.getSource() == search) {
                    String bid = book_id.getText().trim();
                    String sroll_no = student_roll_no.getText().trim();

                    if (bid.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (sroll_no.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Student Roll Number", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT issue_book_date,return_book_date FROM issue_book WHERE book_id=? && student_roll_no=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid);
                            ps.setString(2, sroll_no);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String issue_date2 = rs.getString(1);
                                String return_date2 = rs.getString(2);
                                book_id.setEditable(false);
                                student_roll_no.setEditable(false);
                                hide_component(true);
                                issue_date.setText(issue_date2);
                                return_date.setText(return_date2);
                                issue_date.setEditable(false);
                                return_date.setEditable(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "This Book is not issued for this student",
                                        "WARNING", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == clear) {
                    book_id.setText("");
                    student_roll_no.setText("");
                    issue_date.setText("");
                    return_date.setText("");
                    hide_component(false);
                    book_id.setEditable(true);
                    student_roll_no.setEditable(true);
                    book_id.requestFocus();
                } else if (e.getSource() == returnb) {
                    String bid = book_id.getText().trim();
                    String sroll_no = student_roll_no.getText().trim();
                    String issue_book2 = issue_date.getText().trim();
                    String return_book2 = return_date.getText().trim();
                    String no_avaible_book = "", no_issue_book = "", no_return_book = "", std_total_issue_book = "",
                            std_total_return_book = "";
                    String[] arr = return_book2.split("/");
                    int d1 = Integer.parseInt(arr[0]);
                    int m1 = Integer.parseInt(arr[1]);
                    int y1 = Integer.parseInt(arr[2]);

                    // current date
                    Calendar cal = new GregorianCalendar();
                    int d2 = cal.get(Calendar.DAY_OF_MONTH);
                    int m2 = cal.get(Calendar.MONTH) + 1;
                    int y2 = cal.get(Calendar.YEAR);

                    String book_submit_date = d2 + "/" + m2 + "/" + y2;
                    int sd = d2, sm = m2, sy = y2;

                    int d3, m3, y3;
                    if (d2 < d1) {
                        m2--;
                        d2 += check_day(m2, y2);
                    }
                    if (m2 < m1) {
                        m2 += 12;
                        y2--;
                    }
                    d3 = d2 - d1;
                    m3 = m2 - m1;
                    y3 = y2 - y1;
                    int late_fine = 0, total_late_day = 0;
                    if ((sd == d1 && sm == m1 && sy == y1) || (y3 <= -1)) {
                        late_fine = 0;
                    } else if (d3 >= 0 && m3 >= 0 && y3 >= 0) {

                        // int day1,month1;
                        int year1;
                        // int day2,month2;
                        int yearn;

                        // day1=1;
                        // month1=1;
                        year1 = y1;

                        // day2=31;
                        // month2=31;
                        yearn = sy - 1;

                        int td = 0;
                        for (int z = year1; z <= yearn; z++) {
                            if ((z % 400 == 0) || ((z % 4 == 0) && (z % 100 != 0))) {
                                td = td + 366;
                            } else {
                                td = td + 365;
                            }
                        }
                        int daysub = total_days(d1, m1, y1);

                        int dayadd = total_days(sd, sm, sy);

                        total_late_day = td - daysub + dayadd;
                        late_fine = total_late_day * 10;
                    }

                    try {
                        // get avaible_book,no_of_issue_book,no_of_return_book for book table in
                        // database
                        String q = "SELECT avaible_book,no_of_issue_book,no_of_return_book FROM book WHERE book_id=?";
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, bid);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            no_avaible_book = rs.getString(1);
                            no_issue_book = rs.getString(2);
                            no_return_book = rs.getString(3);
                        }

                        // get total_issue_book,total_return_book for student table in database
                        q = "SELECT total_issue_book,total_return_book FROM student WHERE roll_no=?";
                        ps = con.prepareStatement(q);
                        ps.setString(1, sroll_no);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            std_total_issue_book = rs.getString(1);
                            std_total_return_book = rs.getString(2);
                        }

                        // get information data for issue_book
                        String bname1 = "", bauthorn1 = "", bedition1 = "", bpubn1 = "", sname = "", course1 = "",
                                branch1 = "", year1 = "", semester1 = "";
                        q = "SELECT book_name,book_author,book_edition,book_publication,std_name,course,branch,year,semester FROM issue_book WHERE book_id=? && student_roll_no=?";
                        ps = con.prepareStatement(q);
                        ps.setString(1, bid);
                        ps.setString(2, sroll_no);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            bname1 = rs.getString(1);
                            bauthorn1 = rs.getString(2);
                            bedition1 = rs.getString(3);
                            bpubn1 = rs.getString(4);
                            sname = rs.getString(5);
                            course1 = rs.getString(6);
                            branch1 = rs.getString(7);
                            year1 = rs.getString(8);
                            semester1 = rs.getString(9);
                        }

                        // insert return_date releted data in database
                        q = "INSERT INTO return_book(book_id,book_name,book_author,book_edition,book_publication,student_roll_no,std_name,course,branch,year,semester,issue_date,return_date,submit_date,total_late_day,late_fine,username_of_admin_return_book,username_of_librarian_return_book) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                        ps.setString(12, issue_book2);
                        ps.setString(13, return_book2);
                        ps.setString(14, book_submit_date);
                        ps.setString(15, String.valueOf(total_late_day));
                        ps.setString(16, String.valueOf(late_fine));
                        ps.setString(17, user);
                        ps.setString(18, "null");

                        ps.executeUpdate();

                        // update avaible_book,no_of_issue_book,no_of_return_book information from book
                        // table in database
                        no_avaible_book = String.valueOf((Integer.parseInt(no_avaible_book) + 1));
                        no_issue_book = String.valueOf((Integer.parseInt(no_issue_book) - 1));
                        no_return_book = String.valueOf((Integer.parseInt(no_return_book) + 1));
                        q = "UPDATE book SET avaible_book=?,no_of_issue_book=?,no_of_return_book=? WHERE book_id=?";
                        ps = con.prepareStatement(q);
                        ps.setString(1, no_avaible_book);
                        ps.setString(2, no_issue_book);
                        ps.setString(3, no_return_book);
                        ps.setString(4, bid);
                        ps.executeUpdate();

                        // update total_issue_book information from student table in database
                        std_total_issue_book = String.valueOf((Integer.parseInt(std_total_issue_book) - 1));
                        std_total_return_book = String.valueOf((Integer.parseInt(std_total_return_book) + 1));
                        q = "UPDATE student SET total_issue_book=?,total_return_book=? WHERE roll_no=?";
                        ps = con.prepareStatement(q);
                        ps.setString(1, std_total_issue_book);
                        ps.setString(2, std_total_return_book);
                        ps.setString(3, sroll_no);
                        ps.executeUpdate();

                        // delete the issue data for issue_book table in database
                        q = "DELETE FROM issue_book WHERE book_id=? && student_roll_no=?";
                        ps = con.prepareStatement(q);
                        ps.setString(1, bid);
                        ps.setString(2, sroll_no);
                        ps.executeUpdate();

                        if (total_late_day > 0) {
                            // JOptionPane.showMessageDialog(null, "This student is due for
                            // "+total_late_day+" days of returning the issued book so, total late fee to be
                            // paid by this student ₹"+late_fine, "WARNING",JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(null, "This student is submitting the book " + total_late_day
                                    + " days after the date of return of the issued book so, total late fee to be paid by this student ₹"
                                    + late_fine, "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                        JOptionPane.showMessageDialog(null, "this Book Return successful for this student",
                                "Information", JOptionPane.INFORMATION_MESSAGE);
                        book_id.setText("");
                        student_roll_no.setText("");
                        issue_date.setText("");
                        return_date.setText("");
                        hide_component(false);
                        book_id.setEditable(true);
                        student_roll_no.setEditable(true);
                        book_id.requestFocus();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            } else if (e.getSource() == returnb) {
                returnb.setBackground(Color.WHITE);
            } else if (e.getSource() == search) {
                search.setBackground(Color.WHITE);
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
            } else if (e.getSource() == returnb) {
                returnb.setBackground(Color.YELLOW);
            } else if (e.getSource() == search) {
                search.setBackground(Color.YELLOW);
            } else if (e.getSource() == clear) {
                clear.setBackground(Color.YELLOW);
            }
        }
    }

    public int total_days(int d, int m, int y) {
        int td = 0;
        for (int i = 1; i <= m; i++) {
            if (i == m) {
                td = td + d - 1;
            } else {
                td = td + check_day(i, y);
            }
        }
        return td;
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
}
