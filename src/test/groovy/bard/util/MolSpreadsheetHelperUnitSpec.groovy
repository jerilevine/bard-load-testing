package bard.util

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/31/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */

@Unroll
class MolSpreadsheetHelperUnitSpec extends Specification {
    final MolSpreadsheetHelper helper = new MolSpreadsheetHelper()

    void "test MolSpreadsheetHelper"() {
        expect:
        helper.cidToExperimentCountMap
        helper.cidToExperimentCountMap.size() > 1
    }

    void "test findCidsByMinExperimentCount #desc #minimumNumExperiments experiments"() {
        expect: 'all the cids that appeared in at least 40 experiments'
        helper.findCidsByMinExperimentCount(minimumNumExperiments) == expectedCids
        where:
        desc                      | minimumNumExperiments | expectedCids
        "cids active in at least" | 29                    | [3689413]
        "cids active in at least" | 26                    | [2398303,5718138,9551964,3689413]
    }

    void "test findCidsWithExperimentCount #desc #numExperiments experiments"() {
        expect:
        helper.findCidsWithExperimentCount(numExperiments).size() == expectedCidCount

        where:
        desc                  | numExperiments | expectedCidCount
        "cids active exactly" | 29             | 1
        "cids active exactly" | 26             | 3
    }
}
