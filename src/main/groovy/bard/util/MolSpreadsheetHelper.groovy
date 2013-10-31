package bard.util

import org.apache.commons.lang3.math.NumberUtils

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/31/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
class MolSpreadsheetHelper {

    private final Map<Integer, Integer> cidToExperimentCountMap = [:]

    MolSpreadsheetHelper() {
        // looking to parse a file with CID and distinct experiment count
        // first line is a header

        this.getClass().getClassLoader().getResource("./pubchem_cid_disctinct_exp_count.csv").eachLine() { line ->
            def (String pubchemCid, String experimentCount) = line.split(',')
           if(NumberUtils.isNumber(pubchemCid)){
               cidToExperimentCountMap.put(pubchemCid.toInteger(), experimentCount.toInteger())
           }

        }
    }

    /**
     *
     * @param minimumExperiments
     * @return list of CIDs that appeared in at least the minimumExperiments specified
     */
    List<Integer> findCidsByMinExperimentCount(Integer minimumExperiments) {
        cidToExperimentCountMap.findAll { k, v -> v >= minimumExperiments }.collect{ k,v -> k}
    }

}
