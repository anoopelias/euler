(ns truncatable-primes.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn powers-of-10
  ([] (powers-of-10 1))
  ([n] (lazy-seq (cons (* n 10) (powers-of-10 (* n 10))))))

(defn num-set [n]
  (cons n (concat
            (take-while #(not (zero? %))  (map #(int (/ n %)) (powers-of-10)))
            (take-while #(not (= n %)) (map #(mod n %) (powers-of-10))))))

(defn is-prime? [n]
  (and (not= n 1) (= (count
       (filter
         #(= (mod n %) 0)
         (range 2
               (inc (int (Math/sqrt n))))))
     0)))

(def is-prime-m?
  (memoize is-prime?))

(defn prime-num-set? [n]
  (nil? (first (remove is-prime-m? (num-set n)))))

(defn all-prime-set []
  (filter prime-num-set? (range 10 1000000)))

(defn -main
  "Truncatable primes"
  [& args]
  (println (reduce + (all-prime-set))))
