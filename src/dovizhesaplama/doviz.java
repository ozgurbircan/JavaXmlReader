/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dovizhesaplama;

import java.io.File;


import java.net.URL;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Lenovo
 */
public class doviz extends javax.swing.JFrame {

    /**
     * Creates new form doviz
     */
    public doviz() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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
        setSize(new java.awt.Dimension(0, 0));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Döviz Kodu", "Birim", "Döviz Cinsi", "Döviz Alış", "Döviz Satış "
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Verileri Al");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(243, 243, 243)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
    
         URL u = new URL("http://www.tcmb.gov.tr/kurlar/today.xml");
         File fXmlFile = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\DovizHesaplama\\src\\dovizhesaplama\\staff.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	//Document doc = dBuilder.parse(fXmlFile);
        Document doc = dBuilder.parse(u.openStream());
    
    doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("Currency");
        Object []kolonlar={"Döviz Kodu","İsmi","forexalış","forexsatış"};
       	System.out.println("----------------------------");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
                Vector<Object> row = new Vector<Object>();
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
                
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
                            
			//row.add(eElement.getAttribute("CurrencyCode"));
			row.add(eElement.getAttribute("Kod"));
			//row.add(eElement.getElementsByTagName("CurrencyName").item(0).getTextContent());
                        row.add(eElement.getElementsByTagName("Unit").item(0).getTextContent());
			row.add(eElement.getElementsByTagName("Isim").item(0).getTextContent());
			row.add(eElement.getElementsByTagName("ForexBuying").item(0).getTextContent());
			row.add(eElement.getElementsByTagName("ForexSelling").item(0).getTextContent());
			//row.add(eElement.getElementsByTagName("BanknoteBuying").item(0).getTextContent());
			//row.add(eElement.getElementsByTagName("BanknoteSelling").item(0).getTextContent());
                        model.addRow(row);
                        
		}
                

                jTable2.setModel(model);
                
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

                
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doviz().setVisible(true);
            }
        });
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
 
}
