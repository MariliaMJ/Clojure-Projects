(ns small-projects.stats)


(defn average
  [data]
  (cond
    (= (count data) 0) nil
    (not (= data 0)) (double (/ (reduce + data) (count data)))))

(defn mode
  [data]
  (let [frequencies (reduce #(update %1 %2 (fnil inc 0)) {} data)
        max-frequency (apply max (vals frequencies))
        mode-result (filter #(= max-frequency (frequencies %)) (keys frequencies))]
    (first mode-result)))

(defn median-for-even-collection
  [data
   middle-index]
  (/ (+ (data middle-index) (data (dec middle-index))) 2))

(defn median
  [data]
  (let [len (count data)
        middle-index (int (inc (/ len 2)))]
    (cond
      (even? len) (median-for-even-collection data middle-index)
      (odd? len) (data middle-index))))
