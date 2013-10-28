package bard.util;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public enum SearchResultsTab {
    ASSAYS("assays"), COMPOUNDS("compounds"), PROJECTS("projects");

    private String tabName;

    private SearchResultsTab(String name){
        tabName = name;
    }

    public String getTabName(){
        return tabName;
    }
}
