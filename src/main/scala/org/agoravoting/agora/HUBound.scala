package org.agoravoting.agora

import org.apache.commons.math3.distribution.HypergeometricDistribution

/**
 * Calculates the exact confidence upper bound for the
 * hypergeometric distribution according to Konijn (1973)
 *
 * See
 *
 * https://www.rug.nl/research/portal/files/2912436/c4.pdf (4.2.1)
 * http://www.sascommunity.org/sugi/SUGI91/Sugi-91-248%20Tsao%20LaLonde.pdf (Eq 3)
 *
*/
object HUBound extends App {

  def getUpperBound(population: Int, sampled: Int, successes: Int, confidence: Double): Int = {
    var max = -1;
    println("calculating with population " + population + " sampled " + sampled + " successes " + successes + " confidence level " + confidence)

    // MU (k) = largest integer M s.t. P{K <= k} > alpha
    for (i <- 0 to population) {
        val p = if(successes > i) {
            0.0
        }
        else {
            val h = new HypergeometricDistribution(population, i, sampled)
            h.cumulativeProbability(successes)
        }

        if(p > confidence) {
            if(i >= max) {
                max = i
            }
        }
    }
    if(max == -1) {
        max = population;
    }

    return max;
  }

  if(args.length != 4) {
    println("HUBound <population> <sampled> <successes> <confidence>")
  } else {
    val max = getUpperBound(args(0).toInt, args(1).toInt, args(2).toInt, 1 - (args(3).toDouble / 100.0))

    println("upper bound " + args(3).toDouble + "% at " + max + " " + (max / args(0).toDouble))
  }
}