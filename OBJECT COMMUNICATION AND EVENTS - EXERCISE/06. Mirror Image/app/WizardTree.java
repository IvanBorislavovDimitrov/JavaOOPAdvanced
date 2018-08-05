package app;

public class WizardTree {

    private Wizard wizard;
    private WizardTree leftChild;
    private WizardTree rightChild;

    public WizardTree(Wizard wizard) {
        this.wizard = wizard;
    }

    public void castFireball(int index) {
        WizardTree wizardTree = this.search(index, this);
        preOrder(wizardTree);
    }

    private void preOrder(WizardTree root) {
        if (root == null) {
            return;
        } else {
            System.out.println(String.format("%s %d casts Fireball for %d damage", root.wizard.getName(),
                    root.wizard.getId(), root.wizard.getMagicalPower()));
        }
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void castReflection(int index) {
        WizardTree wizardTree = this.search(index, this);
        if (!Times.countOfImages.containsKey(wizardTree.wizard.getId())) {
            Times.countOfImages.put(wizardTree.wizard.getId(), 1);
        } else {
            Times.countOfImages.put(wizardTree.wizard.getId(), Times.countOfImages.get(wizardTree.wizard.getId()) + 1);
        }
        if (Times.countOfImages.get(wizardTree.wizard.getId()) <= 2) {
            System.out.println(String.format("%s %d casts Reflection", wizardTree.wizard.getName(), wizardTree.wizard.getId()));
            this.dfsAdd(wizardTree);
        }
    }

    private void dfsAdd(WizardTree root) {
        if (root.leftChild == null || root.rightChild == null) {
            root.leftChild =
                    new WizardTree(new Wizard(IdIncrementer.getId(), root.wizard.getName(), root.wizard.getMagicalPower() / 2));
            root.rightChild =
                    new WizardTree(new Wizard(IdIncrementer.getId(), root.wizard.getName(), root.wizard.getMagicalPower() / 2));
        } else {
            dfsAdd(root.leftChild);
            System.out.println(String.format("%s %d casts Reflection", root.leftChild.wizard.getName(), root.leftChild.wizard.getId()));
            dfsAdd(root.rightChild);
            System.out.println(String.format("%s %d casts Reflection", root.rightChild.wizard.getName(), root.rightChild.wizard.getId()));
        }
    }

    private WizardTree search(int index, WizardTree root) {
        if (root == null) {
            return null;
        }
        if (root.wizard.getId() == index) {
            return root;
        }
        WizardTree wizardTree = search(index, root.leftChild);
        if (wizardTree != null) {
            return wizardTree;
        }
        wizardTree = search(index, root.rightChild);
        if (wizardTree != null) {
            return wizardTree;
        }

        return null;
    }
}
