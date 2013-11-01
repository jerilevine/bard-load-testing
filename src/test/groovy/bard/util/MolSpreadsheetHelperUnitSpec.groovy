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
        "cids active in at least" | 40                    | [66541, 6763, 701067, 375895, 10864994, 2408467, 443939, 460747, 254021, 6364517, 9551964, 5718631, 3609942, 1472216]
        "cids active in at least" | 48                    | [66541, 6763]
    }

    void "test findCidsWithExperimentCount #desc #numExperiments experiments"() {
        expect:
        helper.findCidsWithExperimentCount(numExperiments).size() == expectedCidCount

        where:
        desc                  | numExperiments | expectedCidCount
        "cids active exactly" | 48             | 2
        "cids active exactly" | 47             | 1
        "cids active exactly" | 46             | 1
        "cids active exactly" | 20             | 46
    }
}
