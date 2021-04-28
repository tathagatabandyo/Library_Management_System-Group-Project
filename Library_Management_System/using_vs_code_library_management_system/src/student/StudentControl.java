package student;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Main.EstablishConection;
import Main.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentControl extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p;
    public JPanel mp1,borderp, p1, p2, p3, ph;
    public JButton logout, exit, bi, bj;
    public JLabel libimage, admintext, weltext;
    JButton[] b;
    JPanel[] mp;
    JLabel[] ml;
    JScrollPane ms;
    Connection con = null;
    String user = "";
    String name = "";

    public StudentControl(String s, Connection con, String name, String user) {
        super(s);
        // setSize(1080, 780);
        setMinimumSize(new Dimension(1320, 790));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this.con = con;
        this.user = user;
        this.name = name;
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
        mp1 = new JPanel();
        ms = new JScrollPane(mp1);
        p = new JPanel[7];

        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }
        p[0].setPreferredSize(new Dimension(10, 70));
        p[1].setPreferredSize(new Dimension(10, 0));
        p[2].setPreferredSize(new Dimension(0, 10));
        p[3].setPreferredSize(new Dimension(0, 0));
        p[5].setPreferredSize(new Dimension(10, 40));

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        p1.setPreferredSize(new Dimension(155, 10));
        p2.setPreferredSize(new Dimension(130, 10));

        admintext = new JLabel("Student Control Panel", JLabel.CENTER);
        weltext = new JLabel("Welcome " + name, JLabel.CENTER);

        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        logout.setPreferredSize(new Dimension(134, 51));
        exit.setPreferredSize(new Dimension(110, 51));

        mp = new JPanel[3];
        for (int i = 0; i < mp.length; i++) {
            mp[i] = new JPanel();
            mp[i].setLayout(new BorderLayout(0, 0));
        }

        b = new JButton[3];
        b[0] = new JButton(new ImageIcon(getClass().getResource("/photo/student.png")));
        b[1] = new JButton(new ImageIcon(getClass().getResource("/photo/book_datails.png")));
        b[2] = new JButton(new ImageIcon(getClass().getResource("/photo/std_library.png")));

        ml = new JLabel[3];
        ml[0] = new JLabel("Profile Details & Update Profile", JLabel.CENTER);
        ml[1] = new JLabel("Issue and Return Book Details", JLabel.CENTER);
        ml[2] = new JLabel("View all available Book in Library", JLabel.CENTER);

        b[0].setToolTipText("Profile Details & Update Profile");
        b[1].setToolTipText("Issue and Return Book Details");
        b[2].setToolTipText("View all available Book in Library");

        ph = new JPanel();
        ph.setPreferredSize(new Dimension(10, 40));

        bi = new JButton("About us");
        bj = new JButton("Developer details");
        bi.setPreferredSize(new Dimension(126, 40));
        bj.setPreferredSize(new Dimension(146, 40));

    }

    // set_Layout
    public void set_Layout() {
        setLayout(new GridLayout(1,1));
        mp1.setLayout(new BorderLayout(0, 0));
        ph.setLayout(new FlowLayout(0, 0, FlowLayout.LEFT));
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new BorderLayout(0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 1, 5, 0));
        p[6].setLayout(new GridLayout(1, 3, 80, 40));
        p3.setLayout(new GridLayout(1, 1));
        Cursor cursor2 = new Cursor(Cursor.HAND_CURSOR);
        for (int i = 0; i < mp.length; i++) {
            // b[i].setBounds(0,0,237,230);
            b[i].setCursor(cursor2);
        }
    }

    // add_component
    public void add_component() {
        add(ms);
        mp1.add(ph, BorderLayout.NORTH);
        ph.add(bi);
        ph.add(bj);
        mp1.add(borderp, BorderLayout.CENTER);
        borderp.add(p[0], BorderLayout.NORTH);
        borderp.add(p[1], BorderLayout.SOUTH);
        borderp.add(p[2], BorderLayout.EAST);
        borderp.add(p[3], BorderLayout.WEST);
        borderp.add(p[4], BorderLayout.CENTER);

        p[0].add(p1, BorderLayout.WEST);
        p[0].add(p2, BorderLayout.EAST);
        p[0].add(p3, BorderLayout.CENTER);

        p[4].add(p[5], BorderLayout.NORTH);
        p[4].add(p[6], BorderLayout.CENTER);

        p[5].add(admintext);
        p1.add(logout);
        p3.add(weltext);
        p2.add(exit);

        for (int i = 0; i < mp.length; i++) {
            p[6].add(mp[i]);
            mp[i].setBackground(new Color(41, 128, 185));
        }
        Font font2 = new Font("Tahoma", Font.BOLD, 18);
        for (int i = 0; i < b.length; i++) {
            mp[i].add(b[i], BorderLayout.CENTER);
            mp[i].add(ml[i], BorderLayout.SOUTH);
            b[i].setFocusable(false);
            ml[i].setFont(font2);
            ml[i].setForeground(Color.WHITE);
            b[i].setBackground(new Color(48, 51, 107));
        }
    }

    // set_Border
    public void set_Border() {
        borderp.setBorder(BorderFactory.createLineBorder(new Color(19, 15, 64), 10));
        p[4].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        p[0].setBorder(BorderFactory.createLineBorder(new Color(162, 155, 254), 4));
        p[6].setBorder(BorderFactory.createMatteBorder(165, 80, 165, 80, new Color(41, 128, 185)));
        Color color = new Color(45, 52, 54);
        bi.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, color));
        bj.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, color));

    }

    // set_color
    public void set_color() {
        getContentPane().setBackground(new Color(19, 15, 64));

        p[0].setBackground(new Color(19, 15, 64));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(Color.WHITE);
        p[6].setBackground(new Color(41, 128, 185));
        admintext.setBackground(new Color(48, 51, 107));
        admintext.setOpaque(true);
        admintext.setForeground(Color.WHITE);
        weltext.setForeground(Color.WHITE);
        Color co1 = new Color(211, 84, 0);
        p1.setBackground(co1);
        p2.setBackground(co1);
        p3.setBackground(co1);
        logout.setBackground(new Color(34, 47, 62));
        exit.setBackground(new Color(34, 47, 62));
        logout.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);

        ph.setBackground(new Color(45, 52, 54));
        bi.setBackground(Color.BLACK);
        bj.setBackground(Color.BLACK);

        bi.setForeground(Color.WHITE);
        bj.setForeground(Color.WHITE);
    }

    // set_font_and_Cursor
    public void set_font_and_Cursor() {
        Font af = new Font("Tahoma", Font.BOLD, 18);
        admintext.setFont(af);
        logout.setFont(af);
        exit.setFont(af);
        weltext.setFont(new Font("Tahoma", Font.BOLD, 22));

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        logout.setCursor(cursor);
        exit.setCursor(cursor);
        bi.setCursor(cursor);
        bj.setCursor(cursor);
        bi.setFocusable(false);
        bj.setFocusable(false);

        logout.setFocusable(false);
        exit.setFocusable(false);

        Font fontd = new Font("Tahoma", Font.BOLD, 14);
        bi.setFont(fontd);
        bj.setFont(fontd);
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
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                System.exit(0);
            }
        });
        logout.addActionListener(new Add_Action());
        logout.addMouseListener(new Add_Action());
        exit.addMouseListener(new Add_Action());
        for (int i = 0; i < b.length; i++) {
            b[i].addActionListener(new Add_Action());
        }
        bi.addMouseListener(new Add_Action());
        bj.addMouseListener(new Add_Action());
        bi.addActionListener(new Add_Action());
        bj.addActionListener(new Add_Action());
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
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (e.getSource() == b[0]) {
                    dispose();
                    new StudentProfile("Student Profile Details & Update Profile", con, name, user).setVisible(true);
                } else if (e.getSource() == b[1]) {
                    dispose();
                    new Student_View_Issue_Return_Book_Details("Student View Issue and Return Book Details", con, name,
                            user).setVisible(true);
                } else if (e.getSource() == b[2]) {
                    dispose();
                    new Student_Check_Availble_Book("Student Check Availble Book in Library", con, name, user)
                            .setVisible(true);
                } else if (e.getSource() == bi) {
                    JOptionPane.showMessageDialog(null,
                            "Library Management System\n\nVersion : 1.0.0\nDate : 31-01-2021\nOS : Windows,Linux,Mac",
                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                } else if (e.getSource() == bj) {
                    dispose();
                    new DeveloperDetailsS("Developer Details", con, name, user).setVisible(true);
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
            } else if (e.getSource() == bi) {
                bi.setBackground(Color.DARK_GRAY);
            } else if (e.getSource() == bj) {
                bj.setBackground(Color.DARK_GRAY);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == bi) {
                bi.setForeground(Color.BLACK);
            } else if (e.getSource() == bj) {
                bj.setForeground(Color.BLACK);
            }
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
            } else if (e.getSource() == bi) {
                bi.setBackground(Color.BLACK);
                bi.setForeground(Color.WHITE);
            } else if (e.getSource() == bj) {
                bj.setBackground(Color.BLACK);
                bj.setForeground(Color.WHITE);
            }
        }
    }
}
