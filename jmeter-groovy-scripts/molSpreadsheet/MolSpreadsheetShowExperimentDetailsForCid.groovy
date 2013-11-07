import pages.ShowExperimentDetailsPage

import static bard.util.SeleniumUtils.getDriver

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 11/7/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */

println("Parameters : ${Parameters}" )
def parametersMap = Parameters?  evaluate(Parameters) : [:]

ShowExperimentDetailsPage showExperimentDetailsPage = new ShowExperimentDetailsPage(getDriver(), parametersMap.cid?:11057);
println(showExperimentDetailsPage.getLinkedEids())

showExperimentDetailsPage

