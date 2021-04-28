package librarian;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.sql.Statement;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Librarian_Manage_Book extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel[] p, pp, q1, q2, q3;
    public JButton[] bp;
    public JPanel borderp, p1, p2, p3, p4, p5, cp1, bp1, r1, searchp, searchp1, searchp2, deletep, v1, v2, v3, v4;
    public JLabel weltext, searchl, cl[], cl2[];
    JTextField bid, bname, bauthorn, bpubn, bquantity, searcht, bid2, bname2, bauthorn2, bpubn2, bquantity2;
    JComboBox<String> bedition, bedition2;
    JButton logout, exit, back, crb, searchb, deleteb, searchb2, updateb, clear;
    JTable table1, table2;
    DefaultTableModel model1, model2;
    JScrollPane js, js1,ms;
    Connection con = null;
    String user = "";
    String name = "";

    public Librarian_Manage_Book(String s, Connection con, String name, String user) {
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

        bp = new JButton[4];
        bp[0] = new JButton("Add New Book");
        bp[1] = new JButton("View Book List");
        bp[2] = new JButton("Edit Book");
        bp[3] = new JButton("Delete Book");

        pp = new JPanel[4];
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
        weltext = new JLabel("Manage Book", JLabel.CENTER);
        logout = new JButton("Logout", new ImageIcon(getClass().getResource("/photo/logout.png")));
        exit = new JButton("Exit", new ImageIcon(getClass().getResource("/photo/exit.png")));
        exit.setPreferredSize(new Dimension(140, 48));

        q1 = new JPanel[12];
        for (int i = 0; i < q1.length; i++) {
            q1[i] = new JPanel();
        }
        q1[0].setPreferredSize(new Dimension(230, 10));
        q1[1].setPreferredSize(new Dimension(230, 10));
        // q1[2].setPreferredSize(new Dimension(230,10));//2
        q1[3].setPreferredSize(new Dimension(20, 10));
        q1[4].setPreferredSize(new Dimension(20, 10));
        // q1[5].setPreferredSize(new Dimension(230,10));//5
        q1[6].setPreferredSize(new Dimension(230, 10));
        q1[7].setPreferredSize(new Dimension(230, 10));
        // q1[8].setPreferredSize(new Dimension(230,10));//8
        q1[9].setPreferredSize(new Dimension(20, 10));
        q1[10].setPreferredSize(new Dimension(20, 10));
        // q1[11].setPreferredSize(new Dimension(230,10));//11

        cp1 = new JPanel();
        bp1 = new JPanel();
        bp1.setPreferredSize(new Dimension(10, 90));

        r1 = new JPanel();
        crb = new JButton("Add Book");
        crb.setPreferredSize(new Dimension(200, 48));

        cl = new JLabel[6];
        cl[0] = new JLabel("Book ID", JLabel.CENTER);
        cl[1] = new JLabel("Book Name", JLabel.CENTER);
        cl[2] = new JLabel("Book Author Name", JLabel.CENTER);
        cl[3] = new JLabel("Book Edition", JLabel.CENTER);
        cl[4] = new JLabel("Book Publication Name", JLabel.CENTER);
        cl[5] = new JLabel("Quantity of Book", JLabel.CENTER);

        bid = new JTextField();
        bname = new JTextField();
        bauthorn = new JTextField();
        bpubn = new JTextField();
        bedition = new JComboBox<>(new String[] { "Select Book Edition", "1st", "2nd", "3rd", "4th", "5th", "6th",
                "7th", "8th", "9th", "10th" });
        bquantity = new JTextField();

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

        searchl = new JLabel("Book ID", JLabel.CENTER);
        searcht = new JTextField();
        searchb = new JButton("Search");
        deleteb = new JButton("Delete Book");

        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(140);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(180);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);

        columnModel = table2.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(140);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(180);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);

        q3 = new JPanel[8];
        for (int i = 0; i < q3.length; i++) {
            q3[i] = new JPanel();
        }

        v1 = new JPanel();
        v2 = new JPanel();
        v3 = new JPanel();
        v4 = new JPanel();

        cl2 = new JLabel[6];
        cl2[0] = new JLabel("Book ID", JLabel.CENTER);
        cl2[1] = new JLabel("Book Name", JLabel.CENTER);
        cl2[2] = new JLabel("Book Author Name", JLabel.CENTER);
        cl2[3] = new JLabel("Book Edition", JLabel.CENTER);
        cl2[4] = new JLabel("Book Publication Name", JLabel.CENTER);
        cl2[5] = new JLabel("Quantity of Book", JLabel.CENTER);

        bid2 = new JTextField();
        bname2 = new JTextField();
        bauthorn2 = new JTextField();
        bpubn2 = new JTextField();
        bedition2 = new JComboBox<>(new String[] { "Select Book Edition", "1st", "2nd", "3rd", "4th", "5th", "6th",
                "7th", "8th", "9th", "10th" });
        bquantity2 = new JTextField();

        searchb2 = new JButton("Search");
        updateb = new JButton("Update");
        clear = new JButton("Clear");
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
        cp1.setLayout(new GridLayout(6, 2, 20, 20));
        bp1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        q1[5].setLayout(new GridLayout(1, 1));
        q1[8].setLayout(new GridLayout(8, 1, 20, 20));
        q1[11].setLayout(new BorderLayout(0, 0));
        searchp.setLayout(new GridLayout(2, 1));
        searchp1.setLayout(new BorderLayout(0, 0));
        searchp2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        deletep.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        q2[2].setLayout(new GridLayout(1, 2, 20, 0));

        q3[0].setLayout(new GridLayout(1, 2, 20, 20));
        q3[1].setLayout(new GridLayout(1, 3, 100, 0));
        q3[2].setLayout(new GridLayout(1, 2, 20, 20));
        q3[3].setLayout(new GridLayout(1, 2, 20, 20));
        q3[4].setLayout(new GridLayout(1, 2, 20, 20));
        q3[5].setLayout(new GridLayout(1, 2, 20, 20));
        q3[6].setLayout(new GridLayout(1, 2, 20, 20));
        q3[7].setLayout(new GridLayout(1, 4, 20, 0));
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
        r1.add(crb);

        cp1.add(cl[0]);
        cp1.add(bid);
        cp1.add(cl[1]);
        cp1.add(bname);
        cp1.add(cl[2]);
        cp1.add(bauthorn);
        cp1.add(cl[3]);
        cp1.add(bedition);
        cp1.add(cl[4]);
        cp1.add(bpubn);
        cp1.add(cl[5]);
        cp1.add(bquantity);

        q1[5].add(js);

        q1[11].add(searchp, BorderLayout.NORTH);
        q1[11].add(deletep, BorderLayout.SOUTH);
        q1[11].add(js1, BorderLayout.CENTER);
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

        for (int i = 0; i < q3.length; i++) {
            q1[8].add(q3[i]);
        }

        q3[0].add(cl2[0]);
        q3[0].add(bid2);
        q3[1].add(v1);
        q3[1].add(searchb2);
        q3[1].add(v2);
        q3[2].add(cl2[1]);
        q3[2].add(bname2);
        q3[3].add(cl2[2]);
        q3[3].add(bauthorn2);
        q3[4].add(cl2[3]);
        q3[4].add(bedition2);
        q3[5].add(cl2[4]);
        q3[5].add(bpubn2);
        q3[6].add(cl2[5]);
        q3[6].add(bquantity2);
        q3[7].add(v3);
        q3[7].add(updateb);
        q3[7].add(clear);
        q3[7].add(v4);

        Color color = new Color(41, 128, 185);
        for (int i = 0; i < q1.length; i++) {
            q1[i].setBackground(color);
        }
        for (int i = 0; i < q3.length; i++) {
            q3[i].setBackground(color);
        }
        v1.setBackground(color);
        v2.setBackground(color);
        v3.setBackground(color);
        v4.setBackground(color);
        // q1[0].setBackground(Color.RED);
        // q1[1].setBackground(Color.cyan);
        // q1[2].setBackground(Color.BLACK);//2
        // q1[3].setBackground(Color.YELLOW);
        // q1[4].setBackground(Color.GRAY);
        // q1[5].setBackground(Color.GREEN);//5
        // q1[6].setBackground(Color.WHITE);
        // q1[7].setBackground(Color.lightGray);
        // q1[8].setBackground(Color.PINK);//8
        // q1[9].setBackground(Color.BLACK);
        // q1[10].setBackground(Color.lightGray);
        // q1[11].setBackground(Color.PINK);//11
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
        bid.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bauthorn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bpubn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bquantity.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bid2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bname2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bauthorn2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bpubn2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        bquantity2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));

        q1[5].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));
        q1[8].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));
        q1[11].setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0, color));

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

        for (int i = 0; i < q2.length; i++) {
            q2[i].setBackground(color1);
        }

        searchp2.setBackground(color1);
        deletep.setBackground(color1);

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

        crb.setBackground(Color.YELLOW);
        r1.setBackground(new Color(30, 39, 46));
        crb.setForeground(Color.BLACK);

        Color color = new Color(19, 15, 64);
        bid.setBackground(color);
        bname.setBackground(color);
        bauthorn.setBackground(color);
        bedition.setBackground(color);
        bpubn.setBackground(color);
        bquantity.setBackground(color);
        searcht.setBackground(color);
        bid2.setBackground(color);
        bname2.setBackground(color);
        bauthorn2.setBackground(color);
        bedition2.setBackground(color);
        bpubn2.setBackground(color);
        bquantity2.setBackground(color);

        Color wh = Color.WHITE;
        bid.setForeground(wh);
        bname.setForeground(wh);
        bauthorn.setForeground(wh);
        bedition.setForeground(wh);
        bpubn.setForeground(wh);
        bquantity.setForeground(wh);
        searcht.setForeground(wh);
        bid2.setForeground(wh);
        bname2.setForeground(wh);
        bauthorn2.setForeground(wh);
        bedition2.setForeground(wh);
        bpubn2.setForeground(wh);
        bquantity2.setForeground(wh);

        bid.setCaretColor(wh);
        bname.setCaretColor(wh);
        bauthorn.setCaretColor(wh);
        bpubn.setCaretColor(wh);
        bquantity.setCaretColor(wh);
        searcht.setCaretColor(wh);
        bid2.setCaretColor(wh);
        bname2.setCaretColor(wh);
        bauthorn2.setCaretColor(wh);
        bpubn2.setCaretColor(wh);
        bquantity2.setCaretColor(wh);

        bid.setHorizontalAlignment(JTextField.CENTER);
        bname.setHorizontalAlignment(JTextField.CENTER);
        bauthorn.setHorizontalAlignment(JTextField.CENTER);
        bpubn.setHorizontalAlignment(JTextField.CENTER);
        bquantity.setHorizontalAlignment(JTextField.CENTER);
        searcht.setHorizontalAlignment(JTextField.CENTER);
        bid2.setHorizontalAlignment(JTextField.CENTER);
        bname2.setHorizontalAlignment(JTextField.CENTER);
        bauthorn2.setHorizontalAlignment(JTextField.CENTER);
        bpubn2.setHorizontalAlignment(JTextField.CENTER);
        bquantity2.setHorizontalAlignment(JTextField.CENTER);

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        bedition.setRenderer(listRenderer);
        bedition2.setRenderer(listRenderer);

        for (int i = 0; i < cl.length; i++) {
            cl[i].setOpaque(true);
            cl[i].setBackground(Color.YELLOW);
            cl[i].setForeground(Color.BLACK);
        }
        for (int i = 0; i < cl2.length; i++) {
            cl2[i].setOpaque(true);
            cl2[i].setBackground(Color.YELLOW);
            cl2[i].setForeground(Color.BLACK);
        }

        bid.requestFocus();

        searchb.setBackground(Color.YELLOW);
        searchb.setForeground(new Color(19, 15, 64));

        deleteb.setBackground(Color.YELLOW);
        deleteb.setForeground(new Color(19, 15, 64));

        searchl.setOpaque(true);
        searchl.setBackground(Color.YELLOW);

        searchb2.setBackground(Color.YELLOW);
        searchb2.setForeground(new Color(19, 15, 64));

        updateb.setBackground(Color.YELLOW);
        updateb.setForeground(new Color(19, 15, 64));

        clear.setBackground(Color.YELLOW);
        clear.setForeground(new Color(19, 15, 64));

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
    }

    public void hide() {
        for (int i = 0; i < pp.length; i++) {
            pp[i].setVisible(false);
            p[6].remove(pp[i]);
        }
    }

    public void set_visible(boolean va) {
        bname2.setVisible(va);
        bauthorn2.setVisible(va);
        bedition2.setVisible(va);
        bpubn2.setVisible(va);
        bquantity2.setVisible(va);
        updateb.setVisible(va);
        clear.setVisible(va);
        for (int i = 1; i < cl2.length; i++) {
            cl2[i].setVisible(va);
        }
    }

    public void clear_Text() {
        bid2.setText("");
        bname2.setText("");
        bauthorn2.setText("");
        bedition2.setSelectedIndex(0);
        bpubn2.setText("");
        bquantity2.setText("");
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
                bp[3].setBackground(new Color(48, 51, 107));
                bid.requestFocus();
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
                bp[3].setBackground(new Color(48, 51, 107));
                if (con != null && EstablishConection.getEstblishConnection() != null) {
                    if (model1.getRowCount() != 0) {
                        int no = model1.getRowCount();
                        for (int i = 1; i <= no; i++) {
                            model1.removeRow(0);
                        }
                    }
                    try {
                        String q = "SELECT book_id,book_name,book_author,book_edition,book_publication,quantity_of_book,avaible_book,no_of_issue_book,no_of_return_book FROM book";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(q);
                        String[] row = new String[9];
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
                bp[3].setBackground(new Color(48, 51, 107));
                clear_Text();
                set_visible(false);
                bid2.requestFocus();
            }
        });
        bp[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                p[6].add(pp[3]);
                pp[3].setVisible(true);
                bp[0].setBackground(new Color(48, 51, 107));
                bp[1].setBackground(new Color(48, 51, 107));
                bp[2].setBackground(new Color(48, 51, 107));
                bp[3].setBackground(new Color(142, 68, 173));
                searcht.setText("");
                searcht.requestFocus();
                if (model2.getRowCount() != 0) {
                    model2.removeRow(0);
                }
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
        crb.setCursor(cursor);
        searchb.setCursor(cursor);
        deleteb.setCursor(cursor);
        searchb2.setCursor(cursor);
        updateb.setCursor(cursor);
        clear.setCursor(cursor);

        logout.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);
        crb.setFocusable(false);
        searchb.setFocusable(false);
        deleteb.setFocusable(false);
        searchb2.setFocusable(false);
        updateb.setFocusable(false);
        clear.setFocusable(false);

        Font font = new Font("Tahoma", Font.BOLD, 22);
        for (int i = 0; i < cl.length; i++) {
            cl[i].setFont(font);
        }
        for (int i = 0; i < cl2.length; i++) {
            cl2[i].setFont(font);
        }
        bid.setFont(font);
        bname.setFont(font);
        bauthorn.setFont(font);
        bedition.setFont(font);
        bpubn.setFont(font);
        bquantity.setFont(font);
        crb.setFont(font);
        searchl.setFont(font);
        searcht.setFont(font);
        searchb.setFont(font);
        deleteb.setFont(font);
        bid2.setFont(font);
        bname2.setFont(font);
        bauthorn2.setFont(font);
        bedition2.setFont(font);
        bpubn2.setFont(font);
        bquantity2.setFont(font);
        searchb2.setFont(font);
        updateb.setFont(font);
        clear.setFont(font);

        Font font1 = new Font("Tahoma", Font.BOLD, 15);
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
                        Librarian_logout_Info.save_Logout_Info(con, name, user);
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
        crb.addMouseListener(new Add_Action());
        crb.addActionListener(new Add_Action());
        searchb.addActionListener(new Add_Action());
        searchb.addMouseListener(new Add_Action());
        deleteb.addActionListener(new Add_Action());
        deleteb.addMouseListener(new Add_Action());
        searchb2.addActionListener(new Add_Action());
        searchb2.addMouseListener(new Add_Action());
        updateb.addActionListener(new Add_Action());
        updateb.addMouseListener(new Add_Action());
        clear.addActionListener(new Add_Action());
        clear.addMouseListener(new Add_Action());
    }

    class Add_Action implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (con != null && EstablishConection.getEstblishConnection() != null) {
                if (e.getSource() == logout) {
                    try {
                        Librarian_logout_Info.save_Logout_Info(con, name, user);
                        con.close();
                        dispose();
                        new Main("Library Management System").setVisible(true);
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR);
                    }
                } else if (e.getSource() == back) {
                    dispose();
                    new LibrarianControl("Linrarian Control", con, name, user).setVisible(true);
                } else if (e.getSource() == crb) {
                    String bid1 = bid.getText().trim();
                    String bname1 = bname.getText().trim();
                    String bauthorn1 = bauthorn.getText().trim();
                    String bedition1 = String.valueOf(bedition.getSelectedItem()).trim();
                    String bpubn1 = bpubn.getText().trim();
                    String bquantity1 = bquantity.getText().trim();
                    boolean nonotd = false;
                    if (bquantity1.isEmpty() == false) {
                        try {
                            Integer.parseInt(bquantity1);
                        } catch (NumberFormatException e1) {
                            nonotd = true;
                        }
                    }
                    if (bid1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bname1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book Name", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bauthorn1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book Author", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bedition1.equals("Select Book Edition")) {
                        JOptionPane.showMessageDialog(null, "Select Book Edition", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bpubn1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book Publication Name", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bquantity1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Quantity of Book", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (nonotd) {
                        JOptionPane.showMessageDialog(null, "Quantity of Book is should be Number(Not Decimal Number)",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT book_id FROM book WHERE book_id=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                JOptionPane.showMessageDialog(null, "That Book Id Book is taken. Try another.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                q = "INSERT INTO book(book_id,book_name,book_author,book_edition,book_publication,quantity_of_book,avaible_book,username_of_admin_add_book,username_of_librarian_add_book) VALUES(?,?,?,?,?,?,?,?,?)";
                                ps = con.prepareStatement(q);

                                ps.setString(1, bid1);
                                ps.setString(2, bname1);
                                ps.setString(3, bauthorn1);
                                ps.setString(4, bedition1);
                                ps.setString(5, bpubn1);
                                ps.setString(6, bquantity1);
                                ps.setString(7, bquantity1);
                                ps.setString(8, "null");
                                ps.setString(9, user);

                                ps.executeUpdate();

                                bid.setText("");
                                bname.setText("");
                                bauthorn.setText("");
                                bedition.setSelectedIndex(0);
                                bpubn.setText("");
                                bquantity.setText("");

                                bid.requestFocus();
                                JOptionPane.showMessageDialog(null, "Book add Successful", "Information",
                                        JOptionPane.INFORMATION_MESSAGE);

                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            e1.printStackTrace();
                        }
                    }
                } else if (e.getSource() == searchb) {
                    String bid1 = searcht.getText().trim();
                    if (bid1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (model2.getRowCount() != 0) {
                            model2.removeRow(0);
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
                                model2.addRow(row);
                            } else {
                                JOptionPane.showMessageDialog(null, "This book id is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == deleteb) {
                    String bid1 = searcht.getText().trim();
                    if (bid1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        // if (model2.getRowCount() != 0) {
                        // model2.removeRow(0);
                        // }
                        try {
                            String q = "SELECT book_id,no_of_issue_book FROM book WHERE book_id=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                int no_ofissue_book = Integer.parseInt(rs.getString(2));
                                if (no_ofissue_book == 0) {
                                    q = "DELETE FROM book WHERE book_id=?";
                                    PreparedStatement ps1 = con.prepareStatement(q);
                                    ps1.setString(1, bid1);
                                    ps1.executeUpdate();

                                    searcht.setText("");
                                    if (model2.getRowCount() != 0) {
                                        model2.removeRow(0);
                                    }
                                    JOptionPane.showMessageDialog(null, "Book Deleted Successful", "Information",
                                            JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "This Book has been issued to some students os, the record of this book cannot be deleted",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This book id is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }

                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == searchb2) {
                    String bid1 = bid2.getText().trim();
                    if (bid1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        String q = "SELECT book_name,book_author,book_edition,book_publication,quantity_of_book FROM book WHERE book_id=?";
                        try {
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String[] row = new String[5];
                                row[0] = rs.getString(1);
                                row[1] = rs.getString(2);
                                row[2] = rs.getString(3);
                                row[3] = rs.getString(4);
                                row[4] = rs.getString(5);

                                bid2.setEditable(false);
                                bname2.setEditable(false);
                                set_visible(true);
                                bname2.setText(row[0]);
                                bauthorn2.setText(row[1]);
                                bedition2.setSelectedItem(row[2]);
                                bpubn2.setText(row[3]);
                                bquantity2.setText(row[4]);
                                bauthorn2.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(null, "This book id is not valid", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getSource() == clear) {
                    bid2.setEditable(true);
                    clear_Text();
                    set_visible(false);
                } else if (e.getSource() == updateb) {
                    String bid1 = bid2.getText().trim();
                    // String bname1=bname2.getText().trim();
                    String bauthorn1 = bauthorn2.getText().trim();
                    String bedition1 = String.valueOf(bedition2.getSelectedItem()).trim();
                    String bpubn1 = bpubn2.getText().trim();
                    String bquantity1 = bquantity2.getText().trim();
                    boolean nonotd = false;
                    if (bquantity1.isEmpty() == false) {
                        try {
                            Integer.parseInt(bquantity1);
                        } catch (NumberFormatException e1) {
                            nonotd = true;
                        }
                    }
                    // if(bid1.isEmpty()) {
                    // JOptionPane.showMessageDialog(null, "Field the Book ID", "WARNING",
                    // JOptionPane.WARNING_MESSAGE);
                    // }
                    // else if(bname1.isEmpty()) {
                    // JOptionPane.showMessageDialog(null, "Field the Book Name", "WARNING",
                    // JOptionPane.WARNING_MESSAGE);
                    // }
                    if (bauthorn1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book Author", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bedition1.equals("Select Book Edition")) {
                        JOptionPane.showMessageDialog(null, "Select Book Edition", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bpubn1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Book Publication Name", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bquantity1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field the Quantity of Book", "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (nonotd) {
                        JOptionPane.showMessageDialog(null, "Quantity of Book is should be Number(Not Decimal Number)",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            String q = "SELECT no_of_issue_book FROM book WHERE book_id=?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, bid1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                String issue_book = rs.getString(1);
                                int bq = Integer.parseInt(bquantity1);
                                int isb = Integer.parseInt(issue_book);
                                if (bq >= isb) {
                                    int ab = bq - isb;
                                    String avaible_book = String.valueOf(ab);

                                    q = "UPDATE book SET book_author=?,book_edition=?,book_publication=?,quantity_of_book=?,avaible_book=? WHERE book_id=?";
                                    ps = con.prepareStatement(q);
                                    ps.setString(1, bauthorn1);
                                    ps.setString(2, bedition1);
                                    ps.setString(3, bpubn1);
                                    ps.setString(4, bquantity1);
                                    ps.setString(5, avaible_book);
                                    ps.setString(6, bid1);

                                    ps.executeUpdate();

                                    JOptionPane.showMessageDialog(null, "Book Update Successful", "WARNING",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    bid2.setEditable(true);
                                    clear_Text();
                                    set_visible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "The Quantity of book will be more than or equal to the Issue Book(No. Of Issue Book : "
                                                    + isb + ")",
                                            "WARNING", JOptionPane.WARNING_MESSAGE);
                                }
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
            } else if (e.getSource() == crb) {
                crb.setBackground(new Color(30, 39, 46));
                r1.setBackground(Color.YELLOW);
                crb.setForeground(Color.WHITE);
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.WHITE);
            } else if (e.getSource() == deleteb) {
                deleteb.setBackground(Color.WHITE);
            } else if (e.getSource() == searchb2) {
                searchb2.setBackground(Color.WHITE);
            } else if (e.getSource() == updateb) {
                updateb.setBackground(Color.WHITE);
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
            } else if (e.getSource() == crb) {
                crb.setBackground(Color.YELLOW);
                r1.setBackground(new Color(30, 39, 46));
                crb.setForeground(Color.BLACK);
            } else if (e.getSource() == searchb) {
                searchb.setBackground(Color.YELLOW);
            } else if (e.getSource() == deleteb) {
                deleteb.setBackground(Color.YELLOW);
            } else if (e.getSource() == searchb2) {
                searchb2.setBackground(Color.YELLOW);
            } else if (e.getSource() == updateb) {
                updateb.setBackground(Color.YELLOW);
            } else if (e.getSource() == clear) {
                clear.setBackground(Color.YELLOW);
            }
        }
    }
}
