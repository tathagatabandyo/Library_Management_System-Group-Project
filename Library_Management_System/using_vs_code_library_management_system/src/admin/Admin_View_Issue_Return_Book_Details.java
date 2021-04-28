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

public class Admin_View_Issue_Return_Book_Details extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, pp;
    public JButton[] bp;
    public JPanel borderp, p1, p2, p3, p4, p5;
    public JLabel weltext;
    JButton logout, exit, back;
    JTable table1, table2;
    DefaultTableModel model1, model2;
    JScrollPane js, js1,ms;
    Connection con = null;
    String user = "";
    String name = "";

    public Admin_View_Issue_Return_Book_Details(String s, Connection con, String name, String user) {
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

        bp = new JButton[2];
        bp[0] = new JButton("Issue Book Details");
        bp[1] = new JButton("Return Book Details");

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
        p4.setPreferredSize(new Dimension(130, 10));

        back = new JButton("Back", new ImageIcon(getClass().getResource("/photo/back1.png")));
        weltext = new JLabel("Admin View Issue and Return Book Details", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        String[] col1 = { "Book ID", "Book Name", "Book Author Name", "Student Roll No.", "Student Name", "Course",
                "Branch", "Year", "semester", "Date of Issue Book", "Date of Return Book" };
        String[] col2 = { "Book ID", "Book Name", "Book Author Name", "Student Roll No.", "Student Name", "Course",
                "Branch", "Year", "semester", "Date of Issue Book", "Date of Return Book", "Date Submit Book",
                "Total Late Day", "Late Fine" };
        // table1
        model1 = new DefaultTableModel(col1, 0);
        table1 = new JTable(model1);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(30);
        // cell alignment
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        js = new JScrollPane(table1);
        // table2
        model2 = new DefaultTableModel(col2, 0);
        table2 = new JTable(model2);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.setRowHeight(30);
        // cell alignment
        renderer = (DefaultTableCellRenderer) table2.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        js1 = new JScrollPane(table2);

        table1.setGridColor(Color.WHITE);
        table2.setGridColor(Color.WHITE);

        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(130);
        columnModel.getColumn(4).setPreferredWidth(140);

        columnModel = table2.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(180);
        columnModel.getColumn(9).setPreferredWidth(130);
        columnModel.getColumn(10).setPreferredWidth(130);
        columnModel.getColumn(11).setPreferredWidth(130);
        columnModel.getColumn(12).setPreferredWidth(100);

        issue_book_data_show();
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
            pp[i].setLayout(new GridLayout(1, 1));
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

        pp[0].add(js);
        pp[1].add(js1);

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
        pp[0].setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color));
        pp[1].setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, color));
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
        Color color = new Color(41, 128, 185);
        for (int i = 0; i < bp.length; i++) {
            bp[i].setForeground(Color.WHITE);
            pp[i].setBackground(color);
        }
        // pp[0].setBackground(Color.RED);
        // pp[1].setBackground(Color.BLACK);

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
        table1.setBackground(color1);
        table1.setForeground(Color.WHITE);
        table2.setBackground(color1);
        table2.setForeground(Color.WHITE);
        table1.getTableHeader().setBackground(new Color(45, 52, 54));
        table1.getTableHeader().setForeground(Color.WHITE);
        table2.getTableHeader().setBackground(new Color(45, 52, 54));
        table2.getTableHeader().setForeground(Color.WHITE);

        js.getViewport().setBackground(color);
        js.setBorder(BorderFactory.createEmptyBorder());
        js1.getViewport().setBackground(color);
        js1.setBorder(BorderFactory.createEmptyBorder());
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
                issue_book_data_show();
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
                    if (model2.getRowCount() != 0) {
                        int no = model2.getRowCount();
                        for (int i = 1; i <= no; i++) {
                            model2.removeRow(0);
                        }
                    }
                    try {
                        String q = "SELECT book_id,book_name,book_author,student_roll_no,std_name,course,branch,year,semester,issue_date,return_date,submit_date,total_late_day,late_fine From return_book";
                        PreparedStatement ps = con.prepareStatement(q);
                        ResultSet rs = ps.executeQuery();
                        String[] row = new String[14];
                        while (rs.next()) {
                            row[0] = rs.getString(1);
                            row[1] = rs.getString(2);
                            row[2] = rs.getString(3);
                            row[3] = rs.getString(4);
                            row[4] = rs.getString(5);
                            row[5] = rs.getString(6);
                            row[6] = rs.getString(7);
                            row[7] = rs.getString(8);
                            row[8] = rs.getString(9);
                            row[9] = rs.getString(10);
                            row[10] = rs.getString(11);
                            row[11] = rs.getString(12);
                            row[12] = rs.getString(13);
                            row[13] = "₹" + rs.getString(14);

                            model2.addRow(row);
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Database not connected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void issue_book_data_show() {
        if (con != null && EstablishConection.getEstblishConnection() != null) {
            if (model1.getRowCount() != 0) {
                int no = model1.getRowCount();
                for (int i = 1; i <= no; i++) {
                    model1.removeRow(0);
                }
            }
            try {
                String q = "SELECT book_id,book_name,book_author,student_roll_no,std_name,course,branch,year,semester,issue_book_date,return_book_date From issue_book";
                PreparedStatement ps = con.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                String[] row = new String[11];
                while (rs.next()) {
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    row[4] = rs.getString(5);
                    row[5] = rs.getString(6);
                    row[6] = rs.getString(7);
                    row[7] = rs.getString(8);
                    row[8] = rs.getString(9);
                    row[9] = rs.getString(10);
                    row[10] = rs.getString(11);

                    model1.addRow(row);
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

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);

        Font font1 = new Font("Tahoma", Font.BOLD, 12);
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
