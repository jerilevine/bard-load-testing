package bard

import pages.ShowExperimentDetailsPage
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 11/7/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Unroll
class MolSpreadsheetUnitSpec extends FunctionalUnitSpec {

    void "testMolSpreadsheetForCidsActiveInManyExperiments"() {

        expect: 'we can drive the script '
        final Binding binding = new Binding();
        binding.setVariable("Parameters", "");
        gse.run("MolSpreadsheetFromCidsScript.groovy", binding);
    }

    void testShowExperimentalDetails() {
        when: 'we can drive the '
        final Binding binding = new Binding();
        binding.setVariable("Parameters", parameters);
        ShowExperimentDetailsPage showExperimentDetailsPage = gse.run("MolSpreadsheetShowExperimentDetailsForCid.groovy", binding);

        then:
        showExperimentDetailsPage.getLinkedEids().containsAll(expectedEids)

        where:
        desc          | parameters     | expectedEids
        'no params'   | ''             | []
        'specify cid' | '[cid:746381]' | ['4411', '4413', '3452', '3897']
    }

    void "test search for a term, use the cart and view MolSpreadsheet"() {

        expect: 'we can drive the script '
        final Binding binding = new Binding();
        binding.setVariable("Parameters", "");
        gse.run("SearchForTermUseCartAndViewMolSpreadsheet.groovy", binding);
    }
}
