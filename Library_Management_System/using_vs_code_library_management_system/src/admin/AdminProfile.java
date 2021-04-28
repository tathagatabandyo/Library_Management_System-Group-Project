package admin;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class AdminProfile extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p;
    public JPanel borderp, p1, p3, p4, p5, q1, q2;
    public JLabel htext, cl[];
    public JTextField[] te;
    public JPasswordField pass1;
    JButton logout, exit, back, update;
    Connection con = null;
    JScrollPane ms;
    String user = "";
    String name = "";

    public AdminProfile(String s, Connection con, String name, String user) {
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
        get_profile_date();
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
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p3.setPreferredSize(new Dimension(155, 10));
        p4.setPreferredSize(new Dimension(155, 10));

        back = new JButton("Back", new ImageIcon(getClass().getResource("/photo/back1.png")));
        htext = new JLabel(name + " Profile Details & Update Profile", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel();
        q2 = new JPanel();

        q1.setPreferredSize(new Dimension(10, 50));

        cl = new JLabel[8];
        cl[0] = new JLabel("Username", JLabel.CENTER);
        cl[1] = new JLabel("Name", JLabel.CENTER);
        cl[2] = new JLabel("Password", JLabel.CENTER);
        cl[3] = new JLabel("Gender", JLabel.CENTER);
        cl[4] = new JLabel("E-mail ID", JLabel.CENTER);
        cl[5] = new JLabel("Phone Number", JLabel.CENTER);
        cl[6] = new JLabel("Security Question", JLabel.CENTER);
        cl[7] = new JLabel("Answer", JLabel.CENTER);

        te = new JTextField[7];
        for (int i = 0; i < te.length; i++) {
            te[i] = new JTextField();
        }
        pass1 = new JPasswordField();
        pass1.setEchoChar('*');
        update = new JButton("Update Profile");
        update.setPreferredSize(new Dimension(200, 50));

        te[0].setEditable(false);
        te[2].setEditable(false);
        te[5].setEditable(false);
    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 1, 0, 0));
        p[6].setLayout(new BorderLayout(0, 20));

        p1.setLayout(new BorderLayout(0, 0));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new GridLayout(1, 1));
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        q1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q2.setLayout(new GridLayout(8, 2, 15, 15));
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

        p[6].add(q1, BorderLayout.SOUTH);
        p[6].add(q2, BorderLayout.CENTER);

        q1.add(update);

        q2.add(cl[0]);
        q2.add(te[0]);
        q2.add(cl[1]);
        q2.add(te[1]);
        q2.add(cl[2]);
        q2.add(pass1);
        q2.add(cl[3]);
        q2.add(te[2]);
        q2.add(cl[4]);
        q2.add(te[3]);
        q2.add(cl[5]);
        q2.add(te[4]);
        q2.add(cl[6]);
        q2.add(te[5]);
        q2.add(cl[7]);
        q2.add(te[6]);

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
        p[6].setBorder(BorderFactory.createMatteBorder(20, 245, 20, 245, new Color(41, 128, 185)));
        te[0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        te[1].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        te[2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        te[3].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        te[4].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        te[5].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        te[6].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        pass1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));

    }

    // set_color
    public void set_color() {
        getContentPane().setBackground(new Color(19, 15, 64));

        Color color1 = new Color(41, 128, 185);

        p[0].setBackground(new Color(19, 15, 64));
        p[4].setBackground(new Color(245, 246, 250));
        p[5].setBackground(new Color(45, 52, 54));
        p[6].setBackground(color1);
        q1.setBackground(color1);
        q2.setBackground(color1);

        htext.setForeground(Color.WHITE);
        Color co1 = new Color(211, 84, 0);
        p1.setBackground(co1);
        p3.setBackground(co1);
        p5.setBackground(co1);
        logout.setBackground(new Color(34, 47, 62));
        exit.setBackground(new Color(34, 47, 62));
        back.setBackground(new Color(34, 47, 62));
        logout.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        Color color = new Color(19, 15, 64);
        Color wt = Color.WHITE;
        pass1.setBackground(color);
        pass1.setForeground(wt);
        pass1.setCaretColor(wt);
        pass1.setHorizontalAlignment(JPasswordField.CENTER);
        for (int i = 0; i < te.length; i++) {
            te[i].setBackground(color);
            te[i].setForeground(wt);
            te[i].setCaretColor(wt);
            te[i].setHorizontalAlignment(JTextField.CENTER);
        }
        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }

        update.setFocusable(false);
        update.setBackground(Color.YELLOW);
        update.setForeground(color);

    }

    public void get_profile_date() {
        if (con != null && EstablishConection.getEstblishConnection() != null) {
            try {
                String q = "SELECT name,password,gender,email_id,phone_no,security_question FROM admin WHERE username=?";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    te[0].setText(user);
                    te[1].setText(rs.getString(1));
                    pass1.setText(rs.getString(2));
                    te[2].setText(rs.getString(3));
                    te[3].setText(rs.getString(4));
                    te[4].setText(rs.getString(5));
                    te[5].setText(rs.getString(6));

                    te[1].requestFocus();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // set_font_and_Cursor
    public void set_font_and_Cursor() {
        Font af = new Font("Tahoma", Font.BOLD, 16);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        htext.setFont(new Font("Tahoma", Font.BOLD, 18));
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
        pass1.setFont(font);
        update.setFont(font);
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
        update.addActionListener(new Add_Action());
        update.addMouseListener(new Add_Action());
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
                } else if (e.getSource() == update) {
                    String name1 = te[1].getText().trim();
                    String pass = String.valueOf(pass1.getPassword()).trim();
                    String email = te[3].getText().trim();
                    String phone = te[4].getText().trim();
                    String securityq = te[5].getText().trim();
                    String sans = te[6].getText().trim();
                    boolean ph = false, em = false;
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

                    if (name1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Name", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (name1.length() < 4 || name1.length() > 30) {
                        JOptionPane.showMessageDialog(null, "Sorry, name must be between 4 and 30 characters long.",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Password", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (pass.length() < 6 || phone.length() > 15) {
                        JOptionPane.showMessageDialog(null,
                                " Sorry, Password must be between 6 and 15 characters long.", "WARNING",
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
                    } else if (phone.length() <= 9 || phone.length() > 10) {
                        JOptionPane.showMessageDialog(null, "phone number must be 10 digits", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (phone.startsWith("0") || phone.startsWith("1") || phone.startsWith("2")
                            || phone.startsWith("3") || phone.startsWith("4") || phone.startsWith("5")) {
                        JOptionPane.showMessageDialog(null, "phone Number not valid", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (sans.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Security Answer", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT name FROM admin WHERE username=? && security_question=? && answer=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user);
                            ps.setString(2, securityq);
                            ps.setString(3, sans);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                q = "UPDATE admin SET name=?,password=?,email_id=?,phone_no=? WHERE username=?";
                                ps = con.prepareStatement(q);
                                ps.setString(1, name1);
                                ps.setString(2, pass);
                                ps.setString(3, email);
                                ps.setString(4, phone);
                                ps.setString(5, user);

                                ps.executeUpdate();

                                JOptionPane.showMessageDialog(null, te[1].getText() + " Profile Update Successful",
                                        "Information", JOptionPane.INFORMATION_MESSAGE);
                                htext.setText(name1 + " Profile Details & Update Profile");
                                te[6].setText("");
                                name = name1;
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
