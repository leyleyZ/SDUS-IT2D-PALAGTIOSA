package org.example.model;

public class user {
    private String studentId;
    private String name;
    private String roomNumber;
    private double utilityBalance;

    public user(String studentId, String name, String roomNumber, double utilityBalance) {
        this.studentId = studentId;
        this.name = name;
        this.roomNumber = roomNumber;
        this.utilityBalance = utilityBalance;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public double getUtilityBalance() { return utilityBalance; }
    public void setUtilityBalance(double utilityBalance) { this.utilityBalance = utilityBalance; }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name + " | Room: " + roomNumber + " | Utility Due: ₱" + utilityBalance;
    }
}