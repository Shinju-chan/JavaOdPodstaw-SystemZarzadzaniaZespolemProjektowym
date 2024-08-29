package org.example;

import java.util.ArrayList;
import java.util.List;

public interface TeamMember {

    // Constants
    String TEAM_MEMBER_TYPE_DEVELOPER = "Developer";
    String TEAM_MEMBER_TYPE_MANAGER = "Manager";


    // Methods
    int getId();
    String getName();
    String getEmail();
    void displayTeamMemberInfo();
    public class Team {
        private List<TeamMember> teamMembers = new ArrayList<>();

        public void addTeamMember(TeamMember teamMember) {
            teamMembers.add(teamMember);
        }

        public List<TeamMember> getTeamMembers() {
            return teamMembers;
        }
    }
}
