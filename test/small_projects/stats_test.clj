(ns small-projects.stats-test
  (:require [clojure.test :refer :all]
            [small-projects.stats :refer :all]))

(with-test
  (defn test-average [data]
    (average data))
  (is (= 5.0 (test-average [2 4 6 8])))
  (is (= 5.35 (test-average [2.5 4.1 6.7 8.1])))
  (is (= 0.45 (test-average [2/5 1/2])))
  (is (= 19.6675 (test-average [3.87 12.3 7.88 54.62])))
  (is (= 5.0 (test-average '(2 4 6 8))))
  (is (= 4.2625 (test-average '(2.1 4.55 6.4 8/2))))
  (is (= nil (test-average []))))

(test #'test-average)

(with-test
  (defn test-mode [data]
    (mode data))
  (is (= 8 (test-mode [92 45 6 8 8 1077 8 8 2 32 23 12])))
  (is (= 2.5 (test-mode [2.5 4.1 6.7 8.1 89.099 2.5 2.52])))
  (is (= 1/2 (test-mode [37/5 1/2 1/2 6/7 87/90])))
  (is (= 6 (test-mode '(2 4 6 8 6 6))))
  (is (= 4.55 (test-mode '(2.1 4.55 6.4 8/2 4.55 4.55)))))

(test #'test-mode)

(with-test
  (defn test-median [data]
    (median data))
  (is (= 5.0 (test-average [2 4 6 8])))
  (is (= 6 (test-average [2 4 6 8 10])))
  (is (= 7.4 (test-average [2.5 4.1 6.7 8.1])))
  (is (= 0.45 (test-average [2/5 1/2])))
  (is (= 31.25 (test-average [3.87 12.3 7.88 54.62])))
  (is (= 5.0 (test-average '(2 4 6 8))))
  (is (= 4.2625 (test-average '(2.1 4.55 6.4 8/2))))
  (is (= 0 (test-average []))))

(test #'test-median)




