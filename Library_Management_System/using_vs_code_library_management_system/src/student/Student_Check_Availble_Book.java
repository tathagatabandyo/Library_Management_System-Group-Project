package student;

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

public class Student_Check_Availble_Book extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p;
    public JPanel borderp, p1, p3, p4, p5;
    public JLabel htext;
    JButton logout, exit, back;
    JTable table1;
    DefaultTableModel model1;
    JScrollPane js,ms;
    Connection con = null;
    String user = "";
    String name = "";

    public Student_Check_Availble_Book(String s, Connection con, String name, String user) {
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
        check_Availble_Book();
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
        htext = new JLabel("Check Availble Book in Library", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        String[] col = { "Book Id", "Book Name", "Book Author Name", "Book Edition", "book Publication Name" };
        // table1
        model1 = new DefaultTableModel(col, 0);
        table1 = new JTable(model1);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(30);
        // cell alignment
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        js = new JScrollPane(table1);

    }

    // set_Layout
    public void set_Layout() {
        borderp.setLayout(new BorderLayout(0, 0));
        p[0].setLayout(new GridLayout(1, 1, 0, 0));
        p[4].setLayout(new BorderLayout(0, 0));
        p[5].setLayout(new GridLayout(1, 1, 0, 0));
        p[6].setLayout(new GridLayout(1, 1));

        p1.setLayout(new BorderLayout(0, 0));
        p3.setLayout(new GridLayout(1, 1));
        p4.setLayout(new GridLayout(1, 1));
        p5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

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
        p[6].add(js);

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
        p[6].setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(41, 128, 185)));
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
        p3.setBackground(co1);
        p5.setBackground(co1);
        logout.setBackground(new Color(34, 47, 62));
        exit.setBackground(new Color(34, 47, 62));
        back.setBackground(new Color(34, 47, 62));
        logout.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        table1.setBackground(new Color(19, 15, 64));
        table1.setForeground(Color.WHITE);
        table1.getTableHeader().setBackground(new Color(45, 52, 54));
        table1.getTableHeader().setForeground(Color.WHITE);

        js.getViewport().setBackground(color);
        js.setBorder(BorderFactory.createEmptyBorder());

        table1.setGridColor(Color.WHITE);
    }

    public void check_Availble_Book() {
        if (con != null && EstablishConection.getEstblishConnection() != null) {
            try {
                String q = "SELECT book_id,book_name,book_author,book_edition,book_publication FROM book WHERE avaible_book>?";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, "0");
                ResultSet rs = ps.executeQuery();
                String[] row = new String[5];
                while (rs.next()) {
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    row[4] = rs.getString(5);
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

        htext.setFont(new Font("Tahoma", Font.BOLD, 18));
        logout.setFont(af);
        exit.setFont(af);
        back.setFont(af);

        logout.setCursor(cursor);
        exit.setCursor(cursor);
        back.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);

        Font font1 = new Font("Tahoma", Font.BOLD, 16);
        table1.setFont(font1);
        table1.getTableHeader().setFont(font1);
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
                        Student_logout_Info.save_Logout_Info(con, name, user);
                        con.close();
                        dispose();
                        new Main("Library Management System").setVisible(true);
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                    }
                } else if (e.getSource() == back) {
                    dispose();
                    new StudentControl("Student Control", con, name, user).setVisible(true);
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
