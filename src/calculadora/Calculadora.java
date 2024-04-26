package calculadora;

import java.awt.Color;
import com.mysql.jdbc.Connection;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
   // la integracion de los apartados de sonido viene de parte de un foto de stackoverflow, junto con un wav que viene de freesound.com
   
public class Calculadora extends javax.swing.JFrame {

    private boolean punto = true; //me sirve para el boton
    String num1, num2, signo, contenido;
    Double resultado;
    Double resulta = 0.0;
    String respuesta;

    public void setTable() {
        PreparedStatement pr = null; //para poder realizar la consulta
        ResultSet rs = null; // sirve para obtener los resultados
        ResultSetMetaData rsmt = null; //sirve para obtener informacion de la base de datos
        //preparamos las variables que vamos a utiliza
        try {
            DefaultTableModel model = new DefaultTableModel(); //para poder modificar la tabla un modelo de jtable
            tabla.setModel(model);
            model.addColumn("id");
            model.addColumn("calculo");
            model.addColumn("resultado"); //definimos los nombres de las columnas, tambien se puede hacer por meta datos
            com.mysql.jdbc.Connection sql = (com.mysql.jdbc.Connection) new conexion().getConexion();
            pr = (PreparedStatement) sql.prepareStatement("SELECT * FROM Calculos");
            rs = pr.executeQuery();
            rsmt = pr.getMetaData();
            //obtenemos la conexion, realizamos la consulta y guardamos los datos
            int cols = rsmt.getColumnCount(); //obtenemos columnas
            Object filas[] = new Object[cols]; // definimos el numero de columnas para rellenar datos
            while (rs.next()) {
                for (int i = 0; i < cols; i++) {
                    filas[i] = rs.getObject(i + 1); //almacenamos los datos en objetos
                }
                model.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Revise la conexion a la base de datos, o a la tabla.", "ERROR", 0, 0);

        }
    }
 public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/suma/success-48018.wav").getAbsoluteFile());
            Mixer.Info[] mixers =  AudioSystem.getMixerInfo(); //declaramos opciones de mixer, depende del tipo de salida
            Clip clip = AudioSystem.getClip(mixers[0]); //este es el mixer de mis auriculares, los tres primeros son de la placa
            //probablemente se deba de cambiar de mixer para poder verse
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error mientras se reproducia el archivo.");
            ex.printStackTrace();
        }
    }

    public Calculadora() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtResultado = new javax.swing.JLabel();
        btn_oscuro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnigual = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnexp = new javax.swing.JButton();
        btnraiz = new javax.swing.JButton();
        btndiv = new javax.swing.JButton();
        btnmulti = new javax.swing.JButton();
        btnresta = new javax.swing.JButton();
        btnsuma = new javax.swing.JButton();
        btnrm = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btnmasmenos = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnpunto = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 253, 251));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtResultado.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 48)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(55, 62, 71));
        txtResultado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 320, 60));

        btn_oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/darkmode_1.png"))); // NOI18N
        btn_oscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oscuroActionPerformed(evt);
            }
        });
        jPanel1.add(btn_oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 20));

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("•");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 20, 20));

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("•");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patito.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 210, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 250));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnigual.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 30)); // NOI18N
        btnigual.setForeground(new java.awt.Color(255, 255, 255));
        btnigual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn3.png"))); // NOI18N
        btnigual.setText("=");
        btnigual.setFocusPainted(false);
        btnigual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnigual.setPreferredSize(new java.awt.Dimension(50, 50));
        btnigual.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnigual.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnigual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnigualActionPerformed(evt);
            }
        });
        jPanel2.add(btnigual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        btn9.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn9.setForeground(new java.awt.Color(55, 62, 71));
        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn9.setText("9");
        btn9.setFocusPainted(false);
        btn9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn9.setPreferredSize(new java.awt.Dimension(50, 50));
        btn9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        btnexp.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 20)); // NOI18N
        btnexp.setForeground(new java.awt.Color(55, 62, 71));
        btnexp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnexp.setText("<-");
        btnexp.setFocusPainted(false);
        btnexp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnexp.setPreferredSize(new java.awt.Dimension(50, 50));
        btnexp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnexp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnexp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexpActionPerformed(evt);
            }
        });
        jPanel2.add(btnexp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        btnraiz.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 21)); // NOI18N
        btnraiz.setForeground(new java.awt.Color(55, 62, 71));
        btnraiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnraiz.setText(" √");
        btnraiz.setFocusPainted(false);
        btnraiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnraiz.setPreferredSize(new java.awt.Dimension(50, 50));
        btnraiz.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnraiz.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnraiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnraizActionPerformed(evt);
            }
        });
        jPanel2.add(btnraiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        btndiv.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 24)); // NOI18N
        btndiv.setForeground(new java.awt.Color(55, 62, 71));
        btndiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btndiv.setText("/");
        btndiv.setFocusPainted(false);
        btndiv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndiv.setPreferredSize(new java.awt.Dimension(50, 50));
        btndiv.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btndiv.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btndiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndivActionPerformed(evt);
            }
        });
        jPanel2.add(btndiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        btnmulti.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 24)); // NOI18N
        btnmulti.setForeground(new java.awt.Color(55, 62, 71));
        btnmulti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnmulti.setText("X");
        btnmulti.setFocusPainted(false);
        btnmulti.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnmulti.setPreferredSize(new java.awt.Dimension(50, 50));
        btnmulti.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnmulti.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnmulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmultiActionPerformed(evt);
            }
        });
        jPanel2.add(btnmulti, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        btnresta.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 32)); // NOI18N
        btnresta.setForeground(new java.awt.Color(55, 62, 71));
        btnresta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnresta.setText("-");
        btnresta.setFocusPainted(false);
        btnresta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnresta.setPreferredSize(new java.awt.Dimension(50, 50));
        btnresta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnresta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestaActionPerformed(evt);
            }
        });
        jPanel2.add(btnresta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        btnsuma.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 30)); // NOI18N
        btnsuma.setForeground(new java.awt.Color(55, 62, 71));
        btnsuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnsuma.setText("+");
        btnsuma.setFocusPainted(false);
        btnsuma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsuma.setPreferredSize(new java.awt.Dimension(50, 50));
        btnsuma.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnsuma.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnsuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsumaActionPerformed(evt);
            }
        });
        jPanel2.add(btnsuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        btnrm.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 24)); // NOI18N
        btnrm.setForeground(new java.awt.Color(55, 62, 71));
        btnrm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnrm.setText("C");
        btnrm.setFocusPainted(false);
        btnrm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnrm.setPreferredSize(new java.awt.Dimension(50, 50));
        btnrm.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnrm.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrmActionPerformed(evt);
            }
        });
        jPanel2.add(btnrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        btn7.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn7.setForeground(new java.awt.Color(55, 62, 71));
        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn7.setText("7");
        btn7.setFocusPainted(false);
        btn7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn7.setPreferredSize(new java.awt.Dimension(50, 50));
        btn7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        btn8.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn8.setForeground(new java.awt.Color(55, 62, 71));
        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn8.setText("8");
        btn8.setFocusPainted(false);
        btn8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn8.setPreferredSize(new java.awt.Dimension(50, 50));
        btn8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        btn6.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn6.setForeground(new java.awt.Color(55, 62, 71));
        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn6.setText("6");
        btn6.setFocusPainted(false);
        btn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn6.setPreferredSize(new java.awt.Dimension(50, 50));
        btn6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        btn5.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 24)); // NOI18N
        btn5.setForeground(new java.awt.Color(55, 62, 71));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn5.setText("5");
        btn5.setFocusPainted(false);
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn5.setPreferredSize(new java.awt.Dimension(50, 50));
        btn5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        btn4.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn4.setForeground(new java.awt.Color(55, 62, 71));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn4.setText("4");
        btn4.setFocusPainted(false);
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn4.setPreferredSize(new java.awt.Dimension(50, 50));
        btn4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        btnmasmenos.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btnmasmenos.setForeground(new java.awt.Color(55, 62, 71));
        btnmasmenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btnmasmenos.setText("±");
        btnmasmenos.setFocusPainted(false);
        btnmasmenos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnmasmenos.setPreferredSize(new java.awt.Dimension(50, 50));
        btnmasmenos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnmasmenos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnmasmenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasmenosActionPerformed(evt);
            }
        });
        jPanel2.add(btnmasmenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

        btn2.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn2.setForeground(new java.awt.Color(55, 62, 71));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn2.setText("2");
        btn2.setFocusPainted(false);
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn2.setPreferredSize(new java.awt.Dimension(50, 50));
        btn2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        btn1.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn1.setForeground(new java.awt.Color(55, 62, 71));
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn1.setText("1");
        btn1.setFocusPainted(false);
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.setPreferredSize(new java.awt.Dimension(50, 50));
        btn1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        btnpunto.setFont(new java.awt.Font("Montserrat Medium", 1, 24)); // NOI18N
        btnpunto.setForeground(new java.awt.Color(55, 62, 71));
        btnpunto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btnpunto.setText(".");
        btnpunto.setFocusPainted(false);
        btnpunto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpunto.setPreferredSize(new java.awt.Dimension(50, 50));
        btnpunto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btnpunto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btnpunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpuntoActionPerformed(evt);
            }
        });
        jPanel2.add(btnpunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        btn0.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn0.setForeground(new java.awt.Color(55, 62, 71));
        btn0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn0.setText("0");
        btn0.setFocusPainted(false);
        btn0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn0.setPreferredSize(new java.awt.Dimension(50, 50));
        btn0.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn0.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel2.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        btn3.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        btn3.setForeground(new java.awt.Color(55, 62, 71));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn2.png"))); // NOI18N
        btn3.setText("3");
        btn3.setFocusPainted(false);
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn3.setPreferredSize(new java.awt.Dimension(50, 50));
        btn3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1.png"))); // NOI18N
        btn3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn1_pressed.png"))); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        tabla.setAutoCreateRowSorter(true);
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Calculo", "Resultado"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 220, 360));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, 230));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 550, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnraizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnraizActionPerformed
        contenido = txtResultado.getText();
        if (contenido.length() > 0) {
            resultado = Math.sqrt(Double.parseDouble(contenido));
            txtResultado.setText(resultado.toString());

        }

    }//GEN-LAST:event_btnraizActionPerformed
    
    private void btnrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrmActionPerformed
        txtResultado.setText("");
    }//GEN-LAST:event_btnrmActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        txtResultado.setText(txtResultado.getText() + "0");

    }//GEN-LAST:event_btn0ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        txtResultado.setText(txtResultado.getText() + "7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnexpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexpActionPerformed

    }//GEN-LAST:event_btnexpActionPerformed

    private void btndivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndivActionPerformed
        if (!txtResultado.getText().equals("")) {
            num1 = txtResultado.getText();
            signo = "/";
            txtResultado.setText("");
        }

    }//GEN-LAST:event_btndivActionPerformed

    private void btnmultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmultiActionPerformed
        if (!txtResultado.getText().equals("")) {
            num1 = txtResultado.getText();
            signo = "X";
            txtResultado.setText("");
        }

    }//GEN-LAST:event_btnmultiActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        txtResultado.setText(txtResultado.getText() + "9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        txtResultado.setText(txtResultado.getText() + "8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        txtResultado.setText(txtResultado.getText() + "4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        txtResultado.setText(txtResultado.getText() + "5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        txtResultado.setText(txtResultado.getText() + "6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        txtResultado.setText(txtResultado.getText() + "1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        txtResultado.setText(txtResultado.getText() + "2");

    }//GEN-LAST:event_btn2ActionPerformed
    public String operaciones(String num1, String num2, String signo) {
        try{
            if (signo.equals("+")) {
            resulta = Double.parseDouble(num1) + Double.parseDouble(num2);
        } else if (signo.equals("-")) {
            resulta = Double.parseDouble(num1) - Double.parseDouble(num2);
        } else if (signo.equals("X")) {
            resulta = Double.parseDouble(num1) * Double.parseDouble(num2);
        } else if (signo.equals("/")) {
            resulta = Double.parseDouble(num1) / Double.parseDouble(num2);
        } else if (signo.equals("-")) {
            resulta = Double.parseDouble(num1) - Double.parseDouble(num2);
        } else if (signo.equals("<-")) {
            resulta = Double.parseDouble(num1) * Double.parseDouble(num2);
        }
        respuesta = resulta.toString();
        return respuesta;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Debes ingresar un segundo numero");
        }
        return respuesta;
    }
    private void btnmasmenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasmenosActionPerformed
        contenido = txtResultado.getText();
        if (contenido.length() > 0) {
            resultado = (-1) * Double.parseDouble(contenido);
            txtResultado.setText(resultado.toString());
            //lo que hacemos aca e multiplicar el -1 para convertir un numero 
            //positivo a negativo.

        }
    }//GEN-LAST:event_btnmasmenosActionPerformed

    private void btnpuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpuntoActionPerformed
        contenido = txtResultado.getText();
        //si el contenido es igual o menor a 0,muestra "0.
        //si el campo esta vacio muestra "0.
        if (contenido.length() <= 0) {
            txtResultado.setText("0.");
        } else //contamos ucantos puntos existen, si hay algun punto,
        //no se podra colocar otr punto
        if (txtResultado.getText().contains(".")) {

        } else {
            txtResultado.setText(txtResultado.getText() + ".");
            punto = false;
        }

    }//GEN-LAST:event_btnpuntoActionPerformed

    private void btnigualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnigualActionPerformed
        String total;
        num2 = txtResultado.getText();
        if (!num2.equals("")) {
            total = operaciones(num1, num2, signo);
            txtResultado.setText(total);
            try {
                java.sql.Connection sql = new conexion().getConexion();
                PreparedStatement pr = null;
                ResultSet rs = null;
                pr = (PreparedStatement) sql.prepareStatement("INSERT INTO Calculos VALUES(null, ?, ?)");
                pr.setString(1, resulta.toString());
                pr.setString(2, respuesta);
                pr.execute();
                setTable();
            } catch (SQLException e) {
                if (e.toString().contains("Expected l-value but found")) {
                    JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "Ingrese un Valor a calcular.", "ERROR", 0, 0);
                }
                if (e.toString().contains("Expected an operand but found eof")) {
                    JOptionPane.showConfirmDialog(null, "Ha habido un Error: \n" + "No finalice los calculos con operadores.", "ERROR", 0, 0);
                }
            }
        }


    }//GEN-LAST:event_btnigualActionPerformed

    private void btnsumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsumaActionPerformed
        if (!txtResultado.getText().equals("")) {
            num1 = txtResultado.getText();
            signo = "+";
            txtResultado.setText("");
        }
    }//GEN-LAST:event_btnsumaActionPerformed

    private void btnrestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaActionPerformed
        if (!txtResultado.getText().equals("")) {
            num1 = txtResultado.getText();
            signo = "-";
            txtResultado.setText("");
        }
    }//GEN-LAST:event_btnrestaActionPerformed

    boolean modoOscuro = false;

    private void btn_oscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oscuroActionPerformed
        if (!modoOscuro) {
            jPanel1.setBackground(Color.decode("#212b41"));
            jPanel2.setBackground(Color.decode("#2e3951"));

            txtResultado.setForeground(Color.decode("#0db387"));
            cambiarColorBtn1(btnmulti);
            cambiarColorBtn1(btnsuma);
            cambiarColorBtn1(btnresta);
            cambiarColorBtn1(btnexp);
            cambiarColorBtn1(btndiv);
            cambiarColorBtn1(btnrm);
            cambiarColorBtn1(btnraiz);
            cambiarColorBtn2(btn1);
            cambiarColorBtn2(btn2);
            cambiarColorBtn2(btn3);
            cambiarColorBtn2(btnmasmenos);
            cambiarColorBtn2(btn4);
            cambiarColorBtn2(btn5);
            cambiarColorBtn2(btn6);
            cambiarColorBtn2(btn7);
            cambiarColorBtn2(btn8);
            cambiarColorBtn2(btn9);
            cambiarColorBtn2(btn0);
            cambiarColorBtn2(btnpunto);

            btn_oscuro.setIcon(new ImageIcon(getClass().getResource("/images/darkmode_2.png")));
            btnigual.setIcon(new ImageIcon(getClass().getResource("/images/btn3_dark.png")));
            btnigual.setPressedIcon(new ImageIcon(getClass().getResource("/images/btn3_dark.png")));
            btnigual.setRolloverIcon(new ImageIcon(getClass().getResource("/images/btn3_pressed_dark.png")));
            btnigual.setForeground(Color.decode("#2e3951"));
            modoOscuro = true;
        } else {
            Calculadora frame = new Calculadora();
            this.dispose();
            frame.setVisible(true);
        }


    }//GEN-LAST:event_btn_oscuroActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
         txtResultado.setText(txtResultado.getText() + "3");
    }//GEN-LAST:event_btn3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    public void cambiarColorBtn1(JButton btn) {
        btn.setIcon(new ImageIcon(getClass().getResource("/images/btn1_dark.png")));
        btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/btn1_dark.png")));
        btn.setRolloverIcon(new ImageIcon(getClass().getResource("/images/btn1_pressed_dark.png")));
        btn.setForeground(Color.decode("#0db387"));
    }

    public void cambiarColorBtn2(JButton btn) {
        btn.setIcon(new ImageIcon(getClass().getResource("/images/btn2_dark.png")));
        btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/btn2_dark.png")));
        btn.setRolloverIcon(new ImageIcon(getClass().getResource("/images/btn1_pressed_dark.png")));
        btn.setForeground(Color.decode("#96a8a0"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btn_oscuro;
    private javax.swing.JButton btndiv;
    private javax.swing.JButton btnexp;
    private javax.swing.JButton btnigual;
    private javax.swing.JButton btnmasmenos;
    private javax.swing.JButton btnmulti;
    private javax.swing.JButton btnpunto;
    private javax.swing.JButton btnraiz;
    private javax.swing.JButton btnresta;
    private javax.swing.JButton btnrm;
    private javax.swing.JButton btnsuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}
