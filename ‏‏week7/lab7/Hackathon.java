package exceptions.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Gal is participating in a hackathon in Paris. In order to keep track of his code and be able to revert
 * changes, he wants to work with git.
 *
 * The rules of the hackathon do not allow the use of any git service so Gal decided to write the code for
 * managing his local git repository himself.
 *
 * Gal wants a simple git implementation with the methods:
 *
 * Commit – saves the current state of the code.
 *
 * Rollback – reverts the code to state of last commit.
 *
 *
 * Originator - CodeProject
 *
 * Implements:
 *
 * createSnapshot()
 *
 * restore(snapshot)
 *
 *
 * Memento – Snapshot
 *
 *
 * CareTaker - Git
 *
 * Implements:
 *
 * commit()
 *
 * rollback()
 *
 * Choose a relevant data structure for the code commits.
 * */

/**
 * in this example, we will meet the memento pattern.
 * the memento pattern is used to capture the state of an object, and store
 * it in a way that it can be restored later.
 * the memento pattern is implemented using three classes:
 * 1. Originator: the object that knows how to save itself and restore itself.
 * 2. Memento: the object that is used to store the state of the originator.
 * 3. Caretaker: the object that keeps track of the different states of the originator.
 *
 * in this example :
 * the Memento is the snapshot of the code project.
 * the Originator is the code project.
 * the Caretaker is the git.
 * */

class CodeProject {
    private String code;
    private String name;

    public CodeProject(String name) {
        this.name = name;
        this.code = "";
        System.out.println(String.format("Created a new project named: %s", name));

    }

    public void addCode(String code) {
        this.code += "\n" + code;
    }

    public void restore(SnapShot snapshot) {
        this.code = snapshot.getCode();
    }

    public String getCode() {
        return code;
    }

    public SnapShot createSnapshot() {
        return new SnapShot(this.code);
    }

    public static class SnapShot {
        private String snap;

        private SnapShot(String snap) {
            this.snap = snap;
        }

        private String getCode() {
            return this.snap;
        }
    }
}

class Git {
    private final Stack<CodeProject.SnapShot> commits = new Stack<>();
    CodeProject codeProject;

    public Git(CodeProject hackathonProject) {
        this.codeProject = hackathonProject;
    }

    public void commit() {
        commits.add(codeProject.createSnapshot());
    }

    public void rollback() {
        if (!commits.isEmpty()) {
            CodeProject.SnapShot lastSnapshot = commits.pop();
            codeProject.restore(lastSnapshot);
        }
    }

}

public class Hackathon {
    public static void main(String[] args) {
        CodeProject hackathonProject = new CodeProject("Hackathon");
        Git hackathonGit = new Git(hackathonProject);

        hackathonProject.addCode("Ok, Lets start");
        hackathonGit.commit();

        hackathonProject.addCode("pseudo code for the project \n" +
                "use Python 3.7 \n" +
                "create dictionary and get data \n");
        hackathonGit.commit();


        hackathonProject.addCode("add elements to dictionary: (Apple, 189), (Chips,547) \n" +
                "Calculate the best diet for me");
        hackathonGit.commit();


        System.out.println("State before rolled back");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
        System.out.println("\n" + "************************************************************" + "\n");

        hackathonGit.rollback();
        System.out.println("Rolled back once");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));

        hackathonGit.rollback();
        System.out.println("Rolled back twice");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
    }
}