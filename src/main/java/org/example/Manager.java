package org.example;

public class Manager extends Person implements TeamMember{
    private int teamSize;

    public Manager(int id, String name, String email, int teamSize) {
        super(id, name, email); // Calls the constructor of the Person class
        this.teamSize = teamSize;
    }

    @Override
    public void displayTeamMemberInfo() {
        System.out.println("Manager ID: " + getId());
        System.out.println("Manager Name: " + getName());
        System.out.println("Manager Email: " + getEmail());
        System.out.println("Team Size: " + teamSize);
    }

    // Getters and Setters
    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
