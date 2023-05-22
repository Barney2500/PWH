package proyectowh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.sql.*;


public class Gui2 {

    private JFrame frame;
    private JPanel panel;
    private JButton StartB;
    private JButton SelChar;
    private JButton SelWeap;
    private JButton Ranking;
    private Player J1, Cpu;
    private CharArray ca = new CharArray();
    private JTextArea console;
    //starts the gui
    public Gui2(Player J1) {
        this.J1 = J1;
        Toolkit ms = Toolkit.getDefaultToolkit();
        Dimension ss = ms.getScreenSize();
        int h = ss.height;
        int w = ss.width;
        frame = new JFrame("The Final Showdown: Battle of the Last Ones");
		Image icon = ms.getImage("src/proyectowh/images/Logo.jpg");
		frame.setIconImage(icon);
		frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((w * 2) / 3, (h * 2) / 3);
        frame.setLocationRelativeTo(null);
        console = new JTextArea();
        console.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(console);
        scrollPane.setPreferredSize(new Dimension(frame.getWidth(), 100)); 
        frame.add(scrollPane, BorderLayout.SOUTH);
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        StartB = new JButton("Start");
        SelChar = new JButton("Select Faction");
        SelWeap = new JButton("Select Army");
        Ranking = new JButton("Ranking");
        StartB.setAlignmentX(Component.CENTER_ALIGNMENT);
        StartB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BattleStart();
            }
        });
        SelChar.setAlignmentX(Component.CENTER_ALIGNMENT);
        SelChar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectchara();
            }
        });
        SelWeap.setAlignmentX(Component.CENTER_ALIGNMENT);
        SelWeap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectweapon(J1.getChara().getId());
            }
        });
        Ranking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ranking();
            }
        });
        Ranking.setAlignmentX(Component.CENTER_ALIGNMENT);

        StartB.setFocusPainted(false);
        SelChar.setFocusPainted(false);
        SelWeap.setFocusPainted(false);

        panel.add(Box.createVerticalGlue());
        panel.add(StartB);
        panel.add(Box.createVerticalStrut(10));
        panel.add(SelChar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(SelWeap);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Ranking);
        panel.add(Box.createVerticalGlue());
        frame.add(panel, BorderLayout.CENTER);

        int widthb = 200;
        int heightb = 70;

        StartB.setSize(widthb, heightb);
        StartB.setMaximumSize(new Dimension(widthb, heightb));
        SelChar.setSize(widthb, heightb);
        SelChar.setMaximumSize(new Dimension(widthb, heightb));
        SelWeap.setSize(widthb, heightb);
        SelWeap.setMaximumSize(new Dimension(widthb, heightb));
        Ranking.setSize(widthb, heightb);
        Ranking.setMaximumSize(new Dimension(widthb, heightb));
        frame.setVisible(true);
    }
    //shows the message you want in the console integrated to the gui
    private void showM(String message) {
        console.append(message + "\n");
    }
	//starts the battle if the conditions are done
private void BattleStart() {
		if (J1.getChara().getId() == 0 && J1.getWeapon().getId() == 0) {
			JOptionPane.showMessageDialog(null, "First select Your Character and Weapon", "Warning",
					JOptionPane.WARNING_MESSAGE);
		} else if (J1.getChara().getId() != 0 && J1.getWeapon().getId() == 0) {
			JOptionPane.showMessageDialog(null, "First select Your Weapon", "Warning", JOptionPane.WARNING_MESSAGE);
		} else if (J1.getChara().getId() == 0 && J1.getWeapon().getId() != 0) {
			JOptionPane.showMessageDialog(null, "First select Your Character", "Warning", JOptionPane.WARNING_MESSAGE);
		} else if (J1.getName() != null) {
	       	final int a = selfirst();
        	int s = 0;
        	cpu();
        	setfight();
        	fight(a, s );
		}else {
			selname();

		}
	}	
	//selects the weapon of your character  
	private void selectweapon(int i) {
	    int a;
	    a = i;
	    WeaponArray wa = new WeaponArray(a);
	    if (J1.getChara().getId() == 0) {
	        JOptionPane.showMessageDialog(null, "First select Your Character", "Warning",
	                JOptionPane.WARNING_MESSAGE);
	    } else {
	    panel.removeAll();
	    JLabel tit = new JLabel("Choose your Army");
	    tit.setAlignmentX(Component.CENTER_ALIGNMENT);
	    panel.add(tit);
	    JPanel buttonsPanel = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.insets = new Insets(10, 10, 10, 10);

	    ArrayList<Weapon> weaps = wa.getWeapons();

	    int numColumns = 3;
	    int weapIndex = 0;

	    for (int col = 0; col < numColumns; col++) {
	        gbc.gridx = col;
	        gbc.gridy = 0;

	        for (int row = 0; row < weaps.size() / numColumns; row++) {
	            if (weapIndex >= weaps.size()) {
	                break;
	            }

	            Weapon w = weaps.get(weapIndex);
	            JButton boto = new JButton();
	            ImageIcon imageIcon2 = new ImageIcon(w.getUrl());
	            Image image = imageIcon2.getImage().getScaledInstance(frame.getWidth()/3, frame.getHeight(), Image.SCALE_SMOOTH);
	            ImageIcon scaledImageIcon = new ImageIcon(image);
	            boto.setIcon(scaledImageIcon);
	            Dimension buttonSize = new Dimension(frame.getWidth()/3, frame.getHeight());
	            boto.setPreferredSize(buttonSize);
	            boto.setMaximumSize(buttonSize);
	            boto.setMinimumSize(buttonSize);
	            boto.setBorderPainted(false);
	            boto.setContentAreaFilled(false);
	            boto.setFocusPainted(false);
	            boto.setOpaque(false);
	            boto.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    boolean compro = popuconfirm("Confirm Your Selection");
	                    if (compro) {
	                        J1.setWeapon(w);
	                        volverinicio();
	                    }
	                }
	            });

	            JPanel charPanel = new JPanel();
	            charPanel.setLayout(new BoxLayout(charPanel, BoxLayout.Y_AXIS)); 
	            charPanel.add(boto);

	            buttonsPanel.add(charPanel, gbc); 

	            weapIndex++;
	            gbc.gridy++;
	        }
	    }

	    panel.add(buttonsPanel);
	    panel.revalidate();
	    panel.repaint();
	}
	}
	//selects your character
	private void selectchara() {
	    panel.removeAll();
	    JLabel tit = new JLabel("Choose your Side");
	    tit.setAlignmentX(Component.CENTER_ALIGNMENT);
	    panel.add(tit);
	    JPanel buttonsPanel = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.insets = new Insets(10, 10, 10, 10);

	    ArrayList<Chara> chars = ca.getCharas();

	    int numColumns = 3;
	    int charIndex = 0;

	    for (int col = 0; col < numColumns; col++) {
	        gbc.gridx = col;
	        gbc.gridy = 0;

	        for (int row = 0; row < chars.size() / numColumns; row++) {
	            if (charIndex >= chars.size()) {
	                break;
	            }

	            Chara c = chars.get(charIndex);
	            JButton boto = new JButton();
	            Dimension buttonSize = new Dimension(frame.getWidth()/3, frame.getHeight());
	            boto.setPreferredSize(buttonSize);
	            boto.setMaximumSize(buttonSize);
	            boto.setMinimumSize(buttonSize);
	            ImageIcon imageIcon2 = new ImageIcon(c.getUrl());
	            Image image = imageIcon2.getImage().getScaledInstance(frame.getWidth()/3, frame.getHeight(), Image.SCALE_SMOOTH);
	            ImageIcon scaledImageIcon = new ImageIcon(image);
	            boto.setIcon(scaledImageIcon);


	            boto.setBorderPainted(false);
	            boto.setContentAreaFilled(false);
	            boto.setFocusPainted(false);
	            boto.setOpaque(false);
	            boto.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    boolean compro = popuconfirm("Confirm Your Selection");
	                    if (compro) {
	                        J1.setChara(c);
	                        J1.getWeapon().setId(0);;
	                        volverinicio();
	                    }
	                }
	            });

	            JPanel charPanel = new JPanel();
	            charPanel.setLayout(new BoxLayout(charPanel, BoxLayout.Y_AXIS)); 
	            charPanel.add(boto);

	            buttonsPanel.add(charPanel, gbc);

	            charIndex++; 
	            gbc.gridy++; 
	        }
	    }

	    panel.add(buttonsPanel);
	    panel.revalidate();
	    panel.repaint();
	}
	//its a pop up with a message you want to confirm something
	private boolean popuconfirm(String s) {
		@SuppressWarnings("unused")
		boolean confi;
		int opcion = JOptionPane.showConfirmDialog(frame, s, "Confirm",
				JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) {
			return confi = true;
		}else {
			return confi = false;
		}
	}
	//returns to the mainmenu
	private void volverinicio() {
			panel.removeAll();
			panel.add(Box.createVerticalGlue());
			panel.add(StartB);
			panel.add(Box.createVerticalStrut(10));
			panel.add(SelChar);
			panel.add(Box.createVerticalStrut(10));
			panel.add(SelWeap);
			panel.add(Box.createVerticalStrut(10));
			panel.add(Ranking);
			panel.add(Box.createVerticalGlue());
			frame.revalidate();
			frame.repaint();
		
	}
	//creates the cpu character and weapon
	private void cpu() {
		Cpu = new Player(null, null, null);
		Random random = new Random();
		System.out.println(random);
		boolean nes = false;
		ArrayList<Integer> in = new ArrayList<Integer>();
	    ArrayList<Chara> chars = ca.getCharas();
	    Cpu.setName("CPU");
	    do {
			int randomNumber = random.nextInt(3) + 1;
		    for (Chara c : chars) {
		    	if (c.getId() == randomNumber && J1.getChara().getId() != randomNumber) {
		    		Cpu.setChara(c);
		    		nes = true;
		    	    WeaponArray wa = new WeaponArray(randomNumber);
		    	    ArrayList<Weapon> weaps = wa.getWeapons();
		    	    for (Weapon w: weaps) {
		    	    	in.add(w.getId());
		    	    }
		            int randomIndex = new Random().nextInt(in.size());
		            int randomNumber2 = in.get(randomIndex);
		    	    for (Weapon w: weaps) {
		    	    	if(w.getId() == randomNumber2) {
		    	    		Cpu.setWeapon(w);
		    	    	}
		    	    }
		    		
		    	}
		    }
	    } while (!nes);

	    
	}
	//lets you put a name and doesnt let you have a white space
	private void selname() {
		cpu();
		boolean conf = false;
        String nombre;
        do {
        	nombre = JOptionPane.showInputDialog(null, "Enter your name:", "Name", JOptionPane.PLAIN_MESSAGE);
            if (nombre != null) {
                if (!nombre.isEmpty() && !nombre.isBlank()) {
                	conf = popuconfirm("Once you confirm the Game will begin");
                } else {
                    JOptionPane.showMessageDialog(null, "No name was entered", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                conf = true;
            }
        }while (conf == false);
        if (nombre != null) {
        	J1.setName(nombre);
        	final int a = selfirst();
        	int s = 0;
        	setfight();
        	fight(a, s );

        }
	}
	//starts the fight between player and cpu
	private void fight(int i, int io) {
		if (J1.getChara().getHp() <= 0 || Cpu.getChara().getHp() <= 0 ) {
			Winner();
			boolean aga = popuconfirm("Do you want to keep fighting to archieve glory?");
			if (aga) {
				if(J1.getChara().getHp() > 0) {
					J1.setPoints(J1.getPoints() + (Cpu.getChara().getPoints() + Cpu.getWeapon().getPoints()));
					System.out.println(J1.getChara().getHp());
					boolean sc = popuconfirm("Do you want to mantain your loyalty to the actual faction?");
					if (sc) {
						Cpu.getChara().resethp();
						J1.getChara().resethp();
						cpu();
			        	turn(i,io);
			        	int ios = io + 1 ;
					    fight(i,ios);
					}else {
						DbCon conn = new DbCon();
				        String c1 = "INSERT INTO players (player_name) VALUES ('"+J1.getName()+"')";
				        try {
				        	conn.insertData(c1);
				        }finally {
				            conn.closeConn();
				        }
						DbCon conn2 = new DbCon();
				        ResultSet rs = conn2.getQueryRS("SELECT player_id FROM players ORDER BY player_id DESC LIMIT 1");
				        try {
			            if (rs.next()) {
			            	int lastId = rs.getInt("player_id");
					        String c2 = "INSERT INTO battle_results (player_id ,char_id, char_race , char_weap_id , char_weap_army, rival_race , rival_weap_army , enemy_casualties , allied_casualties , battle_points) values ("+ lastId + "," + J1.getChara().getId() + ", '"  + J1.getChara().getRace() + "' ," + J1.getWeapon().getId() + ", '"+ J1.getWeapon().getName()+  "' , '" + Cpu.getChara().getRace() + "', '" + Cpu.getWeapon().getName() + "'," + Cpu.getChara().getHp() + "," + J1.getChara().getHp()+"," + J1.getPoints() + ")";
					        conn2.insertData(c2);
			            }
		
			        }catch (SQLException e) {
			            System.out.println("Error running ResultSet");
			        }
				        finally {
				            conn.closeConn();
				        }
				        J1.setPoints(0);
						Cpu.getChara().resethp();
						J1.getChara().resethp();
						volverinicio();
					}
				}else {
					DbCon conn = new DbCon();
			        String c1 = "INSERT INTO players (player_name) VALUES ('"+J1.getName()+"')";
			        try {	
			        	conn.insertData(c1);
			        }finally {
			            conn.closeConn();
			        }
					DbCon conn2 = new DbCon();
			        ResultSet rs = conn2.getQueryRS("SELECT player_id FROM players ORDER BY player_id DESC LIMIT 1");
			        try {
		            if (rs.next()) {
		            	int lastId = rs.getInt("player_id");
				        String c2 = "INSERT INTO battle_results (player_id ,char_id, char_race , char_weap_id , char_weap_army, rival_race , rival_weap_army , enemy_casualties , allied_casualties , battle_points) values ("+ lastId + "," + J1.getChara().getId() + ", '"  + J1.getChara().getRace() + "' ," + J1.getWeapon().getId() + ", '"+ J1.getWeapon().getName()+  "' , '" + Cpu.getChara().getRace() + "', '" + Cpu.getWeapon().getName() + "'," + Cpu.getChara().getHp() + "," + J1.getChara().getHp()+"," + J1.getPoints() + ")";
				        conn2.insertData(c2);
		            }
	
		        }catch (SQLException e) {
		            System.out.println("Error running ResultSet");
		        }
			        finally {
			            conn.closeConn();
			        }
					Cpu.getChara().resethp();
					J1.getChara().resethp();
			        JOptionPane.showMessageDialog(null, "You lost the previous battle, so you can choose again without entering your name", "Defeated", JOptionPane.INFORMATION_MESSAGE);
			        volverinicio();
				}
			}else{
				J1.setPoints(J1.getPoints() + (Cpu.getChara().getPoints() + Cpu.getWeapon().getPoints()));
					if (J1.getChara().getHp() <= 0) {
					DbCon conn = new DbCon();
			        String c1 = "INSERT INTO players (player_name) VALUES ('"+J1.getName()+"')";
			        try {
			        	conn.insertData(c1);
			        }finally {
			            conn.closeConn();
			        }
					DbCon conn2 = new DbCon();
			        ResultSet rs = conn2.getQueryRS("SELECT player_id FROM players ORDER BY player_id DESC LIMIT 1");
			        try {
		            if (rs.next()) {
		            	int lastId = rs.getInt("player_id");
				        String c2 = "INSERT INTO battle_results (player_id ,char_id, char_race , char_weap_id , char_weap_army, rival_race , rival_weap_army , enemy_casualties , allied_casualties , battle_points) values ("+ lastId + "," + J1.getChara().getId() + ", '"  + J1.getChara().getRace() + "' ," + J1.getWeapon().getId() + ", '"+ J1.getWeapon().getName()+  "' , '" + Cpu.getChara().getRace() + "', '" + Cpu.getWeapon().getName() + "'," + Cpu.getChara().getHp() + "," + J1.getChara().getHp()+",0)";
				        conn2.insertData(c2);
		            }
	
		        }catch (SQLException e) {
		            System.out.println("Error running ResultSet");
		        }
			        finally {
			            conn.closeConn();
		            System.exit(0);
		        }}else {
					DbCon conn = new DbCon();
			        String c1 = "INSERT INTO players (player_name) VALUES ('"+J1.getName()+"')";
			        try {
			        	conn.insertData(c1);
			        }finally {
			            conn.closeConn();
			        }
					DbCon conn2 = new DbCon();
			        ResultSet rs = conn2.getQueryRS("SELECT player_id FROM players ORDER BY player_id DESC LIMIT 1");
			        try {
		            if (rs.next()) {
		            	int lastId = rs.getInt("player_id");
				        String c2 = "INSERT INTO battle_results (player_id ,char_id, char_race , char_weap_id , char_weap_army, rival_race , rival_weap_army , enemy_casualties , allied_casualties , battle_points) values ("+ lastId + "," + J1.getChara().getId() + ", '"  + J1.getChara().getRace() + "' ," + J1.getWeapon().getId() + ", '"+ J1.getWeapon().getName()+  "' , '" + Cpu.getChara().getRace() + "', '" + Cpu.getWeapon().getName() + "'," + Cpu.getChara().getHp() + "," + J1.getChara().getHp()+"," + J1.getPoints() + ")";
				        conn2.insertData(c2);
		            }
	
		        }catch (SQLException e) {
		            System.out.println("Error running ResultSet");
		        }
			        finally {
			            conn.closeConn();
		            System.exit(0);
		        }
		        }
			}
		}
		else {
			
        Timer timer = new Timer(1000, e -> {
        	turn(i,io);
        	int ios = io + 1 ;
		    fight(i,ios);
    });
            timer.setRepeats(false);
            timer.start();

		}
	}
	//paints the information of the players in the screen
	private void setfight() {
    panel.removeAll();
    JLabel tit = new JLabel("Fight for the victory");
    panel.add(tit);
    tit.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel leftPanel = new JPanel(new GridBagLayout());
    GridBagConstraints leftGbc = new GridBagConstraints();
    leftGbc.gridx = 0;
    leftGbc.gridy = 0;
    leftGbc.insets = new Insets(10, 10, 10, 10);

    JPanel rightPanel = new JPanel(new GridBagLayout());
    GridBagConstraints rightGbc = new GridBagConstraints();
    rightGbc.gridx = 0;
    rightGbc.gridy = 0;
    rightGbc.insets = new Insets(10, 10, 10, 10);

    ArrayList<Player> players = new ArrayList<Player>();
    players.add(J1);
    players.add(Cpu);
    int numColumns = 2;
    int playIndex = 0;

    for (int col = 0; col < numColumns; col++) {
        if (col == 0) {
            leftGbc.gridx = col;
        } else if (col == 1) {
            rightGbc.gridx = col;
        }

        for (int row = 0; row < players.size() / numColumns; row++) {
            if (playIndex >= players.size()) {
                break;
            }
            Player p = players.get(playIndex);
            JLabel ra;
            JPanel charPanel = new JPanel();
            charPanel.setLayout(new BoxLayout(charPanel, BoxLayout.Y_AXIS));
            if(p.getChara().getId() == 1) {
            	ra = new JLabel("The Imperium of man");
            	ra.setAlignmentX(Component.CENTER_ALIGNMENT);
            	charPanel.add(ra);

            }else if(p.getChara().getId() == 2) {
            	ra = new JLabel("The Aeldari Imperium");
            	ra.setAlignmentX(Component.CENTER_ALIGNMENT);
            	charPanel.add(ra);

            }else if (p.getChara().getId() == 3) {
            	ra = new JLabel("The Waaagh!");
            	ra.setAlignmentX(Component.CENTER_ALIGNMENT);
            	charPanel.add(ra);

            }
            JButton boto = new JButton();
            JLabel name = new JLabel();
            JLabel hp = new JLabel();
            JLabel str = new JLabel();
            JLabel spd = new JLabel();
            JLabel ag = new JLabel();
            JLabel def = new JLabel();
            ImageIcon imageIcon2 = new ImageIcon(p.getWeapon().getUrl());
            Image image = imageIcon2.getImage().getScaledInstance(frame.getWidth()/3, frame.getHeight()/2, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);
            boto = new JButton(scaledImageIcon);
            name = new JLabel(p.getName());
            int at = p.getChara().getStr() + p.getWeapon().getStr();
            int spe = p.getChara().getSpd() + p.getWeapon().getSpd();
            int hpValue = p.getChara().getHp();
            double hpPercentage = (double) hpValue / 100;

            hp.setText("Hp: " + hpValue);
            str.setText("Str: " + at);
            spd.setText("Spd: " + spe);
            ag.setText("Ag: " + p.getChara().getAg());
            def.setText("Def: " + p.getChara().getDef());

            JProgressBar hpBar = new JProgressBar(0, p.getChara().getMaxhp());
            hpBar.setValue((int) (hpPercentage * 100));

            Dimension buttonSize = new Dimension(frame.getWidth()/3, frame.getHeight()/2);
            boto.setPreferredSize(buttonSize);
            boto.setMaximumSize(buttonSize);
            boto.setMinimumSize(buttonSize);

            boto.setBorderPainted(false);
            boto.setContentAreaFilled(false);
            boto.setFocusPainted(false);
            boto.setOpaque(false);
            

            charPanel.add(name);
            charPanel.add(hpBar);
            charPanel.add(hp);
            charPanel.add(boto);
            charPanel.add(str);
            charPanel.add(spd);
            charPanel.add(ag);
            charPanel.add(def);

            if (col == 0) {
                leftPanel.add(charPanel, leftGbc);
                leftGbc.gridy++;
            } else if (col == 1) {
                rightPanel.add(charPanel, rightGbc);
                rightGbc.gridy++;
            }

            playIndex++;
        }
    }

    mainPanel.add(leftPanel, BorderLayout.WEST);
    mainPanel.add(rightPanel, BorderLayout.EAST);
    panel.add(mainPanel);
    panel.revalidate();
    panel.repaint();
}
	//selects who starts
	private int selfirst() {
        Random random = new Random();
        int randomstart = random.nextInt(2) + 1;
	    if (J1.getChara().getSpd() + J1.getWeapon().getSpd() > Cpu.getChara().getSpd() + Cpu.getWeapon().getSpd()) {
	    	return 1;
	    }else if (J1.getChara().getSpd() + J1.getWeapon().getSpd() < Cpu.getChara().getSpd() + Cpu.getWeapon().getSpd()) {
	    	return 2;
	    }else if (J1.getChara().getSpd() + J1.getWeapon().getSpd() == Cpu.getChara().getSpd() + Cpu.getWeapon().getSpd()) {
	    	if(J1.getChara().getAg() > Cpu.getChara().getAg()) {
	    		return 1;
	    	}else if(J1.getChara().getAg() < Cpu.getChara().getAg()) {
	    		return 2;
	    	}else if(J1.getChara().getAg() == Cpu.getChara().getAg()) {
	            return randomstart;
	    	}
	    }
		return randomstart;
		}	
	//establish the turns
private int turn(int i,int iv) {
			int is = iv;
			if (is == 0) {	
				if (i % 2 == 0) {
					do {
						i = P1Attack(i);
						setfight();
					} while (i%2 == 0 && (Cpu.getChara().getHp() > 0) && (J1.getChara().getHp() > 0 ));
					return i;
					}else if(i % 2 != 0){
					do {
						i = CpuAt(i);
						setfight();
					} while (i%2 != 0 && (Cpu.getChara().getHp() > 0) && (J1.getChara().getHp() > 0));
					return i;
					}
					return i;
				}else {
					i = i + is;
					if (i % 2 == 0) {
						do {
							i = P1Attack(i);
							setfight();
						} while (i%2 == 0 && (Cpu.getChara().getHp() > 0) && (J1.getChara().getHp() > 0 ));
						return i;
						}else if(i % 2 != 0){
						do {
							i = CpuAt(i);
							setfight();
						} while (i%2 != 0 && (Cpu.getChara().getHp() > 0) && (J1.getChara().getHp() > 0));
						return i;
						}
						return i;
					}
				}
	//prints who is the winner
private void Winner() {
		int Cpuhp = Cpu.getChara().getHp();
		int J1hp = J1.getChara().getHp();
		if (Cpuhp <= 0) {
			showM(J1.getName() + "is the winner");
			Cpu.getChara().setHp(0);
		}else if (J1hp <= 0){
			showM(Cpu.getName() + "is the winner");
			J1.getChara().setHp(0);

		}
	}
	//the function of the attack of the player
	private int P1Attack(int i) {
		Random random = new Random();
		showM(J1.getName() + "'s turn");
        int ranum = random.nextInt(100) + 1;
        if (J1.getChara().getAg() * 10 >= ranum) {
        	int ranum2 = random.nextInt(50) + 1;
        	if(Cpu.getChara().getAg() >= ranum2) {
        		showM(Cpu.getName() + "has dodge the attack");
        		return i + 1;
        	}else {
            	showM("The atack is succesfull");
        		int at = J1.getChara().getStr() + J1.getWeapon().getStr();
        		showM("The attack has a strenght of " + at);
        		Cpu.getChara().setHp(Cpu.getChara().getHp()-at);
        		showM(J1.getName() + "'s Hp:" + J1.getChara().getHp());
        		showM(Cpu.getName() + "'s Hp:" + Cpu.getChara().getHp());
        		if(J1.getChara().getSpd()+J1.getWeapon().getSpd() > Cpu.getChara().getSpd() + Cpu.getWeapon().getSpd()) {
        			int ranum3 = random.nextInt(100) + 1;
        			if((J1.getChara().getSpd()+J1.getWeapon().getSpd())*10 >= ranum3) {
        				showM("It's " + J1.getName() + " turn again!");
        				return i;
        			}else {
        				return i + 1;
        			}
        		}else {
        			return i + 1;
        		}
        	}
        }else {
        	showM("The attack has failed");
    		return i + 1;
        }
	}
	//the function of the attack of the cpu
private int CpuAt(int i) {
		Random random = new Random();
		showM(Cpu.getName() + "'s turn");
        int ranum = random.nextInt(100) + 1;
        if (Cpu.getChara().getAg() * 10 >= ranum) {
        	int ranum2 = random.nextInt(50) + 1;
        	if(J1.getChara().getAg() >= ranum2) {
        		showM(J1.getName() + "has dodge the attack");
        		return i + 1;
        	}else {
            	showM("The atack is succesfull");
        		int at = Cpu.getChara().getStr() + Cpu.getWeapon().getStr();
        		showM("The attack has a strenght of " + at);
        		J1.getChara().setHp(J1.getChara().getHp()-at);
        		showM(Cpu.getName() + "'s Hp:" + Cpu.getChara().getHp());
        		showM(J1.getName() + "'s Hp:" + J1.getChara().getHp());
        		if(Cpu.getChara().getSpd()+Cpu.getWeapon().getSpd() > J1.getChara().getSpd() + J1.getWeapon().getSpd()) {
        			int ranum3 = random.nextInt(100) + 1;
        			if((Cpu.getChara().getSpd()+Cpu.getWeapon().getSpd())*10 >= ranum3) {
        				return i;
        			}else {
        				return i + 1;
        			}
        		}else {
        			return i + 1;
        		}
        	}
        }else {
        	showM("The attack has failed");
    		return i + 1;
        }
	}
	//shows the top10 players
	private void ranking() {
		    panel.removeAll();
		    JLabel tit = new JLabel("Top 10 Players");
		    panel.add(tit);
		    tit.setAlignmentX(Component.CENTER_ALIGNMENT);

		    JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel charPanel = new JPanel();

		    Rankingshow ra = new Rankingshow();
		    ArrayList<Ranking> ras = ra.getRanking();
		    int numColumns = 9;
		    int rankIndex = 0;

            JLabel labat = new JLabel("Battle ID");
            JLabel laid = new JLabel("Player Name");
            JLabel lapra = new JLabel("Player Race");
            JLabel laplar = new JLabel("Player Army");
            JLabel laenera = new JLabel("Enemy Race");
            JLabel laenear = new JLabel("Enemy Army");
            JLabel laenehp = new JLabel("Enemy Life ");
            JLabel laplhp = new JLabel("Player Life");
            JLabel labtpo = new JLabel("Points");
            JPanel rowPaneltit = new JPanel();
            rowPaneltit.add(labat);
            rowPaneltit.add(laid);
            rowPaneltit.add(lapra);
            rowPaneltit.add(laplar);
            rowPaneltit.add(laplhp);
            rowPaneltit.add(laenera);
            rowPaneltit.add(laenear);
            rowPaneltit.add(laenehp);
            rowPaneltit.add(labtpo);
            Dimension ls = new Dimension(100, 20);
            labat.setPreferredSize(ls);
            laid.setPreferredSize(ls);
            lapra.setPreferredSize(ls);
            laplar.setPreferredSize(ls);
            laenera.setPreferredSize(ls);
            laenear.setPreferredSize(ls);
            laplhp.setPreferredSize(ls);
            laenehp.setPreferredSize(ls);
            labtpo.setPreferredSize(ls);

            charPanel.add(rowPaneltit);
		    
		    for (int col = 0; col < numColumns; col++) {
		        for (int row = 0; row < 10; row++) {
		            if (rankIndex >= ras.size()) {
		                break;
		            }
		            JLabel battid = new JLabel();
		            JLabel enemhp = new JLabel();
		            JLabel allhp = new JLabel();
		            JLabel batlpo = new JLabel();
		            Ranking r = ras.get(rankIndex);
		            JLabel plyid = new JLabel(r.getPlayer_Name());
		            JLabel plarm = new JLabel(r.getChar_army());
		            JLabel plrac = new JLabel(r.getChar_race());
		            JLabel enerac = new JLabel(r.getRival_race());
		            JLabel enearm = new JLabel(r.getRival_race());
		            int batid = r.getBat_id();
		            int plh = r.getAlly_life();
		            int ehp = r.getEnemy_life();
		            int pt = r.getPoints();
		            battid.setText(" " + batid);		            allhp.setText(" " + plh);
		            enemhp.setText(" " + ehp);
		            batlpo.setText(" " + pt);


		            Dimension labelSize = new Dimension(100, 20);
		            battid.setPreferredSize(labelSize);
		            plyid.setPreferredSize(labelSize);
		            plrac.setPreferredSize(labelSize);
		            plarm.setPreferredSize(labelSize);
		            allhp.setPreferredSize(labelSize);
		            enerac.setPreferredSize(labelSize);
		            enearm.setPreferredSize(labelSize);
		            enemhp.setPreferredSize(labelSize);
		            batlpo.setPreferredSize(labelSize);

		            JPanel rowPanel = new JPanel();
		            rowPanel.add(battid);
		            rowPanel.add(plyid);
		            rowPanel.add(plrac);
		            rowPanel.add(plarm);
		            rowPanel.add(allhp);
		            rowPanel.add(enerac);
		            rowPanel.add(enearm);
		            rowPanel.add(enemhp);
		            rowPanel.add(batlpo);

		            charPanel.add(rowPanel);
		            rankIndex++;
		        }

		        mainPanel.add(charPanel);
		        panel.add(mainPanel);
		        panel.revalidate();
		        panel.repaint();

		    }
	        JButton returning = new JButton("Return Back");
	        
	        returning.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	volverinicio();
	            }
	            });
	        int widthb = 150;
	        int heightb = 70;
	        returning.setSize(widthb, heightb);
	        returning.setMaximumSize(new Dimension(widthb, heightb));
	        returning.setAlignmentX(Component.CENTER_ALIGNMENT);
		    panel.add(returning);
	        panel.revalidate();
	        panel.repaint();
	  }
}