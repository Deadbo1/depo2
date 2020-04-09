package Repository;

import Models.Decorations;

import java.util.HashMap;

public class RepositoryForDecorations {

    private static RepositoryForDecorations repositoryForDecorations;

    public static RepositoryForDecorations getInstance() {
        if (repositoryForDecorations == null) {
            repositoryForDecorations = new RepositoryForDecorations();
            return repositoryForDecorations;
        }
        return repositoryForDecorations;
    }

    private HashMap<Integer, Decorations> decorations = new HashMap<Integer, Decorations>();

    public void addDecoration(Decorations decoration) {
        decorations.put(decoration.getId(), decoration);
    }

    public Decorations getDecorationById(int id) {
        return decorations.get(id);
    }

    public void deleteDecoration(Decorations decoration) {
        decorations.remove(decoration.getId());
    }

    public void updateDecorations(Decorations decoration) {
        deleteDecoration(decoration);
        addDecoration(decoration);
    }


    public HashMap<Integer, Decorations> getDecorations() {
        return decorations;
    }
}
