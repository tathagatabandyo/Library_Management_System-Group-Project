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

import Main.EstablishConection;
import Main.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import java.sql.Statement;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Manage_Admin extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, pp, q1, q2;
    public JButton[] bp;
    public JLabel[] cl;
    public JPanel borderp, p1, p2, p3, p4, p5, cp1, bp1, gen, searchp, searchp1, searchp2, deletep, r1;
    JLabel searchl;
    JTextField aname, auser, aemail, aphone, asans, searcht;
    JPasswordField pass1;
    ButtonGroup bgroup;
    JRadioButton m, f;
    String ques = "";
    JComboBox<String> combobox;
    public JLabel weltext;
    JButton logout, exit, back, crad, searchb, deleteb;
    JTable table1, table2;
    DefaultTableModel model1, model2;
    JScrollPane js, js1,ms;
    Connection con = null;
    String user = "";
    String name = "";

    public Manage_Admin(String s, Connection con, String name, String user) {
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

        bp = new JButton[3];
        bp[0] = new JButton("Add New Admin");
        bp[1] = new JButton("View Admin List");
        bp[2] = new JButton("Delete Admin");

        pp = new JPanel[3];
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
        weltext = new JLabel("Manage Admin", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel[9];
        for (int i = 0; i < q1.length; i++) {
            q1[i] = new JPanel();
        }
        q1[0].setPreferredSize(new Dimension(250, 10));
        q1[1].setPreferredSize(new Dimension(250, 10));
        // q1[2].setPreferredSize(new Dimension(280, 10));
        q1[3].setPreferredSize(new Dimension(20, 10));
        q1[4].setPreferredSize(new Dimension(20, 10));
        // q1[5].setPreferredSize(new Dimension(100, 10));
        q1[6].setPreferredSize(new Dimension(20, 10));
        q1[7].setPreferredSize(new Dimension(20, 10));
        // q1[8].setPreferredSize(new Dimension(100, 10));

        cp1 = new JPanel();
        bp1 = new JPanel();
        bp1.setPreferredSize(new Dimension(10, 90));

        r1 = new JPanel();

        cl = new JLabel[8];
        cl[0] = new JLabel("Name", JLabel.CENTER);
        cl[1] = new JLabel("Username", JLabel.CENTER);
        cl[2] = new JLabel("Password", JLabel.CENTER);
        cl[3] = new JLabel("Gender", JLabel.CENTER);
        cl[4] = new JLabel("E-mail ID", JLabel.CENTER);
        cl[5] = new JLabel("Phone Number", JLabel.CENTER);
        cl[6] = new JLabel("Security Question", JLabel.CENTER);
        cl[7] = new JLabel("Answer", JLabel.CENTER);

        aname = new JTextField();
        auser = new JTextField();
        aemail = new JTextField();
        aphone = new JTextField();
        asans = new JTextField();
        pass1 = new JPasswordField();
        pass1.setEchoChar('*');

        gen = new JPanel();

        bgroup = new ButtonGroup();
        m = new JRadioButton("Male");
        f = new JRadioButton("Female");

        bgroup.add(m);
        bgroup.add(f);

        combobox = new JComboBox<>(new String[] { "Select Security Question", "Your Nick Name?", "Your Lucky Number?",
                "Your Childhood Name?", "Your Place of birth?" });

        crad = new JButton("Add Admin");
        crad.setPreferredSize(new Dimension(200, 48));

        String[] col = { "Name", "Username", "Gender", "Email ID", "Phone No." };
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

        searchl = new JLabel("Username", JLabel.CENTER);
        searcht = new JTextField();
        searchb = new JButton("Search");
        deleteb = new JButton("Delete Admin");
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
            pp[i].setLayout(new BorderLayout(0, 0));
        }
        q1[2].setLayout(new BorderLayout(0, 0));

        cp1.setLayout(new GridLayout(8, 2, 20, 15));
        gen.setLayout(new GridLayout(1, 2));
        bp1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        q1[5].setLayout(new GridLayout(1, 1));
        q1[8].setLayout(new BorderLayout(0, 0));
        searchp.setLayout(new GridLayout(2, 1));
        searchp1.setLayout(new BorderLayout(0, 0));
        searchp2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        deletep.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q2[2].setLayout(new GridLayout(1, 2, 20, 0));

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
        for (int i = 0; i < pp.length; i++) {
            pp[i].add(q1[j], BorderLayout.WEST);
            j++;
            pp[i].add(q1[j], BorderLayout.EAST);
            j++;
            pp[i].add(q1[j], BorderLayout.CENTER);
            j++;
        }

        q1[2].add(cp1, BorderLayout.CENTER);
        q1[2].add(bp1, BorderLayout.SOUTH);

        bp1.add(r1);
        r1.add(crad);

        cp1.add(cl[0]);
        cp1.add(aname);
        cp1.add(cl[1]);
        cp1.add(auser);
        cp1.add(cl[2]);
        cp1.add(pass1);
        cp1.add(cl[3]);
        cp1.add(gen);
        cp1.add(cl[4]);
        cp1.add(aemail);
        cp1.add(cl[5]);
        cp1.add(aphone);
        cp1.add(cl[6]);
        cp1.add(combobox);
        cp1.add(cl[7]);
        cp1.add(asans);

        gen.add(m);
        gen.add(f);

        q1[5].add(js);

        q1[8].add(searchp, BorderLayout.NORTH);
        q1[8].add(deletep, BorderLayout.SOUTH);
        q1[8].add(js1, BorderLayout.CENTER);
        searchp.add(searchp1);
        searchp.add(searchp2);

        searchp1.add(q2[0], BorderLayout.WEST);
        searchp1.add(q2[1], BorderLayout.EAST);
        searchp1.add(q2[2], BorderLayout.CENTER);

        q2[0].setPreferredSize(new Dimension(200, 70));
        q2[1].setPreferredSize(new Dimension(200, 70));

        searchb.setPreferredSize(new Dimension(140, 50));
        deleteb.setPreferredSize(new Dimension(200, 50));

        q2[2].add(searchl);
        q2[2].add(searcht);
        searchp2.add(searchb);
        deletep.add(deleteb);

        Color color = new Color(41, 128, 185);
        for (int i = 0; i < q1.length; i++) {
            q1[i].setBackground(color);
        }

        // q1[0].setBackground(Color.RED);
        // q1[1].setBackground(Color.cyan);
        // q1[2].setBackground(Color.BLACK);//2
        // q1[3].setBackground(Color.YELLOW);
        // q1[4].setBackground(Color.GRAY);
        // q1[5].setBackground(Color.GREEN);//5
        // q1[6].setBackground(Color.WHITE);
        // q1[7].setBackground(Color.lightGray);
        // q1[8].setBackground(Color.PINK);//8
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
        cp1.setBorder(BorderFactory.createMatteBorder(20, 0, 5, 0, color));
        bp1.setBorder(BorderFactory.createMatteBorder(12, 0, 20, 0, color));

        aname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        auser.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        pass1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        aemail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        aphone.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        asans.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));

        q1[5].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));
        q1[8].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));

        q2[0].setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        q2[1].setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        q2[2].setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        searchp2.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, color));
        deletep.setBorder(BorderFactory.createMatteBorder(20, 0, 0, 0, color));

        searcht.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));

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

        Color color1 = new Color(41, 128, 185);

        for (int i = 0; i < bp.length; i++) {
            bp[i].setForeground(Color.WHITE);
            pp[i].setBackground(color1);
        }
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

        cp1.setBackground(color1);
        bp1.setBackground(color1);

        Color color = new Color(19, 15, 64);
        aname.setBackground(color);
        auser.setBackground(color);
        pass1.setBackground(color);
        aemail.setBackground(color);
        aphone.setBackground(color);
        combobox.setBackground(color);
        asans.setBackground(color);
        m.setBackground(color);
        f.setBackground(color);
        searcht.setBackground(color);

        aname.setForeground(Color.WHITE);
        auser.setForeground(Color.WHITE);
        pass1.setForeground(Color.WHITE);
        aemail.setForeground(Color.WHITE);
        aphone.setForeground(Color.WHITE);
        combobox.setForeground(Color.WHITE);
        asans.setForeground(Color.WHITE);
        m.setForeground(Color.WHITE);
        f.setForeground(Color.WHITE);
        searcht.setForeground(Color.WHITE);

        aname.setCaretColor(Color.WHITE);
        auser.setCaretColor(Color.WHITE);
        pass1.setCaretColor(Color.WHITE);
        aemail.setCaretColor(Color.WHITE);
        aphone.setCaretColor(Color.WHITE);
        asans.setCaretColor(Color.WHITE);
        searcht.setCaretColor(Color.WHITE);

        aname.setHorizontalAlignment(JTextField.CENTER);
        auser.setHorizontalAlignment(JTextField.CENTER);
        pass1.setHorizontalAlignment(JTextField.CENTER);
        aemail.setHorizontalAlignment(JTextField.CENTER);
        aphone.setHorizontalAlignment(JTextField.CENTER);
        asans.setHorizontalAlignment(JTextField.CENTER);
        m.setHorizontalAlignment(JRadioButton.CENTER);
        f.setHorizontalAlignment(JRadioButton.CENTER);
        searcht.setHorizontalAlignment(JTextField.CENTER);
        m.setFocusable(false);
        f.setFocusable(false);
        crad.setFocusable(false);

        crad.setBackground(Color.YELLOW);
        r1.setBackground(new Color(30, 39, 46));
        crad.setForeground(Color.BLACK);

        searchb.setBackground(Color.YELLOW);
        searchb.setForeground(new Color(19, 15, 64));

        deleteb.setBackground(Color.YELLOW);
        deleteb.setForeground(new Color(19, 15, 64));

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        combobox.setRenderer(listRenderer);

        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }
        searchl.setOpaque(true);
        searchl.setBackground(Color.YELLOW);

        table1.setBackground(color);
        table1.setForeground(Color.WHITE);
        table2.setBackground(color);
        table2.setForeground(Color.WHITE);
        table1.getTableHeader().setBackground(new Color(45, 52, 54));
        table1.getTableHeader().setForeground(Color.WHITE);
        table2.getTableHeader().setBackground(new Color(45, 52, 54));
        table2.getTableHeader().setForeground(Color.WHITE);

        js.getViewport().setBackground(color1);
        js.setBorder(BorderFactory.createEmptyBorder());
        js1.getViewport().setBackground(color);
        js1.setBorder(BorderFactory.createEmptyBorder());

        table1.setGridColor(Color.WHITE);
        table2.setGridColor(Color.WHITE);

        for (int i = 0; i < q2.length; i++) {
            q2[i].setBackground(color1);
        }
        searchp2.setBackground(color1);
        deletep.setBackground(color1);

        aname.requestFocus();
    }

    public void hide() {
        for (int i = 0; i < pp.length; i++) {
            pp[i].setVisible(false);
            p[6].remove(pp[i]);
            aname.setText("");
            auser.setText("");
            pass1.setText("");
            m.setSelected(false);
            f.setSelected(false);
            aemail.setText("");
            combobox.setSelectedIndex(0);
            asans.setText("");
            searcht.setText("");
            if (model2.getRowCount() != 0) {
                model2.removeRow(0);
            }
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
                aname.requestFocus();
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

                if (con != null && EstablishConection.getEstblishConnection() != null) {
                    if (model1.getRowCount() != 0) {
                        int no = model1.getRowCount();
                        for (int i = 1; i <= no; i++) {
                            model1.removeRow(0);
                        }
                    }
                    try {
                        String q = "SELECT name,username,gender,email_id,phone_no FROM admin";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(q);
                        String[] row = new String[5];
                        while (rs.next()) {
                            row[0] = rs.getString(1);
                            row[1] = rs.getString(2);
                            row[2] = rs.getString(3);
                            row[3] = rs.getString(4);
                            row[4] = rs.getString(5);
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
                searcht.requestFocus();
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
        crad.setCursor(cursor);
        searchb.setCursor(cursor);
        deleteb.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        searchb.setFocusable(false);
        deleteb.setFocusable(false);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        for (int i = 0; i < cl.length; i++) {
            cl[i].setFont(font);
        }
        aname.setFont(font);
        auser.setFont(font);
        pass1.setFont(font);
        aemail.setFont(font);
        aphone.setFont(font);
        combobox.setFont(font);
        asans.setFont(font);
        m.setFont(font);
        f.setFont(font);
        crad.setFont(font);
        searchl.setFont(font);
        searcht.setFont(font);
        searchb.setFont(font);
        deleteb.setFont(font);

        Font font1 = new Font("Tahoma", Font.BOLD, 18);
        table1.setFont(font1);
        table2.setFont(font1);
        table1.getTableHeader().setFont(font1);
        table2.getTableHeader().setFont(font1);
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
        crad.addMouseListener(new Add_Action());
        crad.addActionListener(new Add_Action());
        searchb.addActionListener(new Add_Action());
        searchb.addMouseListener(new Add_Action());
        deleteb.addActionListener(new Add_Action());
        deleteb.addMouseListener(new Add_Action());

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
                } else if (e.getSource() == crad) {
                    String name = aname.getText().trim();
                    String user1 = auser.getText().trim();
                    String pass = String.valueOf(pass1.getPassword()).trim();
                    String gender = "";
                    if (m.isSelected()) {
                        gender = "Male";
                    } else if (f.isSelected()) {
                        gender = "Female";
                    }
                    String email = aemail.getText().trim();
                    String phone = aphone.getText().trim();
                    String securityq = String.valueOf(combobox.getSelectedItem()).trim();
                    String sans = asans.getText().trim();
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
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Name", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (name.length() < 4 || name.length() > 30) {
                        JOptionPane.showMessageDialog(null, "Sorry, name must be between 4 and 30 characters long.",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (user1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (user1.length() < 6 || user1.length() > 20) {
                        JOptionPane.showMessageDialog(null, "Sorry, username must be between 6 and 20 characters long.",
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
                    } else if (securityq.equals("Select Security Question")) {
                        JOptionPane.showMessageDialog(null, "Select Security Question", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (sans.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Security Answer", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT username From admin WHERE username=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                JOptionPane.showMessageDialog(null, "That username is taken. Try another.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                q = "INSERT INTO admin(name,username,password,gender,email_id,phone_no,security_question,answer) VALUES(?,?,?,?,?,?,?,?)";
                                ps = con.prepareStatement(q);
                                ps.setString(1, name);
                                ps.setString(2, user1);
                                ps.setString(3, pass);
                                ps.setString(4, gender);
                                ps.setString(5, email);
                                ps.setString(6, phone);
                                ps.setString(7, securityq);
                                ps.setString(8, sans);

                                ps.executeUpdate();

                                aname.setText("");
                                auser.setText("");
                                pass1.setText("");
                                if (m.isSelected()) {
                                    m.setSelected(false);
                                } else if (f.isSelected()) {
                                    f.setSelected(false);
                                }
                                aemail.setText("");
                                aphone.setText("");
                                combobox.setSelectedIndex(0);
                                asans.setText("");
                                aname.requestFocus();

                                JOptionPane.showMessageDialog(null, "Admin add Successful", "Information",
                                        JOptionPane.INFORMATION_MESSAGE);

                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == searchb) {
                    String user1 = searcht.getText().trim();
                    if (user1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (model2.getRowCount() != 0) {
                            model2.removeRow(0);
                        }
                        String q = "SELECT name,username,gender,email_id,phone_no FROM admin WHERE username=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String[] row = new String[5];
                                row[0] = rs.getString(1);
                                row[1] = rs.getString(2);
                                row[2] = rs.getString(3);
                                row[3] = rs.getString(4);
                                row[4] = rs.getString(5);
                                model2.addRow(row);
                            } else {
                                JOptionPane.showMessageDialog(null, "This Username is Invalid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }

                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == deleteb) {
                    String user1 = searcht.getText().trim();
                    if (user1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Username then Search", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (model2.getRowCount() != 0) {
                            model2.removeRow(0);
                        }
                        try {
                            String q = "SELECT username FROM admin WHERE username=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, user1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                q = "DELETE FROM admin WHERE username=?";
                                PreparedStatement ps1 = con.prepareStatement(q);
                                ps1.setString(1, user1);
                                ps1.executeUpdate();

                                searcht.setText("");
                                if (model2.getRowCount() != 0) {
                                    model2.removeRow(0);
                                }

                                if (user.equals(user1)) {
                                    if (con != null) {
                                        try {
                                            con.close();
                                        } catch (SQLException e1) {
                                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",
                                                    JOptionPane.ERROR);
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null,
                                            "Your Account(Your Admin Account) Deleted Successful", "Information",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    dispose();
                                    new Main("Library Management System").setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Admin Deleted Successful", "Information",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This Username is Invalid", "WARNING",
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
            } else if (e.getSource() == crad) {
                crad.setBackground(new Color(30, 39, 46));
                r1.setBackground(Color.YELLOW);
                crad.setForeground(Color.WHITE);
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.WHITE);
            } else if (e.getSource() == deleteb) {
                deleteb.setBackground(Color.WHITE);
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
            } else if (e.getSource() == crad) {
                crad.setBackground(Color.YELLOW);
                r1.setBackground(new Color(30, 39, 46));
                crad.setForeground(Color.BLACK);
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.YELLOW);
            } else if (e.getSource() == deleteb) {
                deleteb.setBackground(Color.YELLOW);
            }
        }
    }
}
