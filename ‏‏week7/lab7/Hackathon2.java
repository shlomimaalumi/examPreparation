package exceptions.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * After implementing the basic Git, Gal realized that he is committing his code a lot. He found out that
 * a lot of times he wants to rollback several commits back, and in his current implementation it is very
 * inefficient to do so.
 *
 * Help upgrade Gal’s git by using ids for his commits.
 *
 * Think of a data structure to use in the git class that can efficiently rollback to previous commit
 * based on a given commit id.
 *
 *
 * In this part you should change the code from the previous part to support commit id generation, and
 * efficient rollback by commit id.
 *
 * Originator - CodeProject
 *
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
 * commit() : int
 *
 * rollback(id:int)
 *
 * Choose a relevant data structure for the code commits.
 * */

/**
 * in this example, we will meet the memento pattern.
 * the memento pattern is used to capture the state of an object, and store
 * it in a way that it can be restored later.
 * the memento pattern is implemented using three classes:
 * 1. Originator: the object that knows how to save itself.
 * 2. Memento: the object that is used to store the state of the originator.
 * 3. Caretaker: the object that keeps track of the different states of the originator.
 * in this example :
 * the Memento is the snapshot of the code project.
 * the Originator is the code project.
 * the Caretaker is the git.
 * */

class CodeProject2 {
    private String code;
    private String name;

    public CodeProject2(String name) {
        this.name = name;
        this.code = "";
        System.out.println(String.format("Created a new project named: %s", name));

    }

    public void addCode(String code) {
        this.code += "\n" + code;
    }

    public void restore(SnapShot2 snapshot) {
        this.code = snapshot.getCode();
    }

    public String getCode() {
        return code;
    }

    public SnapShot2 createSnapshot() {
        return new SnapShot2(this.code);
    }

    public static class SnapShot2 {
        private String snap;

        private SnapShot2(String snap) {
            this.snap = snap;
        }

        private String getCode() {
            return this.snap;
        }
    }
}

class Git2 {
    private final List<CodeProject2.SnapShot2> commits = new ArrayList<>();
    CodeProject2 codeProject;

    public Git2(CodeProject2 hackathonProject) {
        this.codeProject = hackathonProject;
    }

    public int commit() {
        commits.add(codeProject.createSnapshot());
        return commits.size() - 1;
    }

    public void rollback(int ind) {
        if (!commits.isEmpty()) {
            CodeProject2.SnapShot2 lastSnapshot = commits.remove(ind);
            codeProject.restore(lastSnapshot);
        }
    }

}

public class Hackathon2 {
    public static void main(String[] args) {
        CodeProject2 hackathonProject = new CodeProject2("Hackathon");
        Git2 hackathonGit = new Git2(hackathonProject);

        hackathonProject.addCode("Ok, Lets start");
        int firstCommitId = hackathonGit.commit();
        // System.out.println("oz: 1st id: " + firstCommitId);
        hackathonProject.addCode("pseudo code for the project \n" +
                "use Python 3.7 \n" +
                "create dictionary and get data ");
        int secondCommitId = hackathonGit.commit();
        //   System.out.println("oz: 2nd id: " + secondCommitId);


        hackathonProject.addCode("add elements to dictionary: (Apple, 189), (Chips,547) \n" +
                "Calculate the best diet for me");
        int thirdCommitId = hackathonGit.commit();
        //   System.out.println("oz: 3rd id: " + thirdCommitId);

        hackathonProject.addCode("just some more code");
        int forthCommitId = hackathonGit.commit();

        hackathonProject.addCode("and more code");
        int fifthCommitId = hackathonGit.commit();

        System.out.println("State before rolled back");
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
        System.out.println("\n" + "************************************************************" + "\n");

        hackathonGit.rollback(thirdCommitId);
        System.out.println("Rolled back to commitId = " + thirdCommitId);
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
        System.out.println("\n" + "************************************************************" + "\n");

        hackathonGit.rollback(firstCommitId);
        System.out.println("Rolled back to commitId = " + firstCommitId);
        System.out.println(String.format("content: \n######## %s", hackathonProject.getCode()));
    }
}