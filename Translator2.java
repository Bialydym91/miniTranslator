package university.translator2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Translator2 implements ActionListener {

    JFrame okno;
    JPanel panelGora, panelDol;
    JLabel angielskie, polskie;
    JTextField poAngielskue, poPolsku;
    JButton przycisk;
    int indeks = 0;

    ArrayList<ParaSlow> slowka = new ArrayList<>();

    public Translator2() {
        okno = new JFrame("Prezentacja słówek angielskich");
        okno.setSize(600, 150);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setLayout(new BorderLayout());

        panelGora = new JPanel();
        panelGora.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        angielskie = new JLabel("Po angielsku:");
        polskie = new JLabel("Po polsku:");

        poAngielskue = new JTextField(10);
        poPolsku = new JTextField(10);

        panelGora.add(angielskie);
        panelGora.add(poAngielskue);
        panelGora.add(polskie);
        panelGora.add(poPolsku);

        panelDol = new JPanel();
        przycisk = new JButton("Pokaż następne słówko");
        przycisk.addActionListener(this);
        panelDol.add(przycisk);

        okno.add(panelGora, BorderLayout.CENTER);
        okno.add(panelDol, BorderLayout.SOUTH);


        dodajSlowka();

        okno.setVisible(true);
    }

    private void dodajSlowka() {
        slowka.add(new ParaSlow("Pencil", "Ołówek"));
        slowka.add(new ParaSlow("Wood", "Drewno"));
        slowka.add(new ParaSlow("Iron", "Żelazo"));
        slowka.add(new ParaSlow("Mirror", "Lustro"));
        slowka.add(new ParaSlow("Steel", "Stal"));
        slowka.add(new ParaSlow("Copper", "Miedź"));
        slowka.add(new ParaSlow("Silver", "Srebro"));
        slowka.add(new ParaSlow("Gold", "Złoto"));
        slowka.add(new ParaSlow("Messing", "Mosiądz"));
        slowka.add(new ParaSlow("Water", "Woda"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (indeks < slowka.size()) {
            ParaSlow para = slowka.get(indeks);
            poAngielskue.setText(para.getAngielskie());
            poPolsku.setText(para.getPolskie());
            indeks++;
        } else {
            indeks = 0;
            poAngielskue.setText("");
            poPolsku.setText("");
        }
    }

    public static void main(String[] args) {
        Translator2 translator = new Translator2();
    }
}
