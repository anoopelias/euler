(ns name-scores.core
  (:gen-class)
  (:require [clojure.java.io :as io]))

(def filename (str (System/getProperty "user.dir") "/../p022_names.txt" ))

(defn names-from [text]
  (map #(% 1) (re-seq #"\"([A-Z]*)\"" text)))

(defn name-val [name]
  (reduce + (map
              #(inc (- (int %) (int \A)))
              (seq name))))

(defn name-num [name-idx]
  (* (inc (first name-idx))
     (name-val (last name-idx))))

(defn total [text]
  (reduce + (map
    name-num
    (map-indexed list (sort (names-from text))))))

(defn -main
  "Find total of name scores"
  [& args]
  (println (total (slurp filename))))
