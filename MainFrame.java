package MiniProject;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainMenu mainMenuPage;
    private AddStudent addStudentPage;
    private ListStudent listStudentPage;

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENT APPLICATION");
        setSize(500, 500);
        setLayout(null);

        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudentPage = new AddStudent(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listStudentPage = new ListStudent(this);
        listStudentPage.setVisible(false);
        add(listStudentPage);
    }

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public AddStudent getAddStudentPage() {
        return addStudentPage;
    }

    public ListStudent getListStudentPage() {
        return listStudentPage;
    }

}
