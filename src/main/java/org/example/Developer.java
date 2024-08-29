package org.example;

import java.util.List;


public class Developer extends Person implements TeamMember {
    private List<String> programmingLanguages;
    private String languages;

    public Developer(int id, String name, String email, List<String> programmingLanguages, String languages) {
        super(id, name, email);
        this.programmingLanguages = programmingLanguages;
        this.languages = languages;
    }

    @Override
    public void displayTeamMemberInfo() {
        System.out.println("Developer ID: " + getId());
        System.out.println("Developer Name: " + getName());
        System.out.println("Developer Email: " + getEmail());
        System.out.println("Programming Languages: " + languages);
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Developer(int id, String name, String email, List<String> programmingLanguages) {
        super(id, name, email);
        this.programmingLanguages = programmingLanguages;
    }

    // Getters and Setters
    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}

