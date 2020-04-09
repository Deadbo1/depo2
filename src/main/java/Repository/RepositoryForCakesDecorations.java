package Repository;

import Models.CakesDecorations;

import java.util.ArrayList;
import java.util.List;

public class RepositoryForCakesDecorations {

    private static RepositoryForCakesDecorations repositoryForCakesDecorations;

    public static RepositoryForCakesDecorations getInstance() {
        if (repositoryForCakesDecorations == null) {
            repositoryForCakesDecorations = new RepositoryForCakesDecorations();
            return repositoryForCakesDecorations;
        }
        return repositoryForCakesDecorations;
    }

    private List<CakesDecorations> cakesDecorations = new ArrayList<CakesDecorations>();

    public void addCakesDecorations(CakesDecorations cakeDecoration){
        cakesDecorations.add(cakeDecoration);
    }

    public void deleteCakesDecorations(int cakeId,int decorationId) {
        for (CakesDecorations cakesDecoration: cakesDecorations) {
            if (cakesDecoration.getCakeId() == cakeId && cakesDecoration.getDecorationId() == decorationId){
                cakesDecorations.remove(cakesDecoration);
            }
        }
    }

    public List<CakesDecorations> getCakesDecorations() {
        return cakesDecorations;
    }
}
