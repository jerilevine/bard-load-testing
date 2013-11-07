package bard.util

import org.apache.commons.lang3.math.NumberUtils

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/31/13
 * Time: 1:31 PM
 *
 * The data in the file was produced by the following query on BBDS
 *
 * -- look for CIDs that are not null, are pubchem outcome Active
 * -- and appear in some number of experiments and the experiments are not Draft
 * select to_char(s.PUBCHEM_CID) PUBCHEM_CID
 *        ,count(distinct e.EXPERIMENT_REF) DISTINCT_EXP_COUNT
 *        ,LISTAGG(e.EXPERIMENT_ID,',') within group( order by e.EXPERIMENT_ID) EIDs
 * from SUBSTANCE s
 *        join RESULT r on r.SUBSTANCE_REF = s.SUBSTANCE_REF
 *        join EXPERIMENT e on e.EXPERIMENT_REF = r.EXPERIMENT_REF
 *        join RESULT_TYPE rt on rt.RESULT_TYPE_REF = r.RESULT_TYPE_REF
 * where rt.RESULT_TYPE_FULLNAME = 'PubChem outcome'
 *        and r.VALUE_DISPLAY = 'Active'
 *        and s.PUBCHEM_CID is not null
 *        and e.EXPERIMENT_STATUS <> 'Draft'
 * group by s.PUBCHEM_CID
 * --having count(distinct e.EXPERIMENT_REF) > 5
 * order by count(distinct e.EXPERIMENT_REF) asc
 *
 */
class MolSpreadsheetHelper {

    private final Map<Integer, Integer> cidToExperimentCountMap = [:]

    MolSpreadsheetHelper() {
        // looking to parse a file with CID and distinct experiment count
        // first line is a header

        this.getClass().getClassLoader().getResource("pubchem_cid_disctinct_exp_count.csv").eachLine() { line ->
            def (String pubchemCid, String experimentCount) = line.split('\t')
            if (NumberUtils.isNumber(pubchemCid)) {
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
        cidToExperimentCountMap.findAll { k, v -> v >= minimumExperiments }.collect { k, v -> k }
    }

    /**
     *
     * @param experimentCount
     * @return list of CIDs that appeared in experimentCount number of experiments
     */
    List<Integer> findCidsWithExperimentCount(Integer experimentCount) {
        cidToExperimentCountMap.findAll { k, v -> v == experimentCount }.collect { k, v -> k }
    }


}
