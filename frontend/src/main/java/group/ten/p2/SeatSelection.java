/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.ten.p2;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import group.ten.p2.interfaces.RestServer;
import group.ten.p2.interfaces.ServerInterface;

/**
 *
 * @author dwara
 */
public class SeatSelection extends javax.swing.JFrame {
    private ServerInterface serverInterface;
    private String flightIdentifier;
    private String flightString;
    private String flightSeatsString;
    private HashMap<String, String> flightDetails = new HashMap<>();
    private String[] flightSeatsArray;

    /**
     * Creates new form SeatSelection
     */
    public SeatSelection(String type, String flightIdentifier) {
        this.flightIdentifier = flightIdentifier;
        if(type=="REST"){
            serverInterface = new RestServer();
            try {
                flightString = serverInterface.getFlight(this.flightIdentifier);
                flightSeatsString = serverInterface.getSeatsForFlight(this.flightIdentifier);
                populateFlight();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        initComponents();
    }

    private void populateFlight() {
        JSONObject flight = new JSONObject(this.flightString);
        flightDetails.put(RestServer.ORIGIN_DATE, flight.getString(RestServer.ORIGIN_DATE));
        flightDetails.put(RestServer.FILGHT_NUMBER, flight.getString(RestServer.FILGHT_NUMBER));
        flightDetails.put(RestServer.DEPARTURE_AIRPORT, flight.getString(RestServer.DEPARTURE_AIRPORT));
        flightDetails.put(RestServer.ARRIVAL_AIRPORT, flight.getString(RestServer.ARRIVAL_AIRPORT));

        JSONArray flightSeatsArrayJSON = new JSONArray(flightSeatsString);
        flightSeatsArray = new String[flightSeatsArrayJSON.length()];
        for (int i=0; i<flightSeatsArrayJSON.length(); i++) {
            JSONObject flightSeat = flightSeatsArrayJSON.getJSONObject(i);
            flightSeatsArray[i] = flightSeat.getString(RestServer.SEAT_UNIQUE_CODE) +"-[" + flightSeat.getString(RestServer.SEAT_TYPE)+ "]";
            if ((boolean)flightSeat.get(RestServer.EXIT_ROW)) {
                flightSeatsArray[i] = flightSeatsArray[i] + "-[EXIT]";
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxFoodPreference = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSeatSelection = new javax.swing.JComboBox<>();
        jTextFieldSelectedFlight = new javax.swing.JTextField();
        jTextFieldOriginDate = new javax.swing.JTextField();
        jTextFieldDepartureAirport = new javax.swing.JTextField();
        jTextFieldArrivalAirport = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldAge = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTextFieldOriginDate.setText(this.flightDetails.get(RestServer.ORIGIN_DATE));
        jTextFieldSelectedFlight.setText(this.flightDetails.get(RestServer.FILGHT_NUMBER));
        jTextFieldDepartureAirport.setText(this.flightDetails.get(RestServer.DEPARTURE_AIRPORT));
        jTextFieldArrivalAirport.setText(this.flightDetails.get(RestServer.ARRIVAL_AIRPORT));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setText("Selected Flight: ");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel2.setText("Origin Date:");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel3.setText("Departure Airport:");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setText("Arrival Airport:");

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel5.setText("Food Preference: ");

        jComboBoxFoodPreference.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jComboBoxFoodPreference.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vegetarian", "Non-Vegetarian", "Vegan"}));

        jButton1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton1.setText("Book Ticket");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel6.setText("Seat Selection: ");

        jComboBoxSeatSelection.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jComboBoxSeatSelection.setModel(new javax.swing.DefaultComboBoxModel<>(flightSeatsArray));

        jTextFieldSelectedFlight.setEditable(false);
        jTextFieldSelectedFlight.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextFieldSelectedFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSelectedFlightActionPerformed(evt);
            }
        });

        jTextFieldOriginDate.setEditable(false);
        jTextFieldOriginDate.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextFieldOriginDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOriginDateActionPerformed(evt);
            }
        });

        jTextFieldDepartureAirport.setEditable(false);
        jTextFieldDepartureAirport.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextFieldDepartureAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDepartureAirportActionPerformed(evt);
            }
        });

        jTextFieldArrivalAirport.setEditable(false);
        jTextFieldArrivalAirport.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel8.setText("Age:");

        jTextFieldName.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jTextFieldAge.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel9.setText("PASSENGER DETAILS");

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel10.setText("FLIGHT DETAILS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldArrivalAirport)
                    .addComponent(jTextFieldName)
                    .addComponent(jTextFieldAge)
                    .addComponent(jComboBoxSeatSelection, 0, 259, Short.MAX_VALUE)
                    .addComponent(jComboBoxFoodPreference, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldOriginDate)
                    .addComponent(jTextFieldDepartureAirport)
                    .addComponent(jTextFieldSelectedFlight))
                .addGap(211, 211, 211))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(361, 361, 361))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldSelectedFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldOriginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDepartureAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldArrivalAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxSeatSelection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxFoodPreference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isNotValidSeat() {
        String selectedSeat = flightSeatsArray[jComboBoxSeatSelection.getSelectedIndex()];
        String[] splitSeatString = selectedSeat.split("-");
        int age;
        try {
                age = Integer.parseInt(jTextFieldAge.getText());
        } catch(Exception e) {
            javax.swing.JLabel label = new javax.swing.JLabel("Invalid age Entered!!!");
            label.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 18));
            javax.swing.JOptionPane.showMessageDialog(null, label, "ERROR" , javax.swing.JOptionPane.WARNING_MESSAGE);
            return true;
        }
        if(splitSeatString[2].equals("[EXIT]") && age>40) {
            return true;
        }
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (isNotValidSeat()) {
            javax.swing.JLabel label = new javax.swing.JLabel("Emergency exit seats can only be selected by customers 40 years of age or less!!!");
            label.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 18));
            javax.swing.JOptionPane.showMessageDialog(null, label, "ERROR" , javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        new Payment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldSelectedFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSelectedFlightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSelectedFlightActionPerformed

    private void jTextFieldOriginDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOriginDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOriginDateActionPerformed

    private void jTextFieldDepartureAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDepartureAirportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDepartureAirportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxFoodPreference;
    private javax.swing.JComboBox<String> jComboBoxSeatSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldArrivalAirport;
    private javax.swing.JTextField jTextFieldDepartureAirport;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldOriginDate;
    private javax.swing.JTextField jTextFieldSelectedFlight;
    // End of variables declaration//GEN-END:variables
}
