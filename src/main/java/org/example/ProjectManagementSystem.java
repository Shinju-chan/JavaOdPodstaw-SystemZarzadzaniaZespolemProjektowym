package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectManagementSystem {
    private List<Person> teamMembers;
    private List<Task> tasks;


    public void addTeamMember(List<String> programmingLanguages) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz stanowisko osoby z zespołu (Programista/Menedżer): ");
        String type = scanner.nextLine();

        System.out.println("Wprowadź identyfikator osoby z zwspołu: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.println("Wprowadź nazwę zespołu: ");
        String name = scanner.nextLine();

        System.out.println("Wprowadź adres email zespołu: ");
        String email = scanner.nextLine();

        if (type.equalsIgnoreCase("Developer")) {
            System.out.println("Wpisz języki programowania (oddzielone przecinkami):");
            String languages;
            languages = scanner.nextLine();
            TeamMember teamMember = new Developer(id, name, email, programmingLanguages, languages);
            teamMembers.add((Person) teamMember);
            System.out.println("Developer added successfully!");
        } else if (type.equalsIgnoreCase("Manager")) {
            System.out.println("Podaj wielkośc zespołu: ");
            int teamSize = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            TeamMember teamMember = new Manager(id, name, email, teamSize);
            teamMembers.add((Person) teamMember);
            System.out.println("Menedżer został dodany pomyślnie!");
        } else {
            System.out.println("Błędne stanowisko osoby z zespołu!");
        }
    }
    public ProjectManagementSystem() {
        teamMembers = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public void addTeamMember(Person person) {
        teamMembers.add(person);
    }

    public void assignTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        try (PrintWriter writer = new PrintWriter("tasks.txt")) {
            for (Task task : tasks) {
                writer.println("ID zadania: " + task.getTaskId());
                writer.println("Nazwa: " + task.getTitle());
                writer.println("Opis: " + task.getDescription());
                writer.println("Osoaba odpowiedzialna: " + task.getAssignee().getName());
                writer.println("Status: " + task.getStatus());
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Błąd podczas zapisywania zadań do pliku: " + e.getMessage());
        }
    }

    public void displayTasksByStatus(String status) {
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                System.out.println("ID zadania: " + task.getTaskId());
                System.out.println("Nazwa: " + task.getTitle());
                System.out.println("Opis: " + task.getDescription());
                System.out.println("Osoba odpowiedzialna: " + task.getAssignee().getName());
                System.out.println("Status: " + task.getStatus());
                System.out.println();
            }
        }
    }

    public void updateTaskStatus(int taskId, String newStatus) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.setStatus(newStatus);
                break;
            }
        }
    }


    public void operateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Project Management System");
            System.out.println("1. Dodaj nową osobę zespołu");
            System.out.println("2. Przydziel zadanie osobie z zespołu");
            System.out.println("3. Wyświetl wszystkie zadania");
            System.out.println("4. Wyświetl zadania według statusu");
            System.out.println("5. Aktualizuj status zadania");
            System.out.println("6. Wyjście");
            System.out.print("Wpisz swój wybór: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Dodawanie osoby do zespołu
                    System.out.print("Wprowadź identyfikator osoby z zespołu: ");
                    int id = scanner.nextInt();
                    System.out.print("Wprowadź imię i nazwisko osoby z zwspołu: ");
                    String name = scanner.next();
                    System.out.print("Wprowadź adres e-mail osoby z zespołu: ");
                    String email = scanner.next();
                    // Tworzenie nowego obiektu osoby z zespołu i dodawanie go do listy
                    break;
                case 2:
                    // Przydzielealnie zadań w zespole
                    System.out.print("Wprowadź identyfikator zadania: ");
                    int taskId = scanner.nextInt();
                    System.out.print("Wprowadź nazwę zadania: ");
                    String title = scanner.next();
                    System.out.print("Wprowadź opis zadania: ");
                    String description = scanner.next();
                    System.out.print("Wprowadź identyfikator osoby z zespołu: ");
                    int assigneeId = scanner.nextInt();
                    // Tworznie nowego obiektu zadaniai przypisywanie go do osoby z zespołu
                    break;
                case 3:
                    // Wyświetkanie wszystki zadań
                    displayTasks();
                    break;
                case 4:
                    // Wyświetlanie wesług zadań
                    System.out.print("Wprowadź stattus zadania: ");
                    String status = scanner.next();
                    displayTasksByStatus(status);
                    break;
                case 5:
                    // Zmianina statusu zadania
                    System.out.print("Wprowadź identyfikator zadania: ");
                    int updateTaskId = scanner.nextInt();
                    System.out.print("Wprowadź nowy status zadania: ");
                    String newStatus = scanner.next();
                    updateTaskStatus(updateTaskId, newStatus);
                    break;
                case 6:
                    // Wyjście
                    System.out.println("Do widzenia! :)");
                    return;
                default:
                    System.out.println("Coś nie wyszło. Spróbuj jeszcze raz");
            }
        }
    }
}