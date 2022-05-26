import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class client implements ActionListener{

    static HyCon con = new HyCon();


    static JFrame frame = new JFrame("HyPickle");
    static String UUID = "8d4e329c-24e2-4776-a70e-e33eff685e94";
    static JLabel face1;
    static JLabel face2;
    static JLabel face3;


    //Panel 1
    static JButton button = new JButton("Grab Data");
    static JLabel text = new JLabel("Username");
    static JTextField uid = new JTextField("UUID");


    //Panel 2
    static JLabel lv2 = new JLabel("Level: 420");
    static JLabel gd2 = new JLabel("Guild: Amogusfornigh");
    static JLabel ls2 = new JLabel("Last Seen: 89065");
    static JLabel user2 = new JLabel("[RANK] Name");

    //Panel 3
    static JLabel lv3 = new JLabel("Level: 469");
    static JLabel kd3 = new JLabel("KD: 0.69, 369/420");
    static JLabel wl3 = new JLabel("Win%: 0.5, 27/98687");
    static JLabel user3 = new JLabel("[RANK] Name");

    //Panel 5
    static JLabel lv4 = new JLabel("Level: 469");
    static JLabel kd4 = new JLabel("KD: 0.69, 369/420");
    static JLabel wl4 = new JLabel("Win%: 0.5, 27/98687");
    static JLabel user4 = new JLabel("[RANK] Name");


    public static void main(String[] args) throws Exception {


        client te = new client();
        button.addActionListener(te);
        JTabbedPane panes = new JTabbedPane();
        panes.add(setupPanel1(), "main");//94a2d285-b2c8-4185-9376-d0f56556c0f0
        panes.add(setupPanel2(), "Hypixel");
        panes.add(setupPanel3(), "SkyWars");
        panes.add(setupPanel5(), "BedWars");
        panes.add(bzUpdate(), "Bazzr");


        frame.add(panes);
        frame.setSize(500, 500);
        frame.setVisible(true);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Grab Data")) {
            UUID = uid.getText();
            try {
                text.setText("Person Online? " + con.toHashmap(con.request("/status?uuid=" + UUID + "&").get("session")).get("online"));
                update();
                text.setText("Success!");
            } catch (Exception ex) {
                text.setText("Something has gone wrong! Check the UUID you have input!");
                System.out.println(UUID);
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
    }

    public static JPanel setupPanel1(){
        GridBagConstraints c = new GridBagConstraints();
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        p.add(uid,c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        p.add(button,c);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        p.add(text,c);


        return p;
    }

    public static JPanel setupPanel2(){
        GridBagConstraints c = new GridBagConstraints();
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        JLabel name2 = user2;
        p.add(name2, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        p.add(lv2, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        p.add(gd2, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        p.add(ls2, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.ipadx = 10;
        c.ipady = 10;
        c.gridheight = 5;
        try {
            URL url = new URL("https://crafthead.net/avatar/" + UUID + ".png");
            face1 = new JLabel(new ImageIcon(ImageIO.read(url).getScaledInstance(120, 120, 4)));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        p.add(face1, c);

        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 4;
        p.add(new JLabel(""), c);

        return p;
    }

    public static JPanel setupPanel3(){
        GridBagConstraints c = new GridBagConstraints();
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        JLabel name2 = user3;
        p.add(name2, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        p.add(lv3, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        p.add(kd3, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        p.add(wl3, c);

        c.anchor = GridBagConstraints.NORTHWEST;
//        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.ipadx = 10;
        c.ipady = 10;
        c.gridheight = 5;
        try {
            URL url = new URL("https://crafthead.net/avatar/" + UUID + ".png");
            face2 = new JLabel(new ImageIcon(ImageIO.read(url).getScaledInstance(120, 120, 4)));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        p.add(face2, c);

        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 4;
        p.add(new JLabel(""), c);

        return p;
    }

    public static JPanel setupPanel5(){
        GridBagConstraints c = new GridBagConstraints();
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        JLabel name2 = user4;
        p.add(name2, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        p.add(lv4, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        p.add(kd4, c);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        p.add(wl4, c);

        c.anchor = GridBagConstraints.NORTHWEST;
//        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.ipadx = 10;
        c.ipady = 10;
        c.gridheight = 5;
        try {
            URL url = new URL("https://crafthead.net/avatar/" + UUID + ".png");
            face3 = new JLabel(new ImageIcon(ImageIO.read(url).getScaledInstance(120, 120, 4)));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        p.add(face3, c);

        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 4;
        p.add(new JLabel(""), c);

        return p;
    }

    public static void update() throws Exception {
        HashMap<String, String> data = HyCon.toHashmap(HyCon.request("/player?uuid=" + UUID + "&").get("player"));
        String rank = data.get("rank");
        if(rank == null){
            rank = data.get("newPackageRank");
        }
        String name = data.get("displayname");

        ImageIcon face =  new ImageIcon();
        try {
            URL url = new URL("https://crafthead.net/avatar/" + UUID + ".png");
            face = new ImageIcon(ImageIO.read(url).getScaledInstance(120, 120, 4));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        //94a2d285-b2c8-4185-9376-d0f56556c0f0
        //HYPIXEL, PANEL 2
        //hypixel level is lv 2 at 10,000, then 2500 from there
        String guildTest = HyCon.request("/guild?player=" + UUID + "&").get("guild");
        HashMap<String, String> guild;
        if(guildTest != "null") {
            guild = HyCon.toHashmap(HyCon.request("/guild?player=" + UUID + "&").get("guild"));
        } else {
            guild = new HashMap<String, String>();
            guild.put("name", "None");
        }

        user2.setText("Name: [" + rank + "] " + name);
        ls2.setText("Last Seen: " + data.get("lastLogout"));
        gd2.setText("Guild: " + guild.get("name"));
        double exp = (Double.valueOf(data.get("networkExp")));
        double level = Math.sqrt((exp / 1250) + 12.25) - 3.5;
        lv2.setText("Level:" + (int)level);
        face1.setIcon(face);

        //SKYWARS, PANEL 3
        HashMap<String, String> stats = HyCon.toHashmap(data.get("stats"));
        HashMap<String, String> skywars = HyCon.toHashmap(stats.get("SkyWars"));
        lv3.setText("SkyWars Level: " + skywars.get("levelFormatted").substring(2, skywars.get("levelFormatted").length() - 3));

        int kills = Integer.parseInt(skywars.get("kills"));
        int deaths = Integer.parseInt(skywars.get("deaths"));
        kd3.setText("KD: " + String.format("%.2f", (double)(kills)/deaths) + ", " + kills + "/" + deaths);

        int total = Integer.parseInt(skywars.get("games_played_skywars"));
        double wins = Double.parseDouble(skywars.get("wins"));
        wl3.setText("Win%: " + String.format("%.2f", (wins/total) * 100.0) + ", " + wins+"/"+total);
        user3.setText("Name: [" + rank + "] " + name);
        face2.setIcon(face);

        //BEDWARS, PANEL 5
        HashMap<String, String> bedwars = HyCon.toHashmap(stats.get("Bedwars"));
        HashMap<String, String> lvl = HyCon.toHashmap(data.get("achievements"));
        String blvl = lvl.get("bedwars_level");
        lv4.setText("BedWars Level: " + blvl);

        int bkills = Integer.parseInt(bedwars.get("kills_bedwars")) + Integer.parseInt(bedwars.get("void_kills_bedwars"));
        int bdeaths = Integer.parseInt(bedwars.get("deaths_bedwars"));
        kd4.setText("KD: " + String.format("%.2f", (double)(bkills * 100)/bdeaths) + "%, " + bkills + "/" + bdeaths);

        int btotal = Integer.parseInt(bedwars.get("beds_broken_bedwars"));
        wl4.setText("Beds Broken: " + btotal);
        user4.setText("Name: [" + rank + "] " + name);
        face3.setIcon(face);
    }

    public static JTabbedPane bzUpdate() throws Exception {
        HashMap<String, String> items = HyCon.items();
        HashMap<String, String> data = HyCon.toHashmap(HyCon.request("/skyblock/bazaar?").get("products"));
        JTabbedPane output = new JTabbedPane();

        String sort1 = ""; //C:\Users\1556786\AppData\Local\Pearson\TestNav\jxbrowser\hypixL\src\main\java\pain.json
        File myObj = new File("./pain.json");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            sort1 += myReader.nextLine();
        }
        HashMap<String, String> sort = HyCon.toHashmap(sort1);

        ArrayList<String> farming = new ArrayList<String>();
        ArrayList<String> mining = new ArrayList<String>();
        ArrayList<String> combat = new ArrayList<String>();
        ArrayList<String> fishing = new ArrayList<String>();
        ArrayList<String> oddities = new ArrayList<String>();

        for(String i : data.keySet()){ //sort all of the items
            String query = items.get(i);
            if(query == null){
                continue;
            }
            HashMap<String, String> item = HyCon.toHashmap(items.get(i));
            if(item.get("bazaar") != null){
                String hash = "";
                for(String j : sort.keySet()){
                    if(sort.get(j).indexOf(item.get("name")) > -1){
                        hash = j;
                    }
                }

                switch(hash){
                    case("farming"):
                        farming.add(i);
                        break;
                    case("mining"):
                        mining.add(i);
                        break;
                    case("combat"):
                        combat.add(i);
                        break;
                    case("fishing"):
                        fishing.add(i);
                        break;
                    case("oddities"):
                        oddities.add(i);
                        break;
                }
            }
        }

        output.add(setupBzPane(farming), "Farming");

        output.add(setupBzPane(mining), "Mining");

        output.add(setupBzPane(combat), "Combat");

        output.add(setupBzPane(fishing), "Fishing");

        output.add(setupBzPane(oddities), "Other");

        return output;
    }

    public static JScrollPane setupBzPane(ArrayList<String> items) throws Exception {
        HashMap<String, String> data = HyCon.toHashmap(HyCon.request("/skyblock/bazaar?").get("products"));
        HashMap<String, String> names = HyCon.items();

        JPanel farm = new JPanel();
        farm.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        farm.add(new JLabel("Item Name:"));
        c.gridx = 1;
        farm.add(new JLabel("Buy Price:"));
        c.gridx = 2;
        farm.add(new JLabel("Buy Price:"));
        for(int i = 0; i < items.size(); i++){
            String ID = items.get(i);
            HashMap<String, String> quick = HyCon.toHashmap(HyCon.toHashmap(data.get(ID)).get("quick_status"));
            double buy = Double.parseDouble(quick.get("buyPrice"));
            double sell = Double.parseDouble(quick.get("sellPrice"));


            c.anchor = GridBagConstraints.NORTHWEST;
            c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = i + 1;
            farm.add(new JLabel(HyCon.toHashmap(names.get(ID)).get("name")), c);

            c.anchor = GridBagConstraints.NORTHWEST;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy = i + 1;
            farm.add(new JLabel(String.format("%.3f", buy)), c);

            c.anchor = GridBagConstraints.NORTHWEST;
            c.weightx = 0.5;
            c.gridx = 2;
            c.gridy = i + 1;
            farm.add(new JLabel(String.format("%.3f",sell)), c);
        }
        return new JScrollPane(farm);
    }
}