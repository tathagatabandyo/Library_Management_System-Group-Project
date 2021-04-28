package admin;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Admin_Search_Book extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p;
    public JPanel borderp, p1, p2, p3, p4, q1, q2, q3, q4, v1, v2, v3, v4, v5, v6;
    public JLabel htext, searchl;
    JTextField searcht;
    JTable table1;
    DefaultTableModel model1;
    JScrollPane js,ms;
    JButton logout, exit, back, searchb, clear;
    Connection con = null;
    String user = "";
    String name = "";

    public Admin_Search_Book(String s, Connection con, String name, String user) {
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
        htext = new JLabel("Search Book", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel();
        q2 = new JPanel();
        q3 = new JPanel();
        q4 = new JPanel();

        v1 = new JPanel();
        v2 = new JPanel();
        v3 = new JPanel();
        v4 = new JPanel();
        v5 = new JPanel();
        v6 = new JPanel();

        q1.setPreferredSize(new Dimension(10, 140));

        String[] col = { "Book ID", "Book Name", "Book Author Name", "Book Edition", "Book Publication Name",
                "Quantity of Book", "Avaible Book", "No. of Issue Book", "No. of Return Book" };
        // table1
        model1 = new DefaultTableModel(col, 0);
        table1 = new JTable(model1);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(30);
        // cell alignment
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        js = new JScrollPane(table1);

        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(140);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(180);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);

        searchl = new JLabel("Book ID", JLabel.CENTER);
        searcht = new JTextField();
        searchb = new JButton("Search");
        clear = new JButton("Clear");
    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 3, 5, 0));
        p[6].setLayout(new BorderLayout(0, 20));

        p1.setLayout(new BorderLayout(0, 0));
        p2.setLayout(new GridLayout(1, 1));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q1.setLayout(new GridLayout(2, 1, 0, 20));
        q2.setLayout(new GridLayout(1, 1, 0, 0));
        q3.setLayout(new GridLayout(1, 4, 20, 0));
        q4.setLayout(new GridLayout(1, 6, 20, 0));

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

        p[6].add(q1, BorderLayout.NORTH);
        p[6].add(q2, BorderLayout.CENTER);

        q1.add(q3);
        q1.add(q4);
        q2.add(js);

        q3.add(v1);
        q3.add(searchl);
        q3.add(searcht);
        q3.add(v2);
        q4.add(v3);
        q4.add(v4);
        q4.add(searchb);
        q4.add(clear);
        q4.add(v5);
        q4.add(v6);

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
        p[6].setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, color));
        searcht.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
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

        v1.setBackground(color);
        v2.setBackground(color);
        v3.setBackground(color);
        v4.setBackground(color);
        v5.setBackground(color);
        v6.setBackground(color);

        Color color1 = new Color(19, 15, 64);
        searcht.setBackground(color1);

        Color wh = Color.WHITE;
        searcht.setForeground(wh);
        searcht.setCaretColor(wh);

        searcht.setHorizontalAlignment(JTextField.CENTER);

        searchb.setBackground(Color.YELLOW);
        searchb.setForeground(new Color(19, 15, 64));

        searchl.setOpaque(true);
        searchl.setBackground(Color.YELLOW);

        clear.setBackground(Color.YELLOW);
        clear.setForeground(new Color(19, 15, 64));

        table1.setBackground(new Color(19, 15, 64));
        table1.setForeground(Color.WHITE);
        table1.getTableHeader().setBackground(new Color(45, 52, 54));
        table1.getTableHeader().setForeground(Color.WHITE);

        js.getViewport().setBackground(color);
        js.setBorder(BorderFactory.createEmptyBorder());
        table1.setGridColor(Color.WHITE);
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
        searchb.setCursor(cursor);
        clear.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        searchb.setFocusable(false);
        clear.setFocusable(false);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        searchl.setFont(font);
        searcht.setFont(font);
        searchb.setFont(font);
        clear.setFont(font);

        Font font1 = new Font("Tahoma", Font.BOLD, 15);
        table1.setFont(font1);
        table1.getTableHeader().setFont(font1);

        js.setVisible(false);
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
        searchb.addActionListener(new Add_Action());
        searchb.addMouseListener(new Add_Action());
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
                } else if (e.getSource() == searchb) {
                    String bid1 = searcht.getText().trim();
                    if (bid1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (model1.getRowCount() != 0) {
                            model1.removeRow(0);
                        }
                        String q = "SELECT book_id,book_name,book_author,book_edition,book_publication,quantity_of_book,avaible_book,no_of_issue_book,no_of_return_book FROM book WHERE book_id=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String[] row = new String[9];
                                row[0] = rs.getString(1);
                                row[1] = rs.getString(2);
                                row[2] = rs.getString(3);
                                row[3] = rs.getString(4);
                                row[4] = rs.getString(5);
                                row[5] = rs.getString(6);
                                row[6] = rs.getString(7);
                                row[7] = rs.getString(8);
                                row[8] = rs.getString(9);
                                js.setVisible(true);
                                model1.addRow(row);
                            } else {
                                JOptionPane.showMessageDialog(null, "This book id is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                                js.setVisible(false);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == clear) {
                    searcht.setText("");
                    searcht.requestFocus();
                    js.setVisible(false);
                    if (model1.getRowCount() != 0) {
                        model1.removeRow(0);
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
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.WHITE);
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
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.YELLOW);
            } else if (e.getSource() == clear) {
                clear.setBackground(Color.YELLOW);
            }
        }
    }
}
