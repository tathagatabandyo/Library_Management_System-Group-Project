package Main;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import admin.AdminControl;
import admin.Admin_Forgot_Password;
import librarian.LibrarianControl;
import librarian.Librarian_Forgot_Password;
import student.StudentControl;
import student.Student_Forgot_Password;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, q1, q2, q3;
    public JPanel mp,borderp, ap, lp, sp, ph, ph1, ph2, ph3;
    public JButton ab, lb, sb, bi, bj;
    public JLabel libimage, ll, al, sl, college_nane;
    JButton[] b;
    JCheckBox checkp1, checkp2, checkp3;
    JLabel u1, u2, iu1, iu2, iu3, fl1, fl2, fl3, u3, u4, u5, u6;
    JPasswordField p1, p2, p3;
    JTextField t1, t2, t3;
    JScrollPane ms;
    Connection con = null;

    public Main(String s) {
        super(s);
        // setSize(1080,780);
        setMinimumSize(new Dimension(1320, 790));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        // setState(JFrame.ICONIFIED);
        // setUndecorated(true);
        // setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/photo/library.png")).getImage());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create_component();
        set_Layout();
        add_component();
        set_color();
        set_Border();
        set_font_and_Cursor();
        checkp1.addItemListener(new AddListener());
        checkp2.addItemListener(new AddListener());
        checkp3.addItemListener(new AddListener());
        for (int i = 0; i < b.length; i++) {
            b[i].addMouseListener(new AddListener());
            b[i].addActionListener(new AddListener());
        }
        bi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Library Management System\n\nVersion : 1.0.0\nDate : 31-01-2021\nOS : Windows,Linux,Mac","Library Management System", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        bj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeveloperDetailsM("Developer Details").setVisible(true);
            }
        });
        bi.addMouseListener(new AddListener());
        bj.addMouseListener(new AddListener());
        albActionListener();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(400);
                        libimage.setVisible(false);
                        college_nane.setVisible(true);
                        Thread.sleep(400);
                        libimage.setVisible(true);
                        college_nane.setVisible(false);
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
        mp = new JPanel();
        ms = new JScrollPane(mp);
        borderp = new JPanel();
        p = new JPanel[7];

        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }
        p[0].setPreferredSize(new Dimension(10, 94));
        p[1].setPreferredSize(new Dimension(10, 0));
        p[2].setPreferredSize(new Dimension(0, 10));
        p[3].setPreferredSize(new Dimension(0, 0));
        p[5].setPreferredSize(new Dimension(10, 40));
        ImageIcon icon = new ImageIcon(getClass().getResource("/photo/text.gif"));

        ab = new JButton("Admin Login");
        lb = new JButton("Librarian Login");
        sb = new JButton("Student Login");
        ab.setFocusable(false);
        lb.setFocusable(false);
        sb.setFocusable(false);
        ap = new JPanel();
        lp = new JPanel();
        sp = new JPanel();

        q1 = new JPanel[9];
        q2 = new JPanel[9];
        q3 = new JPanel[9];
        for (int i = 0; i < q1.length; i++) {
            q1[i] = new JPanel();
            q2[i] = new JPanel();
        }
        for (int i = 0; i < q3.length; i++) {
            q3[i] = new JPanel();
        }

        libimage = new JLabel(icon);
        b = new JButton[6];
        iu1 = new JLabel("", new ImageIcon(getClass().getResource("/photo/login1.png")), JLabel.CENTER);
        al = new JLabel("Admin Login", JLabel.CENTER);
        u1 = new JLabel("Username", JLabel.CENTER);
        t1 = new JTextField();
        u2 = new JLabel("Password", JLabel.CENTER);
        p1 = new JPasswordField();
        checkp1 = new JCheckBox("show Password");
        b[0] = new JButton("Login", new ImageIcon(getClass().getResource("/photo/login2.png")));
        b[1] = new JButton("Forgot Password");
        fl1 = new JLabel("Trouble in Login?", JLabel.CENTER);

        iu2 = new JLabel("", new ImageIcon(getClass().getResource("/photo/login.png")), JLabel.CENTER);
        ll = new JLabel("Librarian Login", JLabel.CENTER);
        u3 = new JLabel("Username", JLabel.CENTER);
        t2 = new JTextField();
        u4 = new JLabel("Password", JLabel.CENTER);
        p2 = new JPasswordField();
        checkp2 = new JCheckBox("show Password");
        b[2] = new JButton("Login", new ImageIcon(getClass().getResource("/photo/login2.png")));
        fl2 = new JLabel("Trouble in Login?", JLabel.CENTER);
        b[3] = new JButton("Forgot Password");

        iu3 = new JLabel("", new ImageIcon(getClass().getResource("/photo/std.png")), JLabel.CENTER);
        sl = new JLabel("Student Login", JLabel.CENTER);
        u5 = new JLabel("Roll Number", JLabel.CENTER);
        t3 = new JTextField();
        u6 = new JLabel("Password", JLabel.CENTER);
        p3 = new JPasswordField();
        checkp3 = new JCheckBox("show Password");
        b[4] = new JButton("Login", new ImageIcon(getClass().getResource("/photo/login2.png")));
        fl3 = new JLabel("Trouble in Login?", JLabel.CENTER);
        b[5] = new JButton("Forgot Password");

        ph = new JPanel();
        ph1 = new JPanel();
        ph2 = new JPanel();
        ph3 = new JPanel();
        ph.setPreferredSize(new Dimension(10, 50));

        bi = new JButton("About us");
        bj = new JButton("Developer details");
        college_nane = new JLabel("Bengal College of Engineering and Technology", JLabel.CENTER);
        bi.setPreferredSize(new Dimension(126, 50));
        bj.setPreferredSize(new Dimension(146, 50));

        college_nane.setVisible(false);
    }

    // set_Layout
    public void set_Layout() {
        setLayout(new GridLayout(1,1));
        mp.setLayout(new BorderLayout(0, 0));
        ph.setLayout(new BorderLayout(0, 0));
        ph1.setLayout(new GridLayout(1, 1));
        // ph2.setLayout(new FlowLayout(0,0,FlowLayout.RIGHT));
        ph2.setLayout(new GridLayout(1, 1));
        ph3.setLayout(new GridLayout(1, 1));
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new GridLayout(1, 1));

        ap.setLayout(new BorderLayout(0, 0));
        lp.setLayout(new BorderLayout(0, 0));
        sp.setLayout(new BorderLayout(0, 0));

        // librarian
        q1[2].setLayout(new BorderLayout(0, 0));
        q2[0].setLayout(new BorderLayout(0, 0));
        q2[1].setLayout(new BorderLayout(0, 0));
        q2[2].setLayout(new GridLayout(2, 2, 10, 10));

        q3[0].setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        q3[1].setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // admin
        q1[5].setLayout(new BorderLayout(0, 0));
        q2[3].setLayout(new BorderLayout(0, 0));
        q2[4].setLayout(new BorderLayout(0, 0));
        q2[5].setLayout(new GridLayout(2, 2, 10, 10));

        q3[3].setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        q3[4].setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // student
        q1[8].setLayout(new BorderLayout(0, 0));
        q2[6].setLayout(new BorderLayout(0, 0));
        q2[7].setLayout(new BorderLayout(0, 0));
        q2[8].setLayout(new GridLayout(2, 2, 10, 10));

        q3[6].setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        q3[7].setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

    }

    // add_component
    public void add_component() {
        add(ms);
        mp.add(ph, BorderLayout.NORTH);
        ph.add(ph1, BorderLayout.WEST);
        ph.add(ph2, BorderLayout.EAST);
        ph.add(ph3, BorderLayout.CENTER);
        ph1.add(bi);
        ph2.add(bj);
        ph3.add(college_nane);
        mp.add(borderp, BorderLayout.CENTER);
        borderp.add(p[0], BorderLayout.NORTH);
        borderp.add(p[1], BorderLayout.SOUTH);
        borderp.add(p[2], BorderLayout.EAST);
        borderp.add(p[3], BorderLayout.WEST);
        borderp.add(p[4], BorderLayout.CENTER);
        p[0].add(libimage);
        p[4].add(p[5], BorderLayout.NORTH);
        p[4].add(p[6], BorderLayout.CENTER);
        p[5].add(ab);
        p[5].add(lb);
        p[5].add(sb);
        hide();
        p[6].add(lp);
        lp.setVisible(true);

        // admin panel
        ap.add(q1[3], BorderLayout.WEST);
        ap.add(q1[4], BorderLayout.EAST);
        ap.add(q1[5], BorderLayout.CENTER);

        q1[3].setPreferredSize(new Dimension(230, 10));
        q1[4].setPreferredSize(new Dimension(230, 10));

        q1[3].setBackground(new Color(41, 128, 185));
        q1[4].setBackground(new Color(41, 128, 185));
        q1[5].setBackground(Color.YELLOW);

        q1[5].add(q2[3], BorderLayout.NORTH);
        q1[5].add(q2[4], BorderLayout.SOUTH);
        q1[5].add(q2[5], BorderLayout.CENTER);

        q2[3].setPreferredSize(new Dimension(10, 290));
        q2[4].setPreferredSize(new Dimension(10, 140));

        q2[3].setBackground(new Color(41, 128, 185));
        q2[4].setBackground(new Color(41, 128, 185));
        q2[5].setBackground(new Color(41, 128, 185));

        q2[4].add(q3[3], BorderLayout.NORTH);
        q2[4].add(q3[4], BorderLayout.SOUTH);
        q2[4].add(q3[5], BorderLayout.CENTER);

        q3[3].setBackground(new Color(41, 128, 185));
        q3[4].setBackground(new Color(41, 128, 185));
        q3[5].setBackground(new Color(41, 128, 185));

        // admin add
        q2[3].add(iu1, BorderLayout.CENTER);
        q2[3].add(al, BorderLayout.SOUTH);
        q2[5].add(u1);
        q2[5].add(t1);
        q2[5].add(u2);
        q2[5].add(p1);
        q3[3].add(checkp1);
        q3[5].add(b[0]);
        q3[4].add(fl1);
        q3[4].add(b[1]);

        // librarian panel
        lp.add(q1[0], BorderLayout.WEST);
        lp.add(q1[1], BorderLayout.EAST);
        lp.add(q1[2], BorderLayout.CENTER);

        q1[0].setPreferredSize(new Dimension(230, 10));
        q1[1].setPreferredSize(new Dimension(230, 10));

        q1[0].setBackground(new Color(41, 128, 185));
        q1[1].setBackground(new Color(41, 128, 185));
        q1[2].setBackground(Color.YELLOW);

        q1[2].add(q2[0], BorderLayout.NORTH);
        q1[2].add(q2[1], BorderLayout.SOUTH);
        q1[2].add(q2[2], BorderLayout.CENTER);

        q2[0].setPreferredSize(new Dimension(10, 290));
        q2[1].setPreferredSize(new Dimension(10, 140));

        q2[0].setBackground(new Color(41, 128, 185));
        q2[1].setBackground(new Color(41, 128, 185));
        q2[2].setBackground(new Color(41, 128, 185));

        q2[1].add(q3[0], BorderLayout.NORTH);
        q2[1].add(q3[1], BorderLayout.SOUTH);
        q2[1].add(q3[2], BorderLayout.CENTER);

        q3[0].setBackground(new Color(41, 128, 185));
        q3[1].setBackground(new Color(41, 128, 185));
        q3[2].setBackground(new Color(41, 128, 185));

        q2[0].add(iu2, BorderLayout.CENTER);
        q2[0].add(ll, BorderLayout.SOUTH);
        q2[2].add(u3);
        q2[2].add(t2);
        q2[2].add(u4);
        q2[2].add(p2);
        q3[0].add(checkp2);
        q3[2].add(b[2]);
        q3[1].add(fl2);
        q3[1].add(b[3]);

        // student panel
        sp.add(q1[6], BorderLayout.WEST);
        sp.add(q1[7], BorderLayout.EAST);
        sp.add(q1[8], BorderLayout.CENTER);

        q1[6].setPreferredSize(new Dimension(230, 10));
        q1[7].setPreferredSize(new Dimension(230, 10));

        q1[6].setBackground(new Color(41, 128, 185));
        q1[7].setBackground(new Color(41, 128, 185));
        q1[8].setBackground(Color.YELLOW);

        q1[8].add(q2[6], BorderLayout.NORTH);
        q1[8].add(q2[7], BorderLayout.SOUTH);
        q1[8].add(q2[8], BorderLayout.CENTER);

        q2[6].setPreferredSize(new Dimension(10, 290));
        q2[7].setPreferredSize(new Dimension(10, 140));

        q2[6].setBackground(new Color(41, 128, 185));
        q2[7].setBackground(new Color(41, 128, 185));
        q2[8].setBackground(new Color(41, 128, 185));

        q2[7].add(q3[6], BorderLayout.NORTH);
        q2[7].add(q3[7], BorderLayout.SOUTH);
        q2[7].add(q3[8], BorderLayout.CENTER);

        q3[6].setBackground(new Color(41, 128, 185));
        q3[7].setBackground(new Color(41, 128, 185));
        q3[8].setBackground(new Color(41, 128, 185));

        q2[6].add(iu3, BorderLayout.CENTER);
        q2[6].add(sl, BorderLayout.SOUTH);
        q2[8].add(u5);
        q2[8].add(t3);
        q2[8].add(u6);
        q2[8].add(p3);
        q3[6].add(checkp3);
        q3[8].add(b[4]);
        q3[7].add(fl3);
        q3[7].add(b[5]);

    }

    // set_Border
    public void set_Border() {
        // libimage.setBorder(BorderFactory.createMatteBorder(0,0,10,0,Color.WHITE));
        p[4].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        // Font font=new java.awt.Font("Tahoma",Font.BOLD,22);
        borderp.setBorder(BorderFactory.createLineBorder(new Color(19, 15, 64), 10));
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        p1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        t2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        p2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        t3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        p3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        // librarian
        q2[2].setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, new Color(41, 128, 185)));
        q3[0].setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, new Color(41, 128, 185)));
        q3[1].setBorder(BorderFactory.createMatteBorder(0, 0, 15, 0, new Color(41, 128, 185)));
        // admin
        q2[5].setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, new Color(41, 128, 185)));
        q3[3].setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, new Color(41, 128, 185)));
        q3[4].setBorder(BorderFactory.createMatteBorder(0, 0, 15, 0, new Color(41, 128, 185)));
        // student
        q2[8].setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, new Color(41, 128, 185)));
        q3[6].setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, new Color(41, 128, 185)));
        q3[7].setBorder(BorderFactory.createMatteBorder(0, 0, 15, 0, new Color(41, 128, 185)));
        Color color = new Color(19, 15, 64);
        bi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, color));
        bj.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, color));
        ph1.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 0, color));
        ph2.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 10, color));
    }

    public void hide() {
        ap.setVisible(false);
        lp.setVisible(false);
        sp.setVisible(false);
        p[6].remove(ap);
        p[6].remove(lp);
        p[6].remove(sp);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        p1.setText("");
        p2.setText("");
        p3.setText("");
        checkp1.setSelected(false);
        checkp2.setSelected(false);
        checkp3.setSelected(false);
    }

    public void albActionListener() {
        ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(ap);
                ap.setVisible(true);
                ab.setBackground(new Color(142, 68, 173));
                lb.setBackground(new Color(48, 51, 107));
                sb.setBackground(new Color(48, 51, 107));
                t1.requestFocus();
            }
        });
        lb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(lp);
                lp.setVisible(true);
                ab.setBackground(new Color(48, 51, 107));
                lb.setBackground(new Color(142, 68, 173));
                sb.setBackground(new Color(48, 51, 107));
                t2.requestFocus();
            }
        });
        sb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(sp);
                sp.setVisible(true);
                ab.setBackground(new Color(48, 51, 107));
                lb.setBackground(new Color(48, 51, 107));
                sb.setBackground(new Color(142, 68, 173));
                t3.requestFocus();
            }
        });
    }

    // set_color()
    public void set_color() {
        getContentPane().setBackground(new Color(19, 15, 64));

        // p[0].setBackground(new Color(19, 15, 64));
        p[0].setBackground(new Color(211, 84, 0));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(Color.WHITE);
        p[6].setBackground(Color.PINK);
        ab.setBackground(new Color(48, 51, 107));
        lb.setBackground(new Color(142, 68, 173));
        sb.setBackground(new Color(48, 51, 107));
        ab.setForeground(Color.WHITE);
        lb.setForeground(Color.WHITE);
        sb.setForeground(Color.WHITE);

        ap.setBackground(new Color(41, 128, 185));
        lp.setBackground(new Color(41, 128, 185));
        sp.setBackground(new Color(41, 128, 185));

        al.setForeground(Color.WHITE);
        ll.setForeground(Color.WHITE);
        sl.setForeground(Color.WHITE);

        t1.setBackground(new Color(19, 15, 64));
        p1.setBackground(new Color(19, 15, 64));
        u1.setBackground(Color.YELLOW);
        u1.setOpaque(true);
        u2.setBackground(Color.YELLOW);
        u2.setOpaque(true);
        t2.setBackground(new Color(19, 15, 64));
        p2.setBackground(new Color(19, 15, 64));
        u3.setBackground(Color.YELLOW);
        u3.setOpaque(true);
        u4.setBackground(Color.YELLOW);
        u4.setOpaque(true);
        t3.setBackground(new Color(19, 15, 64));
        p3.setBackground(new Color(19, 15, 64));
        u5.setBackground(Color.YELLOW);
        u5.setOpaque(true);
        u6.setBackground(Color.YELLOW);
        u6.setOpaque(true);
        checkp1.setBackground(new Color(19, 15, 64));
        checkp1.setForeground(Color.WHITE);
        checkp2.setBackground(new Color(19, 15, 64));
        checkp2.setForeground(Color.WHITE);
        checkp3.setBackground(new Color(19, 15, 64));
        checkp3.setForeground(Color.WHITE);
        u1.setForeground(Color.BLACK);
        u2.setForeground(Color.BLACK);
        u3.setForeground(Color.BLACK);
        t1.setForeground(Color.WHITE);
        p1.setForeground(Color.WHITE);
        t1.setCaretColor(Color.WHITE);
        p1.setCaretColor(Color.WHITE);
        t3.setForeground(Color.WHITE);
        p3.setForeground(Color.WHITE);
        t3.setCaretColor(Color.WHITE);
        p3.setCaretColor(Color.WHITE);
        // u3.setForeground(new Color(19, 15, 64));
        u4.setForeground(Color.BLACK);
        u5.setForeground(Color.BLACK);
        u6.setForeground(Color.BLACK);
        t2.setForeground(Color.WHITE);
        p2.setForeground(Color.WHITE);
        t2.setCaretColor(Color.WHITE);
        p2.setCaretColor(Color.WHITE);
        t3.setCaretColor(Color.WHITE);
        p3.setCaretColor(Color.WHITE);
        college_nane.setForeground(Color.WHITE);

        // ph.setBackground(new Color(45, 52, 54));
        ph3.setBackground(new Color(19, 15, 64));
        bi.setBackground(Color.YELLOW);
        bj.setBackground(Color.YELLOW);

        bi.setForeground(Color.BLACK);
        bj.setForeground(Color.BLACK);

    }

    public void set_font_and_Cursor() {
        Font af = new Font("Tahoma", Font.BOLD, 16);
        ab.setFont(af);
        lb.setFont(af);
        sb.setFont(af);

        Font fontl = new Font("Tahoma", Font.BOLD, 16);
        ll.setFont(fontl);
        al.setFont(fontl);
        sl.setFont(fontl);

        Font font = new Font("Tahoma", Font.BOLD, 24);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        ab.setCursor(cursor);
        lb.setCursor(cursor);
        sb.setCursor(cursor);
        bi.setCursor(cursor);
        bj.setCursor(cursor);
        bi.setFocusable(false);
        bj.setFocusable(false);

        for (int i = 0; i < b.length; i++) {
            b[i].setFont(font);
            b[i].setFocusable(false);
            b[i].setCursor(cursor);
            b[i].setBackground(Color.YELLOW);
            b[i].setForeground(Color.BLACK);
        }
        t1.setHorizontalAlignment(JTextField.CENTER);
        p1.setHorizontalAlignment(JTextField.CENTER);
        t2.setHorizontalAlignment(JTextField.CENTER);
        p2.setHorizontalAlignment(JTextField.CENTER);
        t3.setHorizontalAlignment(JTextField.CENTER);
        p3.setHorizontalAlignment(JTextField.CENTER);

        Font font2 = new Font("Tahoma", Font.BOLD, 22);
        u1.setFont(font2);
        t1.setFont(font2);
        u2.setFont(font2);
        p1.setFont(font2);
        u3.setFont(font2);
        t2.setFont(font2);
        u4.setFont(font2);
        p2.setFont(font2);
        u5.setFont(font2);
        t3.setFont(font2);
        u6.setFont(font2);
        p3.setFont(font2);
        college_nane.setFont(font2);
        p1.setEchoChar('*');
        p2.setEchoChar('*');
        p3.setEchoChar('*');
        checkp1.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkp1.setFocusable(false);
        checkp2.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkp2.setFocusable(false);
        checkp3.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkp3.setFocusable(false);
        Font f1 = new Font("Tahoma", Font.BOLD, 15);
        fl1.setFont(f1);
        fl2.setFont(f1);
        fl3.setFont(f1);
        b[1].setFont(f1);
        b[3].setFont(f1);
        b[5].setFont(f1);

        fl1.setForeground(Color.WHITE);
        fl2.setForeground(Color.WHITE);
        fl3.setForeground(Color.WHITE);

        Font fontd = new Font("Tahoma", Font.BOLD, 16);
        bi.setFont(fontd);
        bj.setFont(fontd);
    }

    public ImageIcon image_Size(ImageIcon icon, int w, int h) {
        Image oimg = icon.getImage();
        Image nimg = oimg.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        icon = new ImageIcon(nimg);
        return icon;
    }

    class AddListener implements ItemListener, MouseListener, ActionListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == checkp1) {
                if (checkp1.isSelected()) {
                    p1.setEchoChar((char) 0);
                } else {
                    p1.setEchoChar('*');
                }
            } else if (e.getSource() == checkp2) {
                if (checkp2.isSelected()) {
                    p2.setEchoChar((char) 0);
                } else {
                    p2.setEchoChar('*');
                }
            } else if (e.getSource() == checkp3) {
                if (checkp3.isSelected()) {
                    p3.setEchoChar((char) 0);
                } else {
                    p3.setEchoChar('*');
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == b[0]) {
                b[0].setBackground(Color.WHITE);
            } else if (e.getSource() == b[1]) {
                b[1].setBackground(Color.WHITE);
            } else if (e.getSource() == b[2]) {
                b[2].setBackground(Color.WHITE);
            } else if (e.getSource() == b[3]) {
                b[3].setBackground(Color.WHITE);
            } else if (e.getSource() == b[4]) {
                b[4].setBackground(Color.WHITE);
            } else if (e.getSource() == b[5]) {
                b[5].setBackground(Color.WHITE);
            } else if (e.getSource() == bi) {
                bi.setBackground(Color.WHITE);
            } else if (e.getSource() == bj) {
                bj.setBackground(Color.WHITE);
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
            if (e.getSource() == b[0]) {
                b[0].setBackground(Color.YELLOW);
            } else if (e.getSource() == b[1]) {
                b[1].setBackground(Color.YELLOW);
            } else if (e.getSource() == b[2]) {
                b[2].setBackground(Color.YELLOW);
            } else if (e.getSource() == b[3]) {
                b[3].setBackground(Color.YELLOW);
            } else if (e.getSource() == b[4]) {
                b[4].setBackground(Color.YELLOW);
            } else if (e.getSource() == b[5]) {
                b[5].setBackground(Color.YELLOW);
            } else if (e.getSource() == bi) {
                bi.setBackground(Color.YELLOW);
            } else if (e.getSource() == bj) {
                bj.setBackground(Color.YELLOW);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            con = EstablishConection.getEstblishConnection();
            if (con != null) {
                if (e.getSource() == b[0]) {
                    String user = t1.getText().trim();
                    String pass = String.valueOf(p1.getPassword()).trim();
                    if (user.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Password", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        String q = "SELECT name,username FROM admin WHERE username=? && password=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user);
                            ps.setString(2, pass);

                            ResultSet rs = ps.executeQuery();

                            if (rs.next()) {
                                q = "INSERT INTO admin_login_information(name,username) VALUES(?,?)";
                                ps = con.prepareStatement(q);
                                ps.setString(1, rs.getString(1));
                                ps.setString(2, rs.getString(2));
                                ps.executeUpdate();
                                dispose();
                                new AdminControl("Admin Control", con, rs.getString(1), rs.getString(2))
                                        .setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error",
                                        JOptionPane.ERROR_MESSAGE);

                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == b[1]) {
                    dispose();
                    new Admin_Forgot_Password("Admin Forgot Password").setVisible(true);
                } else if (e.getSource() == b[2]) {
                    String user = t2.getText().trim();
                    String pass = String.valueOf(p2.getPassword()).trim();
                    if (user.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Password", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        String q = "SELECT name,username FROM librarian WHERE username=? && password=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user);
                            ps.setString(2, pass);

                            ResultSet rs = ps.executeQuery();

                            if (rs.next()) {
                                q = "INSERT INTO librarian_login_information(name,username) VALUES(?,?)";
                                ps = con.prepareStatement(q);
                                ps.setString(1, rs.getString(1));
                                ps.setString(2, rs.getString(2));
                                ps.executeUpdate();
                                dispose();
                                new LibrarianControl("Librarian Control Panel", con, rs.getString(1), rs.getString(2))
                                        .setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error",
                                        JOptionPane.ERROR_MESSAGE);

                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == b[3]) {
                    dispose();
                    new Librarian_Forgot_Password("Librarian Forgot Password").setVisible(true);
                } else if (e.getSource() == b[4]) {
                    String std_roll_no = t3.getText().trim();
                    String pass = String.valueOf(p3.getPassword()).trim();
                    if (std_roll_no.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Roll No.", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Password", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT name FROM student WHERE roll_no=? && password=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, std_roll_no);
                            ps.setString(2, pass);
                            ResultSet rs = ps.executeQuery();

                            if (rs.next()) {
                                q = "INSERT INTO student_login_information(name,student_roll_no) VALUES(?,?)";
                                ps = con.prepareStatement(q);
                                ps.setString(1, rs.getString(1));
                                ps.setString(2, std_roll_no);
                                ps.executeUpdate();
                                dispose();
                                new StudentControl("Student Control Panel", con, rs.getString(1), std_roll_no)
                                        .setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Roll No. or Password", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == b[5]) {
                    dispose();
                    new Student_Forgot_Password("Student Forgot Password").setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Main("Library Management System").setVisible(true);
        ;
    }
}
