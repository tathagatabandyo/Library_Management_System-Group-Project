package admin;

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
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DeveloperDetailsA extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, pt;
    public JPanel borderp, p1, p2, p3, p4, p5, q1, q2, q3;
    public JLabel htext, im1, im2, im3, n1, n2, n3, ro1, ro2, ro3, branch1, branch2, branch3, y1, y2, y3, s1, s2, s3,
            dd[], dt[];
    JButton logout, exit, back;
    JScrollPane ms;
    Connection con = null;
    String user = "";
    String name = "";

    public DeveloperDetailsA(String s, Connection con, String name, String user) {
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
        p[5].setPreferredSize(new Dimension(10, 40));

        p1 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p3.setPreferredSize(new Dimension(155, 10));
        p4.setPreferredSize(new Dimension(155, 10));

        back = new JButton("Back", new ImageIcon(getClass().getResource("/photo/back1.png")));
        htext = new JLabel("Developer Details for Library Management System(Group Project)", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        // developer Details add
        q1 = new JPanel();
        q2 = new JPanel();
        q3 = new JPanel();

        pt = new JPanel[12];
        for (int i = 0; i < pt.length; i++) {
            pt[i] = new JPanel();
        }
        pt[0].setPreferredSize(new Dimension(10, 260));
        pt[2].setPreferredSize(new Dimension(10, 260));
        pt[4].setPreferredSize(new Dimension(10, 260));
        pt[6].setPreferredSize(new Dimension(126, 10));
        pt[8].setPreferredSize(new Dimension(126, 10));
        pt[10].setPreferredSize(new Dimension(126, 10));

        im1 = new JLabel(new ImageIcon(getClass().getResource("/photo/img1.png")), JLabel.CENTER);
        im2 = new JLabel(new ImageIcon(getClass().getResource("/photo/img2.png")), JLabel.CENTER);
        im3 = new JLabel(new ImageIcon(getClass().getResource("/photo/img3.png")), JLabel.CENTER);

        dd = new JLabel[15];
        dd[0] = new JLabel("Name", JLabel.CENTER);
        dd[1] = new JLabel("Roll Number", JLabel.CENTER);
        dd[2] = new JLabel("Branch", JLabel.CENTER);
        dd[3] = new JLabel("Year", JLabel.CENTER);
        dd[4] = new JLabel("Semester", JLabel.CENTER);
        dd[5] = new JLabel("Name", JLabel.CENTER);
        dd[6] = new JLabel("Roll Number", JLabel.CENTER);
        dd[7] = new JLabel("Branch", JLabel.CENTER);
        dd[8] = new JLabel("Year", JLabel.CENTER);
        dd[9] = new JLabel("Semester", JLabel.CENTER);
        dd[10] = new JLabel("Name", JLabel.CENTER);
        dd[11] = new JLabel("Roll Number", JLabel.CENTER);
        dd[12] = new JLabel("Branch", JLabel.CENTER);
        dd[13] = new JLabel("Year", JLabel.CENTER);
        dd[14] = new JLabel("Semester", JLabel.CENTER);

        dt = new JLabel[15];
        dt[0] = new JLabel("Pranab Pal", JLabel.CENTER);
        dt[1] = new JLabel("65", JLabel.CENTER);
        dt[2] = new JLabel("CSE", JLabel.CENTER);
        dt[3] = new JLabel("3rd", JLabel.CENTER);
        dt[4] = new JLabel("5th", JLabel.CENTER);
        dt[5] = new JLabel("Sayandeep Barai", JLabel.CENTER);
        dt[6] = new JLabel("94", JLabel.CENTER);
        dt[7] = new JLabel("CSE", JLabel.CENTER);
        dt[8] = new JLabel("3rd", JLabel.CENTER);
        dt[9] = new JLabel("5th", JLabel.CENTER);
        dt[10] = new JLabel("Tathagata Bandyopadhyay", JLabel.CENTER);
        dt[11] = new JLabel("120", JLabel.CENTER);
        dt[12] = new JLabel("CSE", JLabel.CENTER);
        dt[13] = new JLabel("3rd", JLabel.CENTER);
        dt[14] = new JLabel("5th", JLabel.CENTER);
    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new GridLayout(1, 3, 20, 0));

        p1.setLayout(new BorderLayout(0, 0));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new GridLayout(1, 1));
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        q1.setLayout(new BorderLayout(0, 0));
        q2.setLayout(new BorderLayout(0, 0));
        q3.setLayout(new BorderLayout(0, 0));

        pt[0].setLayout(new GridLayout(1, 1));
        pt[2].setLayout(new GridLayout(1, 1));
        pt[4].setLayout(new GridLayout(1, 1));
        pt[1].setLayout(new BorderLayout(15, 0));
        pt[3].setLayout(new BorderLayout(15, 0));
        pt[5].setLayout(new BorderLayout(15, 0));
        pt[6].setLayout(new GridLayout(5, 1, 10, 20));
        pt[7].setLayout(new GridLayout(5, 1, 10, 20));
        pt[8].setLayout(new GridLayout(5, 1, 10, 20));
        pt[9].setLayout(new GridLayout(5, 1, 10, 20));
        pt[10].setLayout(new GridLayout(5, 1, 10, 20));
        pt[11].setLayout(new GridLayout(5, 1, 10, 20));

        p[6].add(q1);
        p[6].add(q2);
        p[6].add(q3);

        q1.add(pt[0], BorderLayout.NORTH);
        q1.add(pt[1], BorderLayout.CENTER);
        q2.add(pt[2], BorderLayout.NORTH);
        q2.add(pt[3], BorderLayout.CENTER);
        q3.add(pt[4], BorderLayout.NORTH);
        q3.add(pt[5], BorderLayout.CENTER);

        pt[0].add(im1);
        pt[2].add(im2);
        pt[4].add(im3);

        pt[1].add(pt[6], BorderLayout.WEST);
        pt[1].add(pt[7], BorderLayout.CENTER);

        pt[3].add(pt[8], BorderLayout.WEST);
        pt[3].add(pt[9], BorderLayout.CENTER);

        pt[5].add(pt[10], BorderLayout.WEST);
        pt[5].add(pt[11], BorderLayout.CENTER);

        for (int i = 0; i < dd.length; i++) {
            if (i < 5) {
                pt[6].add(dd[i]);
                pt[7].add(dt[i]);
            } else if (i < 10) {
                pt[8].add(dd[i]);
                pt[9].add(dt[i]);
            } else {
                pt[10].add(dd[i]);
                pt[11].add(dt[i]);
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
        p1.add(p3, BorderLayout.WEST);
        p1.add(p4, BorderLayout.EAST);
        p1.add(p5, BorderLayout.CENTER);
        p3.add(back);
        p4.add(logout);
        p5.add(exit);

        p[4].add(p[5], BorderLayout.NORTH);
        p[4].add(p[6], BorderLayout.CENTER);
        p[5].add(htext);

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
        Color color1 = new Color(45, 52, 54);
        p[6].setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, color));
        q1.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color1));
        q2.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color1));
        q3.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color1));
        pt[1].setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color));
        pt[3].setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color));
        pt[5].setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color));
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
        p1.setBackground(co1);
        // p2.setBackground(new Color(45, 52, 54));
        p3.setBackground(co1);
        p5.setBackground(co1);
        logout.setBackground(new Color(34, 47, 62));
        exit.setBackground(new Color(34, 47, 62));
        back.setBackground(new Color(34, 47, 62));
        logout.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        Color color1 = new Color(19, 15, 64);
        q1.setBackground(color);
        q2.setBackground(color);
        q3.setBackground(color);

        for (int i = 0; i < pt.length; i++) {
            pt[i].setBackground(color);
        }
        for (int i = 0; i < dd.length; i++) {
            dd[i].setOpaque(true);
            dd[i].setBackground(Color.YELLOW);
            dd[i].setForeground(Color.BLACK);
        }
        Color wt = Color.WHITE;
        for (int i = 0; i < dt.length; i++) {
            dt[i].setOpaque(true);
            dt[i].setBackground(color1);
            dt[i].setForeground(wt);
        }
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

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        Font font = new Font("Tahoma", Font.BOLD, 15);
        for (int i = 0; i < dd.length; i++) {
            dd[i].setFont(font);
        }
        for (int i = 0; i < dt.length; i++) {
            dt[i].setFont(font);
        }
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
            }
        }
    }
}
