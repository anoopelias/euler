(ns distinct-powers.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(def max-num 100)

(def combinations
  (let [nums (range 2 (inc max-num))]
    (for [x nums y nums] (vector x y))))

(def cnt
  (count (set (map
                #(math/expt (% 0) (% 1))
                combinations))))
(defn -main
  "Find distinct powers"
  [& args]
  (println cnt))
