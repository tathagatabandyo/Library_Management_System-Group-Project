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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Admin_Forgot_Password extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, q1, q2;
    public JLabel hl, al[];
    public JPanel borderp, p1, p3, p4, p5;
    public JButton exit, back, search, re, cl;
    JTextField auser, aname, asecurity, asans, apass;
    JScrollPane ms;
    public Connection con = null;

    public Admin_Forgot_Password(String s) {
        super(s);
        // setSize(1080,780);
        setMinimumSize(new Dimension(1320, 790));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
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
        p[0].setPreferredSize(new Dimension(10, 70));
        p[1].setPreferredSize(new Dimension(10, 0));
        p[2].setPreferredSize(new Dimension(0, 10));
        p[3].setPreferredSize(new Dimension(0, 0));
        p[5].setPreferredSize(new Dimension(10, 40));

        hl = new JLabel("Admin Forgot Password", JLabel.CENTER);

        p1 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p3.setPreferredSize(new Dimension(155, 10));
        p4.setPreferredSize(new Dimension(130, 10));

        back = new JButton("Back", new ImageIcon(getClass().getResource("/photo/back1.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel[3];
        for (int i = 0; i < q1.length; i++) {
            q1[i] = new JPanel();
        }
        q1[0].setPreferredSize(new Dimension(250, 10));
        q1[1].setPreferredSize(new Dimension(250, 10));

        q2 = new JPanel[7];
        for (int i = 0; i < q2.length; i++) {
            q2[i] = new JPanel();
            q2[i].setBackground(new Color(41, 128, 185));
        }
        for (int i = 0; i < q1.length; i++) {
            q1[i].setBackground(new Color(41, 128, 185));
        }

        al = new JLabel[5];
        al[0] = new JLabel("Username", JLabel.CENTER);
        al[1] = new JLabel("Name", JLabel.CENTER);
        al[2] = new JLabel("Your Security Question", JLabel.CENTER);
        al[3] = new JLabel("Answer", JLabel.CENTER);
        al[4] = new JLabel("Password", JLabel.CENTER);

        auser = new JTextField();
        aname = new JTextField();
        asecurity = new JTextField();
        asans = new JTextField();
        apass = new JTextField();

        search = new JButton("Search");
        re = new JButton("Retrieve");
        cl = new JButton("Clear");

        search.setPreferredSize(new Dimension(140, 53));
        cl.setPreferredSize(new Dimension(140, 53));
        re.setPreferredSize(new Dimension(140, 53));

        clear(false);
    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new BorderLayout(0, 0));

        p1.setLayout(new BorderLayout(0, 0));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new GridLayout(1, 1));
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        q1[2].setLayout(new GridLayout(7, 1, 0, 30));

        q2[0].setLayout(new GridLayout(1, 2, 20, 0));
        q2[1].setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
        q2[2].setLayout(new GridLayout(1, 2, 20, 0));
        q2[3].setLayout(new GridLayout(1, 2, 20, 0));
        q2[4].setLayout(new GridLayout(1, 2, 20, 0));
        q2[5].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q2[6].setLayout(new GridLayout(1, 2, 20, 0));

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
        p4.add(exit);

        p[4].add(p[5], BorderLayout.NORTH);
        p[4].add(p[6], BorderLayout.CENTER);

        p[5].add(hl);

        p[6].add(q1[0], BorderLayout.WEST);
        p[6].add(q1[1], BorderLayout.EAST);
        p[6].add(q1[2], BorderLayout.CENTER);

        for (int i = 0; i < q2.length; i++) {
            q1[2].add(q2[i]);
        }

        q2[0].add(al[0]);
        q2[0].add(auser);

        q2[1].add(search);
        q2[1].add(cl);

        q2[2].add(al[1]);
        q2[2].add(aname);

        q2[3].add(al[2]);
        q2[3].add(asecurity);

        q2[4].add(al[3]);
        q2[4].add(asans);

        q2[5].add(re);

        q2[6].add(al[4]);
        q2[6].add(apass);

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
        q1[2].setBorder(BorderFactory.createMatteBorder(25, 0, 25, 0, new Color(41, 128, 185)));

        aname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        auser.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        asecurity.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        asans.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        apass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
    }

    // set_color
    public void set_color() {
        // getContentPane().setBackground(new Color(19, 15, 64));

        p[0].setBackground(new Color(19, 15, 64));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(new Color(48, 51, 107));

        hl.setForeground(Color.WHITE);

        Color co1 = new Color(211, 84, 0);
        p1.setBackground(co1);
        p3.setBackground(co1);
        p5.setBackground(co1);
        exit.setBackground(new Color(34, 47, 62));
        back.setBackground(new Color(34, 47, 62));
        exit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        for (int i = 0; i < al.length; i++) {
            al[i].setOpaque(true);
            ;
            al[i].setBackground(Color.YELLOW);
        }
        Color col = new Color(19, 15, 64);
        auser.setBackground(col);
        aname.setBackground(col);
        asecurity.setBackground(col);
        asans.setBackground(col);
        apass.setBackground(col);

        aname.setForeground(Color.WHITE);
        auser.setForeground(Color.WHITE);
        asans.setForeground(Color.WHITE);
        asecurity.setForeground(Color.WHITE);
        apass.setForeground(Color.WHITE);

        aname.setCaretColor(Color.WHITE);
        auser.setCaretColor(Color.WHITE);
        asecurity.setCaretColor(Color.WHITE);
        asans.setCaretColor(Color.WHITE);
        apass.setCaretColor(Color.WHITE);

        aname.setHorizontalAlignment(JTextField.CENTER);
        auser.setHorizontalAlignment(JTextField.CENTER);
        asecurity.setHorizontalAlignment(JTextField.CENTER);
        asans.setHorizontalAlignment(JTextField.CENTER);
        apass.setHorizontalAlignment(JTextField.CENTER);

        search.setFocusable(false);
        cl.setFocusable(false);
        re.setFocusable(false);

        search.setBackground(Color.YELLOW);
        search.setForeground(new Color(19, 15, 64));

        cl.setBackground(Color.YELLOW);
        cl.setForeground(new Color(19, 15, 64));

        re.setBackground(Color.YELLOW);
        re.setForeground(new Color(19, 15, 64));
    }

    // set_font_and_Cursor
    public void set_font_and_Cursor() {
        Font af = new Font("Tahoma", Font.BOLD, 16);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        hl.setFont(af);
        exit.setFont(af);
        back.setFont(af);

        exit.setCursor(cursor);
        back.setCursor(cursor);
        search.setCursor(cursor);
        cl.setCursor(cursor);
        re.setCursor(cursor);

        exit.setFocusable(false);
        back.setFocusable(false);
        cl.setFocusable(false);

        Font font = new Font("Tahoma", Font.BOLD, 22);

        aname.setFont(font);
        auser.setFont(font);
        asecurity.setFont(font);
        asans.setFont(font);
        apass.setFont(font);
        search.setFont(font);
        cl.setFont(font);
        re.setFont(font);

        auser.requestFocus();

        for (int i = 0; i < al.length; i++) {
            al[i].setFont(font);
        }

    }

    public void clear(boolean va) {
        for (int i = 1; i < al.length; i++) {
            al[i].setVisible(va);
        }
        aname.setVisible(va);
        asecurity.setVisible(va);
        asans.setVisible(va);
        apass.setVisible(va);
        re.setVisible(va);
    }

    public void create_ActionListener() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                System.exit(0);
            }
        });
        back.addActionListener(new Add_Action());
        back.addMouseListener(new Add_Action());
        exit.addMouseListener(new Add_Action());
        search.addActionListener(new Add_Action());
        search.addMouseListener(new Add_Action());
        cl.addActionListener(new Add_Action());
        cl.addMouseListener(new Add_Action());
        re.addActionListener(new Add_Action());
        re.addMouseListener(new Add_Action());
    }

    class Add_Action implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            con = EstablishConection.getEstblishConnection();
            if (con != null) {
                if (e.getSource() == back) {
                    dispose();
                    new Main("Library Management System").setVisible(true);
                } else if (e.getSource() == search) {
                    String user = auser.getText().trim();
                    if (user.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        String q = "SELECT name,security_question FROM admin WHERE username=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                boolean va = true;
                                for (int i = 1; i < al.length - 1; i++) {
                                    al[i].setVisible(va);
                                }
                                aname.setVisible(va);
                                asecurity.setVisible(va);
                                asans.setVisible(va);
                                re.setVisible(va);
                                aname.setText(rs.getString(1));
                                asecurity.setText(rs.getString(2));
                                asans.requestFocus();
                                auser.setEditable(false);
                                aname.setEditable(false);
                                asecurity.setEditable(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "This Username is Invalid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == cl) {
                    auser.setText("");
                    aname.setText("");
                    asecurity.setText("");
                    apass.setText("");
                    asans.setText("");
                    clear(false);
                    asans.setEditable(true);
                    auser.setEditable(true);
                    auser.requestFocus();

                } else if (e.getSource() == re) {
                    String user = auser.getText().trim();
                    String securitya = asecurity.getText().trim();
                    String sans = asans.getText().trim();
                    if (sans.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Security Answer", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        String q = "SELECT password FROM admin WHERE username=? && security_question=? && answer=?";

                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user);
                            ps.setString(2, securitya);
                            ps.setString(3, sans);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                asans.setEditable(false);
                                al[4].setVisible(true);
                                apass.setVisible(true);
                                apass.setText(rs.getString(1));
                                apass.setEditable(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Security answer not match", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == exit) {
                exit.setBackground(Color.ORANGE);
                exit.setForeground(new Color(34, 47, 62));
            } else if (e.getSource() == back) {
                back.setBackground(Color.ORANGE);
                back.setForeground(new Color(34, 47, 62));
            } else if (e.getSource() == search) {
                search.setBackground(Color.WHITE);
            } else if (e.getSource() == cl) {
                cl.setBackground(Color.WHITE);
            } else if (e.getSource() == re) {
                re.setBackground(Color.WHITE);
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
            if (e.getSource() == exit) {
                exit.setBackground(new Color(34, 47, 62));
                exit.setForeground(Color.WHITE);
            } else if (e.getSource() == back) {
                back.setBackground(new Color(34, 47, 62));
                back.setForeground(Color.WHITE);
            } else if (e.getSource() == search) {
                search.setBackground(Color.YELLOW);
            } else if (e.getSource() == cl) {
                cl.setBackground(Color.YELLOW);
            } else if (e.getSource() == re) {
                re.setBackground(Color.YELLOW);
            }
        }
    }
}
