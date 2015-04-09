# hubound

Calculates the exact confidence upper bound for the
hypergeometric distribution according to Konijn (1973)

See

https://www.rug.nl/research/portal/files/2912436/c4.pdf
http://www.sascommunity.org/sugi/SUGI91/Sugi-91-248%20Tsao%20LaLonde.pdf

# running

To calculate the exact upper bound for

population: 1000

sampled: 500

successes: 50

confidence level: 95%

sbt

run 1000 500 50 95

    [info] Running org.agoravoting.agora.HUBound 1000 500 50 95
    calculating with population 1000 sampled 500 successes 50 confidence level 0.050000000000000044
    upper bound 95.0% at 117 0.117